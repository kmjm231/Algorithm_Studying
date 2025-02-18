import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int L, P, V;
		int num = 1;
		
		while(true) {
		L = in.nextInt();
		P = in.nextInt();
	    V = in.nextInt();
	    
	    if (L == 0 && P == 0 && V == 0) {
	        break;
	    }
	    
	    int date = (V / P) * L + Math.min(V % P, L);
	    System.out.printf("Case %d: %d\n", num, date);
	    num++;
		}
		
	}
}