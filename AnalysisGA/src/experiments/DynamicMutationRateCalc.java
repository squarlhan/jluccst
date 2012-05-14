package experiments;

import org.jgap.BaseRateCalculator;
import org.jgap.Configuration;
import org.jgap.IChromosome;
import org.jgap.IUniversalRateCalculator;
import org.jgap.InvalidConfigurationException;
import org.jgap.RandomGenerator;

public class DynamicMutationRateCalc extends BaseRateCalculator {
	
	

	private int min;
	private int max;
	
	public DynamicMutationRateCalc(Configuration a_config)
			throws InvalidConfigurationException {
		super(a_config);
		// TODO Auto-generated constructor stub
	}
	public DynamicMutationRateCalc(Configuration a_config, int min, int  max)
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
	    if(min<1){
	    	return size;
	    }else{
	    	System.out.println("CurrentMutationRate: "+(int)(Math.random()*(max-min)+min));
	    	return (int)(Math.random()*(max-min)+min);
	    }
	    
	}

	@Override
	public boolean toBePermutated(IChromosome a_chrom, int a_geneIndex) {
		// TODO Auto-generated method stub
		 RandomGenerator generator = getConfiguration().getRandomGenerator();
		    return (generator.nextInt(calculateCurrentRate()) == 0);
	}

}
