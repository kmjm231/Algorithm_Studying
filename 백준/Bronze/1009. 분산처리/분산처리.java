import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        // 첫 번째 입력
        int T = in.nextInt();
        
        // 반복문 실행
        while (T > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            
            // modular_one 메서드를 호출해서 결과 출력
            System.out.println(modular_one(a, b));
            
            // num이 0 이하일 경우 루프 종료
            T--;
        }
        
        in.close(); // Scanner 객체 닫기
    }
    
    // modular_one 메서드 정의
    public static int modular_one(int a, int b) {
        // 만약 a가 10의 배수라면, 일의 자리는 무조건 0
        if (a % 10 == 0) {
            return 10;
        }
        
        int result = 1;
        a %= 10;  // a의 일의 자리만 사용
        
        // 거듭제곱의 일의 자리를 구하는 반복문
        while (b > 0) {
            result = (result * a) % 10;  // 결과를 10으로 나눈 나머지
            b--;  // b를 감소
        }
        
        return result;
    }
}
