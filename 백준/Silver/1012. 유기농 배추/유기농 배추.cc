#include <iostream>
using namespace std;

// 재귀 DFS 함수 정의
void dfs(int x, int y, int M, int N, int** matrix) {
    // 범위 밖이면 return
    if (x < 0 || y < 0 || x >= M || y >= N) return;

    // 배추가 아니거나 이미 방문했으면 return
    if (matrix[y][x] == 0) return;

    // 현재 위치 방문 처리 (0으로 변경)
    matrix[y][x] = 0;

    // 상하좌우로 재귀 호출
    dfs(x + 1, y, M, N, matrix);
    dfs(x - 1, y, M, N, matrix);
    dfs(x, y + 1, M, N, matrix);
    dfs(x, y - 1, M, N, matrix);
}

int main() {
    int testNum; // 테스트 케이스 수
    cin >> testNum;

    while (testNum--) {
        int M, N, K; // 가로, 세로, 배추 수
        cin >> M >> N >> K;

        // 2차원 배열 동적 할당
        int** matrix = new int*[N];
        for (int i = 0; i < N; i++) {
            matrix[i] = new int[M](); // 초기값 0으로 채움
        }

        // 배추 위치 입력
        for (int i = 0; i < K; i++) {
            int x, y;
            cin >> x >> y;
            matrix[y][x] = 1; // 주의: [y][x] 순서
        }

        // DFS를 통해 지렁이 수(= 연결된 배추 묶음 수) 세기
        int wormCount = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (matrix[y][x] == 1) {
                    dfs(x, y, M, N, matrix);
                    wormCount++; // 새로운 그룹 발견
                }
            }
        }

        cout << wormCount << endl;

        // 동적 메모리 해제
        for (int i = 0; i < N; i++) {
            delete[] matrix[i];
        }
        delete[] matrix;
    }

    return 0;
}
