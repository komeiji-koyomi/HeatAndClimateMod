package defeatedcrow.hac.food;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import defeatedcrow.hac.core.ClimateCore;
import defeatedcrow.hac.food.block.BlockPotteryPot;
import defeatedcrow.hac.food.block.BlockSteelPot;
import defeatedcrow.hac.food.block.BlockTeaPot;
import defeatedcrow.hac.food.block.crop.BlockCoffee;
import defeatedcrow.hac.food.block.crop.BlockCotton;
import defeatedcrow.hac.food.block.crop.BlockLeavesLemon;
import defeatedcrow.hac.food.block.crop.BlockLeavesOlive;
import defeatedcrow.hac.food.block.crop.BlockLeavesTea;
import defeatedcrow.hac.food.block.crop.BlockOnion;
import defeatedcrow.hac.food.block.crop.BlockRice;
import defeatedcrow.hac.food.block.crop.BlockSaplingDC;
import defeatedcrow.hac.food.block.crop.BlockSpinach;
import defeatedcrow.hac.food.block.crop.BlockTomato;
import defeatedcrow.hac.food.capability.DrinkCapabilityHandler;
import defeatedcrow.hac.food.item.ItemDCCrops;
import defeatedcrow.hac.food.item.ItemDCSeeds;
import defeatedcrow.hac.food.item.ItemDairy;
import defeatedcrow.hac.food.item.ItemFluidDrop;
import defeatedcrow.hac.food.item.ItemFluidPack;
import defeatedcrow.hac.food.item.ItemMeatMaterials;
import defeatedcrow.hac.food.item.ItemPastry;
import defeatedcrow.hac.food.item.ItemSilverCup;
import defeatedcrow.hac.food.item.ItemTeaLeaves;
import defeatedcrow.hac.food.item.RoundBreadItem;
import defeatedcrow.hac.food.item.RoundPastryItem;
import defeatedcrow.hac.food.item.SquarePastryItem;
import defeatedcrow.hac.food.item.StickFoodsItem;
import defeatedcrow.hac.main.ClimateMain;
import defeatedcrow.hac.main.MainMaterialRegister;
import defeatedcrow.hac.main.block.fluid.DCFluidBlockBase;
import defeatedcrow.hac.main.config.ModuleConfig;

public class FoodInitRegister {

	private FoodInitRegister() {
	}

	public static void load() {
		DrinkCapabilityHandler.register();

		loadBlocks();
		loadItems();
		loadFluids();
		loadFoods();

		if (ModuleConfig.food)
			loadCreativeTab();
	}

