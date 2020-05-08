package com.halotroop.tconstruct.registry.block;

import com.halotroop.tconstruct.TConstruct;
import com.halotroop.tconstruct.fluid.MoltenMaterialFluid;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class MaterialSet {
	public final Item rawItem, brokenItem;
	@Nullable private final BlockItemPair ore;
	public final BlockItemPair block;
	public final MoltenMaterialFluid molten;
	
	// The most customizable way to create a set, but good god does it take a lot of big parameters!
	public MaterialSet(@NotNull String baseName, @NotNull Block storageBlock, @Nullable OreBlock oreBlock, // Block stuff
	                   @NotNull Item rawItem, @NotNull Item brokenItem, // Item stuff
	                   Item.Settings blockItemSettings, Type type) { // General stuff
		TConstruct.logger.debug("Registering material set for " + baseName);
		// BlockItemPair will do its own cottonCheck.
		this.block = new BlockItemPair(baseName + "_block", storageBlock, blockItemSettings);
		if (!type.equals(Type.ALLOY) && oreBlock != null) {
			this.ore = new BlockItemPair(baseName + "_ore", oreBlock, blockItemSettings);
		} else {
			this.ore = null;
		}
		this.molten = new MoltenMaterialFluid(baseName, TConstruct.GENERAL_TAB);
		
		String rawName = baseName + type.rawSuffix;
		if (TConRegistry.cottonItemCheck(rawName)) this.rawItem = TConRegistry.registerItem(rawName, rawItem);
		else this.rawItem = TConRegistry.cottonItem(rawName);
		
		String brokenName = baseName + type.brokenSuffix;
		if (TConRegistry.cottonBlockCheck(brokenName)) this.brokenItem = TConRegistry.registerItem(brokenName, brokenItem);
		else this.brokenItem = TConRegistry.cottonItem(brokenName);
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
	public MaterialSet(@NotNull String baseName, @NotNull Item.Settings itemSettings, // Item stuff
	                   @NotNull Block.Settings blockSettings, int oreExperience, int miningLevel, // Block stuff
	                   @NotNull Type materialType) { // General stuff
		this(baseName, new Block(blockSettings), itemSettings, new Item(itemSettings), new Item(itemSettings),
				oreExperience, miningLevel, materialType);
	}
	
	public Block oreBlock() {
		if (ore != null) return ore.block;
		else return Blocks.AIR;
	}
	
	public Item oreBlockItem() {
		if (ore != null) return ore.blockItem;
		else return Items.AIR;
	}

	enum Type {
		GEM("", "_shard"), METAL("_ingot", "_nugget"), ALLOY("_ingot", "_nugget");

		public final String rawSuffix;
		public final String brokenSuffix;

		Type(String rawSuffix, String brokenSuffix) {
			this.rawSuffix = rawSuffix;
			this.brokenSuffix = brokenSuffix;
		}
	}
}