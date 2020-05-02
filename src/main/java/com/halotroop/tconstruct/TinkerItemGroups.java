package com.halotroop.tconstruct;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class TinkerItemGroups {

	public static final ItemGroup GENERAL_ITEMS = FabricItemGroupBuilder.build(new Identifier(TConstruct.modid, "tinkers_general"), () -> {
		return new ItemStack(Items.ACACIA_PLANKS);
	});

	public static final ItemGroup TOOLS = FabricItemGroupBuilder.build(new Identifier(TConstruct.modid, "tinkers_tools"), () -> {
		return new ItemStack(Items.ACACIA_PLANKS);
	});

	public static final ItemGroup TOOL_PARTS = FabricItemGroupBuilder.build(new Identifier(TConstruct.modid, "tinkers_tool_parts"), () -> {
		return new ItemStack(Items.ACACIA_PLANKS);
	});

	public static final ItemGroup SMELTERY = FabricItemGroupBuilder.build(new Identifier(TConstruct.modid, "tinkers_smeltery"), () -> {
		return new ItemStack(Items.ACACIA_PLANKS);
	});

	public static final ItemGroup WORLD = FabricItemGroupBuilder.build(new Identifier(TConstruct.modid, "tinkers_world"), () -> {
		return new ItemStack(Items.ACACIA_PLANKS);
	});

	public static final ItemGroup GADGETS = FabricItemGroupBuilder.build(new Identifier(TConstruct.modid, "tinkers_gadgets"), () -> {
		return new ItemStack(Items.ACACIA_PLANKS);
	});
}
