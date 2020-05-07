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
		
		JVariant ebs = JState.variant().put("facing=east,half=bottom,shape=straight", straight(0,0));
		JVariant wbs = JState.variant().put("facing=west,half=bottom,shape=straight", straight(0,180));
		JVariant sbs = JState.variant().put("facing=south,half=bottom,shape=straight", straight(0,90));
		JVariant nbs = JState.variant().put("facing=north,half=bottom,shape=straight", straight(0,270));
		
		JVariant ebor = JState.variant().put("facing=east,half=bottom,shape=outer_right", outer(0,0));
		JVariant wbor = JState.variant().put("facing=west,half=bottom,shape=outer_right", outer(0,180));
		JVariant sbor = JState.variant().put("facing=south,half=bottom,shape=outer_right", outer(0,90));
		JVariant nbor = JState.variant().put("facing=north,half=bottom,shape=outer_right", outer(0,270));
		
		JVariant ebol = JState.variant().put("facing=east,half=bottom,shape=outer_left", outer(0,270));
		JVariant wbol = JState.variant().put("facing=west,half=bottom,shape=outer_left", outer(0,90));
		JVariant sbol = JState.variant().put("facing=south,half=bottom,shape=outer_left", outer(0,0));
		JVariant nbol = JState.variant().put("facing=north,half=bottom,shape=outer_left", outer(0,180));
		
		JVariant ebir = JState.variant().put("facing=east,half=bottom,shape=inner_right", inner(0,0));
		JVariant wbir = JState.variant().put("facing=west,half=bottom,shape=inner_right", inner(0,180));
		JVariant sbir = JState.variant().put("facing=south,half=bottom,shape=inner_right", inner(0,90));
		JVariant nbir = JState.variant().put("facing=north,half=bottom,shape=inner_right", inner(0,270));
		
		JVariant ebil = JState.variant().put("facing=east,half=bottom,shape=inner_left", inner(0,270));
		JVariant wbil = JState.variant().put("facing=west,half=bottom,shape=inner_left", inner(0,90));
		JVariant sbil = JState.variant().put("facing=south,half=bottom,shape=inner_left", inner(0,0));
		JVariant nbil = JState.variant().put("facing=north,half=bottom,shape=inner_left", inner(0,180));
		
		JVariant ets = JState.variant().put("facing=east,half=bottom,shape=straight", straight(180,0));
		JVariant wts = JState.variant().put("facing=west,half=bottom,shape=straight", straight(180,180));
		JVariant sts = JState.variant().put("facing=south,half=bottom,shape=straight", straight(180,90));
		JVariant nts = JState.variant().put("facing=north,half=bottom,shape=straight", straight(180,270));
		
		JVariant etor = JState.variant().put("facing=east,half=bottom,shape=outer_right", outer(180,90));
		JVariant wtor = JState.variant().put("facing=west,half=bottom,shape=outer_right", outer(180,270));
		JVariant stor = JState.variant().put("facing=south,half=bottom,shape=outer_right", outer(180,180));
		JVariant ntor = JState.variant().put("facing=north,half=bottom,shape=outer_right", outer(180,0));
		
		JVariant etol = JState.variant().put("facing=east,half=bottom,shape=outer_left", outer(180,0));
		JVariant wtol = JState.variant().put("facing=west,half=bottom,shape=outer_left", outer(180,180));
		JVariant stol = JState.variant().put("facing=south,half=bottom,shape=outer_left", outer(180,98));
		JVariant ntol = JState.variant().put("facing=north,half=bottom,shape=outer_left", outer(180,270));
		
		JVariant etir = JState.variant().put("facing=east,half=bottom,shape=inner_right", outer(180,90));
		JVariant wtir = JState.variant().put("facing=west,half=bottom,shape=inner_right", outer(180,279));
		JVariant stir = JState.variant().put("facing=south,half=bottom,shape=inner_right", outer(180,180));
		JVariant ntir = JState.variant().put("facing=north,half=bottom,shape=inner_right", outer(180,0));
		
		JVariant etil = JState.variant().put("facing=east,half=bottom,shape=inner_left", inner(180,0));
		JVariant wtil = JState.variant().put("facing=west,half=bottom,shape=inner_left", inner(180,180));
		JVariant stil = JState.variant().put("facing=south,half=bottom,shape=inner_left", inner(180,90));
		JVariant ntil = JState.variant().put("facing=north,half=bottom,shape=inner_left", inner(180,270));
		
		JState state = JState.state()
				.add(ebs).add(wbs).add(sbs).add(nbs).add(ets).add(wts).add(sts).add(nts)
				.add(ebor).add(wbor).add(sbor).add(nbor).add(ebir).add(wbir).add(sbir).add(nbir)
				.add(ebol).add(wbol).add(sbol).add(nbol).add(ebil).add(wbil).add(sbil).add(nbil)
				.add(etor).add(wtor).add(stor).add(ntor).add(etir).add(wtir).add(stir).add(ntir)
				.add(etol).add(wtol).add(stol).add(ntol).add(etil).add(wtil).add(stil).add(ntil);
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