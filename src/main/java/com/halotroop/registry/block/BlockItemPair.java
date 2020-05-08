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
	
	// This is NOT for creating Blocks without BlockItems! That would be pointless!
	// Creates an object containing both a Block and a BlockItem, so they can both be referenced from a larger container
	public BlockItemPair(@NotNull String name, @NotNull Block block, @NotNull Item.Settings blockItemSettings) {
		RegistryMod.logger.debug("Registering a block/item pair for " + name);
		this.id = RegistryMod.makeID(name);
		
		if (RegistryMod.cottonBlockCheck(name))
			this.block = Registry.register(Registry.BLOCK, this.id, block);
		else this.block = RegistryMod.cottonBlock(name);
		
		if (RegistryMod.cottonItemCheck(name))
			this.blockItem = (BlockItem) RegistryMod.registerItem(name, new BlockItem(block, blockItemSettings));
		else this.blockItem = (BlockItem) RegistryMod.cottonItem(name);
	}
	
	@Nullable
	public ItemGroup getGroup() {
		return blockItem.getGroup();
	}
}
