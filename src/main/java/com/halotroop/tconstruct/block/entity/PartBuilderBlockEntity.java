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
