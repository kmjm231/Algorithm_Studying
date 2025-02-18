import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int H = in.nextInt();
		int M = in.nextInt();
		
		if (M >= 45 && M <= 59) {
		    System.out.println(H + " " + (M-45));
		}
		else if (M >= 0 && M < 45) {
		    if(H == 0) {
		        System.out.println("23" + " " + (15+M));
		    }
		    else {
		        System.out.println((H-1) + " " + (15+M));
		    }
		}
	}
}
