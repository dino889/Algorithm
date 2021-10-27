import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  @title 거리두기 확인하기
 *  @date 211009
 *  @author Jiwoo Choi
 */


// 행렬 (r1, c1), (r2, c2) 맨해튼 거리 -> |r1 - r2| + |c1 - c2| 
public class 거리두기확인하기 {
  private static int[] dx = {-1, 1, 0, 0};
  private static int[] dy = {0, 0, -1, 1};
  private static char[][] map;
  private static boolean[][] visited;
  
  private static class Node {
    int x, y;

    public Node(int x, int y){
      this.x = x;
      this.y = y;
    }
  }

  private static boolean isWall(int x, int y){
    return x < 0 || x >= 5 || y < 0 || y >= 5;
  }

  private static boolean bfs(char[][] m, int x, int y) {
    Queue<Node> queue = new LinkedList<>();
    visited = new boolean[5][5];
    queue.offer(new Node(x, y));
    visited[x][y] = true;

    while(!queue.isEmpty()) {
      Node current = queue.poll();

      for (int i = 0; i < 4; i++) {
        int newX = current.x + dx[i];
        int newY = current.y + dy[i];
        int manhattanDist = Math.abs(x - newX) + Math.abs(y - newY);

        if(isWall(newX, newY)) continue;  // 배열 범위 넘어가면 패스
        if(visited[newX][newY] || manhattanDist > 2) continue;  // 맨해튼 거리 2인 경우 거리두기 X -> 이동 X

        visited[newX][newY] = true;
        // System.out.println("bfs : " + m[newX][newY]);
        if(m[newX][newY] == 'X') continue;  // 새로운 위치에 파티션이 있으면 거리두기 O
        else if(m[newX][newY] == 'P') return true;  // 탐색 중에 또 다른 응시자 만나면 true -> 맨해튼 거리 내에서 파티션으로 나눠지지 않은 공간에 다른 응시자가 있음을 의미
        else queue.offer(new Node(newX, newY)); // 빈테이블
      }
    }
    return false;
  }

  private static char[][] convert(String[] place){
    
    for(int i = 0; i < 5; i++) {
      map[i] = place[i].toCharArray();
      // System.out.println(Arrays.toString(map[i]));
    }
    return map;
  }

  public static int[] solution(String[][] places) {
    int[] answer = new int[places.length];
    Arrays.fill(answer, 1);
    map = new char[5][5];

    for (int k = 0; k < 5; k++) {
      map = convert(places[k]);
      for (int i = 0; i < 5; i++) {
        // System.out.println(Arrays.toString(map[i]));
        for (int j = 0; j < 5; j++) {
          // System.out.println(map[i][j]);
          if(map[i][j] == 'P') {  // 응시자가 앉아 있는 자리부터 탐색
            if(bfs(map, i, j)){
              answer[k] = 0;
            } 
            // else {
            //   answer[k] = 1;
            // }
          }
        }
      }
      System.out.println();
    }

    return answer;
  }

  public static void main(String[] args) {
    String[][] p = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                    {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
                    {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, 
                    {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, 
                    {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

    System.out.println(Arrays.toString(solution(p)));
  }
}
