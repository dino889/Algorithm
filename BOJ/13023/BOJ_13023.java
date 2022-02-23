import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @num 13023
 * @title ABCDE
 * @author Jiwoo Choi
 * @date 22.02.15.
 */

public class BOJ_13023 {
  
  private static void dfs(int idx, int cnt, List<List<Integer>> g, boolean[] visited) {
    if(cnt == 4) {
      System.out.println(1);
      System.exit(0);
    }

    visited[idx] = true;
    for (int i = 0; i < g.get(idx).size(); i++) {
      int next = g.get(idx).get(i);
      if(visited[next])  continue;

      visited[next] = true;
      dfs(next, cnt + 1, g, visited);
      visited[next] = false;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // 사람 수
    int M = Integer.parseInt(st.nextToken()); // 친구 관계의 수

    // int[][] arr = new int[N][N];
    List<List<Integer>> graph = new ArrayList<>();
    // boolean[] visited = new boolean[N];

    for (int i = 0; i < N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    for (int i = 0; i < N; i++) {
      boolean[] visited = new boolean[N];
      dfs(i, 0, graph, visited);
    }

    System.out.println(0);
  }
}
