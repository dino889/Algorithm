import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @title 벽 부수고 이동하기
 * @date 210914
 * @author Jiwoo Choi
 */

public class BOJ_2206 {
  private static int[] dx = {-1, 1, 0, 0};
  private static int[] dy = {0, 0, -1, 1};
  private static int N, M;
  private static int[][] map;
  private static boolean[][][] visited;
  private static int res;
  
  private static class Node{
    int x;
    int y;
    int cnt;
    int wall;


    Node(int x, int y, int cnt, int wall) {
      this.x = x;
      this.y = y;
      this.cnt = cnt;
      this.wall = wall;
    }
  }

  private static boolean isWall(int x, int y){
    if(x < 0 || x >= N || y < 0 || y >= M){
      return true;
    }
    else return false;
  }

  private static void bfs() {
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(0, 0, 1, 0));
    visited[0][0][0] = true;

    while(!queue.isEmpty()){
      Node node = queue.poll();
      int r = node.x;
      int c = node.y;

      if(r == N - 1 && c == M - 1){
        res = node.cnt;
        break;
      }

      for (int i = 0; i < 4; i++) {
        int newX = r + dx[i];
        int newY = c + dy[i];

        if(!isWall(newX, newY)) {
          if(map[newX][newY] == 0) {
            if(!visited[node.wall][newX][newY]) { // node.wall == 0
              visited[node.wall][newX][newY] = true;
              queue.add(new Node(newX, newY, node.cnt + 1, node.wall));
            }
          }
          else {  // node.wall == 1
            if(node.wall == 0){ 
              if(!visited[node.wall + 1][newX][newY]) { 
                visited[node.wall + 1][newX][newY] = true;
                queue.add(new Node(newX, newY, node.cnt + 1, node.wall + 1));
              }
            }
          }
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    visited = new boolean[2][N][M];
    String[] tmp;
    for (int i = 0; i < N; i++) {
      tmp = br.readLine().split("");
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(tmp[j]);
      }
    }

    res = -1;
    bfs();

    System.out.println(res);

  }
  
}
