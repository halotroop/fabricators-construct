package com.halotroop.tconstruct.registry.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import org.jetbrains.annotations.Nullable;

public class DecorStones {
	public final BlockStairSlabSet SMOOTH, COBBLED, CRACKED, FANCY, SQUARE, ROAD, TRIANGLE, SMALL, TILE, INSCRIBED;
	
	public DecorStones(@Nullable String prefix, String baseName, Block.Settings blockSettings, Item.Settings itemSettings) {
		String fixedPrefix = (prefix != null) ? prefix+"_" : "";
		String fixedSuffix = "_" + baseName.toLowerCase();
		
		SMOOTH     = new BlockStairSlabSet(fixedPrefix + "smooth"    + fixedSuffix, blockSettings, itemSettings);
		COBBLED    = new BlockStairSlabSet(fixedPrefix + "cobbled"   + fixedSuffix, blockSettings, itemSettings);
		CRACKED    = new BlockStairSlabSet(fixedPrefix + "cracked"   + fixedSuffix, blockSettings, itemSettings);
		FANCY      = new BlockStairSlabSet(fixedPrefix + "fancy"     + fixedSuffix, blockSettings, itemSettings);
		SQUARE     = new BlockStairSlabSet(fixedPrefix + "square"    + fixedSuffix, blockSettings, itemSettings);
		ROAD       = new BlockStairSlabSet(fixedPrefix + "road"      + fixedSuffix, blockSettings, itemSettings);
		TRIANGLE   = new BlockStairSlabSet(fixedPrefix + "triangle"  + fixedSuffix, blockSettings, itemSettings);
		SMALL      = new BlockStairSlabSet(fixedPrefix + "small"     + fixedSuffix, blockSettings, itemSettings);
		TILE       = new BlockStairSlabSet(fixedPrefix + "tile"      + fixedSuffix, blockSettings, itemSettings);
		INSCRIBED  = new BlockStairSlabSet(fixedPrefix + "inscribed" + fixedSuffix, blockSettings, itemSettings);
	}
}
