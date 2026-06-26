package de.drachir000.simplehammers.item;

import de.drachir000.simplehammers.SimpleHammers;
import de.drachir000.simplehammers.tag.ModTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Collection;
import java.util.List;

public class ModItems {
	
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SimpleHammers.MOD_ID);
	
	public static final DeferredItem<Item> WOODEN_HAMMER = ITEMS.registerItem("wooden_hammer", properties -> new HammerItem(properties
			.tool(ToolMaterial.WOOD, ModTags.Block.MINEABLE_WITH_HAMMER, 7f, -3.6f, 7)
	));
	
	public static final DeferredItem<Item> COPPER_HAMMER = ITEMS.registerItem("copper_hammer", properties -> new HammerItem(properties
			.tool(ToolMaterial.COPPER, ModTags.Block.MINEABLE_WITH_HAMMER, 8f, -3.6f, 7)
	));
	
	public static final DeferredItem<Item> STONE_HAMMER = ITEMS.registerItem("stone_hammer", properties -> new HammerItem(properties
			.tool(ToolMaterial.STONE, ModTags.Block.MINEABLE_WITH_HAMMER, 8f, -3.6f, 8)
	));
	
	public static final DeferredItem<Item> GOLDEN_HAMMER = ITEMS.registerItem("golden_hammer", properties -> new HammerItem(properties
			.tool(ToolMaterial.GOLD, ModTags.Block.MINEABLE_WITH_HAMMER, 7f, -3.4f, 8)
	));
	
	public static final DeferredItem<Item> IRON_HAMMER = ITEMS.registerItem("iron_hammer", properties -> new HammerItem(properties
			.tool(ToolMaterial.IRON, ModTags.Block.MINEABLE_WITH_HAMMER, 7f, -3.5f, 9)
	));
	
	public static final DeferredItem<Item> DIAMOND_HAMMER = ITEMS.registerItem("diamond_hammer", properties -> new HammerItem(properties
			.tool(ToolMaterial.DIAMOND, ModTags.Block.MINEABLE_WITH_HAMMER, 6f, -3.4f, 9)
	));
	
	public static final DeferredItem<Item> NETHERITE_HAMMER = ITEMS.registerItem("netherite_hammer", properties -> new HammerItem(properties
			.tool(ToolMaterial.NETHERITE, ModTags.Block.MINEABLE_WITH_HAMMER, 6f, -3.4f, 10)
	));
	
	public static Collection<Item> getHammers() {
		return List.of(WOODEN_HAMMER.get(), COPPER_HAMMER.get(), STONE_HAMMER.get(), GOLDEN_HAMMER.get(), IRON_HAMMER.get(), DIAMOND_HAMMER.get(), NETHERITE_HAMMER.get());
	}
	
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
	
}