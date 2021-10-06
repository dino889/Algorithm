import java.util.*;

class 게임맵최단거리 {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static boolean[][] visited;
    private static int n, m;
    
    private static class Node {
        int x;
        int y;
        int dist;
        
        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    public static int solution(int[][] maps) {
        int answer = 0;
        // 0,0 -> n-1, m-1
        
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        // 상대팀 진영 주변이 전부 벽이면
        // if(maps[n - 1][m - 2] == 0 && maps[n - 2][m - 1] == 0 && maps[n - 2][m - 2] == 0){
        //     answer = -1;
        //     return answer;
        // } else {
            answer = bfs(0, 0, maps);
            return answer;
        // }
    }
    
    private static int bfs(int x, int y, int[][] maps){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y, 1));
        visited[x][y] = true;
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.x == n - 1 && node.y == m - 1){
                return node.dist;
            }
            
            for(int i = 0; i < 4; i++){
                int newX = dx[i] + node.x;
                int newY = dy[i] + node.y;
                
                if(isWall(newX, newY)){
                    if(maps[newX][newY] == 1 && !visited[newX][newY]){
                        visited[newX][newY] = true;
                        queue.offer(new Node(newX, newY, node.dist + 1));
                    }
                }
            }
        }
        return -1;
    }
    
    private static boolean isWall(int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= m){
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
      int[][] maps1 = {
        {1,0,1,1,1},
        {1,0,1,0,1},
        {1,0,1,1,1},
        {1,1,1,0,1},
        {0,0,0,0,1}
      };

      int[][] maps2 = {
        {1,0,1,1,1},
        {1,0,1,0,1},
        {1,1,1,1,1},
        {1,1,1,0,0},
        {0,0,0,0,1}
      };

      System.out.println(solution(maps1));
      System.out.println(solution(maps2));

    }
}