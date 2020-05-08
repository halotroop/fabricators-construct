package com.halotroop.tconstruct.registry.block;

import com.halotroop.tconstruct.TConstruct;
import com.halotroop.tconstruct.block.smeltery.SmelteryPieceBlock;
import com.halotroop.tconstruct.item.CastItemSet;
import com.halotroop.tconstruct.registry.item.ItemRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import java.util.List;

import static net.minecraft.util.Identifier.tryParse;

public class BlockRegistry extends ItemRegistry {
	public static CastItemSet casts = new CastItemSet(false), clay_casts = new CastItemSet(true);;
	public static final Item stone_rod = ItemRegistry.registerItem("stone_stick",
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
	public static final DecorStones BROWNSTONE = new DecorStones(null, "brownstone", Block.Settings.copy(Blocks.STONE),
			GENERAL_TAB_GENERIC_SETTINGS);
	public static final DecorStones SEARED_STONE = new DecorStones("seared", "stone", Block.Settings.copy(Blocks.STONE),
			SMELTERY_TAB_GENERIC_SETTINGS);
	public static final MaterialSet ARDITE =
			new MaterialSet("ardite", Block.Settings.of(Material.METAL), GENERAL_TAB_GENERIC_SETTINGS,
					0, 0, MaterialSet.Type.METAL);
	public static final MaterialSet COBALT =
			new MaterialSet("cobalt", Block.Settings.of(Material.METAL), GENERAL_TAB_GENERIC_SETTINGS,
					0, 0, MaterialSet.Type.METAL);
	public static final MaterialSet MANYULLYN =
			new MaterialSet("manyullyn", Block.Settings.of(Material.METAL), GENERAL_TAB_GENERIC_SETTINGS,
					0, 0, MaterialSet.Type.METAL);
	
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

	// Returns true if the block with the given name is not registered in the cotton namespace.
	public static boolean cottonCheck(String name) {
		Identifier cotton = new Identifier("c", name);
		return (!FabricLoader.getInstance().isModLoaded("cotton-resources") || (Registry.BLOCK.get(cotton).equals(Blocks.AIR)));
	}
	
	@Deprecated
	public static void initialize() {
		TConstruct.logger.info("Using a dumb way to register blocks and items. Please fix!");
	} // TODO: Move the registry and find a better way to do this.

	public static Block cottonBlock(String name) {
		return Registry.BLOCK.get(tryParse("c:" + name));
	}
}
