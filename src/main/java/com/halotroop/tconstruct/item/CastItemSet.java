/*
 * Copyright 2020 halotroop, SlimeKnights
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.halotroop.tconstruct.item;

import com.halotroop.registry.RegistryMod;
import com.halotroop.tconstruct.TConstruct;
import net.minecraft.item.Item;

public class CastItemSet {
	public final Item sign_plate, axe_head, broad_axe_head, excavator_head, pickaxe_head, hammer_head, scythe_kama,
			shovel_head, arrow_head, large_sword_blade, sword_blade, knife_blade, hand_guard, wide_guard, cross_guard,
			binding, tough_binding, tool_rod, tough_tool_rod, bowlimb, plate, large_plate, pan;
	
	private final boolean clay;
	
	public CastItemSet(boolean clay) {
		this.clay = clay;
		sign_plate = register("sign_plate");
		axe_head = register("axe_head");
		broad_axe_head = register("broad_axe_head");
		excavator_head = register("excavator_head");
		pickaxe_head = register("pickaxe_head");
		hammer_head = register("hamer_head");
		scythe_kama = register("scythe_kama");
		shovel_head = register("shovel_head");
		arrow_head = register("arrow_head");
		large_sword_blade = register("large_sword_blade");
		sword_blade = register("sword_blade");
		knife_blade = register("knife_blade");
		hand_guard = register("hand_guard");
		wide_guard = register("wide_guard");
		cross_guard = register("cross_guard");
		binding = register("binding");
		tough_binding = register("tough_binding");
		tool_rod = register("tool_rod");
		tough_tool_rod = register("tough_tool_rod");
		bowlimb = register("bowlimb");
		plate = register("plate");
		large_plate = register("large_plate");
		pan = register("pan");
	}
	
	private Item register(String type) {
		return RegistryMod.registerItem( (clay ? "clay_" : "") + type + "_cast", new CastItem(this.clay));
	}
	
	private static class CastItem extends Item {
		private static final Item.Settings settings = new Item.Settings().group(TConstruct.SMELTERY_TAB);
		public boolean clay = false;
		public CastItem(boolean clay) {
			super(settings);
			this.clay = clay;
		}
	}
}
