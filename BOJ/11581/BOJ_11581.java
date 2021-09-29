import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11581 {
  private static int N;
  private static List<List<Integer>> graph = new ArrayList<>();
  private static int[] visited;
  private static boolean chk;


  public static void dfs(int idx) {

    if(visited[idx] == -1){ // 0(default) : 방문 X, -1 : 방문O but 탐색 완료 X, 1 : 탐색 완료
      // if(visited[idx] == -1)
      //   chk = true;
      // else chk = false;
      // chk = true;
      System.out.println("CYCLE");
      System.exit(0);
    }

    visited[idx] = -1;
    for(int v : graph.get(idx)){
      if(visited[v] != 1){  // 탐색이 완료되지 않았으면 다음 정점
        dfs(v);
      }
    }
    visited[idx] = 1;
    // chk = false;
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;

    N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N + 1; i++) {
      graph.add(new ArrayList<>());
    }

    visited = new int[N + 1];

    for (int i = 1; i < N; i++) {
      int cnt = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < cnt; j++) {
        graph.get(i).add(Integer.parseInt(st.nextToken()));
      }
    }
    
    // chk = false;
    dfs(1);
    System.out.println("NO CYCLE");


    // if(chk) { // 1 -> N
    //   System.out.println("CYCLE");
    // } else {
    //   System.out.println("NO CYCLE");
    // }
  }
  
}