	static void loadBlocks() {
		FoodInit.cropRice = new BlockRice(ClimateCore.PACKAGE_BASE + "_crop_rice");
		MainMaterialRegister.registerBlock(FoodInit.cropRice, ClimateCore.PACKAGE_BASE + "_crop_rice");
		ClimateMain.proxy.addCropBlock(FoodInit.cropRice, "crop_rice", 3);

		FoodInit.cropOnion = new BlockOnion(ClimateCore.PACKAGE_BASE + "_crop_onion");
		MainMaterialRegister.registerBlock(FoodInit.cropOnion, ClimateCore.PACKAGE_BASE + "_crop_onion");
		ClimateMain.proxy.addCropBlock(FoodInit.cropOnion, "crop_onion", 3);

		FoodInit.cropSpinach = new BlockSpinach(ClimateCore.PACKAGE_BASE + "_crop_spinach");
		MainMaterialRegister.registerBlock(FoodInit.cropSpinach, ClimateCore.PACKAGE_BASE + "_crop_spinach");
		ClimateMain.proxy.addCropBlock(FoodInit.cropSpinach, "crop_spinach", 3);

		FoodInit.cropTomato = new BlockTomato(ClimateCore.PACKAGE_BASE + "_crop_tomato");
		MainMaterialRegister.registerBlock(FoodInit.cropTomato, ClimateCore.PACKAGE_BASE + "_crop_tomato");
		ClimateMain.proxy.addCropBlock(FoodInit.cropTomato, "crop_tomato", 7);

		FoodInit.cropCoffee = new BlockCoffee(ClimateCore.PACKAGE_BASE + "_crop_coffee");
		MainMaterialRegister.registerBlock(FoodInit.cropCoffee, ClimateCore.PACKAGE_BASE + "_crop_coffee");
		ClimateMain.proxy.addCropBlock(FoodInit.cropCoffee, "crop_coffee", 7);

		FoodInit.cropCotton = new BlockCotton(ClimateCore.PACKAGE_BASE + "_crop_cotton");
		MainMaterialRegister.registerBlock(FoodInit.cropCotton, ClimateCore.PACKAGE_BASE + "_crop_cotton");
		ClimateMain.proxy.addCropBlock(FoodInit.cropCotton, "crop_cotton", 7);

		FoodInit.leavesLemon = new BlockLeavesLemon(ClimateCore.PACKAGE_BASE + "_leaves_lemon");
		MainMaterialRegister.registerBlock(FoodInit.leavesLemon, ClimateCore.PACKAGE_BASE + "_leaves_lemon");
		ClimateMain.proxy.addSidedBlock(FoodInit.leavesLemon, "leaves_lemon", 3);

		FoodInit.leavesOlive = new BlockLeavesOlive(ClimateCore.PACKAGE_BASE + "_leaves_olive");
		MainMaterialRegister.registerBlock(FoodInit.leavesOlive, ClimateCore.PACKAGE_BASE + "_leaves_olive");
		ClimateMain.proxy.addSidedBlock(FoodInit.leavesOlive, "leaves_olive", 3);

		FoodInit.leavesTea = new BlockLeavesTea(ClimateCore.PACKAGE_BASE + "_leaves_tea");
		MainMaterialRegister.registerBlock(FoodInit.leavesTea, ClimateCore.PACKAGE_BASE + "_leaves_tea");

		FoodInit.saplings = new BlockSaplingDC(ClimateCore.PACKAGE_BASE + "_crop_sapling");
		MainMaterialRegister.registerBlock(FoodInit.saplings, ClimateCore.PACKAGE_BASE + "_crop_sapling");
		ClimateMain.proxy.addCropBlock(FoodInit.saplings, "crop_sapling", 2);

		FoodInit.potteryPot = new BlockPotteryPot(ClimateCore.PACKAGE_BASE + "_device_pottery_pot");
		MainMaterialRegister.registerBlock(FoodInit.potteryPot, ClimateCore.PACKAGE_BASE + "_device_pottery_pot");

		FoodInit.steelPot = new BlockSteelPot(ClimateCore.PACKAGE_BASE + "_device_steel_pot");
		MainMaterialRegister.registerBlock(FoodInit.steelPot, ClimateCore.PACKAGE_BASE + "_device_steel_pot");

		FoodInit.teaPot = new BlockTeaPot(ClimateCore.PACKAGE_BASE + "_device_tea_pot");
		MainMaterialRegister.registerBlock(FoodInit.teaPot, ClimateCore.PACKAGE_BASE + "_device_tea_pot");
	}

	static void loadItems() {

		FoodInit.crops = new ItemDCCrops(9).setUnlocalizedName(ClimateCore.PACKAGE_BASE + "_food_crops");
		GameRegistry.register(FoodInit.crops.setRegistryName(ClimateCore.PACKAGE_BASE + "_food_crops"));

		FoodInit.seeds = new ItemDCSeeds(5).setUnlocalizedName(ClimateCore.PACKAGE_BASE + "_food_seeds");
		GameRegistry.register(FoodInit.seeds.setRegistryName(ClimateCore.PACKAGE_BASE + "_food_seeds"));

		FoodInit.teaLeaves = new ItemTeaLeaves(2).setUnlocalizedName(ClimateCore.PACKAGE_BASE + "_food_leaves");
		GameRegistry.register(FoodInit.teaLeaves.setRegistryName(ClimateCore.PACKAGE_BASE + "_food_leaves"));

		FoodInit.dairy = new ItemDairy().setUnlocalizedName(ClimateCore.PACKAGE_BASE + "_food_dairy");
		GameRegistry.register(FoodInit.dairy.setRegistryName(ClimateCore.PACKAGE_BASE + "_food_dairy"));

		FoodInit.meat = new ItemMeatMaterials().setUnlocalizedName(ClimateCore.PACKAGE_BASE + "_food_meat");
		GameRegistry.register(FoodInit.meat.setRegistryName(ClimateCore.PACKAGE_BASE + "_food_meat"));

		FoodInit.pastry = new ItemPastry().setUnlocalizedName(ClimateCore.PACKAGE_BASE + "_food_pastry");
		GameRegistry.register(FoodInit.pastry.setRegistryName(ClimateCore.PACKAGE_BASE + "_food_pastry"));
	}

