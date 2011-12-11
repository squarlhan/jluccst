package experiments.kmeansga;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.IChromosome;
import org.jgap.Population;

import affinitymain.InteractionData;
import affinitymain.RunAlgorithm;
import algorithm.abs.AffinityPropagationAlgorithm.AffinityConnectingMethod;

public class RunKM {
	
	public void run(Population a_pop, Configuration a_conf, KMeansGA obj, FitnessFunction fitness, int kmeans_max, double kmeans_num, double fit_lamda, double cutoff, double extra,BufferedWriter output){
		runimplafter(a_pop, a_conf, obj, fitness, kmeans_max, kmeans_num, fit_lamda, cutoff, extra, output);
//		runimpl(a_pop, a_conf, obj, fitness, kmeans_max, kmeans_num, fit_lamda, cutoff, extra, output);
	}
	
	private  void runimpl(Population a_pop, Configuration a_conf, KMeansGA obj, FitnessFunction fitness, int kmeans_max, double kmeans_num, double fit_lamda, double cutoff, double extra,BufferedWriter output) {
		
		double[][] chromatrix = pop2matrix(a_pop);
		double[][] dis = EucDistance.calcEucMatrix(chromatrix);
		List<Integer> results = KMeans.runKmeans(chromatrix, kmeans_num, kmeans_max);
		if(results==null||results.size()==0){
			for(int i = 0; i<= a_pop.size()-1; i++){
				results.add(i);
			}
			System.err.println("Cluster Error, 0 result!");	
		}
		 clustObjectFun.calcFittnessValue(a_pop, obj, fitness, results, dis, fit_lamda, cutoff, extra,output);
//		 try {
//				for (IChromosome mychrom : a_pop.getChromosomes()) {
//					IChromosome mychrom1 = (IChromosome) mychrom.clone();
//				output.write(Math.abs(fitness.evaluate(mychrom1)-mychrom.getFitnessValueDirectly()) + "\t");
//			}
//			output.write("\n");
//			output.flush();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
  }
	
	private  void runimplafter(Population a_pop, Configuration a_conf, KMeansGA obj, FitnessFunction fitness, int kmeans_max, double kmeans_num, double fit_lamda, double cutoff, double extra,BufferedWriter output) {
		
		
		
		
		
		double[][] chromatrix = pop2matrixafter(a_pop, a_conf);
		double[][] dis = EucDistance.calcEucMatrix(chromatrix);
		double[][] fullchromatrix = pop2matrix(a_pop);
		double[][] fulldis = EucDistance.calcEucMatrix(fullchromatrix);
		List<Integer> tempresults = KMeans.runKmeans(chromatrix, kmeans_num, kmeans_max);
		
		int oldpopsize = a_conf.getPopulationSize();
		Set<Integer> temp = new HashSet();
		temp.addAll(tempresults);
		List<Integer> results = new ArrayList();
		if(tempresults==null||tempresults.size()==0){
			for(int i = 0; i<= a_pop.size()-1; i++){
				results.add(i);
			}
			System.err.println("Cluster Error, 0 result!");	
		}else{
			for(int result:tempresults){
				results.add(result+oldpopsize);
			}
			for(int i = oldpopsize-1; i>=0;i--){
				results.add(0, i);
			}
		}
		int fc = getpopfalse(a_pop, a_conf);
		List<Double> objests = clustObjectFun.calcFittnessValue(a_pop, obj, fitness, results, fulldis, fit_lamda, cutoff, extra, output);
		try {
//				for (IChromosome mychrom : a_pop.getChromosomes()) {
//					IChromosome mychrom1 = (IChromosome) mychrom.clone();
//					double a1 = fitness.evaluate(mychrom1);
//					double a2 = mychrom.getFitnessValueDirectly();
//				    output.write(Math.abs(a1-a2) + "\t");
//			}
			output.write(temp.size()+"\t"+fc);
			output.write("\n");
			output.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
  }
	
	
	private int  getpopfalse(Population pop, Configuration a_conf){
		int oldpopsize = a_conf.getPopulationSize();
		int sum = 0;
		for(int i = 0; i<= oldpopsize-1; i++){
			IChromosome chrom =  pop.getChromosome(i);
			if(!chrom.isIscenter())sum++;
		}
		return sum;
		}

private double[][]  pop2matrix(Population pop){
  
  if(pop==null){
	  return null;
  }
  int m = pop.size();
  int n = pop.getChromosome(0).size();
  double[][]  chromatrix = new double[m][n];
  for(int i = 0; i<=m-1;i++){
	  for(int j = 0; j<=n-1;j++){
		  chromatrix[i][j] = (Double)pop.getChromosome(i).getGene(j).getAllele();
	  }
  }
  return chromatrix;
}

private double[][]  pop2matrixafter(Population pop, Configuration a_conf){
  int oldpopsize = a_conf.getPopulationSize();
  if(pop.size()<=oldpopsize){
	  return null;
  }
  int m = pop.size()-oldpopsize;
  int n = pop.getChromosome(0).size();
  double[][]  chromatrix = new double[m][n];
  for(int i = 0; i<=m-1;i++){
	  for(int j = 0; j<=n-1;j++){
		  chromatrix[i][j] = (Double)pop.getChromosome(i+oldpopsize).getGene(j).getAllele();
	  }
  }
  return chromatrix;
}

}
