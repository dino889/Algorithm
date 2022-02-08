import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @num 10216
 * @title Count Circle Groups
 * @author Jiwoo Choi
 * @date 22.02.08.
 */

public class BOJ_10216 {
  private static int[][] input;
  private static boolean[] visited;

  private static void dfs(int idx) {
    visited[idx] = true;
    for (int i = 0; i < input.length; i++) {
      if(!visited[i]) {
        // 두 점 사이의 거리 : sqrt((x1 - x2)^2 + (y1 - y2)^2)
        double dist = Math.sqrt(Math.pow(input[idx][0] - input[i][0], 2) + Math.pow(input[idx][1] - input[i][1], 2));
        if(dist <= input[idx][2] + input[i][2]) { // 점 사이의 거리가 반지름의 합보다 작다면 통신 영역
          dfs(i);
        }
      }
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;

    int T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      int N = Integer.parseInt(br.readLine());  // 적군 진영의 숫자 N
      input = new int[N][3];
      visited = new boolean[N];

      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());  // 적군 진영의 좌표 x, y + 해당 진영의 R
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        input[i][0] = x;
        input[i][1] = y;
        input[i][2] = R;
      }

      int res = 0;
      for (int i = 0; i < N; i++) {
        if(!visited[i]) {
          dfs(i);
          res++;
        }
      }

      System.out.println(res);
    }
  }
}