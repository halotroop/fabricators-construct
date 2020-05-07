package com.halotroop.tconstruct.registry.block;

import com.halotroop.tconstruct.TConstruct;
import com.halotroop.tconstruct.registry.item.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

public class TConBlock {
	public final Identifier id;
	public final net.minecraft.block.Block block;
	@Nullable private BlockItem item;
	
	/*
	 * @Inputs name of block, settings for blockitem
	 * @Outputs set of an Identifier, Block, and Item
	 */
	public TConBlock(String name, Block block, @Nullable Item.Settings settings) {
		TConstruct.logger.debug("Registering a block/item pair for " + name);
		this.id = TConstruct.makeID(name);
		this.block = Registry.register(Registry.BLOCK, getId(), block);
		if (settings != null) {
			this.item = (BlockItem) ItemRegistry.registerItem(name, new BlockItem(block, settings));
		}
	}
	
	@Nullable
	public BlockItem getItem() {
		return item;
	}
	@Nullable
	public ItemGroup getGroup() {
		if (item != null) {
			return item.getGroup();
		}
		else return null;
	}
	@Nullable
	public Block getBlock() {
		return block;
	}
	public Identifier getId() {
		return id;
	}
}
