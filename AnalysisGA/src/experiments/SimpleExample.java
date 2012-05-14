/*
 * This file is part of JGAP.
 *
 * JGAP offers a dual license model containing the LGPL as well as the MPL.
 *
 * For licensing information please see the file license.txt included with JGAP
 * or have a look at the top of class org.jgap.Chromosome which representatively
 * includes the JGAP license policy applicable for any file delivered with JGAP.
 */
package experiments;

import java.awt.BorderLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jgap.*;
import org.jgap.impl.*;

/**
 * Simple class that demonstrates the basic usage of JGAP.
 * 
 * @author Neil Rotstan
 * @author Klaus Meffert
 * @since 2.0
 */
public class SimpleExample {
	/** String containing the CVS revision. Read out via reflection! */
	private static final String CVS_REVISION = "$Revision: 1.9 $";
	List<Double> fitlist = new ArrayList();
	
	public void runga(int ng, int chromeSize, int popsize, double left, double right, FitnessFunction fitnessfun, BufferedWriter output){
		long startTime = System.currentTimeMillis();
		int numEvolutions = ng;
		Configuration gaConf = new DefaultConfiguration();
		gaConf.reset();
		gaConf.setPreservFittestIndividual(true);
		gaConf.setKeepPopulationSizeConstant(false);
		gaConf.getGeneticOperators().clear();
		try {
			gaConf.addGeneticOperator(new MutationOperator(gaConf, new DynamicMutationRateCalc(gaConf, 10, 100)));
			gaConf.addGeneticOperator(new CrossoverOperator(gaConf, new DynamicCrossoverRateCalc(gaConf, 0.7, 0.99)));
		} catch (InvalidConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Genotype genotype = null;			
		
		try {
			//构建基因(Gene)
			Gene[] sampleGenes = new Gene[chromeSize];//基因长度2
			 for (int i = 0; i < sampleGenes.length; i++) {					    
					sampleGenes[i] = new DoubleGene(gaConf, left, right);
			 }
			// 构建染色体(Chromosome)
			 IChromosome sampleChromosome = new Chromosome(gaConf, sampleGenes);
			 gaConf.setSampleChromosome(sampleChromosome);
			gaConf.setPopulationSize(popsize);
			gaConf.setFitnessFunction(fitnessfun);
			genotype = Genotype.randomInitialGenotype(gaConf);
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
			System.exit(-2);
		}
		int progress = 0;
		int percentEvolution = numEvolutions / 10;
		for (int i = 0; i < numEvolutions; i++) {
			genotype.evolve();
			IChromosome fittest = genotype.getFittestChromosome();
			double fitness = fittest.getFitnessValue();
			fitlist.add(fitness);
			// Print progress.
			// ---------------
			if (percentEvolution > 0 && i % percentEvolution == 0) {
				progress++;
				System.out.println("Currently fittest Chromosome has fitness "+ fitness);
			}
		}
		// Print summary.
		// --------------
		IChromosome fittest = genotype.getFittestChromosome();
		System.out.println("Fittest Chromosome has fitness "
				+ (fittest.getFitnessValue()));
		try {
			output.write(fittest.getFitnessValue() + "\t");

			DecimalFormat myformat = new DecimalFormat("#0.00");
			for (int i = 0; i < chromeSize; i++) {

				// System.out.println(myformat.format(((DoubleGene)fittest.getGene(i)).doubleValue()));
				System.out.print(myformat
						.format(fittest.getGene(i).getAllele()) + "	");
//				output.write(myformat
//						.format(fittest.getGene(i).getAllele()) + "	");
			}
			System.out.println();
			output.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("运行时间 " + (endTime - startTime) + "ms");
		System.out.println("sum counts:  "+ MaxFunction.counts);
	}
	
    public  JFreeChart createChart(){  
    	String[] rowKeys = { "Fitness Line" };     
        String[] colKeys = new String[fitlist.size()];     
        double[][] data = new double[1][fitlist.size()];  
        for(int i =0;i<=fitlist.size()-1;i++){
        	colKeys[i] = String.valueOf(i+1);
        	data[0][i] = fitlist.get(i);
        }
        CategoryDataset dataset = DatasetUtilities.createCategoryDataset(rowKeys, colKeys, data);
        //创建时序图对象  
        JFreeChart jfreechart = ChartFactory.createLineChart("Line Chart Demo", // 标题     
                "Iteration", // categoryAxisLabel （category轴，横轴，X轴标签）     
                "FitnessValue", // valueAxisLabel（value轴，纵轴，Y轴的标签）     
                dataset, // dataset     
                PlotOrientation.VERTICAL, true, // legend     
                false, // tooltips     
                false); // URLs     
    
        // 使用CategoryPlot设置各种参数。以下设置可以省略。     
        CategoryPlot plot = (CategoryPlot) jfreechart.getPlot();      
        // 前景色 透明度     
        plot.setBackgroundAlpha(0.5f); 
        plot.setForegroundAlpha(0.5f);     
        XYPlot xyplot = jfreechart.getXYPlot();  
        //纵坐标设定  
        ValueAxis valueaxis = xyplot.getDomainAxis();  
        //自动设置数据轴数据范围  
        valueaxis.setAutoRange(false);  
        valueaxis.setRange(0, 1000);
  
        valueaxis = xyplot.getRangeAxis();  
        valueaxis.setRange(0.0D,200D);  
  
        return jfreechart;  
      }  

	/**
	 * Starts the example.
	 * 
	 * @param args
	 *            if optional first argument provided, it represents the number
	 *            of bits to use, but no more than 32
	 * 
	 * @author Neil Rotstan
	 * @author Klaus Meffert
	 * @throws IOException 
	 * @since 2.0
	 */
	public static void main(String[] args) throws IOException {

		SimpleExample se = new SimpleExample();	
		
		try {
			File[] result = {new File("ga_x.txt"), new File("ga_cos.txt"), 
					new File("ga_ackley.txt"),	new File("ga_quar.txt"), 
					new File("ga_step.txt"), new File("ga_rosen.txt"), 
					new File("ga_sch.txt"), new File("ga_gri.txt"),
					new File("ga_pen1.txt"), new File("ga_pen2.txt"),
			        new File("ga_wei.txt"), new File("ga_non.txt")};
			BufferedWriter[] output = new BufferedWriter[result.length];
			for(int i = 0; i<= result.length-1;i++){
				if (result[i].exists()) {
					result[i].delete();
					if (result[i].createNewFile()) {
						System.out.println("result"+i+" file create success!");
					} else {
						System.out.println("result"+i+" file create failed!");
					}
				} else {
					if (result[i].createNewFile()) {
						System.out.println("result"+i+" file create success!");
					} else {
						System.out.println("result"+i+" file create failed!");
					}

				}
				output[i] = new BufferedWriter(new FileWriter(result[i]));
			}
			JFrame frame=new JFrame("Test Chart");  
		    frame.getContentPane().add(se.createChart(),new BorderLayout().CENTER);  
		    frame.pack();  
		    frame.setVisible(true);  
			for(int a=0; a<=0;a++){
//				se.runga(100, 30, 40, -100,  100, new MaxFunction(), output[0]);
				se.runga(200, 30, 40, -100,  100, new MaxFunction(), output[0]);
//				se.runga(120, 30, 40, -5.12,  5.12, new CosMaxFunction(), output[1]);
//				se.runga(200, 30, 40, -5.12,  5.12, new CosMaxFunction(), output[1]);
//				se.runga(120, 30, 40, -32,  32, new AckleyMaxFunction(), output[2]);
//				se.runga(200, 30, 40, -32,  32, new AckleyMaxFunction(), output[2]);
//				se.runga(120, 30, 40, -100,  100, new QuardircMaxFunction(), output[3]);
//				se.runga(200, 30, 40, -100,  100, new QuardircMaxFunction(), output[3]);
//				se.runga(120, 30, 40, -100,  100, new StepMaxFunction(), output[4]);
//				se.runga(200, 30, 40, -100,  100, new StepMaxFunction(), output[4]);
//				se.runga(120, 30, 40, -30,  30, new RosenbrockMaxFunction(), output[5]);
//				se.runga(200, 30, 40, -30,  30, new RosenbrockMaxFunction(), output[5]);
//				se.runga(120, 30, 40, -500,  500, new SchwefelMaxFunction(), output[6]);
//				se.runga(200, 30, 40, -500,  500, new SchwefelMaxFunction(), output[6]);
//				se.runga(120, 30, 40, -600,  600, new GriewankMaxFunction(), output[7]);
//				se.runga(200, 30, 40, -600,  600, new GriewankMaxFunction(), output[7]);
//				se.runga(120, 30, 40, -50,  50, new PenalizedMaxFunction(), output[8]);
//				se.runga(200, 30, 40, -50,  50, new PenalizedMaxFunction(), output[8]);
//				se.runga(120, 30, 40, -50,  50, new Penalized2MaxFunction(), output[9]);
//				se.runga(200, 30, 40, -50,  50, new Penalized2MaxFunction(), output[9]);
//				se.runga(120, 30, 40, -5.12,  5.12, new WeiMaxFunction(), output[10]);
//				se.runga(200, 30, 40, -5.12,  5.12, new WeiMaxFunction(), output[10]);
//				se.runga(120, 30, 40, -0.5,  0.5, new NonMaxFunction(), output[11]);
//				se.runga(200, 30, 40, -0.5,  0.5, new NonMaxFunction(), output[11]);
				for(BufferedWriter op : output){
					op.write("\n");
					op.flush();
				}
			}
			
			for(BufferedWriter op : output){
				op.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
				
				
			
	}
}
