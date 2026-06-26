package de.drachir000.simplehammers;

import com.mojang.logging.LogUtils;
import de.drachir000.simplehammers.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.slf4j.Logger;

@Mod(SimpleHammers.MOD_ID)
public class SimpleHammers {
	
	public static final String MOD_ID = "simplehammers";
	public static final Logger LOGGER = LogUtils.getLogger();
	
	public SimpleHammers(IEventBus modEventBus, ModContainer modContainer) {
		
		ModItems.register(modEventBus);
		
		modEventBus.addListener(this::addCreative);
		
	}
	
	private void addCreative(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			event.acceptAll(ModItems.getHammerStacks());
		}
	}
	
}