package de.drachir000.simplehammers.datagen;

import de.drachir000.simplehammers.SimpleHammers;
import de.drachir000.simplehammers.tag.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
	
	public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(output, lookupProvider, SimpleHammers.MOD_ID);
	}
	
	@Override
	protected void addTags(HolderLookup.Provider provider) {
		
		tag(ModTags.Block.MINEABLE_WITH_HAMMER)
				.addTag(BlockTags.MINEABLE_WITH_PICKAXE)
				.addTag(BlockTags.MINEABLE_WITH_SHOVEL);
	
	}
	
}