package experiments;

public class Older {
	
	public static int old_crossover = 0;
	public static int old_mutation = 0;
	
	public static int cmin;
	public static int cmax;
	public static int mmin;
	public static int mmax;
	
	public static void upc(){
		old_crossover++;
		if(old_crossover>cmax)old_crossover = cmax;
	}
	public static void downc(){
		old_crossover--;
		if(old_crossover<cmin)old_crossover = cmin;
	}
	public static void upm(){
		old_mutation++;
		if(old_mutation>mmax)old_mutation = mmax;
	}
	public static void downm(){
		old_mutation--;
		if(old_mutation<mmin)old_mutation = mmin;
	}
	

}
