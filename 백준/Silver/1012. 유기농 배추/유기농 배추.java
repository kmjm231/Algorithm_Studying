import java.util.Scanner;

public class Main {
    static int M, N, K;
    static int[][] field;
    static boolean[][] visited;

    // 방향 배열 (상, 하, 좌, 우)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // DFS 함수
    public static void dfs(int x, int y) {
        visited[x][y] = true;  // 현재 배추를 방문 처리
        
        // 4방향으로 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            // 범위를 벗어나지 않고, 배추가 있으며, 아직 방문하지 않았다면
            if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny] && field[nx][ny] == 1) {
                dfs(nx, ny);  // 해당 배추로 이동하여 DFS 수행
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int T = in.nextInt();  // 테스트 케이스 개수
        
        while (T-- > 0) {
            M = in.nextInt();  // 배추밭의 가로 크기
            N = in.nextInt();  // 배추밭의 세로 크기
            K = in.nextInt();  // 배추의 개수

            // 배추밭 초기화
            field = new int[M][N];
            visited = new boolean[M][N];

            // 배추 위치 입력
            for (int i = 0; i < K; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                field[x][y] = 1;  // 해당 위치에 배추가 있음
            }

            int wormCount = 0;  // 필요한 배추흰지렁이의 수

            // 배추밭을 탐색하여 각 군집을 DFS로 찾음
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    // 배추가 있고, 아직 방문하지 않았다면 DFS 수행
                    if (field[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);  // 새로운 군집 발견
                        wormCount++;  // 배추흰지렁이 하나 배치
                    }
                }
            }

            System.out.println(wormCount);  // 결과 출력
        }
        
        in.close();
    }
}
