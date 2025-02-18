import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄에 입력되는 수의 개수 N
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        int sum = 0;

        // N개의 정수를 입력 받습니다.
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            sum += numbers[i];
        }

        // 1. 산술평균 계산 (소수점 첫째 자리에서 반올림)
        double mean = (double) sum / N;
        System.out.println(Math.round(mean));

        // 2. 중앙값 계산
        Arrays.sort(numbers);
        int median = numbers[N / 2];
        System.out.println(median);

        // 3. 최빈값 계산
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int number : numbers) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }

        int maxFrequency = 0;
        for (int frequency : frequencyMap.values()) {
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }

        ArrayList<Integer> modeList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                modeList.add(entry.getKey());
            }
        }

        Collections.sort(modeList);

        // 최빈값 중 두 번째로 작은 값을 출력해야 함
        int mode = (modeList.size() > 1) ? modeList.get(1) : modeList.get(0);
        System.out.println(mode);

        // 4. 범위 계산
        int range = numbers[N - 1] - numbers[0];
        System.out.println(range);
    }
}
