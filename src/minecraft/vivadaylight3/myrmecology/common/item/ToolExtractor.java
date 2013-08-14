package vivadaylight3.myrmecology.common.item;

import vivadaylight3.myrmecology.common.lib.Register;
import vivadaylight3.myrmecology.common.lib.Resources;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemTool;
import net.minecraft.util.Icon;

public class ToolExtractor extends ItemTool {

	private static final Block[] blocks = new Block[]  {Block.woodDoubleSlab};
	
	public ToolExtractor(int par1) {
		super(par1, 1.0F, EnumToolMaterial.WOOD, blocks);
		func_111206_d(Resources.TEXTURE_PREFIX+Register.ITEM_EXTRACTOR_NAME);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(Resources.TEXTURE_PREFIX+Register.ITEM_EXTRACTOR_NAME);
    }
	
	@Override
	public Icon getIconFromDamage(int par1)
    {
        return this.itemIcon;
    }

}