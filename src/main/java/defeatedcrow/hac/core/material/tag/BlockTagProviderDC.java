package defeatedcrow.hac.core.material.tag;

import org.jetbrains.annotations.Nullable;

import defeatedcrow.hac.core.material.BuildInit;
import defeatedcrow.hac.core.material.CoreInit;
import defeatedcrow.hac.core.material.block.IBlockDC;
import defeatedcrow.hac.core.material.block.IBlockDC.ToolType;
import defeatedcrow.hac.food.material.FoodInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class BlockTagProviderDC extends BlockTagsProvider {

	public BlockTagProviderDC(DataGenerator gen, @Nullable ExistingFileHelper helper) {
		super(gen, "dcs_climate", helper);
	}

	@Override
	protected void addTags() {

		TagsProvider.TagAppender<Block> pickaxe = this.tag(BlockTags.MINEABLE_WITH_PICKAXE);
		CoreInit.BLOCKS.getEntries().stream().filter(block -> block.get() instanceof IBlockDC && ((IBlockDC) block.get()).getToolType() == ToolType.PICKAXE)
			.map(RegistryObject::get).forEach(pickaxe::add);

		TagsProvider.TagAppender<Block> axe = this.tag(BlockTags.MINEABLE_WITH_AXE);
		CoreInit.BLOCKS.getEntries().stream().filter(block -> block.get() instanceof IBlockDC && ((IBlockDC) block.get()).getToolType() == ToolType.AXE)
			.map(RegistryObject::get).forEach(axe::add);

		TagsProvider.TagAppender<Block> toolTier1 = this.tag(BlockTags.NEEDS_STONE_TOOL);
		CoreInit.BLOCKS.getEntries().stream().filter(block -> block.get() instanceof IBlockDC && ((IBlockDC) block.get()).getToolTier() == 1)
			.map(RegistryObject::get).forEach(toolTier1::add);

		TagsProvider.TagAppender<Block> toolTier2 = this.tag(BlockTags.NEEDS_IRON_TOOL);
		CoreInit.BLOCKS.getEntries().stream().filter(block -> block.get() instanceof IBlockDC && ((IBlockDC) block.get()).getToolTier() == 2)
			.map(RegistryObject::get).forEach(toolTier2::add);

		TagsProvider.TagAppender<Block> toolTier3 = this.tag(BlockTags.NEEDS_DIAMOND_TOOL);
		CoreInit.BLOCKS.getEntries().stream().filter(block -> block.get() instanceof IBlockDC && ((IBlockDC) block.get()).getToolTier() == 3)
			.map(RegistryObject::get).forEach(toolTier3::add);

		tag(TagDC.BlockTag.ORES_WHITE).add(CoreInit.ORE_WHITE.get());
		tag(TagDC.BlockTag.ORES_BLUE).add(CoreInit.ORE_BLUE.get());
		tag(TagDC.BlockTag.ORES_BLACK).add(CoreInit.ORE_BLACK.get());
		tag(TagDC.BlockTag.ORES_RED).add(CoreInit.ORE_RED.get());
		tag(TagDC.BlockTag.ORES_GREEN).add(CoreInit.ORE_GREEN.get());

		tag(TagDC.BlockTag.ORES_WHITE_DEEP).add(CoreInit.ORE_WHITE_DEEP.get());
		tag(TagDC.BlockTag.ORES_BLUE_DEEP).add(CoreInit.ORE_BLUE_DEEP.get());
		tag(TagDC.BlockTag.ORES_BLACK_DEEP).add(CoreInit.ORE_BLACK_DEEP.get());
		tag(TagDC.BlockTag.ORES_RED_DEEP).add(CoreInit.ORE_RED_DEEP.get());
		tag(TagDC.BlockTag.ORES_GREEN_DEEP).add(CoreInit.ORE_GREEN_DEEP.get());

		tag(TagDC.BlockTag.ORES_CHALCEDONY).add(CoreInit.ORE_CHALCEDONY.get());
		tag(TagDC.BlockTag.ORES_HELIODOR).add(CoreInit.ORE_HELIODOR.get());
		tag(TagDC.BlockTag.ORES_TOPAZ).add(CoreInit.ORE_TOPAZ.get());
		tag(TagDC.BlockTag.ORES_FLUORITE).add(CoreInit.ORE_FLUORITE.get());
		tag(TagDC.BlockTag.ORES_LARIMAR).add(CoreInit.ORE_LARIMAR.get());
		tag(TagDC.BlockTag.ORES_AQUAMARINE).add(CoreInit.ORE_AQUAMARINE.get());
		tag(TagDC.BlockTag.ORES_JET).add(CoreInit.ORE_JET.get());
		tag(TagDC.BlockTag.ORES_IOLITE).add(CoreInit.ORE_IOLITE.get());
		tag(TagDC.BlockTag.ORES_OPAL).add(CoreInit.ORE_OPAL.get());
		tag(TagDC.BlockTag.ORES_DRAGONSEYE).add(CoreInit.ORE_DRAGONSEYE.get());
		tag(TagDC.BlockTag.ORES_DESERTROSE).add(CoreInit.ORE_DESERTROSE.get());
		tag(TagDC.BlockTag.ORES_ROSINCA).add(CoreInit.ORE_ROSINCA.get());
		tag(TagDC.BlockTag.ORES_SPINEL).add(CoreInit.ORE_SPINEL.get());
		tag(TagDC.BlockTag.ORES_SERPENTINE).add(CoreInit.ORE_SERPENTINE.get());
		tag(TagDC.BlockTag.ORES_AMAZONITE).add(CoreInit.ORE_AMAZONITE.get());
		tag(TagDC.BlockTag.ORES_JADEITE).add(CoreInit.ORE_JADEITE.get());

		tag(TagDC.BlockTag.ORES_SALT).add(CoreInit.STONE_SALT.get());
		tag(TagDC.BlockTag.ORES_NITER).add(CoreInit.STONE_GUANO.get());
		tag(TagDC.BlockTag.ORES_SULFUR).add(CoreInit.STONE_SULFUR.get());
		tag(TagDC.BlockTag.ORES_GYPSUM).add(CoreInit.STONE_GYPSUM.get());
		tag(TagDC.BlockTag.ORES_TRAVERTINE).add(CoreInit.STONE_TRAVERTINE.get());
		tag(TagDC.BlockTag.ORES_LIME).add(CoreInit.STONE_MARBLE.get(), Blocks.CALCITE);

		tag(TagDC.BlockTag.DUSTBLOCK_BRASS).add(CoreInit.DUSTBLOCK_BRASS.get());
		tag(TagDC.BlockTag.DUSTBLOCK_BRONZE).add(CoreInit.DUSTBLOCK_BRONZE.get());
		tag(TagDC.BlockTag.DUSTBLOCK_NICKEL_SILVER).add(CoreInit.DUSTBLOCK_NICKEL_SILVER.get());
		tag(TagDC.BlockTag.DUSTBLOCK_STEEL).add(CoreInit.DUSTBLOCK_STEEL.get());
		tag(TagDC.BlockTag.DUSTBLOCK_SUS).add(CoreInit.DUSTBLOCK_SUS.get());
		tag(TagDC.BlockTag.DUSTBLOCK_TOOL_STEEL).add(CoreInit.DUSTBLOCK_TOOL_STEEL.get());
		tag(TagDC.BlockTag.DUSTBLOCK_TITANIUM).add(CoreInit.DUSTBLOCK_TITANIUM.get());
		tag(TagDC.BlockTag.DUSTBLOCK_MAGNET).add(CoreInit.DUSTBLOCK_MAGNET.get());
		tag(TagDC.BlockTag.DUSTBLOCK_MANGALLOY).add(CoreInit.DUSTBLOCK_MANGALLOY.get());
		tag(TagDC.BlockTag.DUSTBLOCK_BSCCO).add(CoreInit.DUSTBLOCK_BSCCO.get());

		tag(TagDC.BlockTag.METALBLOCK_BRASS).add(CoreInit.METALBLOCK_BRASS.get());
		tag(TagDC.BlockTag.METALBLOCK_BRONZE).add(CoreInit.METALBLOCK_BRONZE.get());
		tag(TagDC.BlockTag.METALBLOCK_NICKEL_SILVER).add(CoreInit.METALBLOCK_NICKEL_SILVER.get());
		tag(TagDC.BlockTag.METALBLOCK_STEEL).add(CoreInit.METALBLOCK_STEEL.get());
		tag(TagDC.BlockTag.METALBLOCK_SUS).add(CoreInit.METALBLOCK_SUS.get());
		tag(TagDC.BlockTag.METALBLOCK_TOOL_STEEL).add(CoreInit.METALBLOCK_TOOL_STEEL.get());
		tag(TagDC.BlockTag.METALBLOCK_TITANIUM).add(CoreInit.METALBLOCK_TITANIUM.get());
		tag(TagDC.BlockTag.METALBLOCK_MAGNET).add(CoreInit.METALBLOCK_MAGNET.get());
		tag(TagDC.BlockTag.METALBLOCK_MANGALLOY).add(CoreInit.METALBLOCK_MANGALLOY.get());
		tag(TagDC.BlockTag.METALBLOCK_BSCCO).add(CoreInit.METALBLOCK_BSCCO.get());

		tag(TagDC.BlockTag.FARMLAND).add(Blocks.FARMLAND, FoodInit.FERTILE.get());
		tag(TagDC.BlockTag.MUD).add(Blocks.MUD, Blocks.MUDDY_MANGROVE_ROOTS);

		tag(TagDC.BlockTag.CROP_PUMPKIN).add(Blocks.PUMPKIN);
		tag(TagDC.BlockTag.CROP_MELON).add(Blocks.MELON);

		tag(TagDC.BlockTag.CROP_GREEN_MANURES).add(FoodInit.BLOCK_BR_RAPESEED.get(), FoodInit.BLOCK_BR_GREEN.get(),
			FoodInit.BLOCK_BR_CABAGGE.get(), FoodInit.BLOCK_BR_RADISH.get(), FoodInit.BLOCK_CR_OAT.get(),
			FoodInit.BLOCK_CR_RYE.get(), FoodInit.BLOCK_CR_BARLEY.get(), FoodInit.BLOCK_PE_GREEN.get(),
			FoodInit.BLOCK_PE_GARBANZO.get(), FoodInit.BLOCK_PE_SOY.get(), FoodInit.BLOCK_RE_SORGHUM.get(),
			Blocks.GRASS, Blocks.TALL_GRASS, Blocks.FERN, Blocks.LARGE_FERN);

		tag(BlockTags.WOODEN_FENCES).add(BuildInit.FENCE_BEECH.get(), BuildInit.FENCE_WALNUT.get(), BuildInit.FENCE_SWEET.get());

		tag(BlockTags.WALLS).add(BuildInit.WALL_MUD.get(), BuildInit.WALL_GYPSUM.get(), BuildInit.WALL_SERPENTINE.get(),
			BuildInit.WALL_GREISEN.get(), BuildInit.WALL_SKARN.get(), BuildInit.WALL_HORNFELS.get(),
			BuildInit.WALL_MARBLE.get(), BuildInit.WALL_SCHIST_BLUE.get(), BuildInit.WALL_SCHIST_NETHER.get(), BuildInit.WALL_GRANITE.get());

	}

}
