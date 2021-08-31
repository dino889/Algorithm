import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_2001 {
  static int N, M;
  static int[][] arr;

  public static boolean isWall(int x, int y){
    if(x < 0 || x >= N || y < 0 || y >= N)
      return false;
    else return true;
  }
  public static int solve() {
    List<Integer> result = new ArrayList<Integer>();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        int tmp = 0;
        // tmp += arr[i][j];
        for(int a = 0; a < M; a++) {
          for (int b = 0; b < M; b++) {
            if(isWall(i + a, j + b)){
              tmp += arr[i + a][j + b];
            }
          }
          result.add(tmp);
        }
      }
    }

    return Collections.max(result);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    int TC = Integer.parseInt(br.readLine());
    for (int t = 1; t <= TC; t++) {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      
      arr = new int[N][N];
      
      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          arr[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      sb.append("#").append(t).append(" ").append(solve()).append("\n");
      
    }
    System.out.println(sb);
  }
}
