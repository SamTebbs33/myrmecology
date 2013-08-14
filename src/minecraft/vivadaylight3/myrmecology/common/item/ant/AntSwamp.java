package vivadaylight3.myrmecology.common.item.ant;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import vivadaylight3.myrmecology.api.ItemAnt;
import vivadaylight3.myrmecology.common.Myrmecology;

public class AntSwamp extends ItemAnt {
        
    public AntSwamp(int par1) {
	super(par1, Myrmecology.MOD_ID);
	// TODO Auto-generated constructor stub
    }
    
    @Override
    public String getSpeciesName() {
	// TODO Auto-generated method stub
	return "Argentine Ant";
    }
    
    @Override
    public String getSpeciesSubName() {
	return "antSwamp";
    }
    
    @Override
    public boolean isHillAnt() {
	// TODO Auto-generated method stub
	return true;
    }
    
    @Override
    public int getFertility() {
	// TODO Auto-generated method stub
	return 2;
    }
    
    @Override
    public int getLifetime() {
	// TODO Auto-generated method stub
	return 0;
    }
    
    @Override
    public boolean eatsSweet() {
	// TODO Auto-generated method stub
	return false;
    }
    
    @Override
    public boolean eatsSavoury() {
	// TODO Auto-generated method stub
	return false;
    }
    
    @Override
    public boolean eatsMeat() {
	// TODO Auto-generated method stub
	return false;
    }
    
    @Override
    public boolean eatsLarvae() {
	// TODO Auto-generated method stub
	return false;
    }
    
    @Override
    public void performBehaviour(World world, int x, int y, int z) {
	// TODO Auto-generated method stub
	
    }
    
    @Override
    public String getSpeciesBinomialName() {
	// TODO Auto-generated method stub
	return "Antus Swampus";
    }
    
    @Override
    public BiomeGenBase[] getAntBiomes() {
	
	BiomeGenBase[] biomes = new BiomeGenBase[] { BiomeGenBase.swampland };
	
	return biomes;
    }
    
    @Override
    public String[] getTypeNames() {
	
	String[] names = new String[] { "Queen", "Drone", "Worker", "Larva" };
	
	return names;
    }
    
}