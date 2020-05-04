package com.halotroop.tconstruct.registry;

import com.halotroop.tconstruct.TConstruct;
import com.halotroop.tconstruct.block.general.*;
import com.halotroop.tconstruct.block.smeltery.SmelteryPieceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

public class EverythingRegistry {
	public static Map<String, Block> BLOCKS = new HashMap<>();
	public static Map<String, Item> ITEMS = new HashMap<>();
	
	public static Map<String, Block> GENERAL_BLOCKS = new HashMap<>();
	public static Map<String, Block> SMELTERY_BLOCKS = new HashMap<>();
	public static Map<String, Block> GADGETS_BLOCKS = new HashMap<>();
	
	public static Map<String, Item> GENERAL_ITEMS = new HashMap<>();
	public static Map<String, Item> SMELTERY_ITEMS = new HashMap<>();
	public static Map<String, Item> GADGETS_ITEMS = new HashMap<>();
	
	public static void registerAll() {
		// THIS ORDER IS VERY IMPORTANT FOR ITERATORS! Don't move things around!
		SoundRegistry.registerAll();
		ItemGroupsRegistry.init();
		
		final String[] block_types = new String[] {"", "slab", "stairs"};
		final String[] stone_styles = new String[] {"", "cobbled", "smooth"};
		final String[] stone_brick_styles = new String[]
				{"", "cracked", "fancy", "square", "road", "triangle", "small", "tile", "inscribed"};
		
		// --General Blocks-- \\
		
		registerGeneralBlock("grout", new FallingBlock(Block.Settings.copy(Blocks.CLAY)));
		
		// STATIONS
		registerGeneralBlock("crafting_station", new CraftingStationBlock());
		registerGeneralBlock("tool_station", new ToolStationBlock());

		// PART BUILDER/STENCIL TABLE
		for (String wood_type : IterationLists.WOOD_TYPES) {
		    registerGeneralBlock(wood_type.toLowerCase() + "_part_builder", new PartBuilderBlock());
			registerGeneralBlock(wood_type.toLowerCase() + "_stencil_table", new StencilTableBlock());
		}
		// TOOL FORGE
		for (String metal : IterationLists.TC_METALS) {
		    registerGeneralBlock(metal.toLowerCase() + "_tool_forge", new ToolForgeBlock(metal));
		}
		// MATERIAL STORAGE BLOCKS
		for (String name : IterationLists.TC_GENERIC_MATERIALS) {
			registerGeneralBlock(name + "_block", new Block(Block.Settings.copy(Blocks.DIAMOND_BLOCK)));
		}
		
		
		// --Smeltery Blocks-- \\
		
		// SEARED GLASSES
		registerSmelteryBlock("seared_glass", new Block(Block.Settings.copy(Blocks.GLASS)));
		
		for (String block_type : block_types) {
			// "SEARED STONE" + SLABS + STAIRS
			for (String stone_style : stone_styles) {
				registerSmelteryBlock(
						// Ex: cobbled_seared_stone_stairs, smooth_seared_stone
						(stone_style.equals("") ? "" : (stone_style + "_")) // Places an _ after if not null
								+ "seared"
								+ (block_type.equals("") ? "" : ("_" + block_type)) // Places an _ between if not null
								+ "_stone",
						new Block(Block.Settings.copy(Blocks.STONE))
				);
			}
			// "SEARED BRICK(S)" + SLABS + STAIRS
			for (String stone_brick_style : stone_brick_styles) {
				registerSmelteryBlock(
						// Ex: inscribed_brownstone_slab, cracked_brownstone
						stone_brick_style + (stone_brick_style.equals("") ? "" : "_") // Places an _ after if not null
								+ "seared_brick" +
								(block_type.equals("") ? "s" : "_" ) + block_type,  // Places an s between if null or an _ if not
						new Block(Block.Settings.copy(Blocks.STONE_BRICKS)));
			}
		}
		
		// SMELTERY PIECES
		// TODO: Give each of these their own type!
		registerSmelteryBlock("smeltery_controller", new SmelteryPieceBlock(Block.Settings.of(Material.STONE)));
		registerSmelteryBlock("seared_tank", new SmelteryPieceBlock(Block.Settings.of(Material.STONE)));
		registerSmelteryBlock("seared_gauge", new SmelteryPieceBlock(Block.Settings.of(Material.STONE)));
		registerSmelteryBlock("seared_faucet", new SmelteryPieceBlock(Block.Settings.of(Material.STONE)));
		registerSmelteryBlock("casting_channel", new SmelteryPieceBlock(Block.Settings.of(Material.STONE)));
		registerSmelteryBlock("casting_table", new SmelteryPieceBlock(Block.Settings.of(Material.STONE)));
		registerSmelteryBlock("casting_basin", new SmelteryPieceBlock(Block.Settings.of(Material.STONE)));
		registerSmelteryBlock("seared_drain", new SmelteryPieceBlock(Block.Settings.of(Material.STONE)));
		registerSmelteryBlock("seared_furnace_controller", new SmelteryPieceBlock(Block.Settings.of(Material.STONE)));
		registerSmelteryBlock("tinker_tank_controller", new SmelteryPieceBlock(Block.Settings.of(Material.STONE)));
		
		
		// --Gadgets Blocks-- \\
		
		// GADGETS MANY MANY BROWN BLOCKS
		for (String block_type : block_types) {
			
			String nullOrUnderscore = block_type.equals("") ? "" : ("_"); // places an _ in between if not null
			
			// "DRIED BRICKS" + SLABS + STAIRS
			registerGadgetsBlock("dried_brick" + (block_type.equals("") ? "s" : block_type),
					new Block(Block.Settings.copy(Blocks.STONE_BRICKS))
			);
			// "DRIED CLAY( BRICKS)" + SLABS + STAIRS
			for (String brown_thing : new String[] {"dried_clay", "dried_clay_bricks"}) {
				registerGadgetsBlock(brown_thing + nullOrUnderscore + block_type,
						new Block(Block.Settings.copy(Blocks.STONE_BRICKS))
				);
			}
			// "BROWNSTONE" + SLABS + STAIRS
			for (String stone_style : stone_styles) {
				registerSmelteryBlock(
						// Ex: cobbled_seared_stone_stairs, smooth_seared_stone
						(stone_style.equals("") ? "" : (stone_style + "_")) // Places an _ after if not null
								+ "brownstone"
								+ (block_type.equals("") ? "" : ("_" + block_type)), // Places an _ between if not null
						new Block(Block.Settings.copy(Blocks.STONE))
				);
			}
			// "BROWNSTONE BRICK(S)" + SLABS + STAIRS
			for (String stone_brick_style : stone_brick_styles) {
				registerSmelteryBlock(
						// Ex: inscribed_brownstone_slab, cracked_brownstone
						stone_brick_style + (stone_brick_style.equals("") ? "" : "_") // Places an _ after if not null
								+ "brownstone_brick" +
								(block_type.equals("") ? "s" : "_" ) + block_type,  // Places an s between if null or an _ if not
						new Block(Block.Settings.copy(Blocks.STONE_BRICKS)));
			}
		}
		
		
		// ~~~~~ ITEMS ~~~~~ \\
		
		for (String material : IterationLists.TC_GEMS) {
			registerGeneralItem(material, new Item(new Item.Settings()
					.group(ItemGroupsRegistry.GENERAL.group)));
		}
		for (String material : IterationLists.TC_METALS) {
			for (String type : new String[] {"nugget", "ingot"})
				registerGeneralItem(material + "_" + type, new Item(new Item.Settings()
						.group(ItemGroupsRegistry.GENERAL.group)));
		}
		
		BLOCKS.putAll(GENERAL_BLOCKS);
		BLOCKS.putAll(SMELTERY_BLOCKS);
		BLOCKS.putAll(GADGETS_BLOCKS);
		ITEMS.putAll(GENERAL_ITEMS);
		ITEMS.putAll(SMELTERY_ITEMS);
		
		EntityRegistry.registerAllBlockEntityTypes();
		EntityRegistry.registerAllEntityTypes();
		ItemGroupsRegistry.init();
	}
	
