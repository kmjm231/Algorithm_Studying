import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine().toUpperCase();  // 입력받은 단어를 모두 대문자로 변환

        int[] frequency = new int[26];  // 각 알파벳의 빈도를 저장할 배열

        // 각 알파벳의 빈도를 계산
        for (char ch : word.toCharArray()) {
            frequency[ch - 'A']++;
        }

        int maxFreq = 0;
        char mostFrequentChar = '?';
        boolean isTie = false;

        // 최빈 알파벳 찾기
        for (int i = 0; i < 26; i++) {
            if (frequency[i] > maxFreq) {
                maxFreq = frequency[i];
                mostFrequentChar = (char) (i + 'A');
                isTie = false;
            } else if (frequency[i] == maxFreq) {
                isTie = true;
            }
        }

        // 결과 출력
        if (isTie) {
            System.out.println("?");
        } else {
            System.out.println(mostFrequentChar);
        }
    }
}
