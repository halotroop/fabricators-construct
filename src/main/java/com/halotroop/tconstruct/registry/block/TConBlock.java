package com.halotroop.tconstruct.registry.block;

import com.halotroop.tconstruct.TConstruct;
import com.halotroop.tconstruct.registry.item.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TConBlock {
	@NotNull private final Identifier id;
	@NotNull private final Block block;
	@Nullable private final BlockItem blockItem;
	
	/*
	 * @Inputs name of block, settings for blockitem
	 * @Outputs set of an Identifier, Block, and Item
	 */
	public TConBlock(@NotNull String name, @NotNull Block block, @Nullable Item.Settings blockItemSettings) {
		TConstruct.logger.debug("Registering a block/item pair for " + name);
		this.id = TConstruct.makeID(name);
		if (BlockRegistry.cottonCheck(name))
			this.block = Registry.register(Registry.BLOCK, getId(), block);
		else this.block = Registry.BLOCK.get(new Identifier("c", name));
		
		if (blockItemSettings != null && ItemRegistry.cottonCheck(name))
			this.blockItem = (BlockItem) ItemRegistry.registerItem(name, new BlockItem(block, blockItemSettings));
		else
			this.blockItem = (BlockItem) ItemRegistry.cotton(name);
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
	@NotNull
	public Block getBlock() {
		return block;
	}
	@NotNull
	public Identifier getId() {
		return id;
	}
}
