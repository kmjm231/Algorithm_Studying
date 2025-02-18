import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 줄에 입력되는 사람의 수 N
        int N = Integer.parseInt(br.readLine());
        int[] times = new int[N];
        
        // 두 번째 줄에 각 사람이 돈을 인출하는데 걸리는 시간 Pi
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(input[i]);
        }
        
        // 돈을 인출하는 시간을 오름차순으로 정렬
        Arrays.sort(times);
        
        int totalWaitTime = 0;
        int accumulatedTime = 0;
        
        // 대기 시간을 계산하면서 총 대기 시간을 합산
        for (int time : times) {
            accumulatedTime += time;
            totalWaitTime += accumulatedTime;
        }
        
        // 결과 출력
        System.out.println(totalWaitTime);
    }
}
