/*
 * This file is part of JGAP.
 *
 * JGAP offers a dual license model containing the LGPL as well as the MPL.
 *
 * For licensing information please see the file license.txt included with JGAP
 * or have a look at the top of class org.jgap.Chromosome which representatively
 * includes the JGAP license policy applicable for any file delivered with JGAP.
 */
package cn.edu.jlu.ccst.example;

import org.jgap.*;
import org.jgap.impl.*;

/**
 * Fitness function for our example. See evaluate(...) method for details.
 *
 * @author Neil Rotstan
 * @author Klaus Meffert
 * @since 2.0
 */
public class MaxFunction
    extends FitnessFunction {
  /** String containing the CVS revision. Read out via reflection!*/
  private final static String CVS_REVISION = "$Revision: 1.6 $";
  
  private int[][] matrix;
  
  public MaxFunction(int[][] matrix) {
		super();
		this.matrix = matrix;
	} 

  public double evaluate(IChromosome a_subject) {
    double total = 0;
    int m = matrix.length;
	int n = matrix[0].length;
	
	for(int i = 0; i<=m-1;i++){
		int temp = 0;
		for(int j = 0; j<=n-1;j++){
			temp = temp + matrix[i][j]*((IntegerGene)a_subject.getGene(j)).intValue();
		}
		total += Math.pow(temp,2);
	}
    
//	total = Math.exp(-1*Math.abs(total));
	total = 1/(total*total+1);
    return total;
  }


}
