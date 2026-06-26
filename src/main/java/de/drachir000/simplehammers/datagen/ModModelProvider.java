package de.drachir000.simplehammers.datagen;

import de.drachir000.simplehammers.SimpleHammers;
import de.drachir000.simplehammers.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class ModModelProvider extends ModelProvider {
	
	public ModModelProvider(PackOutput output) {
		super(output, SimpleHammers.MOD_ID);
	}
	
	@Override
	protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
		
		itemModels.generateFlatItem(ModItems.WOODEN_HAMMER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModels.generateFlatItem(ModItems.COPPER_HAMMER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModels.generateFlatItem(ModItems.STONE_HAMMER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModels.generateFlatItem(ModItems.GOLDEN_HAMMER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModels.generateFlatItem(ModItems.IRON_HAMMER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModels.generateFlatItem(ModItems.DIAMOND_HAMMER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModels.generateFlatItem(ModItems.NETHERITE_HAMMER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
	
	}
	
}