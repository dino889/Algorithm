import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @num 18405
 * @title 경쟁적 전염
 * @author Jiwoo Choi
 * @date 21.12.14.
 */

public class BOJ_18405 {

  private static int N, K, S, X, Y;
  private static int[][] tube;
  private static int[] dx = {-1, 1, 0, 0};
  private static int[] dy = {0, 0, -1, 1};
  private static PriorityQueue<Node> pq;

  private static class Node implements Comparable<Node> {
    int x, y, virus, s;

    Node(int x, int y, int virus, int s){
      this.x = x;
      this.y = y;
      this.virus = virus;
      this.s = s;
    }

    @Override
    public int compareTo(Node node){
      if(this.s == node.s) {
        return Integer.compare(this.virus, node.virus);
      }
      return Integer.compare(this.s, node.s);
    }
  }

  private static boolean isWall(int x, int y) {
    return x < 1 || x >= N + 1 || y < 1 || y >= N + 1;
  }

  private static void spread() {
  
    while(!pq.isEmpty()) {
      Node node = pq.poll();
      if(node.s == S) return;

      for (int i = 0; i < 4; i++) {
        int newX = node.x + dx[i];
        int newY = node.y + dy[i];

        if(isWall(newX, newY))  continue;

        if(tube[newX][newY] != 0) continue;

        tube[newX][newY] = node.virus;
        pq.offer(new Node(newX, newY, node.virus, node.s + 1));
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    tube = new int[N + 1][N + 1];
    pq = new PriorityQueue<>();
    
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        tube[i][j] = Integer.parseInt(st.nextToken());
        if(tube[i][j] != 0) {
          pq.offer(new Node(i, j, tube[i][j], 0));
        }
      }
    }

    st = new StringTokenizer(br.readLine());
    S = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());
    Y = Integer.parseInt(st.nextToken());

    if(S != 0) {
      spread();
    }

    System.out.println(tube[X][Y]);
  }
}
