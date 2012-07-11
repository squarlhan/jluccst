package cn.edu.jlu.ccst.example;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

import cn.edu.jlu.ccst.constraint.Solver;
import cn.edu.jlu.ccst.model.Atom;
import cn.edu.jlu.ccst.model.Molecular;
import cn.edu.jlu.ccst.model.Reaction;

public class GATest {
	
	public static int[] gasolution(int scope, int[][] matrix, int numEvolutions, int popSize){
		int m = matrix.length;
		int n = matrix[0].length;
		int[] result = new int[n];
		
	    Configuration gaConf = new DefaultConfiguration();
	    gaConf.setPreservFittestIndividual(true);
	    gaConf.setKeepPopulationSizeConstant(false);
	    Genotype genotype = null;
	    int chromeSize = n;
	    FitnessFunction fitness = new MaxFunction(matrix);
	   
	    double maxFitness = 1;
	    try {
	    	Gene[] sampleGenes = new IntegerGene[chromeSize];//基因长度
			 for (int i = 0; i < sampleGenes.length; i++) {					    
					sampleGenes[i] = new IntegerGene(gaConf, 1,scope);
			 }
			// 构建染色体(Chromosome)
			 IChromosome sampleChromosome = new Chromosome(gaConf, sampleGenes);
			gaConf.setSampleChromosome(sampleChromosome);
			gaConf.setPopulationSize(popSize);	
			gaConf.setFitnessFunction(fitness);
			genotype = Genotype.randomInitialGenotype(gaConf);
	    }
	    catch (InvalidConfigurationException e) {
	      e.printStackTrace();
	      System.exit( -2);
	    }
	    int progress = 0;
	    int percentEvolution = numEvolutions / 100;
	    for (int i = 0; i < numEvolutions; i++) {
	      genotype.evolve();
	      // Print progress.
	      // ---------------
	      if (percentEvolution > 0 && i % percentEvolution == 0) {
	        progress++;
	        IChromosome fittest = genotype.getFittestChromosome();
	        double fitnessvalue = fittest.getFitnessValue();
	        System.out.println("Currently fittest Chromosome has fitness " +
	                           fitness);
	        if (fitnessvalue >= maxFitness) {
	          break;
	        }
	      }
	    }
	    // Print summary.
	    // --------------
	    IChromosome fittest = genotype.getFittestChromosome();
	    System.out.println("Fittest Chromosome has fitness " +
	                       fittest.getFitnessValue());
	    for(int j = 0; j<=n-1;j++){
			result[j] = ((IntegerGene)fittest.getGene(j)).intValue();
		}
		
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String rstr1 = "H2+O2=H2O";
		String rstr2 = "KClO3 = KCl + O2";
		String rstr3 = "Fe+H2O=Fe3O4+H2";
		String rstr4 = " AI2(SO4)3＋Na2CO3 = AI(OH)3＋CO2＋Na2SO4";
		String rstr5 = "C2H2+ KMnO4+ H2SO4= K2SO4+ MnSO4+ HCOOH+ H2O";
		String rstr6 = "K2Cr2O7+ Fe3O4+ H2SO4=K2SO4+ Fe2(SO4)3+ Cr2(SO4)3+ H2O";
		String rstr7="NaBiO3+MnSO4+H2SO4=Na2SO4+Bi2(SO4)3+NaMnO4+H2O";
		Reaction r = new Reaction(rstr6);
        for(Molecular m: r.getLeft()){
        	for(Atom a:m.getAtoms()){
    			System.out.print(a.getName()+a.getCount());
    		}
        	System.out.print("+");
        }
        System.out.print("=");
        for(Molecular m: r.getRight()){
        	for(Atom a:m.getAtoms()){
    			System.out.print(a.getName()+a.getCount());
    		}
        	System.out.print("+");
        }
        
        int[][] matrix = r.generatematrix();
		for (int i = 0; i < matrix.length; i++) {
			System.out.println();
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]+"\t");
			}
			
		}

		int[] result = gasolution(100, matrix, 2000, 50);
		System.out.println();
		for(int i=0;i<= r.getLeft().size()-1;i++){
			Molecular m =r.getLeft().get(i);
			m.setCount(result[i]);
			if(i == r.getLeft().size()-1){
				System.out.print(m.getCount()+m.getName());
			}else{
			    System.out.print(m.getCount()+m.getName()+"+");
			}
		}
		System.out.print("=");
		for(int i=0;i<= r.getRight().size()-1;i++){
			Molecular m =r.getRight().get(i);
			m.setCount(result[i+r.getLeft().size()]);
			if(i == r.getRight().size()-1){
				System.out.print(m.getCount()+m.getName());
			}else{
			    System.out.print(m.getCount()+m.getName()+"+");
			}
		}

	}

}
