package de.drachir000.simplehammers.datagen;

import de.drachir000.simplehammers.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
	
	public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
		super(registries, output);
	}
	
	@Override
	protected void buildRecipes() {
		
		hammer(ModItems.WOODEN_HAMMER.get(), ItemTags.WOODEN_TOOL_MATERIALS, Items.STICK);
		hammer(ModItems.COPPER_HAMMER.get(), ItemTags.COPPER_TOOL_MATERIALS, Items.COPPER_INGOT);
		hammer(ModItems.STONE_HAMMER.get(), ItemTags.STONE_TOOL_MATERIALS, Items.COBBLESTONE);
		hammer(ModItems.GOLDEN_HAMMER.get(), ItemTags.GOLD_TOOL_MATERIALS, Items.GOLD_INGOT);
		hammer(ModItems.IRON_HAMMER.get(), ItemTags.IRON_TOOL_MATERIALS, Items.IRON_INGOT);
		hammer(ModItems.DIAMOND_HAMMER.get(), ItemTags.DIAMOND_TOOL_MATERIALS, Items.DIAMOND);
		
		this.netheriteSmithing(ModItems.DIAMOND_HAMMER.get(), RecipeCategory.TOOLS, ModItems.NETHERITE_HAMMER.get());
	
	}
	
	private void hammer(Item result, TagKey<Item> ingredientTag, ItemLike unlockItem) {
		shaped(RecipeCategory.TOOLS, result)
				.pattern("XXX")
				.pattern("X#X")
				.pattern(" # ")
				.define('#', Items.STICK)
				.define('X', ingredientTag)
				.unlockedBy(getHasName(unlockItem), has(ingredientTag))
				.save(output);
	}
	
	public static class Runner extends RecipeProvider.Runner {
		
		public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
			super(packOutput, registries);
		}
		
		@Override
		protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
			return new ModRecipeProvider(registries, output);
		}
		
		@Override
		public String getName() {
			return "Simple Hammers Recipes";
		}
		
	}
	
}