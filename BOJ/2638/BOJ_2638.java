import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  @title 치즈
 *  @date 211013
 *  @author Jiwoo Choi
 */

public class BOJ_2638 {
  private static int N, M;
  private static int[][] map;
  private static boolean[][] visited;
  private static int[] dx = {-1, 1, 0, 0};
  private static int[] dy = {0, 0, -1, 1};

  private static boolean isWall(int x, int y){
    // if(x < 0 || x >= N || y < 0 || y >= M){
    //   return true;
    // } else return false;
    if(x >= 0 && x < N && y >= 0 && y < M){
      return true;
    } else return false;
  }

  private static void dfs(int x, int y){
    visited[x][y] = true;

    for (int i = 0; i < 4; i++) {
      int newX = x + dx[i];
      int newY = y + dy[i];

      if(!visited[newX][newY] && isWall(newX, newY)){
        if(map[newX][newY] > 0){
          map[newX][newY]++;
        } else {
          visited[newX][newY] = true;
          dfs(newX, newY);
        }
      }
      // if(newX < 0 || newX >= N || newY < 0 || newY >= M || visited[newX][newY]) continue;
      
      // if(map[newX][newY] > 0){
      //   map[newX][newY]++;
      // } else {
      //   visited[newX][newY] = true;
      //   dfs(newX, newY);
      // }
    }
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    
    map = new int[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

  
    
    int res = -1, cnt = -1;
    while(cnt != 0){
      for(boolean[] b : visited) Arrays.fill(b, false);
      dfs(0, 0);

      cnt = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if(map[i][j] > 0){
            cnt++;
          }
          map[i][j] = map[i][j] >= 3 ? 0 : (map[i][j] >= 1 ? 1 : 0);
        }
      }
      res++;
    }
    System.out.println(res);
  }
}
