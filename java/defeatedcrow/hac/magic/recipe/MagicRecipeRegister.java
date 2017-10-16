package defeatedcrow.hac.magic.recipe;

import defeatedcrow.hac.api.climate.DCHeatTier;
import defeatedcrow.hac.api.recipe.RecipeAPI;
import defeatedcrow.hac.core.DCRecipe;
import defeatedcrow.hac.food.FoodInit;
import defeatedcrow.hac.machine.MachineInit;
import defeatedcrow.hac.magic.MagicInit;
import defeatedcrow.hac.main.MainInit;
import defeatedcrow.hac.main.config.ModuleConfig;
import defeatedcrow.hac.main.util.RecipeResourcesMain;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class MagicRecipeRegister {

	private static final RecipeResourcesMain res = new RecipeResourcesMain("magic");

	public static void load() {
		loadItemRecipes();
	}

	static void loadItemRecipes() {
		// アクセサリー
		Object[] gems = {
				new ItemStack(MainInit.gems, 1, 0), new ItemStack(MainInit.gems, 1, 1),
				new ItemStack(MainInit.gems, 1, 2), "gemQuartz", "gemSapphire", "gemMalachite", "gemCelestite",
				"gemClam", "gemLapis", "gemDiamond", "gemSchorl", "gemSerpentine", "gemOlivine", "gemGarnet",
				new ItemStack(MagicInit.elestial, 1, 0), "gemRutile", "gemBismuth"
		};
		for (int i = 0; i < gems.length; i++) {
			DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.pendant, 1, i), new Object[] {
					" X ", "X X", " Y ", 'X', "ingotSilver", 'Y', gems[i]
			});

			DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.pendant, 1, i), new Object[] {
					" X ", "X X", " Y ", 'X', "ingotNickelsilver", 'Y', gems[i]
			});

			DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.badge, 1, i), new Object[] {
					" Y ", "X X", " X ", 'X', "ingotSilver", 'Y', gems[i]
			});

			DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.badge, 1, i), new Object[] {
					" Y ", "X X", " X ", 'X', "ingotNickelsilver", 'Y', gems[i]
			});
		}

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.pendant, 1, 12), new Object[] {
				" X ", "X X", " Y ", 'X', "ingotSilver", 'Y', "gemPeridot"
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.pendant, 1, 12), new Object[] {
				" X ", "X X", " Y ", 'X', "ingotNickelsilver", 'Y', "gemPeridot"
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.badge, 1, 12), new Object[] {
				" Y ", "X X", " X ", 'X', "ingotSilver", 'Y', "gemPeridot"
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.badge, 1, 12), new Object[] {
				" Y ", "X X", " X ", 'X', "ingotNickelsilver", 'Y', "gemPeridot"
		});

		DCRecipe.addShapelessRecipe(res.getRecipeName(), new ItemStack(MagicInit.badge, 1, 7), new Object[] {
				new ItemStack(MagicInit.badge, 1, 7)
		});

		DCRecipe.addShapelessRecipe(res.getRecipeName(), new ItemStack(MagicInit.badge, 1, 16), new Object[] {
				new ItemStack(MagicInit.badge, 1, 16)
		});

		// dagger
		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.daggerSilver, 3, 0), new Object[] {
				"X", "Y", 'X', "ingotSilver", 'Y', "stickWood"
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.daggerSilver, 3, 0), new Object[] {
				"X", "Y", 'X', "ingotNickelsilver", 'Y', "stickWood"
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.daggerMagic, 1, 0), new Object[] {
				"X", "Y", "Z", 'X', new ItemStack(MainInit.gems, 1, 2), 'Y', new ItemStack(MainInit.gems, 1, 2), 'Z',
				new ItemStack(MagicInit.daggerSilver)
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.daggerMagic, 1, 4), new Object[] {
				"X", "Y", "Z", 'X', new ItemStack(MainInit.gems, 1, 1), 'Y', new ItemStack(MainInit.gems, 1, 2), 'Z',
				new ItemStack(MagicInit.daggerSilver)
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.daggerMagic, 1, 2), new Object[] {
				"X", "Y", "Z", 'X', new ItemStack(MainInit.gems, 1, 0), 'Y', new ItemStack(MainInit.gems, 1, 2), 'Z',
				new ItemStack(MagicInit.daggerSilver)
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.daggerMagic, 1, 1), new Object[] {
				"X", "Y", "Z", 'X', new ItemStack(MainInit.gems, 1, 2), 'Y', "gemSapphire", 'Z',
				new ItemStack(MagicInit.daggerSilver)
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.daggerMagic, 1, 5), new Object[] {
				"XYW", " Z ", 'X', new ItemStack(MainInit.gems, 1, 1), 'Y', "gemSapphire", 'W', "dustBlaze", 'Z',
				new ItemStack(MagicInit.daggerSilver)
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.daggerMagic, 1, 3), new Object[] {
				"XYW", " Z ", 'X', new ItemStack(MainInit.gems, 1, 0), 'Y', "gemSapphire", 'W', "enderpearl", 'Z',
				new ItemStack(MagicInit.daggerSilver)
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.daggerMagic, 1, 6), new Object[] {
				"X", "Y", "Z", 'X', "gemMalachite", 'Y', "gemQuartz", 'Z', new ItemStack(MagicInit.daggerSilver)
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.daggerMagic, 1, 7), new Object[] {
				"X", "Y", "Z", 'X', "gemCelestite", 'Y', "gemQuartz", 'Z', new ItemStack(MagicInit.daggerSilver)
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.daggerMagic, 1, 8), new Object[] {
				"XYW", " Z ", 'X', "gemSapphire", 'Y', "gemQuartz", 'W', "gemLapis", 'Z',
				new ItemStack(MagicInit.daggerSilver)
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.daggerMagic, 1, 9), new Object[] {
				"X", "Y", "Z", 'X', "gemQuartz", 'Y', "gemLapis", 'Z', new ItemStack(MagicInit.daggerSilver)
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.daggerMagic, 1, 10), new Object[] {
				"X", "Y", "Z", 'X', "gemSchorl", 'Y', "gemLapis", 'Z', new ItemStack(MagicInit.daggerSilver)
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.daggerMagic, 1, 11), new Object[] {
				"X", "Y", "Z", 'X', "gemMalachite", 'Y', "gemLapis", 'Z', new ItemStack(MagicInit.daggerSilver)
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.daggerMagic, 1, 12), new Object[] {
				"XYW", " Z ", 'X', "gemCelestite", 'Y', "gemSchorl", 'W', new ItemStack(MainInit.gems, 1, 0), 'Z',
				new ItemStack(MagicInit.daggerSilver)
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.daggerMagic, 1, 13), new Object[] {
				"X", "Y", "Z", 'X', "gemClam", 'Y', "gemSchorl", 'Z', new ItemStack(MagicInit.daggerSilver)
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.daggerMagic, 1, 14), new Object[] {
				"XYW", " Z ", 'X', "gemDiamond", 'Y', "gemClam", 'W', new ItemStack(Items.NETHER_STAR), 'Z',
				new ItemStack(MagicInit.daggerSilver)
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.daggerMagic, 1, 15), new Object[] {
				"XYW", " Z ", 'X', "gemLapis", 'Y', "gemClam", 'W', new ItemStack(Items.NETHER_STAR), 'Z',
				new ItemStack(MagicInit.daggerSilver)
		});

		// mace

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.macehandle, 1, 0), new Object[] {
				"  X", " Y ", "X  ", 'X', "ingotGold", 'Y', "ingotSilver"
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.maceStarItem, 1, 0), new Object[] {
				"XYX", "ZWZ", "XYX", 'X', "ingotGold", 'Y', new ItemStack(MainInit.gems, 1, 1), 'Z',
				new ItemStack(Items.ENDER_EYE, 1, 0), 'W', "blockElestial"
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.maceStarItem, 1, 1), new Object[] {
				"XYX", "ZWZ", "XYX", 'X', "ingotGold", 'Y', "gemLapis", 'Z', "gemCelestite", 'W', "blockElestial"
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.maceStarItem, 1, 3), new Object[] {
				"XYX", "ZWZ", "XYX", 'X', "ingotGold", 'Y', new ItemStack(MainInit.gems, 1, 0), 'Z',
				new ItemStack(Blocks.PACKED_ICE, 1, 0), 'W', "blockElestial"
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.maceStarItem, 1, 2), new Object[] {
				"XYX", "ZWZ", "XYX", 'X', "ingotGold", 'Y', "gemSapphire", 'Z', "gemSchorl", 'W', "blockElestial"
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.maceStarItem, 1, 4), new Object[] {
				"XYX", "ZWZ", "XYX", 'X', "ingotGold", 'Y', "gemClam", 'Z', new ItemStack(Items.EMERALD, 1, 0), 'W',
				"blockElestial"
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.maceStarItem, 1, 5), new Object[] {
				"XYX", "ZWZ", "XYX", 'X', "ingotGold", 'Y', "gemGarnet", 'Z', new ItemStack(MainInit.gems, 1, 1), 'W',
				"blockElestial"
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.maceStarItem, 1, 6), new Object[] {
				"XYX", "ZWZ", "XYX", 'X', "ingotGold", 'Y', "gemMalachite", 'Z', new ItemStack(MainInit.gems, 1, 0),
				'W', "blockElestial"
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.maceStarItem, 1, 7), new Object[] {
				"XYX", "ZWZ", "XYX", 'X', "ingotGold", 'Y', "gemDiamond", 'Z', "gemCelestite", 'W', "blockElestial"
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.maceSun, 1, 0), new Object[] {
				"X", "Y", 'X', new ItemStack(MagicInit.maceStarItem, 1, 0), 'Y',
				new ItemStack(MagicInit.macehandle, 1, 0)
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.maceMoon, 1, 0), new Object[] {
				"X", "Y", 'X', new ItemStack(MagicInit.maceStarItem, 1, 1), 'Y',
				new ItemStack(MagicInit.macehandle, 1, 0)
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.maceBird, 1, 0), new Object[] {
				"X", "Y", 'X', new ItemStack(MagicInit.maceStarItem, 1, 2), 'Y',
				new ItemStack(MagicInit.macehandle, 1, 0)
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.maceIce, 1, 0), new Object[] {
				"X", "Y", 'X', new ItemStack(MagicInit.maceStarItem, 1, 3), 'Y',
				new ItemStack(MagicInit.macehandle, 1, 0)
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.maceOcean, 1, 0), new Object[] {
				"X", "Y", 'X', new ItemStack(MagicInit.maceStarItem, 1, 4), 'Y',
				new ItemStack(MagicInit.macehandle, 1, 0)
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.maceBurn, 1, 0), new Object[] {
				"X", "Y", 'X', new ItemStack(MagicInit.maceStarItem, 1, 5), 'Y',
				new ItemStack(MagicInit.macehandle, 1, 0)
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.maceFlower, 1, 0), new Object[] {
				"X", "Y", 'X', new ItemStack(MagicInit.maceStarItem, 1, 6), 'Y',
				new ItemStack(MagicInit.macehandle, 1, 0)
		});

		DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.maceGlory, 1, 0), new Object[] {
				"X", "Y", 'X', new ItemStack(MagicInit.maceStarItem, 1, 7), 'Y',
				new ItemStack(MagicInit.macehandle, 1, 0)
		});

		// elestial
		RecipeAPI.registerSmelting.addRecipe(new ItemStack(MagicInit.elestial, 1, 0), DCHeatTier.KILN, null, null,
				false, new ItemStack(MainInit.gemBlock, 1, 8));

		if (ModuleConfig.food) {
			DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.lotusCandle, 1, 0), new Object[] {
					"XXX", "XYX", "XXX", 'X', new ItemStack(FoodInit.petals, 1, 0), 'Y', "ingotGold"
			});

			DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.lotusCandleBlack, 1, 0),
					new Object[] {
							"XXX", "XYX", "XXX", 'X', new ItemStack(FoodInit.petals, 1, 1), 'Y', "ingotGold"
					});
		}

		// advanced
		if (ModuleConfig.magic_advanced) {
			DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.biomeOrb, 1, 0), new Object[] {
					"XYX", "YZY", "XYX", 'X', new ItemStack(MainInit.selenite, 1, 0), 'Y', "gemPeridot", 'Z',
					new ItemStack(MagicInit.maceStarItem, 1, 0)
			});

			DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.biomeOrb, 1, 1), new Object[] {
					"XYX", "YZY", "XYX", 'X', new ItemStack(MainInit.selenite, 1, 0), 'Y', "gemPeridot", 'Z',
					new ItemStack(MagicInit.maceStarItem, 1, 6)
			});

			DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.biomeOrb, 1, 2), new Object[] {
					"XYX", "YZY", "XYX", 'X', new ItemStack(MainInit.selenite, 1, 0), 'Y', "gemPeridot", 'Z',
					new ItemStack(MagicInit.maceStarItem, 1, 5)
			});

			DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.biomeOrb, 1, 3), new Object[] {
					"XYX", "YZY", "XYX", 'X', new ItemStack(MainInit.selenite, 1, 0), 'Y', "gemPeridot", 'Z',
					new ItemStack(MagicInit.maceStarItem, 1, 3)
			});

			DCRecipe.addShapedRecipe(res.getRecipeName(), new ItemStack(MagicInit.timeCage, 1, 0), new Object[] {
					"XYX", "YZY", "XYX", 'X', "ingotSilver", 'Y', new ItemStack(MainInit.selenite, 1, 0), 'Z',
					new ItemStack(MachineInit.gemcore, 1, 1)
			});
		}
	}

	public static void loadOres() {
		OreDictionary.registerOre("blockElestial", new ItemStack(MagicInit.elestial, 1, 0));
	}

}
