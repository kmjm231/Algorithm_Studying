import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		int[] coinTypes = new int[N];
		int coins = 0;
		
		for (int i = 0; i < N; i++) {
		    coinTypes[i] = in.nextInt();
		}
		
		for (int i = N-1; i >= 0; i--) {
		    coins += K / coinTypes[i];
		    K %= coinTypes[i];
		}
		
		System.out.print(coins);
	}
}