package defeatedcrow.hac.core.material.block.building;

import java.util.List;
import java.util.Optional;

import org.apache.commons.compress.utils.Lists;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import defeatedcrow.hac.core.json.IJsonDataDC;
import defeatedcrow.hac.core.json.JsonModelDC;
import defeatedcrow.hac.core.material.block.IBlockDC;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

public class FenceWoodDC extends FenceBlock implements IBlockDC, IJsonDataDC {

	final String name;
	private String texDir = "tree/plank_";

	public FenceWoodDC(String n) {
		super(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS));
		name = n;
	}

	public FenceWoodDC setTexDir(String s) {
		texDir = s;
		return this;
	}

	@Override
	public String getRegistryName() {
		return "build/fence_" + name;
	}

	@Override
	public List<JsonModelDC> getBlockModel() {
		return ImmutableList.of(new JsonModelDC("minecraft:block/fence_post", ImmutableMap.of("texture", "dcs_climate:block/" + texDir + name)),
			new JsonModelDC("minecraft:block/fence_side", ImmutableMap.of("texture", "dcs_climate:block/" + texDir + name)));
	}

	@Override
	public Optional<String[]> getModelNameSuffix() {
		return Optional.of(new String[] { "post", "side" });
	}

	@Override
	public JsonModelDC getItemModel() {
		return new JsonModelDC("minecraft:block/fence_inventory", ImmutableMap.of("texture", "dcs_climate:block/" + texDir + name));
	}

	@Override
	public boolean requireStateJson() {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> ret = Lists.newArrayList();
		if (state.getBlock() instanceof IBlockDC) {
			IBlockDC block = (IBlockDC) state.getBlock();
			ServerLevel level = builder.getLevel();
			Entity breaker = builder.getParameter(LootContextParams.THIS_ENTITY);
			ItemStack tool = builder.getParameter(LootContextParams.TOOL);
			// シルクタッチの場合は処理を中段
			if (!block.getSilkyDrop().isEmpty() && !tool.isEmpty() && tool.getEnchantmentLevel(Enchantments.SILK_TOUCH) > 0) {
				ret.add(getSilkyDrop());
				return ret;
			}

			ret.addAll(super.getDrops(state, builder));

			ret.addAll(getAdditionalDrop(state, tool, breaker));
		}
		return ret;
	}

	@Override
	public ItemStack getMainDrop() {
		return new ItemStack(this);
	}

	@Override
	public ItemStack getSilkyDrop() {
		return ItemStack.EMPTY;
	}

	@Override
	public List<ItemStack> getAdditionalDrop(BlockState state, ItemStack tool, Entity entity) {
		List<ItemStack> ret = Lists.newArrayList();
		return ret;
	}

	@Override
	public BlockType getDropType() {
		return BlockType.NORMAL;
	}

	@Override
	public ToolType getToolType() {
		return ToolType.AXE;
	}

	@Override
	public int getToolTier() {
		return 0;
	}

}
