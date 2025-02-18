import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력받기
        int E = scanner.nextInt();
        int S = scanner.nextInt();
        int M = scanner.nextInt();

        // 초기 연도 설정
        int year = 1;

        // 완전탐색을 통해 조건을 만족하는 해를 찾기
        while (true) {
            // E, S, M 값이 주어진 값과 같으면 종료
            if ((year - 1) % 15 + 1 == E &&
                (year - 1) % 28 + 1 == S &&
                (year - 1) % 19 + 1 == M) {
                break;
            }
            year++;
        }

        // 결과 출력
        System.out.println(year);
        
        scanner.close();
    }
}
