package com.halotroop.tconstruct.registry.block;

import com.halotroop.tconstruct.TConstruct;
import com.halotroop.tconstruct.registry.item.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.Nullable;

public class TConBlock {
	public final Identifier id;
	public final Block block;
	@Nullable private final BlockItem blockItem;
	
	/*
	 * @Inputs name of block, settings for blockitem
	 * @Outputs set of an Identifier, Block, and Item
	 */
	public TConBlock(String name, Block block, @Nullable Item.Settings blockItemSettings) {
		TConstruct.logger.debug("Registering a block/item pair for " + name);
		this.id = TConstruct.makeID(name);
		if (BlockRegistry.cottonCheck(name))
			this.block = Registry.register(Registry.BLOCK, getId(), block);
		else this.block = Registry.BLOCK.get(new Identifier("c", name));
		
		if (blockItemSettings != null && ItemRegistry.cottonCheck(name))
			this.blockItem = (BlockItem) ItemRegistry.registerItem(name, new BlockItem(block, blockItemSettings));
		else this.blockItem = (BlockItem) Registry.ITEM.get(new Identifier("c", name));
	}
	
	@Nullable
	public BlockItem getBlockItem() {
		return blockItem;
	}
	@Nullable
	public ItemGroup getGroup() {
		if (blockItem != null) {
			return blockItem.getGroup();
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
