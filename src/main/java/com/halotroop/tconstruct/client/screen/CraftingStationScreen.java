package com.halotroop.tconstruct.client.screen;

import com.halotroop.tconstruct.client.screen.container.CraftingStationContainer;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

/*
 * @Authors: shedaniel
 */
@Environment(EnvType.CLIENT)
public class CraftingStationScreen extends ContainerScreen<CraftingStationContainer> {
	
	private static final Identifier BG_TEX = new Identifier("textures/gui/container/crafting_table.png");
	
	public CraftingStationScreen(CraftingStationContainer container, PlayerInventory inventory, Text title) {
		super(container, inventory, title);
	}
	
	@Override
	protected void drawForeground(int mouseX, int mouseY) {
		this.font.draw(this.title.asFormattedString(), 28.0F, 6.0F, 4210752);
		this.font.draw(this.playerInventory.getDisplayName().asFormattedString(), 8.0F, (float) (this.containerHeight - 96 + 2), 4210752);
	}
	
	@Override
	public void render(int mouseX, int mouseY, float delta) {
		this.renderBackground();
		super.render(mouseX, mouseY, delta);
		this.drawMouseoverTooltip(mouseX, mouseY);
	}
	
	@Override
	protected void drawBackground(float delta, int mouseX, int mouseY) {
		assert this.minecraft != null;
		
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.minecraft.getTextureManager().bindTexture(BG_TEX);
		int i = this.x;
		int j = (this.height - this.containerHeight) / 2;
		this.blit(i, j, 0, 0, this.containerWidth, this.containerHeight);
	}
}
