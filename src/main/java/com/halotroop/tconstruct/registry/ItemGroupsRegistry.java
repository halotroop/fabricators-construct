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

package com.halotroop.tconstruct.registry;

import com.halotroop.tconstruct.TConstruct;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.function.Supplier;

public enum ItemGroupsRegistry {
	GENERAL(() ->  {return new ItemStack(EverythingRegistry.GENERAL_ITEMS.get("grout"));}),
	TOOLS(() ->  {return new ItemStack(Items.ACACIA_PLANKS);}),
	TOOL_PARTS(() ->  {return new ItemStack(Items.ACACIA_PLANKS);}),
	SMELTERY(() ->  {return new ItemStack(Items.ACACIA_PLANKS);}),
	WORLD(() ->  {return new ItemStack(Items.ACACIA_PLANKS);}),
	GADGETS(() ->  {return new ItemStack(Items.ACACIA_PLANKS);});
	
	public ItemGroup group;
	
	ItemGroupsRegistry(Supplier<ItemStack> stackSupplier) {
		group = FabricItemGroupBuilder.build(TConstruct.makeID(name().toLowerCase()), stackSupplier);
	}
	static void init() {}
}
