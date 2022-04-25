package defeatedcrow.hac.main.tabs;

import defeatedcrow.hac.core.CreativeTabClimate;
import defeatedcrow.hac.main.MainInit;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CreativeTabClimateBuild extends CreativeTabClimate {

	// クリエイティブタブのアイコン画像や名称の登録クラス
	public CreativeTabClimateBuild(String type) {
		super(type);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel() {
		return I18n.format("dcs.creativetab.building");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(MainInit.bricks);
	}

}