package com.mjr.extraplanets.jei.crystallizer;

import java.util.List;

import javax.annotation.Nonnull;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.recipe.BlankRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.jei.RecipeCategories;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

public class CrystallizerRecipeCategory extends BlankRecipeCategory {
	private static final ResourceLocation guiTexture = new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/crystallizer.png");

	@Nonnull
	private final IDrawable background;
	@Nonnull
	private final String localizedName;
	@Nonnull
	private final IDrawableAnimated saltBar;

	@Nonnull
	public CrystallizerRecipeCategory(IGuiHelper guiHelper) {
		this.background = guiHelper.createDrawable(guiTexture, 3, 4, 168, 80);
		this.localizedName = TranslateUtilities.translate("container.basic.crystallizer.name");
		IDrawableStatic progressBarDrawableSalt = guiHelper.createDrawable(guiTexture, 192, 0, 16, 38);
		this.saltBar = guiHelper.createAnimatedDrawable(progressBarDrawableSalt, 70, IDrawableAnimated.StartDirection.TOP, true);
	}

	@Nonnull
	@Override
	public String getUid() {
		return RecipeCategories.CRYSTALLIZER_ID;
	}

	@Nonnull
	@Override
	public String getTitle() {
		return this.localizedName;
	}

	@Nonnull
	@Override
	public IDrawable getBackground() {
		return this.background;
	}

	@Override
	public void drawAnimations(@Nonnull Minecraft minecraft) {
		this.saltBar.draw(minecraft, 4, 24);
	}

	@Override
	public void setRecipe(@Nonnull IRecipeLayout recipeLayout, @Nonnull IRecipeWrapper recipeWrapper) {
		IGuiItemStackGroup itemStacks = recipeLayout.getItemStacks();

		itemStacks.init(0, true, 3, 2);
		itemStacks.init(1, false, 108, 30);

		if (recipeWrapper instanceof CrystallizerRecipeWrapper) {
			CrystallizerRecipeWrapper circuitFabricatorRecipeWrapper = (CrystallizerRecipeWrapper) recipeWrapper;
			List<ItemStack> inputs = circuitFabricatorRecipeWrapper.getInputs();

			for (int i = 0; i < inputs.size(); ++i) {
				Object o = inputs.get(i);
				if (o != null) {
					itemStacks.setFromRecipe(i, o);
				}
			}
			itemStacks.setFromRecipe(1, circuitFabricatorRecipeWrapper.getOutputs());
		}
	}
}
