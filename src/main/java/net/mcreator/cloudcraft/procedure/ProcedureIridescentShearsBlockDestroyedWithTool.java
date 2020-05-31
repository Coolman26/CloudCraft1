package net.mcreator.cloudcraft.procedure;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.block.material.Material;

import net.mcreator.cloudcraft.item.ItemMysticButterFlyWings;
import net.mcreator.cloudcraft.ElementsCloudCraft;

@ElementsCloudCraft.ModElement.Tag
public class ProcedureIridescentShearsBlockDestroyedWithTool extends ElementsCloudCraft.ModElement {
	public ProcedureIridescentShearsBlockDestroyedWithTool(ElementsCloudCraft instance) {
		super(instance, 18);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure IridescentShearsBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure IridescentShearsBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure IridescentShearsBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure IridescentShearsBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure IridescentShearsBlockDestroyedWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getMaterial() == Material.LEAVES)) {
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemMysticButterFlyWings.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		}
	}
}
