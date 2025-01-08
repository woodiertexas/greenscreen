package com.woodiertexas;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GreenScreen implements ModInitializer {
	public static final String MOD_ID = "green_screen";
	public static final Logger LOGGER = LoggerFactory.getLogger("Green Screen");
	
	@Override
	public void onInitialize() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL_BLOCKS).register((entries) -> entries.addItem(GreenScreenBlocks.RED_SCREEN.asItem()));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL_BLOCKS).register((entries) -> entries.addItem(GreenScreenBlocks.GREEN_SCREEN.asItem()));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL_BLOCKS).register((entries) -> entries.addItem(GreenScreenBlocks.BLUE_SCREEN.asItem()));
		
		GreenScreenBlocks.init();
	}
}
