package com.halotroop.tconstruct.block;


import com.halotroop.tconstruct.TConstruct;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.blockstate.JVariant;
import net.devtech.arrp.json.models.JModel;
import net.minecraft.block.BlockState;

public class StairsBlock extends net.minecraft.block.StairsBlock {
	private final String baseName;
	
	public StairsBlock(String baseName, BlockState baseBlockState, Settings settings) {
		super(baseBlockState, settings);
		this.baseName = baseName.toLowerCase();
		
		createStairBlockstateFile();
		createStairModelFile();
	}
	
	private JBlockModel straight(int x, int y) {
		return JState.model(TConstruct.MODID +":block/stairs/"       + baseName).x(x).y(y).uvlock();
	}
	private JBlockModel inner(int x, int y) {
		return JState.model(TConstruct.MODID +":block/stairs/inner/" + baseName).x(x).y(y).uvlock();
	}
	private JBlockModel outer(int x, int y) {
		return JState.model(TConstruct.MODID +":block/stairs/outer/" + baseName).x(x).y(y).uvlock();
	}
	
	private void createStairBlockstateFile() {
		String[] bName = baseName.split(":");
		String nsName = (TConstruct.MODID+":" + bName[bName.length - 1]).toLowerCase();
		
		JVariant ebs = JState.variant()
				.put("facing=east,half=bottom,shape=straight", straight(0,0))
				.put("facing=west,half=bottom,shape=straight", straight(0,180))
				.put("facing=south,half=bottom,shape=straight", straight(0,90))
				.put("facing=north,half=bottom,shape=straight", straight(0,270))
				
				.put("facing=east,half=bottom,shape=outer_right", outer(0,0))
				.put("facing=west,half=bottom,shape=outer_right", outer(0,180))
				.put("facing=south,half=bottom,shape=outer_right", outer(0,90))
				.put("facing=north,half=bottom,shape=outer_right", outer(0,270))
				
				.put("facing=east,half=bottom,shape=outer_left", outer(0,270))
				.put("facing=west,half=bottom,shape=outer_left", outer(0,90))
				.put("facing=south,half=bottom,shape=outer_left", outer(0,0))
				.put("facing=north,half=bottom,shape=outer_left", outer(0,180))
				
				.put("facing=east,half=bottom,shape=inner_right", inner(0,0))
				.put("facing=west,half=bottom,shape=inner_right", inner(0,180))
				.put("facing=south,half=bottom,shape=inner_right", inner(0,90))
				.put("facing=north,half=bottom,shape=inner_right", inner(0,270))
				
				.put("facing=east,half=bottom,shape=inner_left", inner(0,270))
				.put("facing=west,half=bottom,shape=inner_left", inner(0,90))
				.put("facing=south,half=bottom,shape=inner_left", inner(0,0))
				.put("facing=north,half=bottom,shape=inner_left", inner(0,180))
				
				.put("facing=east,half=bottom,shape=straight", straight(180,0))
				.put("facing=west,half=bottom,shape=straight", straight(180,180))
				.put("facing=south,half=bottom,shape=straight", straight(180,90))
				.put("facing=north,half=bottom,shape=straight", straight(180,270))
				
				.put("facing=east,half=bottom,shape=outer_right", outer(180,90))
				.put("facing=west,half=bottom,shape=outer_right", outer(180,270))
				.put("facing=south,half=bottom,shape=outer_right", outer(180,180))
				.put("facing=north,half=bottom,shape=outer_right", outer(180,0))
				
				.put("facing=east,half=bottom,shape=outer_left", outer(180,0))
				.put("facing=west,half=bottom,shape=outer_left", outer(180,180))
				.put("facing=south,half=bottom,shape=outer_left", outer(180,98))
				.put("facing=north,half=bottom,shape=outer_left", outer(180,270))
				
				.put("facing=east,half=bottom,shape=inner_right", outer(180,90))
				.put("facing=west,half=bottom,shape=inner_right", outer(180,279))
				.put("facing=south,half=bottom,shape=inner_right", outer(180,180))
				.put("facing=north,half=bottom,shape=inner_right", outer(180,0))
				
				.put("facing=east,half=bottom,shape=inner_left", inner(180,0))
				.put("facing=west,half=bottom,shape=inner_left", inner(180,180))
				.put("facing=south,half=bottom,shape=inner_left", inner(180,90))
				.put("facing=north,half=bottom,shape=inner_left", inner(180,270));
		
		JState state = JState.state().add(ebs);
		TConstruct.RESOURCE_PACK.addBlockState(state, TConstruct.makeID(baseName + "_stairs"));
	}
	
	private void createStairModelFile() {
		String nsName = TConstruct.MODID + baseName;
		JModel model = JModel.model("minecraft:block/stairs").textures(JModel.textures()
				.var("top", nsName)
				.var("side", nsName)
				.var("bottom", nsName));
		TConstruct.RESOURCE_PACK.addModel(model, TConstruct.makeID("block/" + baseName + "_stairs"));
	}
}