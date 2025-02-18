import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int price = in.nextInt();
		int change = 1000 - price;
		
		int coins = 0;
		int[] coinTypes = {500, 100, 50, 10, 5, 1};
		
		for (int i = 0; i < 6; i++) {
		    coins += change / coinTypes[i];
		    change %= coinTypes[i];
		}
		
		System.out.print(coins);
		
	}
}
