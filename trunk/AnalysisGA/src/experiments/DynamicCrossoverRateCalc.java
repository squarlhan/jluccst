package experiments;

import org.jgap.BaseRateCalculator;
import org.jgap.Configuration;
import org.jgap.IChromosome;
import org.jgap.IUniversalRateCalculator;
import org.jgap.InvalidConfigurationException;
import org.jgap.RandomGenerator;

public class DynamicCrossoverRateCalc extends BaseRateCalculator {
	
	

	private double min;
	private double max;
	
	public DynamicCrossoverRateCalc(Configuration a_config)
			throws InvalidConfigurationException {
		super(a_config);
		// TODO Auto-generated constructor stub
	}
	public DynamicCrossoverRateCalc(Configuration a_config, double min, double  max)
			throws InvalidConfigurationException {
		super(a_config);
		this.min = Math.min(min,max);
		this.max = Math.max(min,max);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public int calculateCurrentRate() {
		// TODO Auto-generated method stub
		int size = getConfiguration().getChromosomeSize();
	    if (size < 1) {
	      size = 1;
	    }
	    if(max>1||min<0){
	    		Older.old_crossover = size;
	    	return size;
	    }else{
	    	int newer = (int)((Math.random()*(max-min)+min)*size);
	    	System.out.println("CurrentCrossoverRate: "+newer);
	    		Older.old_crossover = newer;
	    	return newer;
	    }
	    
	}

	@Override
	public boolean toBePermutated(IChromosome a_chrom, int a_geneIndex) {
		// TODO Auto-generated method stub
		
		    return true;
	}

}
