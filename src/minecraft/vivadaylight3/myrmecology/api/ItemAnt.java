package vivadaylight3.myrmecology.api;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import vivadaylight3.myrmecology.common.lib.Nbt;
import vivadaylight3.myrmecology.common.lib.Register;
import vivadaylight3.myrmecology.common.lib.Resources;
import vivadaylight3.myrmecology.common.lib.Time;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Extend this class to create a new ant, it is suggested that you override prepareItem() to set a 
 * non-standard unlocalised name, creative tab, max stack size and resource location.
 * @author samueltebbs
 */

public class ItemAnt extends Item {
    
    /**
     * Holds the ant's icons
     */
    private Icon[] icons = new Icon[4];
    
    /**
     * Holds the mod ID of the mod that this ant belongs to.
     */
    private String modId;
    
    /**
     * Holds the complete set of names for this ant species.
     */
    private String[] names = this.getCompleteNames();

    public ItemAnt(int par1, String parmodID) {
    	super(par1);
	
    	setHasSubtypes(true);
	
    	this.modId = parmodID;
	
    	prepareItem();
	
    	Register.addAnt(this);
	
    }
    
    private void prepareItem(){
	
    	setUnlocalizedName(this.getSpeciesSubName());
    	setCreativeTab(Register.tabMyrmecology);
    	setMaxStackSize(64);
    	func_111206_d(Resources.TEXTURE_PREFIX+"ant_"+this.getSpeciesSubName());
	
    }
    
    @Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer player, World par3World, 
	    int par4, int par5, int par6, int par7, float par8, float par9, float par10){
		
	return true;
	
    }
    
    /**
     * Returns the names variable
     * @return
     */
    public String[] getNames(){
	
    	return this.names;
	
    }
    
    /**
     * Returns a String[] of complete names for the ant species
     * @return
     */
    private String[] getCompleteNames(){
	
    	String[] result = new String[4];
	
    	for(int k = 0; k < this.getTypeNames().length; k++){
	    
    		result[k] = this.getSpeciesName() + " " + this.getTypeNames()[k];
	    
    	}
	
    	return result;
	
    }
    
    @Override
    public void registerIcons(IconRegister register){
	
	for (int k = 0; k < 4; k++) {
	    
	    icons[k] = 
		    register.registerIcon(Resources.TEXTURE_PREFIX+ "ant_" + this.getSpeciesSubName() + "_"+ this.getTypeNames()[k]);
	    
	}
	
    }
    
    @Override
    public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
	
	Nbt.setTag(par1ItemStack);
	
	ItemAnt ant = (ItemAnt) par1ItemStack.getItem();
		
	Properties.setProperties(par1ItemStack, ant.getFertility(), ant.getMaturingTime(), ant.getWinged(), ant.getLifetime(), 0, false, ant.getNocturnal());
    }
    
    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
	if( par1ItemStack.stackTagCompound == null )
		par1ItemStack.setTagCompound( new NBTTagCompound( ) );
	
	if(par1ItemStack.getItemDamage() == Metadata.getMetaQueen()){
	
	    par3List.add("Lifetime left: "+(Properties.getLifetime(par1ItemStack) - Properties.getLifetimeComplete(par1ItemStack)));
    
	}
    }
        
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(int itemID, CreativeTabs tabs, List list) {
	
	for (int k = 0; k < Metadata.typeMeta.length; k++) {
	    
	    list.add(new ItemStack(itemID, 1, k));
	    
	}
	
    }
    
    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
	
	return this.getUnlocalizedName()
		+ getSpeciesName()+" "+getTypeNames()[itemStack.getItemDamage()];
	
    }
    
    @Override
    public Icon getIconFromDamage(int par1)
    {
        return this.icons[par1];
    }
    
    /**
     * Gets the time in ticks that it takes to incubate the ant's larvae
     * @return int
     */
    public int getMaturingTime(){
	
	return Time.getTicksFromMinutes(10);
	
    }
    
    /**
     * Gets the ant species' name to be displayed in-game
     * 
     * @return String
     */
    public String getSpeciesName() {
	// TODO Auto-generated method stub
	return "Default";
    }
    
    /**
     * Gets the ant species' name to be used internally i.e for texture names
     * should be lowercase
     * 
     * @return String
     */
    public String getSpeciesSubName() {
	// TODO Auto-generated method stub
	return "default";
    }
    
    /**
     * Returns true if the ant species can be found in ant hills
     * 
     * @return boolean
     */
    public boolean isHillAnt() {
	// TODO Auto-generated method stub
	return false;
    }
    
    /**
     * Gets the ant species' fertility, one element from the returned array will be chosen
     * 
     * @return int
     */
    public int getFertility() {
	return 2;
    }
    
    /**
     * Gets the ant species' lifetime in ticks, use the
     * Properties.getTicksFromMinutes(minutes) method to convert minutes to
     * ticks
     * 
     * @return int
     */
    public int getLifetime() {
	return 10;
    }
    
    /**
     * Returns true if the species can eat sweet food, i.e cake and sugar
     * 
     * @return boolean
     */
    public boolean eatsSweet() {
	// TODO Auto-generated method stub
	return true;
    }
    
    /**
     * Returns true if the species can eat savoury food, i.e bread and mushroom
     * soup
     * 
     * @return boolean
     */
    public boolean eatsSavoury() {
	// TODO Auto-generated method stub
	return false;
    }
    
    /**
     * Returns true if the species can eat meat food, i.e porkchops and steak
     * 
     * @return boolean
     */
    public boolean eatsMeat() {
	// TODO Auto-generated method stub
	return false;
    }
    
    /**
     * Returns true if the species can eat ant larvae
     * 
     * @return boolean
     */
    public boolean eatsLarvae() {
	// TODO Auto-generated method stub
	return false;
    }
    
    /**
     * Gets called when the ant can perform its behaviour (e.g harvesting crops)
     * from an ant farm
     * 
     * @param world
     * @param x
     * @param y
     * @param z
     */
    public void performBehaviour(World world, int x, int y, int z) {
	// TODO Auto-generated method stub
	
    }
    
    /**
     * Gets the ant species' binomial name (e.g. Atta Colombica)
     * 
     * @param meta
     * @return String
     */
    public String getSpeciesBinomialName() {
	// TODO Auto-generated method stub
	return "Antus Defaultus";
    }
    
    /**
     * Gets the ant species' biomes in which they can breed and perform
     * their behaviour
     * 
     * @return BiomeGenBase[] (null to use in all biomes)
     */
    public BiomeGenBase[] getAntBiomes() {
	// TODO Auto-generated method stub
	return null;
    }
    
    /**
     * Gets the names of each type of ant in the order of the Queen, Drone,
     * Worker and Larva ants
     * 
     * @return String
     */
    public String[] getTypeNames() {
    	
    	String[] result = new String[] {"Queen", "Drone", "Worker", "Larva"};
	
    	return result;
    }

    /**
     * Returns true if the ant is winged (i.e can perform its behaviour and breed in the rain)
     * @return
     */
    public boolean getWinged() {
	return false;
    }

    /**
     * Returns true if the ant can perform its behaviour and breed during the night.
     * @return
     */
    public boolean getNocturnal() {
	return false;
    }
    
}