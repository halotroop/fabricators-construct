package com.halotroop.tconstruct.registry.block;

import com.halotroop.tconstruct.TConstruct;
import com.halotroop.tconstruct.fluid.MoltenMaterialFluid;
import com.halotroop.tconstruct.registry.item.ItemRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class MaterialSet {
	// TODO: Fluids!
	public final Item rawItem, brokenItem;
	public final BlockItemPair ore, block;
	public final Fluid molten;
	
	// The most customizable way to create a set, but good god does it take a lot of big parameters!
	public MaterialSet(@NotNull String baseName, @NotNull Block storageBlock, @NotNull OreBlock oreBlock, // Block stuff
	                   @NotNull Item rawItem, @NotNull Item brokenItem, // Item stuff
	                   Item.Settings blockItemSettings, Type type) { // General stuff
		TConstruct.logger.debug("Registering material set for " + baseName);
		// BlockItemPair will do its own cottonCheck.
		this.block = new BlockItemPair(baseName + "_block", storageBlock, blockItemSettings);
		this.ore = new BlockItemPair(baseName + "_ore", oreBlock, blockItemSettings);
		this.molten = new MoltenMaterialFluid(baseName, TConstruct.GENERAL_TAB);
		
		String rawName = baseName + type.rawSuffix;
		if (ItemRegistry.cottonCheck(rawName)) this.rawItem = ItemRegistry.registerItem(rawName, rawItem);
		else this.rawItem = ItemRegistry.cottonItem(rawName);
		
		String brokenName = baseName + type.brokenSuffix;
		if (BlockRegistry.cottonCheck(brokenName)) this.brokenItem = ItemRegistry.registerItem(brokenName, brokenItem);
		else this.brokenItem = ItemRegistry.cottonItem(brokenName);
	}
	
	public MaterialSet(@NotNull String baseName, @NotNull Block storageBlock, // Block stuff
	                   @Nullable Item.Settings oreBlockItemSettings, // BlockItem stuff
	                   @NotNull Item rawItem, @NotNull Item brokenItem, // Item stuff
	                   int oreExperience, int miningLevel, @NotNull Type type) { // General stuff
		this(baseName, storageBlock, new OreBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE)
				.breakByTool(FabricToolTags.PICKAXES, miningLevel)) {
			@Override
			protected int getExperienceWhenMined(Random random) {
				return oreExperience;
			}
		}, rawItem, brokenItem, oreBlockItemSettings, type);
	}
	
	// The most basic way to create a set of materials.
	// All items in a set created with this constructor will have the same settings! Use with care!
	public MaterialSet(@NotNull String baseName, @NotNull Block.Settings blockSettings,
	                   @NotNull Item.Settings itemSettings,
	                   int oreExperience, int miningLevel, @NotNull Type materialType) {
		this(baseName, new Block(blockSettings), itemSettings, new Item(itemSettings), new Item(itemSettings),
				oreExperience, miningLevel, materialType);
	}

	enum Type {
		GEM("", "_shard"), METAL("_ingot", "_nugget");

		public String rawSuffix;
		public String brokenSuffix;

		Type(String rawSuffix, String brokenSuffix) {
			this.rawSuffix = rawSuffix;
			this.brokenSuffix = brokenSuffix;
		}
	}
}