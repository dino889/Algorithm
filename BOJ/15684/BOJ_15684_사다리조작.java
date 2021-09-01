import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_15684_사다리조작 {
  public static int N, M, H;  // 세로선 개수, 가로선 개수, 세로선마다 가로선을 놓을 수 있는 위치의 개수 
  public static int[][] ladder;
  public static int result;

  public static boolean check() { // 조건에 맞는지 확인 -> i로 시작해서 i로 끝나는지

    for (int i = 1; i <= N; i++) {
      int pos = i;
      for (int j = 1; j <= H; j++) {  // 세로로 내려가면서 
        if(ladder[j][pos] == 1) // 선이 있으면
          pos++;  // 오른쪽으로 이동
        else if(ladder[j][pos - 1] == 1) // 현재 위치 왼쪽에 선이 있으면
          pos--;  // 왼쪽으로 이동
      }
      if(pos != i){
        return false;
      }
    }
    return true;
  }

  public static void dfs(int cnt, int y, int x){
    if(cnt >= result) return ;  // cnt가 이미 내가 찾은 결과보다 크거나 같으면
                                // 최적의 값을 찾아야 하기 떄문에 더이상 체크 필요 X

    if(check()){  // 새로 그려진 사다리가 조건에 맞는지 체크
      result = cnt;
      return;
    }
    
    if(cnt == 3) return ;
    
    for (int i = y; i <= H; i++) {
      for (int j = x; j < N; j++) { // j + 1을 하기 때문에 범위는 마지막 인덱스 전까지
        if(ladder[i][j] == 0 && ladder[i][j - 1] == 0 && ladder[i][j + 1] == 0){  // 현재 위치와 양 옆에 선이 없으면
          ladder[i][j] = 1; // 길 표시
          dfs(cnt + 1, i, j);
          ladder[i][j] = 0;
        }
      }
      x = 1;  // 선은 1부터 긋기 때문에 1로 초기화
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());
    ladder = new int[H + 1][N + 1]; // 배열 인덱스 1부터 쓸거라서 +1

    if(M == 0) System.out.println(0);
    else{
      for (int m = 0; m < M; m++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        ladder[a][b] = 1; // 사다리 선 있는 부분 1로 표시
      }

      result = 4; 
      dfs(0, 1, 1); // cnt, y, x -> 세로로 탐색
      if(result == 4){
        result = -1; // result 결과가 변하지 않으면 -1 반환
      }
      System.out.println(result);
    }
  }
}
// 5 5 6
// 1 1
// 3 2
// 2 3
// 5 1
// 5 4

// 5 6 6
// 1 1
// 3 1
// 5 2
// 4 3
// 2 3
// 1 4