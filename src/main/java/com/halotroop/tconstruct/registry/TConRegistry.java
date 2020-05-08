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
import com.halotroop.tconstruct.block.general.CraftingStationBlock;
import com.halotroop.tconstruct.block.general.PartBuilderBlock;
import com.halotroop.tconstruct.block.general.StencilTableBlock;
import com.halotroop.tconstruct.block.smeltery.SmelteryPieceBlock;
import com.halotroop.tconstruct.item.CastItemSet;
import com.halotroop.tconstruct.registry.block.BlockItemPair;
import com.halotroop.tconstruct.registry.block.StoneSet;
import com.halotroop.tconstruct.registry.block.MaterialSet;
import com.halotroop.tconstruct.registry.block.WoodenSet;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import java.util.List;

public class TConRegistry {
	public static final Item.Settings GENERAL_TAB_GENERIC_SETTINGS = new Item.Settings().group(TConstruct.GENERAL_TAB);
	public static final Item.Settings SMELTERY_TAB_GENERIC_SETTINGS = new Item.Settings().group(TConstruct.SMELTERY_TAB);
	public static final Item.Settings TOOLS_TAB_GENERIC_SETTINGS = new Item.Settings().group(TConstruct.TOOLS_TAB);
	public static final Item.Settings TOOL_PARTS_TAB_GENERIC_SETTINGS = new Item.Settings().group(TConstruct.TOOL_PARTS_TAB);
	public static final Item.Settings WORLD_TAB_GENERIC_SETTINGS = new Item.Settings().group(TConstruct.WORLD_TAB);
	public static final Item.Settings GADGETS_TAB_GENERIC_SETTINGS = new Item.Settings().group(TConstruct.GADGETS_TAB);
	
	public static final MaterialSet ARDITE =
			new MaterialSet("ardite", GENERAL_TAB_GENERIC_SETTINGS, Block.Settings.of(Material.METAL),
					0, 0, MaterialSet.Type.METAL);
	public static final MaterialSet COBALT =
			new MaterialSet("cobalt", GENERAL_TAB_GENERIC_SETTINGS, Block.Settings.of(Material.METAL),
					0, 0, MaterialSet.Type.METAL);
	public static final MaterialSet MANYULLYN =
			new MaterialSet("manyullyn", GENERAL_TAB_GENERIC_SETTINGS, Block.Settings.of(Material.METAL),
					0, 0, MaterialSet.Type.ALLOY);
	
	public static CastItemSet casts = new CastItemSet(false), clay_casts = new CastItemSet(true);
	public static final Item stone_rod = registerItem("stone_stick",
			new Item(SMELTERY_TAB_GENERIC_SETTINGS));
	public static final BlockItemPair GROUT = new BlockItemPair("grout", new FallingBlock(FabricBlockSettings.copy(Blocks.CLAY)) {
		@Override
		public void buildTooltip(ItemStack stack, BlockView view, List<Text> tooltip, TooltipContext options) {
			tooltip.add(new TranslatableText("block.tconstruct.grout.tooltip"));
		}
	}, GENERAL_TAB_GENERIC_SETTINGS);

	public static final BlockItemPair
			STONE_TORCH = new BlockItemPair("stone_torch", new StoneTorch(), GADGETS_TAB_GENERIC_SETTINGS),
			SEARED_GLASS = new BlockItemPair("seared_glass", new Block(Block.Settings.copy(Blocks.GLASS)),
			SMELTERY_TAB_GENERIC_SETTINGS);
	public static final StoneSet BROWNSTONE = new StoneSet(null, "brownstone", Block.Settings.copy(Blocks.STONE),
			GENERAL_TAB_GENERIC_SETTINGS);
	public static final StoneSet SEARED_STONE = new StoneSet("seared", "stone", Block.Settings.copy(Blocks.STONE),
			SMELTERY_TAB_GENERIC_SETTINGS);
	
