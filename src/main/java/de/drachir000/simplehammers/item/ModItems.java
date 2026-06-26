package de.drachir000.simplehammers.item;

import de.drachir000.simplehammers.SimpleHammers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
	
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SimpleHammers.MOD_ID);
	
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
	
}