	static void loadFoods() {
		FoodInit.bread = new RoundBreadItem(false).setUnlocalizedName(ClimateCore.PACKAGE_BASE + "_food_bread");
		GameRegistry.register(FoodInit.bread.setRegistryName(ClimateCore.PACKAGE_BASE + "_food_bread"));

		FoodInit.sticks = new StickFoodsItem(true).setUnlocalizedName(ClimateCore.PACKAGE_BASE + "_food_stick");
		GameRegistry.register(FoodInit.sticks.setRegistryName(ClimateCore.PACKAGE_BASE + "_food_stick"));

		FoodInit.pastryRound = new RoundPastryItem(false).setUnlocalizedName(ClimateCore.PACKAGE_BASE + "_food_tart");
		GameRegistry.register(FoodInit.pastryRound.setRegistryName(ClimateCore.PACKAGE_BASE + "_food_tart"));

		FoodInit.pastrySquare = new SquarePastryItem(false).setUnlocalizedName(ClimateCore.PACKAGE_BASE + "_food_pie");
		GameRegistry.register(FoodInit.pastrySquare.setRegistryName(ClimateCore.PACKAGE_BASE + "_food_pie"));

		FoodInit.cupSilver = new ItemSilverCup(true).setUnlocalizedName(ClimateCore.PACKAGE_BASE + "_food_teacup");
		GameRegistry.register(FoodInit.cupSilver.setRegistryName(ClimateCore.PACKAGE_BASE + "_food_teacup"));
	}

	public static void loadFluids() {
		// fluid
		FoodInit.oil = new Fluid("dcs.seed_oil", new ResourceLocation(ClimateCore.PACKAGE_ID,
				"blocks/fluid/seedoil_still"), new ResourceLocation(ClimateCore.PACKAGE_ID,
				"blocks/fluid/seedoil_still")).setUnlocalizedName(ClimateCore.PACKAGE_BASE + ".seed_oil");
		FluidRegistry.registerFluid(FoodInit.oil);
		FoodInit.oilBlock = new DCFluidBlockBase(FoodInit.oil, "seedoil_still")
				.setUnlocalizedName(ClimateCore.PACKAGE_BASE + "_fluidblock_oil");
		MainMaterialRegister.registerBlock(FoodInit.oilBlock, ClimateCore.PACKAGE_BASE + "_fluidblock_oil");
		FoodInit.oil.setBlock(FoodInit.oilBlock);

		FoodInit.greenTea = new Fluid("dcs.green_tea", new ResourceLocation(ClimateCore.PACKAGE_ID,
				"blocks/fluid/greentea_still"), new ResourceLocation(ClimateCore.PACKAGE_ID,
				"blocks/fluid/greentea_still")).setUnlocalizedName(ClimateCore.PACKAGE_BASE + ".green_tea")
				.setTemperature(370);
		FluidRegistry.registerFluid(FoodInit.greenTea);
		FoodInit.greenTeaBlock = new DCFluidBlockBase(FoodInit.greenTea, "greentea_still")
				.setUnlocalizedName(ClimateCore.PACKAGE_BASE + "_fluidblock_greentea");
		MainMaterialRegister.registerBlock(FoodInit.greenTeaBlock, ClimateCore.PACKAGE_BASE + "_fluidblock_greentea");
		FoodInit.greenTea.setBlock(FoodInit.greenTeaBlock);

		FoodInit.blackTea = new Fluid("dcs.black_tea", new ResourceLocation(ClimateCore.PACKAGE_ID,
				"blocks/fluid/blacktea_still"), new ResourceLocation(ClimateCore.PACKAGE_ID,
				"blocks/fluid/blacktea_still")).setUnlocalizedName(ClimateCore.PACKAGE_BASE + ".black_tea")
				.setTemperature(370);
		FluidRegistry.registerFluid(FoodInit.blackTea);
		FoodInit.blackTeaBlock = new DCFluidBlockBase(FoodInit.blackTea, "blacktea_still")
				.setUnlocalizedName(ClimateCore.PACKAGE_BASE + "_fluidblock_blacktea");
		MainMaterialRegister.registerBlock(FoodInit.blackTeaBlock, ClimateCore.PACKAGE_BASE + "_fluidblock_blacktea");
		FoodInit.blackTea.setBlock(FoodInit.blackTeaBlock);

		FoodInit.coffee = new Fluid("dcs.black_coffee", new ResourceLocation(ClimateCore.PACKAGE_ID,
				"blocks/fluid/coffee_still"), new ResourceLocation(ClimateCore.PACKAGE_ID, "blocks/fluid/coffee_still"))
				.setUnlocalizedName(ClimateCore.PACKAGE_BASE + ".black_coffee").setTemperature(370);
		FluidRegistry.registerFluid(FoodInit.coffee);
		FoodInit.coffeeBlock = new DCFluidBlockBase(FoodInit.coffee, "coffee_still")
				.setUnlocalizedName(ClimateCore.PACKAGE_BASE + "_fluidblock_coffee");
		MainMaterialRegister.registerBlock(FoodInit.coffeeBlock, ClimateCore.PACKAGE_BASE + "_fluidblock_coffee");
		FoodInit.coffee.setBlock(FoodInit.coffeeBlock);

		FoodInit.cream = new Fluid("dcs.milk_cream", new ResourceLocation(ClimateCore.PACKAGE_ID,
				"blocks/fluid/cream_still"), new ResourceLocation(ClimateCore.PACKAGE_ID, "blocks/fluid/cream_still"))
				.setUnlocalizedName(ClimateCore.PACKAGE_BASE + ".milk_cream");
		FluidRegistry.registerFluid(FoodInit.cream);
		FoodInit.creamBlock = new DCFluidBlockBase(FoodInit.cream, "cream_still")
				.setUnlocalizedName(ClimateCore.PACKAGE_BASE + "_fluidblock_cream");
		MainMaterialRegister.registerBlock(FoodInit.creamBlock, ClimateCore.PACKAGE_BASE + "_fluidblock_cream");
		FoodInit.cream.setBlock(FoodInit.creamBlock);

		// bucket
		FluidRegistry.addBucketForFluid(FoodInit.oil);
		FluidRegistry.addBucketForFluid(FoodInit.greenTea);
		FluidRegistry.addBucketForFluid(FoodInit.blackTea);
		FluidRegistry.addBucketForFluid(FoodInit.coffee);
		FluidRegistry.addBucketForFluid(FoodInit.cream);

		// fluid item
		FoodInit.dropOil = new ItemFluidDrop("olive", "dcs.seed_oil").setUnlocalizedName(ClimateCore.PACKAGE_BASE
				+ "_food_drop_oil");
		GameRegistry.register(FoodInit.dropOil.setRegistryName(ClimateCore.PACKAGE_BASE + "_food_drop_oil"));

		FoodInit.dropCream = new ItemFluidDrop("cream", "dcs.milk_cream").setUnlocalizedName(ClimateCore.PACKAGE_BASE
				+ "_food_drop_cream");
		GameRegistry.register(FoodInit.dropCream.setRegistryName(ClimateCore.PACKAGE_BASE + "_food_drop_cream"));

		FoodInit.paperPack = new ItemFluidPack().setUnlocalizedName(ClimateCore.PACKAGE_BASE + "_food_pack");
		GameRegistry.register(FoodInit.paperPack.setRegistryName(ClimateCore.PACKAGE_BASE + "_food_pack"));

	}

