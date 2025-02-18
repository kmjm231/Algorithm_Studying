import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();  // 개행 문자 소비

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String p = sc.nextLine();
            int n = sc.nextInt();
            sc.nextLine();  // 개행 문자 소비

            String arrayStr = sc.nextLine();
            Deque<Integer> deque = new ArrayDeque<>();

            // 배열의 내용을 파싱하여 덱에 추가
            if (n > 0) {
                String[] numbers = arrayStr.substring(1, arrayStr.length() - 1).split(",");
                for (String num : numbers) {
                    deque.add(Integer.parseInt(num.trim()));
                }
            }

            boolean isReversed = false;
            boolean error = false;

            for (char command : p.toCharArray()) {
                if (command == 'R') { //함수 R일때
                    isReversed = !isReversed;
                } else if (command == 'D') { //함수 D일때
                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (isReversed) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }

            if (error) {
                sb.append("error\n");
            } else {
                sb.append("[");
                while (!deque.isEmpty()) {
                    if (isReversed) {
                        sb.append(deque.removeLast());
                    } else {
                        sb.append(deque.removeFirst());
                    }
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]\n");
            }
        }

        // 결과 출력
        System.out.print(sb.toString());
    }
}
