/*
 * This file is part of JGAP.
 *
 * JGAP offers a dual license model containing the LGPL as well as the MPL.
 *
 * For licensing information please see the file license.txt included with JGAP
 * or have a look at the top of class org.jgap.Chromosome which representatively
 * includes the JGAP license policy applicable for any file delivered with JGAP.
 */
package org.jgap.impl;


import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgap.*;
import org.jgap.audit.*;
import org.jgap.event.*;

import affinitymain.InteractionData;
import affinitymain.RunAlgorithm;
import algorithm.abs.AffinityPropagationAlgorithm.AffinityConnectingMethod;
import experiments.kmeansga.EucDistance;
import experiments.kmeansga.KMeans;
import experiments.kmeansga.KMeansGA;
import experiments.kmeansga.clustObjectFun;

public class GABreeder
    extends BreederBase {
  /** String containing the CVS revision. Read out via reflection!*/
  private final static String CVS_REVISION = "$Revision: 1.17 $";

  private transient Configuration m_lastConf;

  private transient Population m_lastPop;

  public GABreeder() {
    super();
  }

  /**
   * Evolves the population of chromosomes within a genotype. This will
   * execute all of the genetic operators added to the present active
   * configuration and then invoke the natural selector to choose which
   * chromosomes will be included in the next generation population.
   *
   * @param a_pop the population to evolve
   * @param a_conf the configuration to use for evolution
   *
   * @return evolved population
   *
   * @author Klaus Meffert
   * @since 3.2
   */
  public Population evolve(Population a_pop, Configuration a_conf, KMeansGA obj,  
		  FitnessFunction fitness, int kmeans_max, double kmeans_num, 
		  double fit_lamda, double cutoff, double extra, BufferedWriter output) {
    Population pop = a_pop;
    int originalPopSize = a_conf.getPopulationSize();
    boolean monitorActive = a_conf.getMonitor() != null;
    IChromosome fittest = null;
    // If first generation: Set age to one to allow genetic operations,
    // see CrossoverOperator for an illustration.
    // ----------------------------------------------------------------
    if (a_conf.getGenerationNr() == 0) {
      int size = pop.size();
      for (int i = 0; i < size; i++) {
        IChromosome chrom = pop.getChromosome(i);
        chrom.increaseAge();
      }
    }
    else {
      // Select fittest chromosome in case it should be preserved and we are
      // not in the very first generation.
      // -------------------------------------------------------------------
      if (a_conf.isPreserveFittestIndividual()) {
        /**@todo utilize jobs. In pop do also utilize jobs, especially for fitness
         * computation*/
//    	  int aa = 0;
//    	  int size = pop.size(); 
//    	  for(int a = 0;a<=size-1;a++){asdf
//    		  fittest = aa<=pop.getChromosome(a).getFitnessValue()?pop.getChromosome(a):fittest;
//    	  }
    	fittest = pop.determineFittestChromosome(0, pop.size() - 1);
    	 
        
      }
    }
    if (a_conf.getGenerationNr() > 0) {
      // Adjust population size to configured size (if wanted).
      // Theoretically, this should be done at the end of this method.
      // But for optimization issues it is not. If it is the last call to
      // evolve() then the resulting population possibly contains more
      // chromosomes than the wanted number. But this is no bad thing as
      // more alternatives mean better chances having a fit candidate.
      // If it is not the last call to evolve() then the next call will
      // ensure the correct population size by calling keepPopSizeConstant.
      // ------------------------------------------------------------------
      keepPopSizeConstant(pop, a_conf);
    }
    // Ensure fitness value of all chromosomes is udpated.
    // ---------------------------------------------------
    if (monitorActive) {
      // Monitor that fitness value of chromosomes is being updated.
      // -----------------------------------------------------------
      a_conf.getMonitor().event(
          IEvolutionMonitor.MONITOR_EVENT_BEFORE_UPDATE_CHROMOSOMES1,
          a_conf.getGenerationNr(), new Object[]{pop});
    }
    updateChromosomes(pop, a_conf, obj, fitness, cutoff);
    if (monitorActive) {
      // Monitor that fitness value of chromosomes is being updated.
      // -----------------------------------------------------------
      a_conf.getMonitor().event(
          IEvolutionMonitor.MONITOR_EVENT_AFTER_UPDATE_CHROMOSOMES1,
          a_conf.getGenerationNr(), new Object[]{pop});
    }
    // Apply certain NaturalSelectors before GeneticOperators will be executed.
    // ------------------------------------------------------------------------
    pop = applyNaturalSelectors(a_conf, pop, true);
    // Execute all of the Genetic Operators.
    // -------------------------------------
    applyGeneticOperators(a_conf, pop);
    // Reset fitness value of genetically operated chromosomes.
    // Normally, this should not be necessary as the Chromosome class
    // initializes each newly created chromosome with
    // FitnessFunction.NO_FITNESS_VALUE. But who knows which Chromosome
    // implementation is used...
    // ----------------------------------------------------------------
    int currentPopSize = pop.size();
    for (int i = originalPopSize; i < currentPopSize; i++) {
      IChromosome chrom = pop.getChromosome(i);
      chrom.setFitnessValueDirectly(FitnessFunction.NO_FITNESS_VALUE);
      // Mark chromosome as new-born.
      // ----------------------------
      chrom.resetAge();
      // Mark chromosome as being operated on.
      // -------------------------------------
      chrom.increaseOperatedOn();
    }
    // Increase age of all chromosomes which are not modified by genetic
    // operations.
    // -----------------------------------------------------------------
    int size = Math.min(originalPopSize, currentPopSize);
    for (int i = 0; i < size; i++) {
      IChromosome chrom = pop.getChromosome(i);
      chrom.increaseAge();
      // Mark chromosome as not being operated on.
      // -----------------------------------------
      chrom.resetOperatedOn();
    }
    // If a bulk fitness function has been provided, call it.
    // ------------------------------------------------------
    BulkFitnessFunction bulkFunction = a_conf.getBulkFitnessFunction();
    if (bulkFunction != null) {
      if (monitorActive) {
        // Monitor that bulk fitness will be called for evaluation.
        // --------------------------------------------------------
        a_conf.getMonitor().event(
            IEvolutionMonitor.MONITOR_EVENT_BEFORE_BULK_EVAL,
            a_conf.getGenerationNr(), new Object[] {bulkFunction, pop});
      }
      /**@todo utilize jobs: bulk fitness function is not so important for a
       * prototype! */
      bulkFunction.evaluate(pop);
      if (monitorActive) {
        // Monitor that bulk fitness has been called for evaluation.
        // ---------------------------------------------------------
        a_conf.getMonitor().event(
            IEvolutionMonitor.MONITOR_EVENT_AFTER_BULK_EVAL,
            a_conf.getGenerationNr(), new Object[] {bulkFunction, pop});
      }
    }
    // Ensure fitness value of all chromosomes is udpated.
    // ---------------------------------------------------
    if (monitorActive) {
      // Monitor that fitness value of chromosomes is being updated.
      // -----------------------------------------------------------
      a_conf.getMonitor().event(
          IEvolutionMonitor.MONITOR_EVENT_BEFORE_UPDATE_CHROMOSOMES2,
          a_conf.getGenerationNr(), new Object[]{pop});
    }
    updateChromosomes(pop, a_conf, obj, fitness, kmeans_max, kmeans_num, fit_lamda, cutoff, extra, output);
    //去掉重复的个体
    /*pop.sortByFitness();
    Population tempop = (Population) pop.clone();
    Set<IChromosome> tempopset= new HashSet();
    tempopset.addAll(tempop.getChromosomes());
    tempop.clear();
    for(Object tempchrom:tempopset.toArray()){
    	tempop.addChromosome((IChromosome) tempchrom);
    }
    pop = tempop;*/
    if (monitorActive) {
      // Monitor that fitness value of chromosomes is being updated.
      // -----------------------------------------------------------
      a_conf.getMonitor().event(
          IEvolutionMonitor.MONITOR_EVENT_AFTER_UPDATE_CHROMOSOMES2,
          a_conf.getGenerationNr(), new Object[]{pop});
    }
    // Apply certain NaturalSelectors after GeneticOperators have been applied.
    // ------------------------------------------------------------------------
    pop = applyNaturalSelectors(a_conf, pop, false);
    // Fill up population randomly if size dropped below specified percentage
    // of original size.
    // ----------------------------------------------------------------------
    if (a_conf.getMinimumPopSizePercent() > 0) {
      int sizeWanted = a_conf.getPopulationSize();
      int popSize;
      int minSize = (int) Math.round(sizeWanted *
                                     (double) a_conf.getMinimumPopSizePercent()
                                     / 100);
      popSize = pop.size();
      if (popSize < minSize) {
        IChromosome newChrom;
        IChromosome sampleChrom = a_conf.getSampleChromosome();
        Class sampleChromClass = sampleChrom.getClass();
        IInitializer chromIniter = a_conf.getJGAPFactory().
            getInitializerFor(sampleChrom, sampleChromClass);
        while (pop.size() < minSize) {
          try {
            /**@todo utilize jobs as initialization may be time-consuming as
             * invalid combinations may have to be filtered out*/
            newChrom = (IChromosome) chromIniter.perform(sampleChrom,
                sampleChromClass, null);
            if (monitorActive) {
              // Monitor that fitness value of chromosomes is being updated.
              // -----------------------------------------------------------
              a_conf.getMonitor().event(
                  IEvolutionMonitor.MONITOR_EVENT_BEFORE_ADD_CHROMOSOME,
                  a_conf.getGenerationNr(), new Object[]{pop, newChrom});
            }
            pop.addChromosome(newChrom);
          } catch (Exception ex) {
            throw new RuntimeException(ex);
          }
        }
      }
    }
    IChromosome newFittest = reAddFittest(pop, fittest);
    
    if (monitorActive && newFittest != null) {
      // Monitor that fitness value of chromosomes is being updated.
      // -----------------------------------------------------------
      a_conf.getMonitor().event(
          IEvolutionMonitor.MONITOR_EVENT_READD_FITTEST,
          a_conf.getGenerationNr(), new Object[] {pop, fittest});
    }

    // Increase number of generations.
    // -------------------------------
    a_conf.incrementGenerationNr();
    // Fire an event to indicate we've performed an evolution.
    // -------------------------------------------------------
    m_lastPop = pop;
    m_lastConf = a_conf;
    a_conf.getEventManager().fireGeneticEvent(
        new GeneticEvent(GeneticEvent.GENOTYPE_EVOLVED_EVENT, this));
  //每次得到的都是真实的适应度
    /*  Chromosome myfit = (Chromosome)pop.determineFittestChromosome();
    if(!myfit.isIscenter()){
//    	System.out.println("size: "+ pop.size()+" fit: "+myfit.isIscenter()+" best fitness: "+pop.determineFittestChromosome().getFitnessValue());
    	myfit.setIscenter(true);
    	double fitvalue = clustObjectFun.calconeFittnessValue(pop.determineFittestChromosome(), obj,  fitness);
    	
    	if(myfit.getFitnessValue()!=fitvalue){
    		System.out.println("a: "+myfit.getFitnessValue());
    		System.out.println("b: "+fitvalue);
    	}
    	myfit.setFitnessValue(fitvalue);
    	
    	pop.sortByFitness();
    	pop.getChromosome(0).setFitnessValue(myfit.getFitnessValue());
//    	System.out.println("size: "+ pop.size()+" fit: "+((Chromosome)pop.getChromosome(0)).isIscenter()+" after best fitness: "+pop.determineFittestChromosome().getFitnessValue());
    }*/
    return pop;
  }
  
  public Population evolve(Population a_pop, Configuration a_conf) {
	    Population pop = a_pop;
	    int originalPopSize = a_conf.getPopulationSize();
	    boolean monitorActive = a_conf.getMonitor() != null;
	    IChromosome fittest = null;
	    // If first generation: Set age to one to allow genetic operations,
	    // see CrossoverOperator for an illustration.
	    // ----------------------------------------------------------------
	    if (a_conf.getGenerationNr() == 0) {
	      int size = pop.size();
	      for (int i = 0; i < size; i++) {
	        IChromosome chrom = pop.getChromosome(i);
	        chrom.increaseAge();
	      }
	    }
	    else {
	      // Select fittest chromosome in case it should be preserved and we are
	      // not in the very first generation.
	      // -------------------------------------------------------------------
	      if (a_conf.isPreserveFittestIndividual()) {
	        /**@todo utilize jobs. In pop do also utilize jobs, especially for fitness
	         * computation*/
	    	 
	    		  fittest = pop.determineFittestChromosome(0, pop.size() - 1);
	    	  
	        
	      }
	    }
	    if (a_conf.getGenerationNr() > 0) {
	      // Adjust population size to configured size (if wanted).
	      // Theoretically, this should be done at the end of this method.
	      // But for optimization issues it is not. If it is the last call to
	      // evolve() then the resulting population possibly contains more
	      // chromosomes than the wanted number. But this is no bad thing as
	      // more alternatives mean better chances having a fit candidate.
	      // If it is not the last call to evolve() then the next call will
	      // ensure the correct population size by calling keepPopSizeConstant.
	      // ------------------------------------------------------------------
	      keepPopSizeConstant(pop, a_conf);
	    }
	    // Ensure fitness value of all chromosomes is udpated.
	    // ---------------------------------------------------
	    if (monitorActive) {
	      // Monitor that fitness value of chromosomes is being updated.
	      // -----------------------------------------------------------
	      a_conf.getMonitor().event(
	          IEvolutionMonitor.MONITOR_EVENT_BEFORE_UPDATE_CHROMOSOMES1,
	          a_conf.getGenerationNr(), new Object[]{pop});
	    }
	    updateChromosomes(pop, a_conf);
	    if (monitorActive) {
	      // Monitor that fitness value of chromosomes is being updated.
	      // -----------------------------------------------------------
	      a_conf.getMonitor().event(
	          IEvolutionMonitor.MONITOR_EVENT_AFTER_UPDATE_CHROMOSOMES1,
	          a_conf.getGenerationNr(), new Object[]{pop});
	    }
	    // Apply certain NaturalSelectors before GeneticOperators will be executed.
	    // ------------------------------------------------------------------------
	    pop = applyNaturalSelectors(a_conf, pop, true);
	    // Execute all of the Genetic Operators.
	    // -------------------------------------
	    applyGeneticOperators(a_conf, pop);
	    // Reset fitness value of genetically operated chromosomes.
	    // Normally, this should not be necessary as the Chromosome class
	    // initializes each newly created chromosome with
	    // FitnessFunction.NO_FITNESS_VALUE. But who knows which Chromosome
	    // implementation is used...
	    // ----------------------------------------------------------------
	    int currentPopSize = pop.size();
	    for (int i = originalPopSize; i < currentPopSize; i++) {
	      IChromosome chrom = pop.getChromosome(i);
	      chrom.setFitnessValueDirectly(FitnessFunction.NO_FITNESS_VALUE);
	      // Mark chromosome as new-born.
	      // ----------------------------
	      chrom.resetAge();
	      // Mark chromosome as being operated on.
	      // -------------------------------------
	      chrom.increaseOperatedOn();
	    }
	    // Increase age of all chromosomes which are not modified by genetic
	    // operations.
	    // -----------------------------------------------------------------
	    int size = Math.min(originalPopSize, currentPopSize);
	    for (int i = 0; i < size; i++) {
	      IChromosome chrom = pop.getChromosome(i);
	      chrom.increaseAge();
	      // Mark chromosome as not being operated on.
	      // -----------------------------------------
	      chrom.resetOperatedOn();
	    }
	    // If a bulk fitness function has been provided, call it.
	    // ------------------------------------------------------
	    BulkFitnessFunction bulkFunction = a_conf.getBulkFitnessFunction();
	    if (bulkFunction != null) {
	      if (monitorActive) {
	        // Monitor that bulk fitness will be called for evaluation.
	        // --------------------------------------------------------
	        a_conf.getMonitor().event(
	            IEvolutionMonitor.MONITOR_EVENT_BEFORE_BULK_EVAL,
	            a_conf.getGenerationNr(), new Object[] {bulkFunction, pop});
	      }
	      /**@todo utilize jobs: bulk fitness function is not so important for a
	       * prototype! */
	      bulkFunction.evaluate(pop);
	      if (monitorActive) {
	        // Monitor that bulk fitness has been called for evaluation.
	        // ---------------------------------------------------------
	        a_conf.getMonitor().event(
	            IEvolutionMonitor.MONITOR_EVENT_AFTER_BULK_EVAL,
	            a_conf.getGenerationNr(), new Object[] {bulkFunction, pop});
	      }
	    }
	    // Ensure fitness value of all chromosomes is udpated.
	    // ---------------------------------------------------
	    if (monitorActive) {
	      // Monitor that fitness value of chromosomes is being updated.
	      // -----------------------------------------------------------
	      a_conf.getMonitor().event(
	          IEvolutionMonitor.MONITOR_EVENT_BEFORE_UPDATE_CHROMOSOMES2,
	          a_conf.getGenerationNr(), new Object[]{pop});
	    }
	    updateChromosomes(pop, a_conf);
	    if (monitorActive) {
	      // Monitor that fitness value of chromosomes is being updated.
	      // -----------------------------------------------------------
	      a_conf.getMonitor().event(
	          IEvolutionMonitor.MONITOR_EVENT_AFTER_UPDATE_CHROMOSOMES2,
	          a_conf.getGenerationNr(), new Object[]{pop});
	    }
	    // Apply certain NaturalSelectors after GeneticOperators have been applied.
	    // ------------------------------------------------------------------------
	    pop = applyNaturalSelectors(a_conf, pop, false);
	    // Fill up population randomly if size dropped below specified percentage
	    // of original size.
	    // ----------------------------------------------------------------------
	    if (a_conf.getMinimumPopSizePercent() > 0) {
	      int sizeWanted = a_conf.getPopulationSize();
	      int popSize;
	      int minSize = (int) Math.round(sizeWanted *
	                                     (double) a_conf.getMinimumPopSizePercent()
	                                     / 100);
	      popSize = pop.size();
	      if (popSize < minSize) {
	        IChromosome newChrom;
	        IChromosome sampleChrom = a_conf.getSampleChromosome();
	        Class sampleChromClass = sampleChrom.getClass();
	        IInitializer chromIniter = a_conf.getJGAPFactory().
	            getInitializerFor(sampleChrom, sampleChromClass);
	        while (pop.size() < minSize) {
	          try {
	            /**@todo utilize jobs as initialization may be time-consuming as
	             * invalid combinations may have to be filtered out*/
	            newChrom = (IChromosome) chromIniter.perform(sampleChrom,
	                sampleChromClass, null);
	            if (monitorActive) {
	              // Monitor that fitness value of chromosomes is being updated.
	              // -----------------------------------------------------------
	              a_conf.getMonitor().event(
	                  IEvolutionMonitor.MONITOR_EVENT_BEFORE_ADD_CHROMOSOME,
	                  a_conf.getGenerationNr(), new Object[]{pop, newChrom});
	            }
	            pop.addChromosome(newChrom);
	          } catch (Exception ex) {
	            throw new RuntimeException(ex);
	          }
	        }
	      }
	    }
	    IChromosome newFittest = reAddFittest(pop, fittest);
	    if (monitorActive && newFittest != null) {
	      // Monitor that fitness value of chromosomes is being updated.
	      // -----------------------------------------------------------
	      a_conf.getMonitor().event(
	          IEvolutionMonitor.MONITOR_EVENT_READD_FITTEST,
	          a_conf.getGenerationNr(), new Object[] {pop, fittest});
	    }

	    // Increase number of generations.
	    // -------------------------------
	    a_conf.incrementGenerationNr();
	    // Fire an event to indicate we've performed an evolution.
	    // -------------------------------------------------------
	    m_lastPop = pop;
	    m_lastConf = a_conf;
	    a_conf.getEventManager().fireGeneticEvent(
	        new GeneticEvent(GeneticEvent.GENOTYPE_EVOLVED_EVENT, this));

	    return pop;
	  }


  
  public Configuration getLastConfiguration() {
    return m_lastConf;
  }

  public Population getLastPopulation() {
    return m_lastPop;
  }

  /**
   * @return deep clone of this instance
   *
   * @author Klaus Meffert
   * @since 3.2
   */
  public Object clone() {
    return new GABreeder();
  }

  /**
   * Cares that population size is kept constant and does not exceed the desired
   * size.
   *
   * @param a_pop Population
   * @param a_conf Configuration
   */
  protected void keepPopSizeConstant(Population a_pop, Configuration a_conf) {
    if (a_conf.isKeepPopulationSizeConstant()) {
      try {
        a_pop.keepPopSizeConstant();
      } catch (InvalidConfigurationException iex) {
        throw new RuntimeException(iex);
      }
    }
  }

  protected IChromosome reAddFittest(Population a_pop, IChromosome a_fittest) {
    // Determine if all-time fittest chromosome is in the population.
    // --------------------------------------------------------------
    if (a_fittest != null && !a_pop.contains(a_fittest)) {
      // Re-add fittest chromosome to current population.
      // ------------------------------------------------
      a_pop.addChromosome(a_fittest);
      return a_fittest;
    }
    return null;
  }
  
  protected void updateChromosomes(Population a_pop, Configuration a_conf ) {
	    int currentPopSize = a_pop.size();
	    // Ensure all chromosomes are updated.
	    // -----------------------------------
	    BulkFitnessFunction bulkFunction = a_conf.getBulkFitnessFunction();
	    boolean bulkFitFunc = (bulkFunction != null);
	    if (!bulkFitFunc) {
	      for (int i = 0; i < currentPopSize; i++) {
	        IChromosome chrom = a_pop.getChromosome(i);
	        chrom.getFitnessValue();
	      }
	    }
	  }
  
  protected void updateChromosomes(Population a_pop, Configuration a_conf, KMeansGA obj,  FitnessFunction fitness, double cutoff) {
	  clustObjectFun.calcFittnessValueDrictely(a_pop, obj, fitness, cutoff);
  }
  
  protected void updateChromosomes(Population a_pop, Configuration a_conf, KMeansGA obj, FitnessFunction fitness, int kmeans_max, double kmeans_num, double fit_lamda, double cutoff, double extra,BufferedWriter output) {
		
			double[][] chromatrix = pop2matrix(a_pop);
			double[][] dis = EucDistance.calcEucMatrix(chromatrix);
			List<Integer> results = KMeans.runKmeans(a_pop, kmeans_num, kmeans_max);
			if(results==null||results.size()==0){
				for(int i = 0; i<= a_pop.size()-1; i++){
					results.add(i);
				}
				System.err.println("Cluster Error, 0 result!");	
			}
			 clustObjectFun.calcFittnessValue(a_pop, obj, fitness, results, dis, fit_lamda, cutoff, extra,output);
//			 try {
//					for (IChromosome mychrom : a_pop.getChromosomes()) {
//						IChromosome mychrom1 = (IChromosome) mychrom.clone();
//					output.write(Math.abs(fitness.evaluate(mychrom1)-mychrom.getFitnessValueDirectly()) + "\t");
//				}
//				output.write("\n");
//				output.flush();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
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
}
