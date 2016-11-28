package defeatedcrow.hac.magic.block;

import java.util.List;

import defeatedcrow.hac.core.ClimateCore;
import defeatedcrow.hac.magic.proj.EntityProjIceSpit;
import defeatedcrow.hac.main.ClimateMain;
import defeatedcrow.hac.main.achievement.AchievementClimate;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBlockMaceIce extends ItemBlockMace {

	public ItemBlockMaceIce(Block block) {
		super(block);
	}

	@Override
	protected void doUsingEffect(ItemStack stack, EntityPlayer player, World world) {
		if (stack != null && player != null) {
			boolean hasAcv = ClimateMain.proxy.hasAchivement(player, AchievementClimate.MAGIC_MASTER);
			boolean flag = player.capabilities.isCreativeMode;

			if (hasAcv || flag) {
				if (!world.isRemote) {
					EntityProjIceSpit entityarrow = new EntityProjIceSpit(world, player);
					entityarrow.setAim(player, player.rotationPitch, player.rotationYaw, 0.0F, 2.0F, 1.0F);
					world.spawnEntityInWorld(entityarrow);
				}

				world.playSound(player, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_EXPERIENCE_ORB_TOUCH,
						SoundCategory.PLAYERS, 0.65F, 2.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + 0.5F);

			} else {
				world.playSound(player, player.posX, player.posY, player.posZ,
						SoundEvents.ENTITY_PLAYER_ATTACK_NODAMAGE, SoundCategory.PLAYERS, 0.65F, 1.0F);
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, player, tooltip, advanced);
		if (ClimateCore.proxy.isShiftKeyDown()) {
			tooltip.add(TextFormatting.YELLOW.toString() + "Require low temperature");
		}
	}

}