import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2573 {
  private static int[] dx = {-1, 1, 0, 0};
  private static int[] dy = {0, 0, -1, 1};
  private static int N, M, res, cnt;
  private static int[][] map;
  private static boolean[][] visited;
  
  // private static class Node {
  //   int x, y;

  //   public Node(int x, int y) {
  //     this.x = x;
  //     this.y = y;
  //   }
  // }

  private static boolean isWall(int x, int y) {
    return (x < 0 || x >= N || y < 0 || y >= M);
  }

  private static void melt(int x, int y) {
    visited[x][y] = true;

    for (int i = 0; i < 4; i++) {
      int newX = x + dx[i];
      int newY = y + dy[i];

      if(isWall(newX, newY) || visited[newX][newY]) continue;

      if(map[newX][newY] == 0) {
        if(map[x][y] > 0) map[x][y]--;
      } else {
        melt(newX, newY);
      }
    }
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    res = 0;
    cnt = 0;
    
    while(true) {
      cnt = 0;
      
      visited = new boolean[N][M];

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if(map[i][j] > 0 && !visited[i][j]) {
            melt(i, j);
            cnt++;
          }
        }
      }

      if(cnt >= 2){
        System.out.println(res);
        break;
      } else if(cnt == 0) {
        System.out.println(0);
        break;
      }
      res++;
    }
  }
}
