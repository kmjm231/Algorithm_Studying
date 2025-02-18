import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 9명의 난쟁이 키를 입력 받기
        int[] heights = new int[9];
        for (int i = 0; i < 9; i++) {
            heights[i] = scanner.nextInt();
        }

        // 난쟁이들의 키 합 계산
        int totalSum = 0;
        for (int height : heights) {
            totalSum += height;
        }

        // 2명의 난쟁이를 찾아서 제외하기
        boolean found = false;
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (totalSum - heights[i] - heights[j] == 100) {
                    heights[i] = -1; // 이 난쟁이를 제외함
                    heights[j] = -1; // 이 난쟁이를 제외함
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        // 결과를 오름차순으로 출력
        Arrays.sort(heights);
        for (int i = 2; i < 9; i++) { // -1로 제외한 값들을 제외하고 출력
            System.out.println(heights[i]);
        }

        scanner.close();
    }
}
