package experiments.kmeansga;

import java.util.ArrayList;
import java.util.List;

import org.jgap.*;

import org.encog.ml.MLCluster;
import org.encog.ml.data.MLDataPair;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLData;
import org.encog.ml.data.basic.BasicMLDataPair;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.ml.kmeans.KMeansClustering;
import org.encog.ml.kmeans.KMeansCluster;
import org.encog.ml.kmeans.Centroid;

public class KMeans {

	public static List<Integer> runKmeans(double[][] KmeansDataSet, double cluster_number, int max_gen, int c) {
//		int currentPopSize = a_pop.size();
//		// if  all  of the chromosomes contain constant genes?
//		int currentChromSize = a_pop.getChromosome(a_pop.size() - 1).size(); 
//		// Ensure all chromosomes are updated.
//		// -----------------------------------
//		double[][] KmeansDataSet = new double[currentPopSize][currentChromSize];
//		for (int i = 0; i < currentPopSize; i++) {
//			IChromosome chrom = a_pop.getChromosome(i);
//			for (int j = 0; j < currentChromSize; j++) {
//				KmeansDataSet[i][j] = (Double) chrom.getGene(j).getAllele();
//				/*
//				 * if((Boolean)chrom.getGene(j).getAllele()){
//				 * KmeansDataSet[i][j]=1.9; } else{ KmeansDataSet[i][j]=0.25; }
//				 */
//			}
//		}
		int currentPopSize = KmeansDataSet.length;
		final BasicMLDataSet set = new BasicMLDataSet();
		for (final double[] element : KmeansDataSet) {
			set.add(new BasicMLData(element));
		}

		int num =(int)(currentPopSize/cluster_number);
		KMeansClustering kmeans = new KMeansClustering(num, set);
		List<KMeansClustering> kcs = new ArrayList();
		List<Double> wcs = new ArrayList();
		for(int i = 0;i<=c-1;i++){
		     final KMeansClustering tempkmeans = new KMeansClustering(num, set);
		     tempkmeans.iteration(max_gen);
		     kcs.add(tempkmeans);
		     wcs.add(tempkmeans.getWCSS());
		}
		int index = 0;
		for(int i = 0;i<=c-1;i++){
			if(Math.abs(wcs.get(i))<Math.abs(wcs.get(index))){
				index = i;
			}
		}
		kmeans = kcs.get(index);
//		System.out.println("Final WCSS: " + kmeans.getWCSS());
		int[] centroidchrom = new int[kmeans.numClusters()];
		int[] chromorderflag = new int[kmeans.numClusters()];
		List<Integer> chromorder = new ArrayList();
		int[] chromflag = new int[currentPopSize];
		int[] clusterflag = new int[currentPopSize];
		 int[] cacflag=new int[currentPopSize];

		for (int k = 0; k < kmeans.getClusters().length; k++) {
			MLCluster cluster = (kmeans.getClusters())[k];
			KMeansCluster kmeanscluster = (KMeansCluster) cluster;
			Centroid centroid = kmeanscluster.getCentroid();
			int minorder = 0;
			double a = 0, MIN = Double.MAX_VALUE;
			for (int i = 0; i < cluster.size(); i++) {
				if ((a = KMeansClustering.calculateEuclideanDistance(centroid,
						cluster.get(i))) < MIN) {
					minorder = i;
					MIN = a;
					// System.out.print(MIN+"  ");
				}
			}
			centroidchrom[k] = minorder;
			/*
			 * System.out.println("  ");
			 * System.out.print(centroidchrom[k]+"  ");
			 * System.out.println("  "); System.out.println("  ");
			 */

		}

		for (int j = 0; j < currentPopSize; j++) {
			for (int k = 0; k < kmeans.getClusters().length; k++) {
				MLCluster cluster = (kmeans.getClusters())[k];
				KMeansCluster kmeanscluster = (KMeansCluster) cluster;
				Centroid centroid = kmeanscluster.getCentroid();
				for (int i = 0; i < cluster.size(); i++) {
					MLDataSet ds = cluster.createDataSet();
					MLDataPair pair = BasicMLDataPair.createPair(
							ds.getInputSize(), ds.getIdealSize());
					ds.getRecord(i, pair);
					double[] clusterdata = new double[pair.getInputArray().length];
					clusterdata = pair.getInputArray();
					boolean flag = true;
					for (int m = 0; m < clusterdata.length; m++) {
						if (clusterdata[m] != KmeansDataSet[j][m]) {
							flag = false;
							break;
						}
					}
					if(flag==true){
      				 
      				
      				
      				
      				  clusterflag[j]=k; 
      				  chromflag[j]=i;
      				 
      				  break;
      				 }
      			  }    	
				}
			}
		

		for (int i = 0; i < centroidchrom.length; i++) {
			for (int k = 0; k < clusterflag.length; k++) {
				if (i == clusterflag[k]) {
					if (centroidchrom[i] == chromflag[k]) {
						chromorderflag[i] = k;
					}
				}
			}
		}
		for (int i = 0; i < currentPopSize; i++) {
			chromorder.add(chromorderflag[clusterflag[i]]);
		}
		
		return chromorder;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
