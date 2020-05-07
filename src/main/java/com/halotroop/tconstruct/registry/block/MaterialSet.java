package com.halotroop.tconstruct.registry.block;

import com.halotroop.tconstruct.TConstruct;
import com.halotroop.tconstruct.registry.item.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import org.jetbrains.annotations.Nullable;

public class MaterialSet extends TConBlock {
	public Item rawItem, brokenItem;
	
	public MaterialSet(String baseName, Block block, Item rawItem, Item brokenItem,
	                   @Nullable Item.Settings blockItemSettings, Type materialType) {
		super(baseName + "_block", block, blockItemSettings);
		TConstruct.logger.debug("Registering material set for " + baseName);
		String rawName = materialType.rawSuffix;
		String brokenName = materialType.brokenSuffix;
		if (BlockRegistry.cottonCheck(rawName)) {
			this.rawItem = ItemRegistry.registerItem(rawName, rawItem);
		}
		if (BlockRegistry.cottonCheck(brokenName))
			this.brokenItem = ItemRegistry.registerItem(brokenName, brokenItem);
		}
	
	enum Type {
		GEM("", "_shard"),
		METAL("_ingot", "_nugget");
		
		public String rawSuffix;
		public String brokenSuffix;
		
		Type(String rawSuffix, String brokenSuffix) {
			this.rawSuffix = rawSuffix;
			this.brokenSuffix = brokenSuffix;
		}
	}
}