	// ---End of registration--- \\

	private static Block registerGeneralBlock(String name, Block entry) {
		Block block = registerBlock(name, entry, GENERAL_BLOCKS);
		registerGeneralItem(name, new BlockItem(block, new Item.Settings().group(ItemGroupsRegistry.GENERAL.group)));
		return block;
	}
	
	private static Block registerSmelteryBlock(String name, Block entry) {
		Block block = registerBlock(name, entry, SMELTERY_BLOCKS);
		registerGeneralItem(name, new BlockItem(block, new Item.Settings().group(ItemGroupsRegistry.SMELTERY.group)));
		return block;
	}
	
	private static Block registerGadgetsBlock(String name, Block entry) {
		Block block = registerBlock(name, entry, GADGETS_BLOCKS);
		registerGeneralItem(name, new BlockItem(block, new Item.Settings().group(ItemGroupsRegistry.GADGETS.group)));
		return block;
	}
	
	private static Block registerBlock (String name, Block entry, Map<String, Block> list) {
		TConstruct.logger.info("REGISTERING " + name);
		Block block = Registry.register(Registry.BLOCK, new Identifier(TConstruct.MODID, name.toLowerCase()), entry);
		list.put(name, block);
		return block;
	}
	
	// ~~~~~ ITEMS ~~~~~ \\
	
	private static Item registerGeneralItem(String name, Item entry) {return registerItem(name, entry, GENERAL_ITEMS);}
	
	private static Item registerSmelteryItem(String name, Item entry) {return registerItem(name, entry, SMELTERY_ITEMS);}
	
	private static Item registerGadgetsItem(String name, Item entry) {return registerItem(name, entry, GADGETS_ITEMS);}
	
	private static Item registerItem(String name, Item entry, Map<String, Item> list) {
		Item item = Registry.register(Registry.ITEM, TConstruct.makeID(name), entry);
		list.put(name, item);
		return item;
	}
}