	static void loadCreativeTab() {
		FoodInit.bread.setCreativeTab(ClimateMain.food);
		FoodInit.sticks.setCreativeTab(ClimateMain.food);
		FoodInit.pastryRound.setCreativeTab(ClimateMain.food);
		FoodInit.pastrySquare.setCreativeTab(ClimateMain.food);

		FoodInit.crops.setCreativeTab(ClimateMain.food);
		FoodInit.seeds.setCreativeTab(ClimateMain.food);
		FoodInit.teaLeaves.setCreativeTab(ClimateMain.food);

		FoodInit.dropOil.setCreativeTab(ClimateMain.food);
		FoodInit.dropCream.setCreativeTab(ClimateMain.food);
		FoodInit.paperPack.setCreativeTab(ClimateMain.food);

		FoodInit.meat.setCreativeTab(ClimateMain.food);
		FoodInit.dairy.setCreativeTab(ClimateMain.food);
		FoodInit.pastry.setCreativeTab(ClimateMain.food);

		FoodInit.cupSilver.setCreativeTab(ClimateMain.food);

		FoodInit.potteryPot.setCreativeTab(ClimateMain.food);
		FoodInit.steelPot.setCreativeTab(ClimateMain.food);
		FoodInit.teaPot.setCreativeTab(ClimateMain.food);

		FoodInit.cropRice.setCreativeTab(ClimateMain.food);
		FoodInit.cropOnion.setCreativeTab(ClimateMain.food);
		FoodInit.cropSpinach.setCreativeTab(ClimateMain.food);
		FoodInit.cropTomato.setCreativeTab(ClimateMain.food);
		FoodInit.cropCoffee.setCreativeTab(ClimateMain.food);
		FoodInit.cropCotton.setCreativeTab(ClimateMain.food);

		FoodInit.leavesOlive.setCreativeTab(ClimateMain.food);
		FoodInit.leavesLemon.setCreativeTab(ClimateMain.food);
		FoodInit.leavesTea.setCreativeTab(ClimateMain.food);
		FoodInit.saplings.setCreativeTab(ClimateMain.food);
	}

}