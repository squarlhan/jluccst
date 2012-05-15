package experiments;

import org.jgap.BaseRateCalculator;
import org.jgap.Configuration;
import org.jgap.IChromosome;
import org.jgap.IUniversalRateCalculator;
import org.jgap.InvalidConfigurationException;
import org.jgap.RandomGenerator;

public class KeyboardMutationRateCalc extends BaseRateCalculator {
	
	

	private double min;
	private double max;
	private double preset;
	private int size; 
	
	public KeyboardMutationRateCalc(Configuration a_config)
			throws InvalidConfigurationException {
		super(a_config);
		// TODO Auto-generated constructor stub
	}
	public KeyboardMutationRateCalc(Configuration a_config, double min, double  max, double preset, int size)
			throws InvalidConfigurationException {
		super(a_config);
		this.min = Math.min(min,max);
		this.max = Math.max(min,max);
		this.preset = preset;
		this.size = size;
		Older.mmax = (int) (1/this.min);
		Older.mmin = (int) (1/this.max);
		Older.old_mutation = (int) (1/preset);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int calculateCurrentRate() {
		// TODO Auto-generated method stub
		return Older.old_mutation;
	    
	}

	@Override
	public boolean toBePermutated(IChromosome a_chrom, int a_geneIndex) {
		// TODO Auto-generated method stub
		 RandomGenerator generator = getConfiguration().getRandomGenerator();
		    return (generator.nextInt(calculateCurrentRate()) == 0);
	}

}
