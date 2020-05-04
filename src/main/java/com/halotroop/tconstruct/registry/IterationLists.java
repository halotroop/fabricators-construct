package com.halotroop.tconstruct.registry;

import net.minecraft.util.Util;

import java.util.Arrays;
import java.util.HashSet;

class IterationLists {
	final static String[] VANILLA_METALS = new String[] {"iron", "gold"};
	final static String[] VANILLA_GEMS = new String[] {"diamond", "emerald"};
	// iron, gold, diamond, emerald
	final static String[] VANILLA_TOOL_MATERIALS = combine(VANILLA_METALS, VANILLA_GEMS);
	// leather, and all vanilla tool materials
	final static String[] VANILLA_ARMOR_MATERIALS = add("leather", VANILLA_TOOL_MATERIALS);
	final static String[] VANILLA_WOOD_TYPES = {"acacia", "oak", "birch", "dark_oak", "jungle"};
	
	final static String[] TC_METALS = new String[] {"cobalt", "ardite", "manyullyn", "knightslime", "alubrass", "pigiron"};
	final static String[] TC_GEMS = new String[] {};
	
	
	final static String[] TC_GENERIC_MATERIALS = add("silky_jewel", combine(TC_METALS, TC_GEMS));
	
	final static String[] TOOL_MATERIALS = combine(
			TC_GENERIC_MATERIALS,
			VANILLA_TOOL_MATERIALS
	);
	final static String[] ARMOR_MATERIALS = combine(
			TC_GENERIC_MATERIALS,
			VANILLA_ARMOR_MATERIALS
	);
	static final String[] WOOD_TYPES = combine(
			VANILLA_WOOD_TYPES
	);
	
	private static String[] combine(String[]... arrays) {
		return Util.make(new HashSet<String>(), self -> {
			for (String[] array : arrays) {
				if (array.length != 0)
					self.addAll(Arrays.asList(array.clone()));
			}
		}).toArray(new String[0]);
	}
	
	private static String[] add(String entry, String[] array) {return combine(new String[] {entry}, array);}
}
