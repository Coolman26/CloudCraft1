
package net.mcreator.cloudcraft.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.cloudcraft.item.ItemIridescentIngot;
import net.mcreator.cloudcraft.block.BlockIridescentOre;
import net.mcreator.cloudcraft.ElementsCloudCraft;

@ElementsCloudCraft.ModElement.Tag
public class RecipeIridescentIngotRecipe extends ElementsCloudCraft.ModElement {
	public RecipeIridescentIngotRecipe(ElementsCloudCraft instance) {
		super(instance, 3);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockIridescentOre.block, (int) (1)), new ItemStack(ItemIridescentIngot.block, (int) (1)), 1F);
	}
}
