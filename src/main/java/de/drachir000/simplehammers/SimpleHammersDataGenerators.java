package de.drachir000.simplehammers;

import de.drachir000.simplehammers.datagen.ModBlockTagsProvider;
import de.drachir000.simplehammers.datagen.ModItemTagsProvider;
import de.drachir000.simplehammers.datagen.ModModelProvider;
import de.drachir000.simplehammers.datagen.ModRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = SimpleHammers.MOD_ID)
public class SimpleHammersDataGenerators {
	
	@SubscribeEvent
	public static void gatherClientData(GatherDataEvent.Client event) {
		
		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();
		var lookupProvider = event.getLookupProvider();
		
		generator.addProvider(true, new ModModelProvider(output));
		generator.addProvider(true, new ModItemTagsProvider(output, lookupProvider));
		generator.addProvider(true, new ModBlockTagsProvider(output, lookupProvider));
		generator.addProvider(true, new ModRecipeProvider.Runner(output, lookupProvider));
		
	}
	
}