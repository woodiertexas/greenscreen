package com.woodiertexas;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;

public class GreenScreenBlocks {
	// The blocks for Green Screen
	
	public static Block registerBlock(String id, Function<AbstractBlock.Settings, Block> function, AbstractBlock.Settings settings) {
		RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(GreenScreen.MOD_ID, id));
		Block block = function.apply(settings.key(blockKey));
		return Registry.register(Registries.BLOCK, blockKey, block);
	}
	
	public static Item registerItem(String id, Function<Item.Settings, Item> factory, Item.Settings settings) {
		RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(GreenScreen.MOD_ID, id));
		Item item = factory.apply(settings.key(itemKey));
		
		if (item instanceof BlockItem blockItem) {
			blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
		}
		
		return Registry.register(Registries.ITEM, itemKey, item);
	}
	
	public static Block registerBlockWithItem(String id, AbstractBlock.Settings settings) {
		Block block = registerBlock(id, Block::new, settings);
		registerItem("somehow_get_block_id", Item::new, new Item.Settings().rarity(Rarity.COMMON));
		return block;
	}
	
	public static void init() {
		
	}
	
	public static final Block RED_SCREEN = registerBlockWithItem("green_screen_block", AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL));
}
