package com.halotroop.tconstruct.registry.block;

import com.halotroop.tconstruct.TConstruct;
import com.halotroop.tconstruct.registry.item.ItemRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.TorchBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.BlockView;

import java.util.List;

public class BlockRegistry {
	private static final Item.Settings GENERAL_TAB_GENERIC_SETTINGS = new Item.Settings().group(TConstruct.GENERAL_TAB);
	private static final Item.Settings SMELTERY_TAB_GENERIC_SETTINGS = new Item.Settings().group(TConstruct.GENERAL_TAB);
	
	public static TConBlock grout, stone_torch;
	public static DecorStones brownstone;
	public static DecorStones seared_stone;
	public static TConBlock seared_glass;
	
	private static boolean registered;
	
	public static void registerBlocks() {
		if (!registered) {
			grout = new TConBlock("grout", new FallingBlock(FabricBlockSettings.copy(Blocks.CLAY)) {
				@Override
				public void buildTooltip(ItemStack stack, BlockView view, List<Text> tooltip, TooltipContext options) {
					tooltip.add(new TranslatableText("block.tconstruct.grout.tooltip"));
				}
			}, GENERAL_TAB_GENERIC_SETTINGS);
			
			stone_torch = new TConBlock("stone_torch", new StoneTorch(Block.Settings.copy(Blocks.TORCH)),
					new Item.Settings().group(TConstruct.GADGETS_TAB));
			
			brownstone = new DecorStones(null, "brownstone", Block.Settings.copy(Blocks.STONE), GENERAL_TAB_GENERIC_SETTINGS);
			seared_stone = new DecorStones("seared", "stone", Block.Settings.copy(Blocks.STONE), SMELTERY_TAB_GENERIC_SETTINGS);
			seared_glass = new TConBlock("seared_glass", new Block(Block.Settings.copy(Blocks.GLASS)), SMELTERY_TAB_GENERIC_SETTINGS);
		} else TConstruct.logger.error("Tried to register blocks twice! Don't do that!");
		registered = true;
	}
	
	static class StoneTorch extends TorchBlock {
		public StoneTorch(Settings settings) {
			super(settings);
		}
	}
}
