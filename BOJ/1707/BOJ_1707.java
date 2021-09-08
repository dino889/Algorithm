import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
// 이분 그래프
// : 인접한 정점끼리 서로 다른 색으로 칠해서 모든 정점을 두 가지 색으로만 칠할 수 있는 그래프.
// : 이분 그래프는 그래프의 정점을 두 그룹으로 나누었을 때 같은 그룹에 속한 정점끼리는 인접하지 않는 것
public class BOJ_1707 {
  public static int K, V, E, color;
  public static List<Integer>[] tree;
  public static int[] visited;
  public static boolean chk;

  public static boolean dfs(int v, int group) {
    visited[v] = group;

    for(int next : tree[v]){
      if(visited[next] == 0) {  // 방문한 적이 없다면
        if(dfs(next, -group) == false){
          return false;
        }
      }

      if(visited[next] == visited[v]){
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    K = Integer.parseInt(br.readLine());
    
    for(int k = 0; k < K; k++){
      st = new StringTokenizer(br.readLine());
      
      V = Integer.parseInt(st.nextToken());
      E = Integer.parseInt(st.nextToken());
      
      tree = new ArrayList[V + 1];
      visited = new int[V + 1];

      for(int i = 1; i <= V; i++){
        tree[i] = new ArrayList<>();
      }

      for (int e = 0; e < E; e++) {
        st = new StringTokenizer(br.readLine(), " ");
        int i = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(st.nextToken());
        tree[i].add(j);
        tree[j].add(i);
      }
      // color = 1;
      chk = true;
      for (int i = 1; i <= V; i++) {
        if(visited[i] == 0){
          chk = dfs(i, 1);
        }
        if(!chk){
          break;
        }
      }
      

      if(chk)
        System.out.println("YES");
      else
        System.out.println("NO");      
    }

  }
}
