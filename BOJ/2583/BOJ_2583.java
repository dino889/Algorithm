import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class BOJ_2583 {
  public static int[] dx = {-1, 1, 0, 0};
  public static int[] dy = {0, 0, -1, 1};

  public static int M, N, K, cnt;
  public static int[][] map;
  public static boolean[][] visited;
  public static int[] c;
  public static List<Integer> list;

  public static void dfs(int x, int y) {
    visited[x][y] = true;  // 방문 체크
    cnt++;
    for (int i= 0; i < 4; i++) {
      int newX = x + dx[i];
      int newY = y + dy[i];
      if(newX < 0 || newX >= M || newY < 0 || newY >= N)
        continue;
      if(map[newX][newY] == 0 && visited[newX][newY] == false){
        dfs(newX, newY);
      }
    }

  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    map = new int[M][N];
    visited = new boolean[M][N];
    list = new ArrayList<>();
    c = new int[M * N];
    for(int k = 0; k < K; k++){
      st = new StringTokenizer(br.readLine());
      
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      for (int i = y1; i < y2; i++) {
        for (int j = x1; j < x2; j++) {
          map[i][j] = 1;
        }
      }
    }

    cnt = 0;
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if(map[i][j] == 0 && visited[i][j] == false){
          dfs(i, j);
          list.add(cnt);
          cnt = 0;
        }
      }
    }
    Collections.sort(list);
    System.out.println(list.size());
    for (int num : list) {
      System.out.print(num + " ");
    }
  }
}
