package com.woodiertexas;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.model.BlockStateModelGenerator;
import net.minecraft.registry.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class GreenScreenDataGen implements DataGeneratorEntrypoint {
	private static class GreenScreenBlockModelGenerator extends FabricModelProvider {
		public GreenScreenBlockModelGenerator(FabricDataOutput output) {
			super(output);
		}
		
		@Override
		public void generateBlockStateModels(BlockStateModelGenerator blockStateOutput) {
			blockStateOutput.registerSimpleCubeAll(GreenScreenBlocks.RED_SCREEN);
		}
		
		@Override
		public void generateItemModels(ItemModelGenerator itemOutput) {
			itemOutput.register();
		}
		
	}
	
	private static class GreenScreenEnglishGenerator extends FabricLanguageProvider {
		private GreenScreenEnglishGenerator(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
			super(dataOutput, registryLookup);
		}
		
		@Override
		public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder translationBuilder) {
			translationBuilder.add(GreenScreenBlocks.RED_SCREEN, "Red Screen Block");
		}
	}
	
	
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator generator) {
		FabricDataGenerator.Pack pack = generator.createPack();
		
		pack.addProvider(GreenScreenBlockModelGenerator::new);
		pack.addProvider(GreenScreenEnglishGenerator::new);
	}
}
