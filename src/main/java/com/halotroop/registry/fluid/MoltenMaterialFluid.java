/*
 * Copyright 2020 halotroop, SlimeKnights
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.halotroop.registry.fluid;

import com.halotroop.registry.RegistryMod;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.BaseFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;
import net.minecraft.world.WorldView;

public class MoltenMaterialFluid extends BaseFluid {
	public final String name;
	public final BucketItem bucket;
	
	// Registers itself, and its bucket, don't try to do it again!
	public MoltenMaterialFluid(String materialName, ItemGroup bucketItemGroup) {
		this.name = "molten_" + materialName;
		Registry.register(Registry.FLUID, RegistryMod.makeID("molten_" + this.name), this);
		bucket = Registry.register(Registry.ITEM, RegistryMod.makeID(name + "_bucket"),
				new BucketItem(this, new Item.Settings().group(bucketItemGroup)));
	}
	
	@Override
	public Item getBucketItem() {
		return this.bucket;
	}
	
	@Override
	protected boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
		return true;
	}
	
	@Override
	public int getTickRate(WorldView world) {
		return 0;
	}
	
	@Override
	protected float getBlastResistance() {
		return 0;
	}
	
	@Override
	protected BlockState toBlockState(FluidState state) {
		return null;
	}
	
	@Override
	public boolean isStill(FluidState state) {
		return state.isStill();
	}
	
	@Override
	public int getLevel(FluidState state) {
		return state.getLevel();
	}
	
	@Override
	public Fluid getFlowing() {
		return this;
	}
	
	@Override
	public Fluid getStill() {
		return this;
	}
	
	@Override
	protected boolean isInfinite() {
		return false;
	}
	
	@Override
	protected void beforeBreakingBlock(IWorld world, BlockPos pos, BlockState state) {
	
	}
	
	@Override
	protected int method_15733(WorldView worldView) {
		return 0;
	}
	
	@Override
	protected int getLevelDecreasePerBlock(WorldView world) {
		return 0;
	}
}
