import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1197 {
  public static int V, E;
  public static int[] parents;
  public static Edge[] edgeList;

  public static class Edge implements Comparable<Edge> {
    int from, to, weight;

    public Edge(int from, int to, int weight){
      this.from = from;
      this.to = to;
      this.weight = weight;
    }

    @Override
    public int compareTo(Edge e) {
      return Integer.compare(this.weight, e.weight);
    }
  }

  public static int kruskal() {
    int res = 0, cnt = 0;

    // 간선 가중치 기준 오름차순 정렬
    Arrays.sort(edgeList);

    // 정점 초기화
    make();

    // 주어진 간선 이으면서
    for(Edge edge : edgeList){
      if(union(edge.from, edge.to)){  // 싸이클이 형성 안되면
        res += edge.weight; // 해당 간선 사용
        if(cnt++ == V - 1) return res;  // 정점 -1의 간선이 이어졌다면 MST 완성
      }
    }
    return res;
  }

  public static boolean union(int a, int b){
    int aRoot = find(a);
    int bRoot = find(b);

    if(aRoot == bRoot) return false;
    parents[aRoot] = bRoot;
    return true;
  }

  public static int find(int a){
    if(a == parents[a]) return a;
    return parents[a] = find(parents[a]);
  }

  public static void make(){
    for (int i = 1; i <= V; i++) {
      parents[i] = i;
    }
  }

  public static void main(String[] args) throws IOException{
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken()); // 정점
    E = Integer.parseInt(st.nextToken()); // 간선
    
    edgeList = new Edge[E]; // 간선 개수 만큼
    parents = new int[V + 1];

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      edgeList[i] = new Edge(a, b, c); 
    }
    

  }

}
