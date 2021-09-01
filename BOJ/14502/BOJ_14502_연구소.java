import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
  int r, c;
  Pair (int r, int c) {
      this.r = r;
      this.c = c;
  }
}

public class BOJ_14502_연구소 {
  public static int[] dx = {-1, 1, 0, 0};  // 상 하 좌 우
  public static int[] dy = {0, 0, -1, 1};
  public static int N, M, result;  // 세로, 가로 
  public static int[][] map;
  public static int[][] temp;
  public static Queue<Pair> q;
  
  // 안전지대 갯수를 세줍니다.
  public static int countSafe() {
    int count = 0;
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        if(temp[i][j] == 0) {
          count++;
        }
      }
    }
    return count;
  }

  // map 배열을 copy배열에 복사합니다.
  public static void copy() {
    for(int i=0; i < N; i++) {
      for(int j=0; j < M; j++) {
        temp[i][j] = map[i][j];
        // 복사와 동시에 q에 바이러스 위치를 집어넣습니다.
        if(temp[i][j] == 2) 
          q.offer(new Pair(i,j));
      }
    }
  }
  
  public static void bfs() { // 바이러스 퍼트리기
    while(!q.isEmpty()){
      Pair cur = q.poll();
      for(int i = 0; i < 4; i++){
        int newX = cur.r + dx[i];
        int newY = cur.c +  dy[i];
        if(newX >=0 && newX < N && newY >= 0 && newY < M) {
          if(temp[newX][newY] == 0) {
            temp[newX][newY] = 2;
            q.offer(new Pair(newX,newY));
          }
        }
      }
    }
  }

  public static void dfs(int depth){  // 벽 세우기
    if(depth == 3){
      copy();
      bfs();
      result = Math.max(result, countSafe());
      return;
    }
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if(map[i][j] == 0) {  // 벽이 아니면
          map[i][j] = 1;  // 벽을 세우고
          dfs(depth + 1); // 다음 노드 탐색
          map[i][j] = 0;  // 
        }      
      }
    }

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    temp = new int[N][M];
    q = new LinkedList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dfs(0);
    System.out.println(result);
    // for (int i = 0; i < N; i++) {
    //   for (int j = 0; j < M; j++) {
    //     System.out.print(map[i][j] + "\t");
    //   }
    //   System.out.println();
    // }
    
  }
}