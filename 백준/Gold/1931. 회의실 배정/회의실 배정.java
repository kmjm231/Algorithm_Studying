import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Main
{
	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    int N = in.nextInt();
	    
	    int[][] time = new int[N][2];
	    
	    for(int i = 0; i < N; i++) {
	        time[i][0] = in.nextInt();
	        time[i][1] = in.nextInt();
	    }
 
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if(a[1] == b[1]) {
					return a[0] - b[0];
				}
				return a[1] - b[1];
			}
		});
		
		int count = 0;
		int prevEndtime = 0;
		
		for(int i = 0; i < N; i++) {
			if(prevEndtime <= time[i][0]) {
				prevEndtime = time[i][1];
				count++;
			}
		}
		System.out.println(count);
	}
}