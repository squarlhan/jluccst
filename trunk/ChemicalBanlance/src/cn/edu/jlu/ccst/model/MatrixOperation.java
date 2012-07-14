package cn.edu.jlu.ccst.model;

import Jama.Matrix;

public class MatrixOperation {

	private double[][] matrix;
	private Matrix operation;
	
	
	public double[][] getMatrix() {
		return matrix;
	}


	public void setMatrix(double[][] matrix) {
		this.matrix = matrix;
	}


	public Matrix getOperation() {
		return operation;
	}


	public void setOperation(Matrix operation) {
		this.operation = operation;
	}

	
	

	public MatrixOperation(int[][] matrix) {
		super();
		int m = matrix.length;
    	int n = matrix[0].length;
    	this.matrix = new double[m][n];
    	for(int i= 0;i<=m-1;i++){
    		for(int j= 0;j<=n-1;j++){
    			this.matrix[i][j] = matrix[i][j];
    		}
    	}
    	this.operation = new Matrix(this.matrix);
	}
	
	public int rank(){
		return operation.rank();
	}
	
	public double[] solve(){
		int m = matrix.length;
    	int n = matrix[0].length;
		double[] rightarray = new double[m];
		for(int i = 0;i<=m-1;i++){
			rightarray[i] = -1*matrix[i][n-1];
		}
		double[][] leftarray = new double[m][n-1];
		for(int i= 0;i<=m-1;i++){
    		for(int j= 0;j<=n-2;j++){
    			leftarray[i][j] = matrix[i][j];
    		}
    	}
		Matrix right = new Matrix(rightarray,matrix.length);
		Matrix left = new Matrix(leftarray);
	    Matrix ans =  left.solve(right);
	    double[] ansarray = new double[n];
	    for(int j= 0;j<=n-2;j++){
	    	ansarray[j] = ans.get(j, 0);
		}
	    ansarray[n-1] = 1;
	    return ansarray;
	}


	public MatrixOperation() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Creating  Arrays Representing Equations
        double[][] lhsArray = {{3, 2, -1}, {2, -2, 4}, {-1, 0.5, -1}};
        double[] rhsArray = {1, -2, 0};
 
        //Creating Matrix Objects with arrays
        Matrix lhs = new Matrix(lhsArray);
        Matrix rhs = new Matrix(rhsArray, 3);
 
        //Calculate Solved Matrix
        Matrix ans = lhs.solve(rhs);
 
        //Printing Answers
        System.out.println("x = " + Math.round(ans.get(0, 0)));
        System.out.println("y = " + Math.round(ans.get(1, 0)));
        System.out.println("z = " + Math.round(ans.get(2, 0)));
	}

}
