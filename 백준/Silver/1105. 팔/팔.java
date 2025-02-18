import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    String L, R; 
	    L = in.next();
	    R = in.next();
	    
	    int count = 0;
	    
	    if(L.length() == R.length()) {
	        for(int i = 0; i < L.length(); i++) {
	            if(L.charAt(i) != R.charAt(i)) {
	                break;
	            }
	            else {
	                if(L.charAt(i) == '8') {
	                    count++;
	                }
	            }
	        }
	    }
	    System.out.println(count);
	}
}