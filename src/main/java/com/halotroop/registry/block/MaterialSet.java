/*
 * MIT License
 *
 * Copyright (c) 2020 SlimeKnights, halotroop2288
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.halotroop.registry.block;

import com.halotroop.registry.RegistryMod;
import com.halotroop.registry.fluid.MoltenMaterialFluid;
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
	public static Block[] all;
	public final Item rawItem, brokenItem;
	@Nullable private final BlockItemPair ore;
	public final BlockItemPair block;
	public final MoltenMaterialFluid molten;
	
	// The most customizable way to create a set, but good god does it take a lot of big parameters!
	public MaterialSet(@NotNull String baseName, @NotNull Block storageBlock, @Nullable OreBlock oreBlock, // Block stuff
	                   @NotNull Item rawItem, @NotNull Item brokenItem, // Item stuff
	                   Item.Settings blockItemSettings, Type type) { // General stuff
		RegistryMod.logger.debug("Registering material set for " + baseName);
		// BlockItemPair will do its own cottonCheck.
		this.block = new BlockItemPair(baseName + "_block", storageBlock, blockItemSettings);
		if (!type.equals(Type.ALLOY) && oreBlock != null) {
			this.ore = new BlockItemPair(baseName + "_ore", oreBlock, blockItemSettings);
		} else {
			this.ore = null;
		}
		this.molten = new MoltenMaterialFluid(baseName, rawItem.getGroup());
		
		String rawName = baseName + type.rawSuffix;
		if (RegistryMod.cottonItemCheck(rawName)) this.rawItem = RegistryMod.registerItem(rawName, rawItem);
		else this.rawItem = RegistryMod.cottonItem(rawName);
		
		String brokenName = baseName + type.brokenSuffix;
		if (RegistryMod.cottonBlockCheck(brokenName)) this.brokenItem = RegistryMod.registerItem(brokenName, brokenItem);
		else this.brokenItem = RegistryMod.cottonItem(brokenName);
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

	public enum Type {
		GEM("", "_shard"), METAL("_ingot", "_nugget"), ALLOY("_ingot", "_nugget");

		public final String rawSuffix;
		public final String brokenSuffix;

		Type(String rawSuffix, String brokenSuffix) {
			this.rawSuffix = rawSuffix;
			this.brokenSuffix = brokenSuffix;
		}
	}
}