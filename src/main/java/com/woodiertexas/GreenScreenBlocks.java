package com.woodiertexas;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class GreenScreenBlocks {
	// The method for registering blocks (and their corresponding items)
	public static Block register(Block block, String name, boolean shouldRegisterItem) {
		Identifier id = Identifier.of(GreenScreen.MOD_ID, name);
		
		if (shouldRegisterItem) {
			BlockItem blockItem = new BlockItem(block, new Item.Settings());
			Registry.register(Registries.ITEM, id, blockItem);
		}
		
		return Registry.register(Registries.BLOCK, id, block);
	}
	
	// The blocks for Green Screen
	public static final Block RED_SCREEN = register(new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)), "red_screen_block", true);
	//public static final Block GREEN_SCREEN = register(new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)), "green_screen_block", true);
	//public static final Block BLUE_SCREEN = register(new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL)), "blue_screen_block", true);
	
}
