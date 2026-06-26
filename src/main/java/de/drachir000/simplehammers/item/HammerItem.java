package de.drachir000.simplehammers.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class HammerItem extends Item {
	
	private static final List<BlockPos> HARVESTED_BLOCKS = new ArrayList<>();
	
	public HammerItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public boolean mineBlock(ItemStack itemStack, Level level, BlockState state, BlockPos initialBlockPos, LivingEntity owner) {
		
		if (itemStack.getItem() instanceof HammerItem hammerItem && owner instanceof ServerPlayer serverPlayer) {
			
			if (HARVESTED_BLOCKS.contains(initialBlockPos)) {
				return true;
			}
			
			for (BlockPos blockPos : getAffectedBlocks(initialBlockPos, serverPlayer)) {
				
				if (!(serverPlayer.getMainHandItem().getItem() instanceof HammerItem)) {
					continue;
				}
				
				if (blockPos.equals(initialBlockPos)) {
					continue;
				}
				
				if (!hammerItem.isCorrectToolForDrops(itemStack, level.getBlockState(blockPos))) {
					continue;
				}
				
				HARVESTED_BLOCKS.add(blockPos);
				if (serverPlayer.gameMode.destroyBlock(blockPos)) {
					itemStack.hurtAndBreak(1, serverPlayer, EquipmentSlot.MAINHAND);
				}
				HARVESTED_BLOCKS.remove(blockPos);
				
			}
			
		}
		
		return super.mineBlock(itemStack, level, state, initialBlockPos, owner);
		
	}
	
	// Inspired by https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
	// Don't be a jerk License
	private static List<BlockPos> getAffectedBlocks(BlockPos initalBlockPos, ServerPlayer player) {
		
		List<BlockPos> affectedBlocks = new ArrayList<>();
		
		BlockHitResult hitResult = player.level().clip(new ClipContext(player.getEyePosition(1f), player.getEyePosition(1f).add(player.getViewVector(1f).scale(6f)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));
		
		if (hitResult.getType() == HitResult.Type.MISS) return affectedBlocks;
		
		boolean xConstant = hitResult.getDirection() == Direction.EAST || hitResult.getDirection() == Direction.WEST;
		boolean yConstant = hitResult.getDirection() == Direction.UP || hitResult.getDirection() == Direction.DOWN;
		boolean zConstant = hitResult.getDirection() == Direction.NORTH || hitResult.getDirection() == Direction.SOUTH;
		
		for (int x = -1; x <= 1; x++) {
			for (int y = -1; y <= 1; y++) {
				affectedBlocks.add(new BlockPos(
						initalBlockPos.getX() + (xConstant ? 0 : x),
						initalBlockPos.getY() + (yConstant ? 0 : (xConstant ? x : y)),
						initalBlockPos.getZ() + (zConstant ? 0 : y)
				));
			}
		}
		
		return affectedBlocks;
		
	}
	
	@Override
	public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
		builder.accept(Component.translatable("item.simplehammers.hammer.tooltip"));
		super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
	}
}