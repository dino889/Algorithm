import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_4179 {
  private static int[] dx = {-1, 1, 0, 0};
  private static int[] dy = {0, 0, -1, 1};
  private static int R, C;
  private static int[][] maze;
  private static Queue<Node> jQueue, fQueue;
  
  private static class Node {
    int x;
    int y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  private static void bfs() {
    int answer = 0;

    while(true){
      answer++;

      int fqSize = fQueue.size();

    // while(!fQueue.isEmpty()){
      while(fqSize > 0){
        fqSize--;
        
        Node node = fQueue.poll();
        int x = node.x;
        int y = node.y;

        for (int i = 0; i < 4; i++) {
          int newX = x + dx[i];
          int newY = y + dy[i];

          if(newX >= 0 && newX < R && newY > 0 && newY < C){
            if(maze[newX][newY] >= 0){
              fQueue.offer(new Node(newX, newY));
              maze[newX][newY] = -2;
            }
          }
        }
      }

      int jqSize = jQueue.size();
      // while(!jQueue.isEmpty()){
      while(jqSize > 0){
        jqSize--;
        Node node = jQueue.poll();
        int x = node.x;
        int y = node.y;

        for (int i = 0; i < 4; i++) {
          int newX = x + dx[i];
          int newY = y + dy[i];

          if(newX < 0 || newX >= R || newY < 0 || newY >= C){
            System.out.println(answer);
            return;
          }

          if(maze[newX][newY] == 0){
            jQueue.offer(new Node(newX, newY));
            maze[newX][newY] = 1;
          }
        }
      }
      if(jQueue.isEmpty()){
        System.out.println("IMPOSSIBLE");
        return;
      }
    }
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    maze = new int[R][C];
    
    jQueue = new LinkedList<>();
    fQueue = new LinkedList<>();

    for (int i = 0; i < R; i++) {
      String s = br.readLine();
      for (int j = 0; j < C; j++) {
        char tmp = s.charAt(j);
        if(tmp == '#'){ // 벽
          maze[i][j] = -1;
        } else if(tmp == 'J') { // 지훈 초기 위치
          maze[i][j] = 1;
          jQueue.add(new Node(i, j));
        } else if(tmp == 'F') {
          maze[i][j] = -2;
          fQueue.add(new Node(i, j));
        } else {
          maze[i][j] = 0;
        }
      }
    }

    bfs();

  }
}