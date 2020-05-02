package com.halotroop.tconstruct.registry;

import com.halotroop.tconstruct.TConstruct;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {

	public static void registerAll() {

	}

	public static Item registerItem(String name, Item item) {
		System.out.println("Registering " + name + " as a(m) " + item.getClass().getSimpleName());
		return Registry.register(Registry.ITEM, new Identifier(TConstruct.modid, name.toLowerCase()), item);
	}
}
