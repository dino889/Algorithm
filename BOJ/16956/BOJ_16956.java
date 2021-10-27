import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16956 {
  private static int[] dx = {-1, 1, 0, 0};
  private static int[] dy = {0, 0, -1, 1};
  private static int R, C;
  private static char[][] farm;
  private static Queue<Node> queue;

  private static class Node {
    int x, y;
    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
  private static boolean isWall(int x, int y)  {
    return x < 0 || x >= R || y < 0 || y >= C;
  }

  private static boolean bfs() {
    while(!queue.isEmpty()) {
      Node node = queue.poll();
      int x = node.x;
      int y = node.y;

      for(int i = 0; i < 4; i++) {
        int newX = x + dx[i];
        int newY = y + dy[i];

        if(isWall(newX, newY))  continue;
        if(farm[newX][newY] == 'S' || farm[newX][newY] == 'D') continue;
        if(farm[newX][newY] == 'W') return true;

        farm[newX][newY] = 'D'; // 울타리 설치
        
      }
    }
    return false;
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    // '.'는 빈 칸, 'S'는 양, 'W'는 늑대
    // 울타리는 'D'로 출력
    String[] str = br.readLine().split(" ");
    R = Integer.parseInt(str[0]);
    C = Integer.parseInt(str[1]);

    farm = new char[R][C];
    queue = new LinkedList<>();
    
    for (int i = 0; i < R; i++) {
      str = br.readLine().split("");
      for (int j = 0; j < C; j++) {
        farm[i][j] = str[j].charAt(0);
        if(farm[i][j] == 'S') {
          queue.offer(new Node(i, j));
        }
      }
    }
    
    // for (int i = 0; i < R; i++) {
    //   System.out.println(Arrays.toString(farm[i]));
      
    // }

    if(bfs()) {
      System.out.println(0);
      return;
    } else {
      sb.append(1).append("\n");
      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
          sb.append(farm[i][j]);
        }
        sb.append("\n");
      }
      System.out.println(sb.toString());
    }
    
  }
  
}
