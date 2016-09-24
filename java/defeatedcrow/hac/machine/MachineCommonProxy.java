package defeatedcrow.hac.machine;

import net.minecraftforge.fml.common.registry.GameRegistry;
import defeatedcrow.hac.machine.block.TileCrank_S;
import defeatedcrow.hac.machine.block.TileFan;
import defeatedcrow.hac.machine.block.TileGearBox;
import defeatedcrow.hac.machine.block.TileHandCrank;
import defeatedcrow.hac.machine.block.TileRedBox;
import defeatedcrow.hac.machine.block.TileShaft_L;
import defeatedcrow.hac.machine.block.TileShaft_S;
import defeatedcrow.hac.machine.block.TileShaft_TA;
import defeatedcrow.hac.machine.block.TileShaft_TB;
import defeatedcrow.hac.machine.block.TileStoneMill;
import defeatedcrow.hac.machine.block.TileWindmill;
import defeatedcrow.hac.machine.block.TileWindmill_L;

public class MachineCommonProxy {

	public static void loadTE() {
		GameRegistry.registerTileEntity(TileWindmill.class, "dcs_te_windmill");
		GameRegistry.registerTileEntity(TileWindmill_L.class, "dcs_te_windmill_l");
		GameRegistry.registerTileEntity(TileShaft_S.class, "dcs_te_shaft_s");
		GameRegistry.registerTileEntity(TileShaft_L.class, "dcs_te_shaft_l");
		GameRegistry.registerTileEntity(TileShaft_TA.class, "dcs_te_shaft_ta");
		GameRegistry.registerTileEntity(TileShaft_TB.class, "dcs_te_shaft_tb");
		GameRegistry.registerTileEntity(TileGearBox.class, "dcs_te_gearbox");
		GameRegistry.registerTileEntity(TileCrank_S.class, "dcs_te_crank_s");
		GameRegistry.registerTileEntity(TileHandCrank.class, "dcs_te_handcrank");
		GameRegistry.registerTileEntity(TileStoneMill.class, "dcs_te_stonemill");
		GameRegistry.registerTileEntity(TileRedBox.class, "dcs_te_redbox");
		GameRegistry.registerTileEntity(TileFan.class, "dcs_te_fan");
	}

}