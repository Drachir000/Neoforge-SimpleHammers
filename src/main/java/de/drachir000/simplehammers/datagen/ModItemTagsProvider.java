package de.drachir000.simplehammers.datagen;

import de.drachir000.simplehammers.SimpleHammers;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
	
	public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(output, lookupProvider, SimpleHammers.MOD_ID);
	}
	
	@Override
	protected void addTags(HolderLookup.Provider provider) {
	
	
	}
	
}