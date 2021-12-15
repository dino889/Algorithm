import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @num 11650
 * @title 좌표 정렬하기
 * @author Jiwoo Choi
 * @date 21.12.15.
 */

public class BOJ_11650 {
  private static int N;
  private static PriorityQueue<Node> pq;

  private static class Node implements Comparable<Node> {
    int x, y;
    
    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Node node){
      if(this.x == node.x) {
        return Integer.compare(this.y, node.y);
      }
      return Integer.compare(this.x, node.x);
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(br.readLine());
    pq = new PriorityQueue<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      pq.offer(new Node(x, y));
    }


    while(!pq.isEmpty()) {
      Node node = pq.poll();

      sb.append(node.x).append(" ").append(node.y).append("\n");
    }

    System.out.println(sb.toString());

  }
}
