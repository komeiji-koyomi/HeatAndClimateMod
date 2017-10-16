package defeatedcrow.hac.plugin;

import defeatedcrow.hac.api.damage.DamageAPI;
import net.minecraft.entity.EntityList;

public class MobResistantData {
	public static final MobResistantData INSTANCE = new MobResistantData();

	private MobResistantData() {}

	public static void load() {
		Class blizz = EntityList.getClassFromName("thermalfoundation.blizz");
		Class blitz = EntityList.getClassFromName("thermalfoundation.blitz");
		Class basalz = EntityList.getClassFromName("thermalfoundation.basalz");

		DamageAPI.resistantData.registerEntityResistant(blizz, 0.0F, 6.0F);
		DamageAPI.resistantData.registerEntityResistant(blitz, 2.0F, 2.0F);
		DamageAPI.resistantData.registerEntityResistant(basalz, 6.0F, 0.0F);
	}

}