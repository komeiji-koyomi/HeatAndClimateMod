package defeatedcrow.hac.food.material.block;

import java.util.List;
import java.util.Optional;

import org.apache.commons.compress.utils.Lists;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import defeatedcrow.hac.api.climate.DCAirflow;
import defeatedcrow.hac.api.climate.DCHeatTier;
import defeatedcrow.hac.api.climate.DCHumidity;
import defeatedcrow.hac.api.crop.CropGrowType;
import defeatedcrow.hac.api.crop.CropTier;
import defeatedcrow.hac.api.crop.CropType;
import defeatedcrow.hac.api.util.DCState;
import defeatedcrow.hac.core.json.JsonModelDC;
import defeatedcrow.hac.food.material.FoodInit;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

public class CropBlockRice extends ClimateCropBaseBlock {

	public CropBlockRice(CropTier t) {
		super(t);
		this.registerDefaultState(this.stateDefinition.any().setValue(DCState.STAGE5, Integer.valueOf(0)));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> def) {
		def.add(DCState.STAGE5);
	}

	/* model */

	@Override
	public String getRegistryName() {
		return "food/cropblock_rice_" + cropTier.toString();
	}

	@Override
	public List<JsonModelDC> getBlockModel() {
		return ImmutableList.of(
			new JsonModelDC("dcs_climate:block/dcs_crop", ImmutableMap.of("crop", "dcs_climate:block/crop/cereals_0")),
			new JsonModelDC("dcs_climate:block/dcs_crop", ImmutableMap.of("crop", "dcs_climate:block/crop/cereals_1")),
			new JsonModelDC("dcs_climate:block/dcs_crop", ImmutableMap.of("crop", "dcs_climate:block/crop/rice_2")),
			new JsonModelDC("dcs_climate:block/dcs_crop", ImmutableMap.of("crop", "dcs_climate:block/crop/rice_" + getSpeciesName(cropTier) + "_f")),
			new JsonModelDC("dcs_climate:block/dcs_crop", ImmutableMap.of("crop", "dcs_climate:block/crop/rice_" + getSpeciesName(cropTier) + "_c")));
	}

	@Override
	public Optional<String[]> getModelNameSuffix() {
		return Optional.empty();
	}

	@Override
	public JsonModelDC getItemModel() {
		return new JsonModelDC("minecraft:item/generated", ImmutableMap.of("layer0", "dcs_climate:item/crop/seed_rice_" + getSpeciesName(cropTier)));
	}

	/* ICropData */

	@Override
	public CropType getFamily() {
		return CropType.RICE;
	}

	@Override
	public CropGrowType getGrowType(CropTier t) {
		return CropGrowType.SINGLE;
	}

	@Override
	public ItemLike getSeedItem(CropTier t) {
		switch (t) {
		case COMMON:
			return FoodInit.BLOCK_RI_SHORT.get();
		case RARE:
			return FoodInit.BLOCK_RI_AROMA.get();
		default:
			return FoodInit.BLOCK_RI_ZIZANIA.get();
		}
	}

	@Override
	public Item getCropItem(CropTier t) {
		switch (t) {
		case COMMON:
			return FoodInit.CROP_RI_SHORT.get();
		case RARE:
			return FoodInit.CROP_RI_AROMA.get();
		default:
			return FoodInit.CROP_RI_ZIZANIA.get();
		}
	}

	@Override
	public Optional<Block> getMutationTarget(CropTier t) {
		switch (t) {
		case WILD:
			return Optional.of(FoodInit.BLOCK_RI_ZIZANIA.get());
		case COMMON:
			return Optional.of(FoodInit.BLOCK_RI_SHORT.get());
		case RARE:
			return Optional.of(FoodInit.BLOCK_RI_AROMA.get());
		default:
			return Optional.empty();
		}
	}

	@Override
	public List<SoilType> getSoilTypes(CropTier t) {
		switch (t) {
		case COMMON:
			return ImmutableList.of(SoilType.FARMLAND, SoilType.MUD);
		case WILD:
			return ImmutableList.of(SoilType.FARMLAND, SoilType.DIRT, SoilType.SAND);
		default:
			return ImmutableList.of(SoilType.FARMLAND, SoilType.MUD);
		}
	}

	@Override
	public List<DCHeatTier> getSuitableTemp(CropTier t) {
		return ImmutableList.of(DCHeatTier.NORMAL, DCHeatTier.WARM, DCHeatTier.HOT, DCHeatTier.BOIL);
	}

	@Override
	public List<DCHumidity> getSuitableHum(CropTier t) {
		return ImmutableList.of(DCHumidity.NORMAL, DCHumidity.WET, DCHumidity.UNDERWATER);
	}

	@Override
	public List<DCAirflow> getSuitableAir(CropTier t) {
		return ImmutableList.of(DCAirflow.NORMAL, DCAirflow.FLOW, DCAirflow.WIND);
	}

	@Override
	public List<String> getGeneratedBiomeTag(CropTier t) {
		switch (t) {
		case WILD:
			return ImmutableList.of("SWAMP", "RIVER");
		default:
			return Lists.newArrayList();
		}
	}

	@Override
	public String getSpeciesName(CropTier tier) {
		if (tier == CropTier.COMMON)
			return "short";
		if (tier == CropTier.RARE)
			return "aroma";
		return "zizania";
	}

}
