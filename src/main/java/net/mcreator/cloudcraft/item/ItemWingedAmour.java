
package net.mcreator.cloudcraft.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.cloudcraft.ElementsCloudCraft;

@ElementsCloudCraft.ModElement.Tag
public class ItemWingedAmour extends ElementsCloudCraft.ModElement {
	@GameRegistry.ObjectHolder("cloudcraft:wingedamourhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("cloudcraft:wingedamourbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("cloudcraft:wingedamourlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("cloudcraft:wingedamourboots")
	public static final Item boots = null;
	public ItemWingedAmour(ElementsCloudCraft instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("WINGEDAMOUR", "cloudcraft:armor_", 30, new int[]{5, 5, 10, 8}, 10,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 0f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("wingedamourhelmet")
				.setRegistryName("wingedamourhelmet").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("wingedamourbody")
				.setRegistryName("wingedamourbody").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("wingedamourlegs")
				.setRegistryName("wingedamourlegs").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("wingedamourboots")
				.setRegistryName("wingedamourboots").setCreativeTab(CreativeTabs.COMBAT));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("cloudcraft:wingedamourhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("cloudcraft:wingedamourbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("cloudcraft:wingedamourlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("cloudcraft:wingedamourboots", "inventory"));
	}
}
