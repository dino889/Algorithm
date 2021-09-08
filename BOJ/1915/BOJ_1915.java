
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1915 {
  // public static int[] dx = {-1, 1, 0 ,0,};
  // public static int[] dy = {0, 0, -1, 1};
  public static int N, M, result;
  public static int[][] map;
  public static int[][] dp;


  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb  = new StringBuilder();
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    dp = new int[N][M];
    result = 0;

    String str;
    for (int i = 0; i < N; i++) {
      str = br.readLine();
      // char[] line = br.readLine().toCharArray();
      for (int j = 0; j < M; j++) {
        map[i][j] = str.charAt(j) - '0';
        if(map[i][j] == 1){
          dp[i][j] = 1;
          result = 1;
        }
      }
    }

    for (int i = 1; i < N; i++) {
      for (int j = 1; j < M; j++) {
        if(map[i][j] == 1){
          dp[i][j] = dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;

          result = Math.max(result, dp[i][j]);
        }
      }
    }

    System.out.println(result * result);
    
  }
}
