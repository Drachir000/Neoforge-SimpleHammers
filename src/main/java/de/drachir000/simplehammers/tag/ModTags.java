package de.drachir000.simplehammers.tag;

import de.drachir000.simplehammers.SimpleHammers;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;

public class ModTags {
	
	public static class Item {
		
		private static TagKey<net.minecraft.world.item.Item> createTag(String name) {
			return ItemTags.create(Identifier.fromNamespaceAndPath(SimpleHammers.MOD_ID, name));
		}
		
	}
	
	public static class Block {
		
		private static TagKey<net.minecraft.world.level.block.Block> createTag(String name) {
			return BlockTags.create(Identifier.fromNamespaceAndPath(SimpleHammers.MOD_ID, name));
		}
		
	}
	
}