package vivadaylight3.myrmecology.common.item.ant;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import vivadaylight3.myrmecology.api.ItemAnt;
import vivadaylight3.myrmecology.common.Reference;
import vivadaylight3.myrmecology.common.Register;
import vivadaylight3.myrmecology.common.lib.Time;

public class AntScavenger extends ItemAnt {

    public AntScavenger(int par1) {
	super(par1);
	// TODO Auto-generated constructor stub
    }

    @Override
    public String getSpeciesName() {

	return "Scavenger Ant";

    }

    @Override
    public String getSpeciesSubName() {

	return Reference.ANT_SCAVENGER_NAME;

    }

    @Override
    public boolean isHillAnt() {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public int getFertility() {
	// TODO Auto-generated method stub
	return 3;
    }

    @Override
    public int getLifetime() {
	// TODO Auto-generated method stub
	return Time.getTicksFromMinutes(20);
    }

    @Override
    public boolean eatsSweet() {
	// TODO Auto-generated method stub
	return true;
    }

    @Override
    public boolean eatsSavoury() {
	// TODO Auto-generated method stub
	return true;
    }

    @Override
    public boolean eatsMeat() {
	// TODO Auto-generated method stub
	return true;
    }

    @Override
    public boolean eatsLarvae() {
	// TODO Auto-generated method stub
	return true;
    }

    @Override
    public void performBehaviour(World world, int x, int y, int z) {

    }

    @Override
    public String getSpeciesBinomialName() {
	// TODO Auto-generated method stub
	return "Formicadae Lutum";
    }

    @Override
    public BiomeGenBase[] getAntBiomes() {

	return null;
    }
    
    @Override
    protected int[] getColours(){
	
	return new int[] {0x724539, 0xf69679};
	
    }

}
