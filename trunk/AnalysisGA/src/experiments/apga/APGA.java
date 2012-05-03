package experiments.apga;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.Population;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.DoubleGene;


public class APGA {
private int nIterateCount=0;
private int progress = 0;
	
	
	public int getProgress() {
	return progress;
}

public void setProgress(int progress) {
	this.progress = progress;
}
	public int getnIterateCount() {
		return nIterateCount;
	}

	public void setnIterateCount(int nIterateCount) {
		this.nIterateCount = nIterateCount;
	}
	
	
	/**
	 * 基因算法优化
	 * @param fitness 目标函数
	 * @param p_lamda      用来指定模式发现的概率，0到1之间
	 * @param p_extra    用来指定模式发现的增幅，0到1之间
	 * @param ap_max     用来指定ap算法迭代次数
	 * @param ap_lamda       ap算法的lamda，决定收敛速度，越大越慢 0.5到0.95之间
	 * @param lamda      ap算法后，估算适应度的lamda 0到1之间
	 * @param scopes 每个参数取值范围矩阵 2行N列
	 * @param popSize  种群大小
	 * @param chromeSize     参数个数
	 * @param max_gen        基因算法内部优化迭代次数
	 */
	public IChromosome Calculate(int max_gen, int popSize, int chromeSize, List<List<Double>> scopes, FitnessFunction fitness, 
			double p_lamda, double p_extra,	int ap_max, double ap_lamda, double lamda, BufferedWriter output) {
		nIterateCount=0;
		progress = 0;
		
		int numEvolutions = max_gen;
		Configuration gaConf = new DefaultConfiguration();
		gaConf.reset();
		gaConf.setPreservFittestIndividual(true);
		gaConf.setKeepPopulationSizeConstant(false);
		Genotype genotype = null;
		
		
		
		try {
			//构建基因(Gene)
			Gene[] sampleGenes = new DoubleGene[chromeSize];//基因长度
			 for (int i = 0; i < sampleGenes.length; i++) {					    
					sampleGenes[i] = new DoubleGene(gaConf, scopes.get(i).get(0),scopes.get(i).get(1));
			 }
			// 构建染色体(Chromosome)
			 IChromosome sampleChromosome = new Chromosome(gaConf, sampleGenes);
			gaConf.setSampleChromosome(sampleChromosome);
			gaConf.setPopulationSize(popSize);	
			gaConf.setFitnessFunction(fitness);
			genotype = Genotype.randomInitialGenotype(gaConf);
			
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
			System.exit(-2);
		}
		progress = 0;
		int percentEvolution = numEvolutions / 10;
		for (int i = 0; i < numEvolutions; i++) {
        	//Start GA
			genotype.evolve(this, fitness, ap_max, ap_lamda, lamda, p_lamda, p_extra, output);
			// Print progress.
			IChromosome fittest  = genotype.getFittestChromosome();
			double bestfitness = fittest.getFitnessValue();
			try {
//				output.write(fittest.getFitnessValueDirectly() + "\t");
	            output.flush();
//				output.write("\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			progress++;
			// ---------------
			if (percentEvolution > 0 && i % percentEvolution == 0) {
				System.out.println("Currently fittest Chromosome has fitness "+ bestfitness);
			}
		}
		// Print summary.
		// --------------
		IChromosome fittest = genotype.getFittestChromosome();
		System.out.println("Fittest Chromosome has fitness "+ (fittest.getFitnessValueDirectly()));
		DecimalFormat myformat = new DecimalFormat("#0.0000");
		try {
//			output.write(fittest.getFitnessValueDirectly() + "\t");
            output.flush();
//            output.write("\t");
			for (int i = 0; i < chromeSize; i++) {
				System.out.print(myformat.format(fittest.getGene(i).getAllele()) + "	");
//				output.write(myformat.format(fittest.getGene(i).getAllele())+ "	");
			}
			System.out.println();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//处理返回结果
        return fittest;
	}// end of this math


	private void printsth(String filename, List<String> contents){
		try {
			File result = new File(filename);
			if (result.exists()) {
				result.delete();
				if (result.createNewFile()) {
					System.out.println("result file create success!");
				} else {
					System.out.println("result file create failed!");
				}
			} else {
				if (result.createNewFile()) {
					System.out.println("result file create success!");
				} else {
					System.out.println("result file create failed!");
				}

			}

			BufferedWriter output = new BufferedWriter(new FileWriter(result));
			
			for(String pattern : contents){
				output.write(pattern+"\n");
			}
			
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
