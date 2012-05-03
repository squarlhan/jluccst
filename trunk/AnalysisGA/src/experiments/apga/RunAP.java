package experiments.apga;

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

public class RunAP {
	
	public void run(Population a_pop, Configuration a_conf, APGA obj, FitnessFunction fitness, int ap_num, double ap_lamda, double fit_lamda, double cutoff, double extra, BufferedWriter output){
//		runimplafter(a_pop, a_conf, obj, fitness, ap_num, ap_lamda, fit_lamda, cutoff, extra, output);
//		runimpl(a_pop, a_conf, obj, fitness, ap_num, ap_lamda, fit_lamda, cutoff, extra, output);
		runordinary(a_pop, a_conf, obj, fitness, ap_num, ap_lamda, fit_lamda, cutoff, extra, output);
	}
	
private  void runordinary(Population a_pop, Configuration a_conf, APGA obj, FitnessFunction fitness, int ap_num, double ap_lamda, double fit_lamda, double cutoff, double extra, BufferedWriter output) {
		
		double[][] chromatrix = pop2matrix(a_pop);
		double[][] dis = EucDistance.calcEucMatrix(chromatrix);
		Collection<InteractionData> inputs = EucDistance.transEucMatrix(dis);
		Double lambda = ap_lamda;
		Integer iterations = ap_num;
		Integer convits = null;
		Double preferences = dis[0][0];

		String kind = "clusters";
		AffinityConnectingMethod connMode = AffinityConnectingMethod.ORIGINAL;
		boolean takeLog = false;
		boolean refine = true;
		Integer steps = null;

		RunAlgorithm alg = new RunAlgorithm(inputs, lambda, iterations,
				convits, preferences, kind);
		alg.setTakeLog(takeLog);
		alg.setConnMode(connMode);
		alg.setSteps(steps);
		alg.setRefine(refine);

		alg.setParemeters();
		List<Integer> results = alg.run();
		if(results==null||results.size()==0){
			for(int i = 0; i<= a_pop.size()-1; i++){
				results.add(i);
			}
			System.err.println("Cluster Error, 0 result!");	
		}
		
		for (IChromosome mychrom : a_pop.getChromosomes()) {
			double a2 = mychrom.getFitnessValue();
	    }

		
		try {
			
			Set<Integer> res = new HashSet();
			res.addAll(results);
			int[] counts = new int[res.size()];
			for(int a : counts){
				a = 0;
			}
			Object[] resarray = res.toArray();
			for(int a = 0;a<=res.size()-1;a++){
				for(int b : results){
					if(resarray[a].equals(b))counts[a]++;
				}
			}
			output.write(counts.length+"\t");
			maoPao(counts);
			for(int a : counts){
				output.write(a+"\t");
			}
			output.write("\n");
			output.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
  }
	
	private void maoPao(int[] x) {
		for (int i = 0; i < x.length; i++) {
			for (int j = i + 1; j < x.length; j++) {
				if (x[i] < x[j]) {
					int temp = x[i];
					x[i] = x[j];
					x[j] = temp;
				}
			}
		}
//		for (int i : x) {
//			System.out.print(i + " ");
//		}
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
