package com.halotroop.tconstruct.registry.block;

import com.halotroop.tconstruct.TConstruct;
import net.devtech.rrp.api.RuntimeResourcePack;
import net.devtech.rrp.util.BlockModelJsonBuilder;
import net.devtech.rrp.util.BlockStateJsonBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.Nullable;

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
			this.item = Registry.register(Registry.ITEM, getId(), new BlockItem(block, settings));
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
