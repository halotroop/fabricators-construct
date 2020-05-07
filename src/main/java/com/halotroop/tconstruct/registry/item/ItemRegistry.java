package com.halotroop.tconstruct.registry.item;

import com.halotroop.tconstruct.TConstruct;
import com.halotroop.tconstruct.item.CastItemSet;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {
	public static CastItemSet casts, clay_casts;
	private static boolean registered;
	
	public static void registerItems() {
		if (!registered) {
			registerItem("stone_stick", new Item(new Item.Settings().group(TConstruct.GADGETS_TAB)));
			casts = new CastItemSet(false);
			clay_casts = new CastItemSet(true);
		} else TConstruct.logger.error("Tried to register items twice! Don't do that!");
		registered = true;
	}
	
	public static Item registerItem(String name, Item item) {
		return Registry.register(Registry.ITEM, TConstruct.makeID(name), item);
	}
}
