import java.util.Scanner;
import java.util.Arrays;

public class Main
{
	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    int n = in.nextInt();
	    
	    for (int i = 0; i < n; i++) { //입력받은 n번 만큼 테스트 반복
	        int[] scores = new int[5]; //점수 입력받을 배열 생성
	        
	        for (int j = 0; j < scores.length; j++) //5개 숫자 입력받기
	            scores[j] = in.nextInt();
	       
	        int sum = 0;
	        
	        Arrays.sort(scores); //크기순으로 정렬
	       
	        if (scores[3] - scores[1] < 4) //총점 계산
	        {
	            for (int j = 0; j < scores.length; j++) {
	                sum += scores[j];
	            }
	            sum -= (scores[0] + scores[4]);
	            System.out.println(sum);
	        }
	        else //점수 조정
	        {
	            System.out.println("KIN");
	        }
	    }
	}
}
