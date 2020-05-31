package net.mcreator.cloudcraft.procedure;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.cloudcraft.item.ItemRainbowIngot;
import net.mcreator.cloudcraft.item.ItemIridescentSword;
import net.mcreator.cloudcraft.ElementsCloudCraft;

@ElementsCloudCraft.ModElement.Tag
public class ProcedureIridescentSwordMobIsHitWithTool extends ElementsCloudCraft.ModElement {
	public ProcedureIridescentSwordMobIsHitWithTool(ElementsCloudCraft instance) {
		super(instance, 15);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure IridescentSwordMobIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof EntityPlayer)
				? ((EntityPlayer) entity).inventory.hasItemStack(new ItemStack(ItemIridescentSword.block, (int) (1)))
				: false)) {
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemRainbowIngot.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		}
	}

	@SubscribeEvent
	public void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getSource() != null && event.getSource().getTrueSource() != null) {
			Entity entity = event.getSource().getTrueSource();
			int i = (int) entity.posX;
			int j = (int) entity.posY;
			int k = (int) entity.posZ;
			World world = entity.world;
			java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}
}
