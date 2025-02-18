import java.util.Scanner;

public class Main {
    static long[] tree; // 세그먼트 트리 배열
    static long[] num;  // 원본 배열

    // 세그먼트 트리 구축
    public static void buildTree(int node, int start, int end) {
        if (start == end) {
            tree[node] = num[start]; // 리프 노드는 원본 배열의 값
        } else {
            int mid = (start + end) / 2;
            buildTree(2 * node, start, mid);
            buildTree(2 * node + 1, mid + 1, end);
            tree[node] = tree[2 * node] + tree[2 * node + 1]; // 부모 노드는 자식 노드들의 합
        }
    }

    // 구간 합 계산
    public static long query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return 0; // 구간 밖이면 0을 반환
        }
        if (l <= start && end <= r) {
            return tree[node]; // 구간 내에 완전히 포함되면 그 값을 반환
        }
        int mid = (start + end) / 2;
        long leftSum = query(2 * node, start, mid, l, r);
        long rightSum = query(2 * node + 1, mid + 1, end, l, r);
        return leftSum + rightSum; // 왼쪽과 오른쪽 구간 합을 합산
    }

    // 원본 배열 업데이트
    public static void update(int node, int start, int end, int idx, long val) {
        if (start == end) {
            num[idx] = val; // 해당 인덱스 값 변경
            tree[node] = val; // 트리에서 해당 값 업데이트
        } else {
            int mid = (start + end) / 2;
            if (start <= idx && idx <= mid) {
                update(2 * node, start, mid, idx, val); // 왼쪽 자식
            } else {
                update(2 * node + 1, mid + 1, end, idx, val); // 오른쪽 자식
            }
            tree[node] = tree[2 * node] + tree[2 * node + 1]; // 부모 노드는 자식 노드들의 합
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long N = in.nextLong();
        long M = in.nextLong();
        long K = in.nextLong();
        
        num = new long[(int) N];
        tree = new long[4 * (int) N]; // 트리 크기는 4배로 설정

        // 원본 배열 입력받기
        for (int i = 0; i < N; i++) {
            num[i] = in.nextLong();
        }

        // 세그먼트 트리 구축
        buildTree(1, 0, (int) N - 1);

        // 쿼리 처리
        for (long i = 0; i < M + K; i++) {
            long a = in.nextLong();
            long b = in.nextLong();
            long c = in.nextLong();
            
            if (a == 1) { // 수 변경
                // 1: b번 수를 c로 변경 (0-based index)
                update(1, 0, (int) N - 1, (int) b - 1, c);
            } else if (a == 2) { // 구간 합
                // 2: b번부터 c번까지의 합
                System.out.println(query(1, 0, (int) N - 1, (int) b - 1, (int) c - 1));
            }
        }
    }
}
