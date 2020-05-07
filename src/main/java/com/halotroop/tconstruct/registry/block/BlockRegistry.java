package com.halotroop.tconstruct.registry.block;

import com.halotroop.tconstruct.TConstruct;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.TorchBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

import java.util.List;

public class BlockRegistry {
	private static final Item.Settings GENERAL_TAB_GENERIC_SETTINGS = new Item.Settings().group(TConstruct.GENERAL_TAB);
	private static final Item.Settings SMELTERY_TAB_GENERIC_SETTINGS = new Item.Settings().group(TConstruct.GENERAL_TAB);
	
	public static TConBlock grout, stone_torch, seared_glass;
	public static DecorStones brownstone;
	public static DecorStones seared_stone;
	
	private static boolean registered;
	
	public static void registerBlocks() {
		if (!registered) {
			grout = new TConBlock("grout", new FallingBlock(FabricBlockSettings.copy(Blocks.CLAY)) {
				@Override
				public void buildTooltip(ItemStack stack, BlockView view, List<Text> tooltip, TooltipContext options) {
					tooltip.add(new TranslatableText("block.tconstruct.grout.tooltip"));
				}
			}, GENERAL_TAB_GENERIC_SETTINGS);
			
			stone_torch = new TConBlock("stone_torch", new StoneTorch(),
					new Item.Settings().group(TConstruct.GADGETS_TAB));
			
			brownstone = new DecorStones(null, "brownstone", Block.Settings.copy(Blocks.STONE), GENERAL_TAB_GENERIC_SETTINGS);
			seared_stone = new DecorStones("seared", "stone", Block.Settings.copy(Blocks.STONE), SMELTERY_TAB_GENERIC_SETTINGS);
			seared_glass = new TConBlock("seared_glass", new Block(Block.Settings.copy(Blocks.GLASS)), SMELTERY_TAB_GENERIC_SETTINGS);
			
			// TODO: Tool tables
			
		} else TConstruct.logger.error("Tried to register blocks twice! Don't do that!");
		registered = true;
	}
	
	static class StoneTorch extends TorchBlock {
		public StoneTorch() {
			super(Block.Settings.copy(Blocks.STONE));
		}
	}
	
	// Returns true if the block with the given name is not registered in the cotton namespace.
	public static boolean cottonCheck(String name) {
		Identifier cotton = new Identifier("c", name);
		return (!FabricLoader.getInstance().isModLoaded("cotton-resources")
				|| (Registry.BLOCK.get(cotton).equals(Blocks.AIR)));
	}
}
