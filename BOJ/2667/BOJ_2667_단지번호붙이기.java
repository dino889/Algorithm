
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2667 {
  public static int[] dx = {-1, 1, 0, 0};  // 상 하 좌 우
  public static int[] dy = {0, 0, -1, 1};

  public static int N;
  public static int[][] map;
  public static boolean[][] visit;
  public static int cnt;

  public static boolean isWall(int x, int y){
    if(x < 0 || x >= N || y < 0 || y >= N)  return true;
    else return false;
  }

  public static void dfs(int x, int y) {
    
    visit[x][y] = true; // 방문처리 하고
    map[x][y] = cnt;
    for (int i = 0; i < 4; i++) {
      int newX = x + dx[i];
      int newY = y + dy[i];
    
      if(!isWall(newX, newY)){
        if(map[newX][newY] == 1 && visit[newX][newY] == false) {
          // map[i][j] = count;
          dfs(newX, newY);
        }
      }
    }
  }


  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();


    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    visit = new boolean[N][N];
    String[] str;
    for (int i = 0; i < N; i++) {
      str = br.readLine().split("");
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(str[j]);
      }
    }

    cnt = 1;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if(map[i][j] == 1){
          cnt++;  // 이미 들어가 있는 수인 1과 중복되지 않기 위해 단지 번호를 2부터 시작
          dfs(i, j);
        }
      }
    }

    // for (int i = 0; i < N; i++) {
    //   for (int j = 0; j < N; j++) {
    //     System.out.print(map[i][j] + "\t"); // 2 3 4
    //   }
    //   System.out.println();
    // }

    // System.out.println(cnt);
    int[] home = new int[cnt];  // cnt == 4 01

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        int index = map[i][j];
        if(index != 0){
          index -= 1;
          home[index]++;  // 단지 수 카운트
        }
      }
    }
    Arrays.sort(home);
    System.out.println(--cnt);
    for(int i = 1; i < home.length; i++){
      System.out.println(home[i]);
    }

  }
}