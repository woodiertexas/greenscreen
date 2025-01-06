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
		RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.ofDefault(id));
		Item item = factory.apply(settings.key(itemKey));
		
		if (item instanceof BlockItem blockItem) {
			blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
		}
		
		return Registry.register(Registries.ITEM, itemKey, item);
	}
	
	//public static Block, Item registerBlockWithItem() {
	//	
	//}
	
	public static final Block RED_SCREEN = registerBlock("green_screen_block", Block::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL));
	public static final Item RED_SCREEN_ITEM = registerItem(String.valueOf(RED_SCREEN.asItem()), Item::new, new Item.Settings().rarity(Rarity.COMMON));
}
