package com.halotroop.tconstruct.registry.item;

import com.halotroop.tconstruct.TConstruct;
import com.halotroop.tconstruct.item.CastItemSet;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
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
	
	// Returns true if the item with the given name is not registered in the cotton namespace.
	public static boolean cottonCheck(String name) {
		Identifier cotton = new Identifier("c", name);
		return (FabricLoader.getInstance().isModLoaded("cotton-resources")
				&& (Registry.ITEM.get(cotton).equals(Items.AIR)));
	}
}
