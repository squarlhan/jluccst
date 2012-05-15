package experiments;

import org.jgap.BaseRateCalculator;
import org.jgap.Configuration;
import org.jgap.IChromosome;
import org.jgap.IUniversalRateCalculator;
import org.jgap.InvalidConfigurationException;
import org.jgap.RandomGenerator;

public class KeyboardCrossoverRateCalc extends BaseRateCalculator {
	
	

	private double min;
	private double max;
	private double preset;
	private int size; 
	
	public KeyboardCrossoverRateCalc(Configuration a_config)
			throws InvalidConfigurationException {
		super(a_config);
		// TODO Auto-generated constructor stub
	}
	public KeyboardCrossoverRateCalc(Configuration a_config, double min, double  max, double preset, int size)
			throws InvalidConfigurationException {
		super(a_config);
		this.min = Math.min(min,max);
		this.max = Math.max(min,max);
		this.preset = preset;
		this.size = size;
		Older.cmax = (int) (this.max*size);
		Older.cmin = (int) (this.min*size);
		Older.old_crossover = (int) (preset*size);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int calculateCurrentRate() {
		// TODO Auto-generated method stub
		return Older.old_crossover;
	    
	}

	@Override
	public boolean toBePermutated(IChromosome a_chrom, int a_geneIndex) {
		// TODO Auto-generated method stub
		
		    return true;
	}

}
