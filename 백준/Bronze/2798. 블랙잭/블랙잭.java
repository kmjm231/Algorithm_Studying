import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 카드 개수 N과 목표 합 M을 입력 받음
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] cards = new int[N];

        // 카드에 쓰여 있는 숫자를 입력 받음
        for (int i = 0; i < N; i++) {
            cards[i] = scanner.nextInt();
        }

        int closestSum = 0;

        // 세 장의 카드를 고르는 모든 조합을 탐색
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < N - 1; j++) {
                for (int k = 0; k < N; k++) {
                    // 세 장의 카드가 서로 다를 때만 고려
                    if (i != j && j != k && i != k) {
                        int sum = cards[i] + cards[j] + cards[k];
                        // M을 넘지 않으면서 가장 M에 가까운 합을 찾음
                        if (sum <= M && sum > closestSum) {
                            closestSum = sum;
                        }
                    }
                }
            }
        }

        // 결과 출력
        System.out.println(closestSum);

        scanner.close();
    }
}
