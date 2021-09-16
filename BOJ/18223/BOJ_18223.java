import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @title 민준이와 마산 그리고 건우
 * @date 210913
 * @author Jiwoo Choi
 */

public class BOJ_18223{
  private static final int INF = Integer.MAX_VALUE;
  private static List<List<Node>> graph = new ArrayList<>();
  private static int[] dist;
  private static boolean[] visited;

  private static class Node implements Comparable<Node> {
    int index;
    int distance;

    Node(int index, int distance){
      this.index = index;
      this.distance = distance;
    }

    @Override
    public int compareTo(Node node){
      return Integer.compare(this.distance, node.distance);
    }
  }

  private static int dijkstra(int index, int end){

    Arrays.fill(dist, INF);

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(index, 0));
    dist[index] = 0;

    while(!pq.isEmpty()){
      Node node = pq.poll();
      int nodeIndex = node.index;
      int nodeDistance = node.distance;

      if(nodeDistance > dist[nodeIndex]){
        continue;
      }

      for(Node linkedNode : graph.get(nodeIndex)) { // 큐에서 꺼낸 노드에서 이동 가능한 다음 노드 탐색
        // 다음 노드까지의 거리가 나까지 거리 + 나로부터 다음 노드까지 거리보다 작다면
        if(nodeDistance + linkedNode.distance < dist[linkedNode.index]) { // 기존 노드 거쳐서 다음 노드로 이동할 때 값이 다음 이동 노드의 최단거리 테이블 값보다 작을 때
          dist[linkedNode.index] = nodeDistance + linkedNode.distance; // 최단 거리 테이블 값 갱신
          pq.offer(new Node(linkedNode.index, dist[linkedNode.index])); // 갱신된 노드 큐에 삽입
        }
      }
    }

    return dist[end];
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int V = Integer.parseInt(st.nextToken()); // 정점 개수
    int E = Integer.parseInt(st.nextToken()); // 간선 개수
    int P = Integer.parseInt(st.nextToken()); // 건우가 위치한 정점

    for (int i = 0; i < V + 1; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken()); // a 정점 b 정점 사이 거리
      graph.get(a).add(new Node(b, c));
      graph.get(b).add(new Node(a, c));

    }

    dist = new int[V + 1];
    visited = new boolean[V + 1];
    
    if(dijkstra(1, P) + dijkstra(P, V) <= dijkstra(1, V)){
      System.out.println("SAVE HIM");
      // sb.append("SAVE HIM");
    } else {
      System.out.println("GOOD BYE");
      // sb.append("GOOD BYE");
    }
    // sb.append("\n");
    // System.out.print(sb.toString());

  }
}