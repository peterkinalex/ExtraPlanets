package com.mjr.extraplanets.items.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;

public class PalladiumArmor extends ItemArmor {
	public String name;

	public PalladiumArmor(String name, ArmorMaterial material, int placement) {
		super(material, 0, placement);
		setCreativeTab(ExtraPlanets.ArmorTab);
		this.name = name;
	}

	@Override
	public String getArmorTexture(ItemStack itemStack, Entity entity, int slot, String type) {
		if (itemStack.getItem() == ExtraPlanets_Armor.PALLASIUM_HELMET || itemStack.getItem() == ExtraPlanets_Armor.PALLASIUM_CHEST || itemStack.getItem() == ExtraPlanets_Armor.PALLASIUM_BOOTS) {
			return Constants.TEXTURE_PREFIX + "textures/model/armor/" + name + "_layer_1.png";
		} else if (itemStack.getItem() == ExtraPlanets_Armor.PALLASIUM_LEGINGS) {
			return Constants.TEXTURE_PREFIX + "textures/model/armor/" + name + "_layer_2.png";
		} else {
			return null;
		}
	}
}
