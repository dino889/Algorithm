import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @num 5972
 * @title 택배 배송
 * @author Jiwoo Choi
 * @date 22.01.04.
 */

public class BOJ_5972 {
  private static int N, M, INF = 50000001;
  private static List<List<Node>> graph = new ArrayList<>();
  private static int[] dist;

  static class Node implements Comparable<Node>{
    int index, dist;

    public Node(int index, int dist) {
      this.index = index;
      this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
      return Integer.compare(this.dist, o.dist);
    }
  }

  private static void dijkstra(int index) {
    
    PriorityQueue<Node> pq = new PriorityQueue<>();
    dist[index] = 0;
    pq.offer(new Node(index, 0));

    while(!pq.isEmpty()) {

      Node node = pq.poll();
      int idx = node.index;
      int d = node.dist;

      if(d > dist[idx]) {
        continue;
      }

      for(Node n : graph.get(idx)) {
        if(d + n.dist < dist[n.index]) {
          dist[n.index] = d + n.dist;
          pq.offer(new Node(n.index, dist[n.index]));
        }
      }

    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    for(int i = 0; i < N + 1; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      int C = Integer.parseInt(st.nextToken());

      graph.get(A).add(new Node(B, C));
      graph.get(B).add(new Node(A, C));
    }

    dist = new int[N + 1];
    Arrays.fill(dist, INF);

    dijkstra(1);

    System.out.println(dist[N]);
    // bw.write(dist[N]);
    // bw.flush();
    // bw.close();
  }
  
}
