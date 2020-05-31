
package net.mcreator.cloudcraft.block;

@ElementsCloudCraft.ModElement.Tag
public class BlockCloudyOil extends ElementsCloudCraft.ModElement {

	@GameRegistry.ObjectHolder("cloudcraft:cloudyoil")
	public static final Block block = null;

	@GameRegistry.ObjectHolder("cloudcraft:cloudyoil")
	public static final Item item = null;

	private Fluid fluid;

	public BlockCloudyOil(ElementsCloudCraft instance) {
		super(instance, 18);
		fluid = new Fluid("cloudyoil", new ResourceLocation("cloudcraft:blocks/cloudyoilstill"),
				new ResourceLocation("cloudcraft:blocks/cloudyoilflowing")).setLuminosity(0).setDensity(1000).setViscosity(1000).setGaseous(true);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockFluidClassic(fluid, Material.WATER) {

		}.setUnlocalizedName("cloudyoil").setRegistryName("cloudyoil"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName("cloudyoil"));
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		ModelBakery.registerItemVariants(item);
		ModelLoader.setCustomMeshDefinition(item, new ItemMeshDefinition() {
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				return new ModelResourceLocation("cloudcraft:cloudyoil", "cloudyoil");
			}
		});
		ModelLoader.setCustomStateMapper(block, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return new ModelResourceLocation("cloudcraft:cloudyoil", "cloudyoil");
			}
		});
	}

}
