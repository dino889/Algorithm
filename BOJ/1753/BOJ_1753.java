import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {
  private static final int INF = Integer.MAX_VALUE;
  private static List<List<Node>> graph = new ArrayList<>();  // 그래프 표현할 2차원 list
  private static int[] dist;  // 최단 거리 표현할 배열
  // private static boolean[] visited; // 방문 처리

  static class Node implements Comparable<Node> { // graph(List)와 우선순위 큐에서 사용할 Node

    int index;  // 노드 번호
    int distance; // 이동할 노드까지의 거리

    Node(int index, int distance) {
      this.index = index;
      this.distance = distance;
    }

    @Override
    public int compareTo(Node o){  // 최단 거리 기준 오름차순 정렬
      return Integer.compare(this.distance, o.distance);
    }
  }


  private static void dijkstra(int index) { // 다익스트라 알고리즘
    
    PriorityQueue<Node> pq = new PriorityQueue<>();   // 최단 거리가 갱신된 노드들을 담을 우선순위 큐
    dist[index] = 0;                // 최단 거리 테이블 시작 지점 노드 값 0으로 set
    pq.offer(new Node(index, 0));   // 우선순위 큐에 시작 노드 넣기

    while(!pq.isEmpty()) {
      
      Node node = pq.poll();  // 큐에서 노드 꺼내기
      int nodeIndex = node.index;   // 꺼낸 노드의 인덱스 및 최단 거리 비용 확인
      int distance = node.distance;
      
      // if(visited[nodeIndex]) {  // 방문했으면 다음 노드
      //   continue;
      // } else {
      //   visited[nodeIndex] = true;
      // }


      // 큐에서 꺼낸 거리와 최단거리테이블의 값을 비교해서 방문 처리
      // 큐는 최단거리를 기준으로 오름차순 정렬되고 있습니다.
      // 만약 현재 꺼낸 노드의 거리가 최단거리테이블의 값보다 크다면 해당 노드는 이전에 방문된 노드입니다.
      // 그러므로 해당노드와 연결 된 노드를 탐색하지 않고 큐에서 다음 노드를 꺼냅니다.
      if(distance > dist[nodeIndex]){
        continue;
      }

      for(Node linkedNode : graph.get(nodeIndex)) { // 큐에서 꺼낸 노드에서 이동 가능한 다음 노드 탐색
        // 다음 노드까지의 거리가 나까지 거리 + 나로부터 다음 노드까지 거리보다 작다면
        if(distance + linkedNode.distance < dist[linkedNode.index]) { // 기존 노드 거쳐서 다음 노드로 이동할 때 값이 다음 이동 노드의 최단거리 테이블 값보다 작을 때
          dist[linkedNode.index] = distance + linkedNode.distance; // 최단 거리 테이블 값 갱신
          pq.offer(new Node(linkedNode.index, dist[linkedNode.index])); // 갱신된 노드 큐에 삽입
        }
      }

      // visited[nodeIndex] = true;
    }
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int V = Integer.parseInt(st.nextToken()); // 정점 개수
    int E = Integer.parseInt(st.nextToken()); // 간선 개수
  
    int K = Integer.parseInt(br.readLine());  // 시작 정점의 번호

    // 그래프 생성 - 정점 + 1 만큼 - > 1부터
    for (int i = 0; i < V + 1; i++) {  
      graph.add(new ArrayList<>());
    }

    // 그래프에 간선 정보 입력
    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      graph.get(Integer.parseInt(st.nextToken())).add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }
    // 최단 거리 테이블 생성 + INF로 초기화
    // 시작 노드에서 하나씩 거쳐서 제일 마지막에 있는 노드에 도달할 때 가질 수 있는 간선의 거리 비용의 최댓값보다 INF의 값이 커야 최단거리 테이블을 갱신할 수 있기 때문
    dist = new int[V + 1];
    Arrays.fill(dist, INF);

    dijkstra(K);

    for (int i = 1; i < V + 1; i++) {
      if(dist[i] == INF) {
        System.out.println("INF");
      } else { 
        System.out.println(dist[i]);
      }
    }

  }
  
}
