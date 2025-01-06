package com.woodiertexas;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class GreenScreen implements ModInitializer {
	public static final String MOD_ID = "green_screen";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("Green Screen");

	public static final Block RED_SCREEN = new Block(Block.Settings.create().sounds(BlockSoundGroup.WOOL).strength(0.1f).luminance(value -> 15).emissiveLighting((state, getter, pos) -> true));
	public static final Block GREEN_SCREEN = new Block(Block.Settings.create().sounds(BlockSoundGroup.WOOL).strength(0.1f).luminance(value -> 15).emissiveLighting((state, getter, pos) -> true));
	public static final Block BLUE_SCREEN = new Block(Block.Settings.create().sounds(BlockSoundGroup.WOOL).strength(0.1f).luminance(value -> 15).emissiveLighting((state, getter, pos) -> true));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		HashMap<Block, String> blocks = new HashMap<>();

		blocks.put(RED_SCREEN, "red_screen_block");
		blocks.put(GREEN_SCREEN, "green_screen_block");
		blocks.put(BLUE_SCREEN, "blue_screen_block");

		for (Block block : blocks.keySet()) {
			Registry.register(Registries.BLOCK, Identifier.of("green_screen", blocks.get(block)), block);
			Registry.register(Registries.ITEM, Identifier.of("green_screen", blocks.get(block)),
				new BlockItem(block, new Item.Settings()));
			ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL_BLOCKS).register(entries -> entries.addItem(block.asItem()));
		}
	}
}
