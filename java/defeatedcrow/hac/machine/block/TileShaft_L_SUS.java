package defeatedcrow.hac.machine.block;

public class TileShaft_L_SUS extends TileShaft_L {

	// tier
	@Override
	public float maxTorque() {
		return 128.0F;
	}

	@Override
	public float getGearTier() {
		return 64.0F;
	}
}