	// ~~Tool Tables~~ \\
	public static final WoodenSet CRAFTING_STATION = new WoodenSet("crafting_station",
			CraftingStationBlock::new, GENERAL_TAB_GENERIC_SETTINGS);
	public static final WoodenSet PART_BUILDER = new WoodenSet("part_builder",
			PartBuilderBlock::new, GENERAL_TAB_GENERIC_SETTINGS);
	public static final WoodenSet STENCIL_TABLE = new WoodenSet("stencil_table",
			StencilTableBlock::new, GENERAL_TAB_GENERIC_SETTINGS);
	
	// --Smeltery Blocks-- \\
	// TODO: Give each of these their own type!
	public static final BlockItemPair
			SMELTERY_CONTROLLER = new BlockItemPair("smeltery_controller",
			new SmelteryPieceBlock(Block.Settings.of(Material.STONE)), SMELTERY_TAB_GENERIC_SETTINGS),
	SEARED_TANK = new BlockItemPair("seared_tank",
			new SmelteryPieceBlock(Block.Settings.of(Material.STONE)), SMELTERY_TAB_GENERIC_SETTINGS),
	SEARED_GUAGE = new BlockItemPair("seared_gauge",
			new SmelteryPieceBlock(Block.Settings.of(Material.STONE)), SMELTERY_TAB_GENERIC_SETTINGS),
	SEARED_FAUCET = new BlockItemPair("seared_faucet",
			new SmelteryPieceBlock(Block.Settings.of(Material.STONE)), SMELTERY_TAB_GENERIC_SETTINGS),
	CASTING_CHANNEL = new BlockItemPair("casting_channel",
			new SmelteryPieceBlock(Block.Settings.of(Material.STONE)), SMELTERY_TAB_GENERIC_SETTINGS),
	CASTING_TABLE = new BlockItemPair("casting_table",
			new SmelteryPieceBlock(Block.Settings.of(Material.STONE)), SMELTERY_TAB_GENERIC_SETTINGS),
	 CASTING_BASIN = new BlockItemPair("casting_basin",
			new SmelteryPieceBlock(Block.Settings.of(Material.STONE)), SMELTERY_TAB_GENERIC_SETTINGS),
	SEARED_DRAIN = new BlockItemPair("seared_drain",
			new SmelteryPieceBlock(Block.Settings.of(Material.STONE)), SMELTERY_TAB_GENERIC_SETTINGS),
	SEARED_FURNACE_CONTROLLER = new BlockItemPair("seared_furnace_controller",
			new SmelteryPieceBlock(Block.Settings.of(Material.STONE)), SMELTERY_TAB_GENERIC_SETTINGS),
	TINKER_TANK_CONTROLLER = new BlockItemPair("tinker_tank_controller",
			new SmelteryPieceBlock(Block.Settings.of(Material.STONE)), SMELTERY_TAB_GENERIC_SETTINGS);

	static class StoneTorch extends TorchBlock {
		public StoneTorch() {
			super(Block.Settings.copy(Blocks.STONE));
		}
	}
	
	public static Item registerItem(String name, Item item) {
		return Registry.register(Registry.ITEM, TConstruct.makeID(name), item);
	}
	
	// Returns true if the block with the given name is NOT registered in the cotton namespace.
	public static boolean cottonBlockCheck(String name) {
		Identifier cotton = new Identifier("c", name);
		return (!FabricLoader.getInstance().isModLoaded("cotton-resources") || (Registry.BLOCK.get(cotton).equals(Blocks.AIR)));
	}
	
	// Returns true if the item with the given name is NOT registered in the cotton namespace.
	public static boolean cottonItemCheck(String name) {
		Identifier cotton = new Identifier("c", name);
		return (FabricLoader.getInstance().isModLoaded("cotton-resources")
				&& (Registry.ITEM.get(cotton).equals(Items.AIR)));
	}
	
	@Deprecated
	public static void initialize() {
		TConstruct.logger.info("Using a dumb way to register blocks and items. Please fix!");
	} // TODO: Move the registry and find a better way to do this.

	// Returns the cotton equivalent of the block requested.
	public static Block cottonBlock(String name) {
		return Registry.BLOCK.get(new Identifier("c", name));
	}
	// Returns the cotton equivalent of the item requested.
	public static Item cottonItem(String name) {
		return Registry.ITEM.get(new Identifier("c", name));
	}
}
