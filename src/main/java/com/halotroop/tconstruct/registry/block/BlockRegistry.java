package com.halotroop.tconstruct.registry.block;

import com.halotroop.tconstruct.TConstruct;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FallingBlock;
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
	private static boolean registered = false;
	
	public static TConBlock grout;
	public static DecorStones brownstone;
	public static DecorStones seared_stone;
	public static TConBlock seared_glass;
	
	public BlockRegistry() {
		if (!registered) {
			grout = new TConBlock("grout", new FallingBlock(FabricBlockSettings.copy(Blocks.CLAY)) {
				@Override
				public void buildTooltip(ItemStack stack, BlockView view, List<Text> tooltip, TooltipContext options) {
					tooltip.add(new TranslatableText("block.tconstruct.grout.tooltip"));
				}
			}, GENERAL_TAB_GENERIC_SETTINGS);
			brownstone = new DecorStones(null, "brownstone", Block.Settings.copy(Blocks.STONE), GENERAL_TAB_GENERIC_SETTINGS);
			seared_stone = new DecorStones("seared", "stone", Block.Settings.copy(Blocks.STONE), SMELTERY_TAB_GENERIC_SETTINGS);
			seared_glass = new TConBlock("seared_glass", new Block(Block.Settings.copy(Blocks.GLASS)), SMELTERY_TAB_GENERIC_SETTINGS);
		} else TConstruct.logger.error("Tried to register blocks twice! What are you a masochist?!");
		registered = true;
	}
}
