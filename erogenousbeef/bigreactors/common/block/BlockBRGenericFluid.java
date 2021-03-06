package erogenousbeef.bigreactors.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import erogenousbeef.bigreactors.common.BigReactors;

public class BlockBRGenericFluid extends BlockFluidClassic {

	private Icon _iconFlowing;
	private Icon _iconStill;
	
	public BlockBRGenericFluid(int blockID, Fluid fluid, String unlocalizedName) {
		super(blockID, fluid, Material.water);

		setUnlocalizedName("fluid." + unlocalizedName + ".still");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegistry) {
		_iconStill   = iconRegistry.registerIcon(BigReactors.TEXTURE_NAME_PREFIX + getUnlocalizedName());
		_iconFlowing = iconRegistry.registerIcon(BigReactors.TEXTURE_NAME_PREFIX + getUnlocalizedName().replace(".still", ".flowing"));

		this.stack.getFluid().setIcons(_iconStill, _iconFlowing);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int metadata) {
		return side <= 1 ? _iconStill : _iconFlowing;
	}
}
