import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * @author Jiwoo Choi
 * @title 바이러스
 * @date 210908
 */

public class BOJ_2606 {
  private static int N, M, cnt;
  private static int[][] map;
  private static boolean[] visited;

  private static void bfs(int idx){
    Queue<Integer> queue = new LinkedList<>();

    queue.add(idx);
    visited[idx] = true;

    while(!queue.isEmpty()){
      idx = queue.poll();

      for (int i = 1; i < N + 1; i++) {
        if(map[idx][i] != 0 && !visited[i]){
          cnt++;
          queue.add(i);
          visited[i] = true;
        }
      }
    }
  }

  private static void dfs(int idx){
    visited[idx] = true;

    for (int i = 1; i < N + 1; i++) {
      if(map[idx][i] != 0 && !visited[i]){
        cnt++;
        dfs(i);
      }
    }
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // StringBuilder sb = new StringBuilder();
    StringTokenizer st = null;

    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    map = new int[N + 1][N + 1];
    visited = new boolean[N + 1];
    for (int e = 0; e < M; e++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      map[from][to] = map[to][from] = 1;
    }

    cnt = 0;
    // dfs(1);
    bfs(1);

    System.out.println(cnt);
  }
}