package com.halotroop.tconstruct.registry.item;

import com.halotroop.tconstruct.item.CastItemSet;
import net.minecraft.item.Item;

// TODO: Finish this.
public class ToolItemSet {
	public Item raw_item, broken_item;
	
	// TODO: Add tools with their own classes
	
	public ToolItemSet (String baseName, int miningLevel, int durability, float miningSpeed, float baseAttack,
	                    float handleMod, Ability ability, int abilityMultiplier) {
	}
	
	public enum Ability {
		REINFORCED,
		STONEBOUND,
		JAGGED,
		WRITABLE,
		SLIMY,
		TASTY
	}
	
	
	public enum ToolPart {
		// Sign plate
		SIGN_PLATE(ToolPartSlot.HEAD),
		// Tool heads
		AXE_HEAD(ToolPartSlot.HEAD),
		BROAD_AXE_HEAD(ToolPartSlot.HEAD),
		EXCAVATOR_HEAD(ToolPartSlot.HEAD),
		PICKAXE_HEAD(ToolPartSlot.HEAD),
		HAMMER_HEAD(ToolPartSlot.HEAD),
		SCYTHE_KAMA(ToolPartSlot.HEAD),
		SHOVEL_HEAD(ToolPartSlot.HEAD),
		ARROW_HEAD(ToolPartSlot.HEAD),
		// Blades
		LARGE_SWORD_BLADE(ToolPartSlot.HEAD),
		SWORD_BLADE(ToolPartSlot.HEAD),
		KNIFE_BLADE(ToolPartSlot.HEAD),
		
		// Sword Guards
		HAND_GUARD(ToolPartSlot.GUARD),
		WIDE_GUARD(ToolPartSlot.GUARD),
		CROSS_GUARD(ToolPartSlot.GUARD),
		
		// Bindings
		BINDING(ToolPartSlot.BINDING),
		TOUGH_BINDING(ToolPartSlot.BINDING),
		
		// Tool rods
		TOOL_ROD(ToolPartSlot.ROD),
		TOUGH_TOOL_ROD(ToolPartSlot.ROD),
		
		// Bow limb
		BOWLIMB(ToolPartSlot.LIMB),
		
		// Miscellaneous
		PLATE(ToolPartSlot.PLATE),
		LARGE_PLATE(ToolPartSlot.PLATE),
		PAN(ToolPartSlot.PAN);
		
		final ToolPartSlot slot;
		ToolPart(ToolPartSlot slot) {
			this.slot = slot;
		}
	}
	
	private enum ToolPartSlot {
		HEAD(),
		BINDING(),
		GUARD(),
		ROD(),
		LIMB(),
		PLATE(),
		PAN()
	}
}
