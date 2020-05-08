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

package com.halotroop.tconstruct.block.entity;

import com.halotroop.tconstruct.registry.EntityRegistry;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.LockableContainerBlockEntity;
import net.minecraft.container.Container;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class PartBuilderBlockEntity extends LockableContainerBlockEntity {
	public PartBuilderBlockEntity() {
		super(EntityRegistry.PART_BUILDER_BLOCK_ENTITY);
	}
	
	@Override
	protected Text getContainerName() {
		return new TranslatableText("container.crafting");
	}
	
	@Override
	protected Container createContainer(int i, PlayerInventory playerInventory) {
		return null;
	}
	
	@Override
	public int getInvSize() {
		return 0;
	}
	
	@Override
	public boolean isInvEmpty() {
		return false;
	}
	
	@Override
	public ItemStack getInvStack(int slot) {
		return null;
	}
	
	@Override
	public ItemStack takeInvStack(int slot, int amount) {
		return null;
	}
	
	@Override
	public ItemStack removeInvStack(int slot) {
		return null;
	}
	
	@Override
	public void setInvStack(int slot, ItemStack stack) {
	
	}
	
	@Override
	public boolean canPlayerUseInv(PlayerEntity player) {
		return false;
	}
	
	@Override
	public void clear() {
	
	}
}
