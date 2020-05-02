package com.halotroop.tconstruct.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.recipebook.RecipeGroupButtonWidget;
import net.minecraft.container.CraftingContainer;

import java.util.Iterator;

/*
 * Authors: SlimeKnights, halotroop2288
 */
// A side inventory to be displayed to the left or right of another GUI
@Environment(EnvType.CLIENT)
public class SideInventoryWidget extends DrawableHelper implements Drawable, Element {
	
	private int leftOffset;
	private int parentWidth;
	private int parentHeight;
	
	private MinecraftClient client;
	
	public SideInventoryWidget(Screen parent) {
		parentHeight = parent.height;
		parentWidth = parent.width;
	}
	
	public void initialize(int parentWidth, int parentHeight, MinecraftClient client, CraftingContainer<?> craftingContainer) {
		this.client = client;
		this.parentWidth = parentWidth;
		this.parentHeight = parentHeight;
	}
	
	@Override
	public void render(int mouseX, int mouseY, float delta) {
		RenderSystem.pushMatrix();
		RenderSystem.translatef(0.0F, 0.0F, 100.0F);
//		this.client.getTextureManager().bindTexture(TEXTURE);
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		int i = (this.parentWidth - 147) / 2 - this.leftOffset;
		int j = (this.parentHeight - 166) / 2;
		this.blit(i, j, 1, 1, 147, 166);
		
		RenderSystem.popMatrix();
	}
}