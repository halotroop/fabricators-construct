package com.halotroop.tconstruct.registry.block;

import com.halotroop.tconstruct.TConstruct;
import com.halotroop.tconstruct.registry.TConRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BlockItemPair {
	@NotNull public final Identifier id;
	@NotNull public final Block block;
	@NotNull public final BlockItem blockItem;
	
	/*
	 * @Inputs name of block, settings for blockitem
	 * @Outputs set of an Identifier, Block, and Item
	 */
	public BlockItemPair(@NotNull String name, @NotNull Block block, @NotNull Item.Settings blockItemSettings) {
		TConstruct.logger.debug("Registering a block/item pair for " + name);
		this.id = TConstruct.makeID(name);
		
		if (TConRegistry.cottonBlockCheck(name))
			this.block = Registry.register(Registry.BLOCK, id, block);
		else this.block = TConRegistry.cottonBlock(name);
		
		if (TConRegistry.cottonItemCheck(name))
			this.blockItem = (BlockItem) TConRegistry.registerItem(name, new BlockItem(block, blockItemSettings));
		else this.blockItem = (BlockItem) TConRegistry.cottonItem(name);
	}
	
	@Nullable
	public ItemGroup getGroup() {
		return blockItem.getGroup();
	}
}
