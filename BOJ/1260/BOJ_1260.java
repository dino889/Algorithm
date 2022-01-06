import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @num 1260
 * @title DFS와 BFS
 * @author Jiwoo Choi
 * @date 22.01.06.
 */

public class BOJ_1260 {
  private static int N, M, V;
  private static int[][] graph;
  private static boolean[] visited;
  private static StringBuilder sb = new StringBuilder();

  private static void dfs(int idx) {
    visited[idx] = true;

    sb.append(idx).append(" ");

    for (int i = 1; i < N + 1; i++) {
      if(graph[idx][i] == 1 && visited[i] == false) {
        dfs(i);
      }
    }
  
  }

  private static void bfs(int idx) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(idx);
    visited[idx] = true;

    while(!queue.isEmpty()) {
      int v = queue.poll();
      sb.append(v).append(" ");

      for (int i = 1; i < N + 1; i++) {
        if(graph[v][i] == 1 && visited[i] == false) {
          queue.offer(i);
          visited[i] = true;
        }
      }
    }

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    V = Integer.parseInt(st.nextToken());

    graph = new int[N + 1][N + 1];
    visited = new boolean[N + 1];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph[a][b] = graph[b][a] = 1;
    }

    dfs(V);
    System.out.println(sb.toString());
    sb.setLength(0);

    Arrays.fill(visited, false);
    bfs(V);
    System.out.println(sb.toString());

  }
}
