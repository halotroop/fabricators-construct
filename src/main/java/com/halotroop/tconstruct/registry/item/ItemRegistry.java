package com.halotroop.tconstruct.registry.item;

import com.halotroop.tconstruct.TConstruct;
import com.halotroop.tconstruct.item.CastItemSet;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {
	public static final Item.Settings GENERAL_TAB_GENERIC_SETTINGS =
			new Item.Settings().group(TConstruct.GENERAL_TAB);
	public static final Item.Settings SMELTERY_TAB_GENERIC_SETTINGS =
			new Item.Settings().group(TConstruct.GENERAL_TAB);
	public static final Item.Settings TOOLS_TAB_GENERIC_SETTINGS =
			new Item.Settings().group(TConstruct.TOOLS_TAB);
	public static final Item.Settings TOOL_PARTS_TAB_GENERIC_SETTINGS =
			new Item.Settings().group(TConstruct.TOOL_PARTS_TAB);
	public static final Item.Settings WORLD_TAB_GENERIC_SETTINGS =
			new Item.Settings().group(TConstruct.WORLD_TAB);
	public static final Item.Settings GADGETS_TAB_GENERIC_SETTINGS =
			new Item.Settings().group(TConstruct.GADGETS_TAB);
	
	private static boolean registered;
	
	public static Item registerItem(String name, Item item) {
		return Registry.register(Registry.ITEM, TConstruct.makeID(name), item);
	}
	
	// Returns true if the item with the given name is not registered in the cotton namespace.
	public static boolean cottonCheck(String name) {
		Identifier cotton = new Identifier("c", name);
		return (FabricLoader.getInstance().isModLoaded("cotton-resources")
				&& (Registry.ITEM.get(cotton).equals(Items.AIR)));
	}

	public static Item cottonItem(String name) {
		return Registry.ITEM.get(new Identifier("c:"+name));
	}
}
