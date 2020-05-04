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
	
	ItemGroup group;
	
	private ItemGroupsRegistry(Supplier<ItemStack> stackSupplier) {
		group = FabricItemGroupBuilder.build(TConstruct.makeID(name().toLowerCase()), stackSupplier);
	}
	static void init() {}
}
