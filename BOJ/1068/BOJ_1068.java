import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @title 트리
 * @date 210914
 * @author Jiwoo Choi
 */
public class BOJ_1068 {
  private static int N, delete, count;
  private static int[] tree;
  private static boolean[] visited;

  public static void dfs(int n){
    boolean isLeaf = true;
    visited[n] = true;
    if(tree[n] != -2) {
      for (int i = 0; i < N; i++) {
        if(!visited[i] && tree[i] == n){
          // visited[i] = true;
          dfs(i);
          // visited[i] = false;
          isLeaf = false;
        }
      }
      if(isLeaf)  count++;
    }
  }

  private static void del(int n){
    tree[n] = -2; // 노드 삭제
    for (int i = 0; i < N; i++) {
      if(tree[i] == n){  // 삭제할 노드를 부모로 가지고 있는 자식 노드 삭제
        del(i);
      }
    }
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;

    N = Integer.parseInt(br.readLine());
    
    tree = new int[N];
    visited = new boolean[N];
    int root = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      tree[i] = Integer.parseInt(st.nextToken());
      if(tree[i] == -1) root = i;
    }

    delete = Integer.parseInt(br.readLine());

    if(delete == root){  // 최상위 부모 노드가 지워지면 리프 노드는 무조건 0
      System.out.println(0);
      return;
    }

    // tree[delete] = -2;
    del(delete);
    
    count = 0;
    dfs(root);

    System.out.println(count);
  }
  
}
