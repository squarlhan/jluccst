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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
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
	boolean flag = true;
	boolean flag2 = true;
	JFrame frame;
	
	public void runga(int ng, int chromeSize, int popsize, double left, double right, FitnessFunction fitnessfun, BufferedWriter output){
		long startTime = System.currentTimeMillis();
		int numEvolutions = ng;
		Configuration gaConf = new DefaultConfiguration();
		gaConf.reset();
		gaConf.setPreservFittestIndividual(true);
		gaConf.setKeepPopulationSizeConstant(false);
		gaConf.getGeneticOperators().clear();
		try {
			gaConf.addGeneticOperator(new MutationOperator(gaConf, new KeyboardMutationRateCalc(gaConf, 0.01, 0.1, 0.05, chromeSize)));
			gaConf.addGeneticOperator(new CrossoverOperator(gaConf, new KeyboardCrossoverRateCalc(gaConf, 0.7, 0.99, 0.8, chromeSize)));
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
//		JOptionPane.showMessageDialog(frame.getContentPane(),
//      	       "暂停ing!", "系统信息", JOptionPane.INFORMATION_MESSAGE);
		
		JFreeChart jfc = createChart();
		frame=new JFrame("Test Chart");  
	    frame.getContentPane().add(new ChartPanel(jfc),new BorderLayout().CENTER);  
	    frame.addKeyListener(new KeyAdapter()  {

            @Override
            public void keyReleased(KeyEvent e) {
                int ch = e.getKeyCode();
                switch(ch){
                case KeyEvent.VK_ENTER : flag = false; break;
                case KeyEvent.VK_SPACE : flag2 = !flag2;break;
                case 37: Older.downc();break;
                case 38: Older.downm();break;
                case 39: Older.upc();break;
                case 40: Older.upm();break;
                default: break;
                }
            }
            
        });
	    frame.pack();  
	    frame.setVisible(true); 
		int progress = 0;
		int percentEvolution = numEvolutions / 10;
		
		int i = 0;
		while(flag){
//		for (int i = 0; i < numEvolutions; i++) {
			if (flag2) {
				genotype.evolve();
				IChromosome fittest = genotype.getFittestChromosome();
				double fitness = fittest.getFitnessValue();
				fitlist.add(fitness);
				jfc = createChart();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new ChartPanel(jfc),
						new BorderLayout().CENTER);
				frame.pack();
				frame.setVisible(true);
				System.out.println("mutation: " + Older.old_mutation);
				System.out.println("crossover: " + Older.old_crossover);
				// Print progress.
				// ---------------
				if (percentEvolution > 0 && i % percentEvolution == 0) {
					progress++;
					System.out
							.println("Currently fittest Chromosome has fitness "
									+ fitness);
				}
			}
			i++;
//			if(i>15000)break;
		}
		// Print summary.
		// --------------
		IChromosome fittest = genotype.getFittestChromosome();
		System.out.println("Fittest Chromosome has fitness "
				+ (fittest.getFitnessValue()));
		try {
			output.write(fittest.getFitnessValue() + "\t");

			DecimalFormat myformat = new DecimalFormat("#0.00");
			for (int ii = 0; ii < chromeSize; ii++) {

				// System.out.println(myformat.format(((DoubleGene)fittest.getGene(i)).doubleValue()));
				System.out.print(myformat
						.format(fittest.getGene(ii).getAllele()) + "	");
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
    	XYSeries xyseries = new XYSeries("Fitness Line");
    	xyseries.add(0.0D, 0.0D); 
        for(int i =1;i<=fitlist.size();i++){
        	xyseries.add(i, fitlist.get(i-1)); 
        }
        XYSeriesCollection xyseriescollection = new XYSeriesCollection(); //再用XYSeriesCollection添加入XYSeries 对象 
        xyseriescollection.addSeries(xyseries);
        //创建时序图对象  
        JFreeChart jfreechart = ChartFactory.createXYLineChart("Line Chart Demo", // 标题     
                "Iteration", // categoryAxisLabel （category轴，横轴，X轴标签）     
                "FitnessValue", // valueAxisLabel（value轴，纵轴，Y轴的标签）     
                xyseriescollection, // dataset     
                PlotOrientation.VERTICAL, true, // legend     
                false, // tooltips     
                false); // URLs     
    
        // 使用CategoryPlot设置各种参数。以下设置可以省略。     
        XYPlot plot = jfreechart.getXYPlot();      
        // 前景色 透明度     
        plot.setBackgroundAlpha(0.5f); 
        plot.setForegroundAlpha(0.5f);     
//        XYPlot xyplot = jfreechart.getXYPlot();  
        //纵坐标设定  
        ValueAxis xx = plot.getDomainAxis();  
        //自动设置数据轴数据范围  
        xx.setAutoRange(true);
//        xx.setRange(0.0, 2000);
  
        ValueAxis yy = plot.getRangeAxis();  
        yy.setRange(600.0,1000);  
  
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
			 
			for(int a=0; a<=0;a++){
//				se.runga(100, 30, 40, -100,  100, new MaxFunction(), output[0]);
//				se.runga(200, 30, 40, -100,  100, new MaxFunction(), output[0]);
//				se.runga(120, 30, 40, -5.12,  5.12, new CosMaxFunction(), output[1]);
//				se.runga(200, 30, 40, -5.12,  5.12, new CosMaxFunction(), output[1]);
//				se.runga(120, 30, 40, -32,  32, new AckleyMaxFunction(), output[2]);
				se.runga(2000, 30, 40, -32,  32, new AckleyMaxFunction(), output[2]);
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
