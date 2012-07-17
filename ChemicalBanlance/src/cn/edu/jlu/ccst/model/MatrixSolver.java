package cn.edu.jlu.ccst.model;

public class MatrixSolver {

	private Fraction[][] matrix;
	private int m;
	private int n;
	private Fraction[][] solvedmatrix;
	private int rank;

	
	
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public Fraction[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(Fraction[][] matrix) {
		this.matrix = matrix;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public Fraction[][] getSolvedmatrix() {
		return solvedmatrix;
	}

	public void setSolvedmatrix(Fraction[][] solvedmatrix) {
		this.solvedmatrix = solvedmatrix;
	}

	public MatrixSolver(int[][] matrix) {
		super();
		this.m = matrix.length;
		this.n = matrix[0].length;
		this.matrix = new Fraction[m][n];
		this.solvedmatrix = new Fraction[m][n];
		for (int i = 0; i <= m - 1; i++) {
			for (int j = 0; j <= n - 1; j++) {
				this.matrix[i][j] = new Fraction(matrix[i][j], 1);
				this.solvedmatrix[i][j] = new Fraction(matrix[i][j], 1);
			}
		}
		tansform();
	}

	private void changerow(int a, int b) {	
		Fraction temp = new Fraction();
		for(int j = 0;j<=n-1;j++){
//			temp.setDenominator(solvedmatrix[a][j].getDenominator());
//			temp.setNumerator(solvedmatrix[a][j].getNumerator());
//			
//			solvedmatrix[a][j].setDenominator(solvedmatrix[b][j].getDenominator());
//			solvedmatrix[a][j].setNumerator(solvedmatrix[b][j].getNumerator());
//			
//			solvedmatrix[b][j].setDenominator(temp.getDenominator());
//			solvedmatrix[b][j].setNumerator(temp.getNumerator());
			
			temp = solvedmatrix[a][j];
			solvedmatrix[a][j] = solvedmatrix[b][j];
			solvedmatrix[b][j] = temp;
		}
	}
	
	private void multrow(Fraction f, int a){
		for(int j = 0;j<=n-1;j++){			
			solvedmatrix[a][j] = solvedmatrix[a][j].multiply(f);
		}
	}

	private void multaddrow(Fraction f, int a, int b){
		for(int j = 0;j<=n-1;j++){			
			solvedmatrix[b][j] = solvedmatrix[b][j].add(solvedmatrix[a][j].multiply(f));
		}
	}
	
	private boolean valizero(int a){
		boolean flag = true;
		
		for (int j = 0; j <= n - 1; j++) {
			if(this.solvedmatrix[a][j].getNumerator() != 0)return false;
		}
		
		return flag;
	}
	
	private boolean validate(){
		boolean flag = true;
		int index = m-1;
		while(index>=0&&valizero(index)){
			index--;
		}
		for (int i = 0; i <= index ; i++) {
			for (int j = 0; j <= index ; j++) {
				if(i == j){
					if(this.solvedmatrix[i][j].getNumerator() != 1)return false;
				}else{
					if(this.solvedmatrix[i][j].getNumerator() != 0)return false;
				}
			}
		}
		this.rank = index+1;
		return flag;
	}
	
	private void tansform() {
		
		Fraction one = new Fraction(1,1);
		Fraction mone = new Fraction(-1,1);
		for(int i = 0;i<=m-1;i++){
			if(validate())return;
			rank = i+1;
			if(solvedmatrix[i][i].getNumerator()==0){
				for(int ii = i+1;ii<=m-1;ii++){
					if(solvedmatrix[ii][i].getNumerator()!=0){
						changerow(ii, i);
						break;
					}
				}
			}
			multrow(one.divide(solvedmatrix[i][i]),i);
			for(int ii = 0;ii<=m-1;ii++){
				if(solvedmatrix[ii][i].getNumerator()!=0&&ii!=i){
					 multaddrow(mone.multiply(solvedmatrix[ii][i]), i, ii);
				}
			}
		}
		
		System.out.println("tttttttttttttttttttttttttttttt");
		for (int i = 0; i <= m - 1; i++) {
			for (int j = 0; j <= n - 1; j++) {
				System.out.print(solvedmatrix[i][j]+"\t");
			}
			System.out.println();
		}
		
		System.out.println("tttttttttttttttttttttttttttttt");

	}
	
	private int getGB(Fraction[] fs){
		int gb= 1;
		for(int j=0;j<=n-1;j++){
			gb = Fraction.gB(gb, fs[j].getDenominator());
		}		
		return Math.abs(gb);
	}

	public int[][] solve(){
		int[][] results = new int[n-rank][n];
		Fraction[][] fresults = new Fraction[n-rank][n];
		Fraction zero = new Fraction(0,1);
		Fraction one = new Fraction(1,1);
		Fraction mone = new Fraction(-1,1);
		for(int j = rank;j<=n-1;j++){
			for(int i = 0;i<=rank-1;i++){
				fresults[j-rank][i] = mone.multiply(solvedmatrix[i][j]);
			}
		}
		for(int i = 0;i<=fresults.length-1;i++){
			for(int j = rank; j<=n-1;j++){
				if(j-i==rank){
					fresults[i][j] = one;
				}else{
					fresults[i][j] = zero;
				}
			}
		}
		System.out.println("*****************************");
		for (int i = 0; i <= fresults.length - 1; i++) {
			for (int j = 0; j <= n - 1; j++) {
				System.out.print(fresults[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("*****************************");
		
		for (int i = 0; i <= fresults.length - 1; i++) {
			int gb = getGB(fresults[i]);
			for (int j = 0; j <= n - 1; j++) {
				results[i][j] = fresults[i][j].getNumerator()*(gb/fresults[i][j].getDenominator());
				System.out.print(results[i][j]+"\t");
			}
			System.out.println();
		}
		
		return results;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] m = {{1, 0, -3, 0},{0, 1, -4, 0},{0, 2, 0, -2}};
		int[][] m = {{1, 2, 3, 4},{-2, 3, 1, 2},{-1, 5, 4, 6}};
		MatrixSolver ms = new MatrixSolver(m);
		
		
		ms.solve();

	}

}
