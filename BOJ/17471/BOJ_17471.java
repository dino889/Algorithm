import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471 {
  private static int N, res = Integer.MAX_VALUE;
  private static int[] people;
  private static boolean[] elections, visited;
  private static boolean[][] isConnected;

  private static void setElection(int start) {
    if(start == N + 1) {
      if(checkIsConnected(true) && checkIsConnected(false)) {
        res = Math.min(res, solve());
      }
      return ;
    }
    elections[start] = true;
    setElection(start + 1);
    elections[start] = false;
    setElection(start + 1);
  }

  private static boolean checkIsConnected(boolean flag) {
    visited = new boolean[N + 1];
    Queue<Integer> queue = new LinkedList<>();
    for(int i = 1; i < N + 1; i++) {
      if(elections[i] == flag) {
        queue.offer(i);
        visited[i] = true;
        break;
      }
    }
    while(!queue.isEmpty()) {
      int now = queue.poll();

      for(int i = 1; i < N + 1; i++) {
        if(visited[i]) continue;
        if(flag != elections[i]) continue;
        if(isConnected[now][i] == false) continue;

        queue.offer(i);
        visited[i] = true;
      }
    }

    for(int i = 1; i < N + 1; i++) {
      if(elections[i] != flag) continue;
      if(!visited[i]) return false;
    }
    return true;
  }

  private static int solve() {
    int fir = 0;
    int sec = 0;
    for(int i = 1; i < N + 1; i++) {
      if(elections[i]) fir += people[i];
      else sec += people[i];
    }
    return Math.abs(fir - sec);
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;

    N = Integer.parseInt(br.readLine());

    people = new int[N + 1];
    elections = new boolean[N + 1];
    isConnected = new boolean[N + 1][N + 1];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i < N + 1; i++) {
      people[i]= Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i < N + 1; i++) {
      st = new StringTokenizer(br.readLine());
      isConnected[i][i] = true;
      int num = Integer.parseInt(st.nextToken());
      for (int j = 0; j < num; j++) {
        int num2 = Integer.parseInt(st.nextToken());
        isConnected[i][num2] = true;
        isConnected[num2][i] = true;
      }
    }

    setElection(1);

    if(res == Integer.MAX_VALUE) {
      System.out.println(-1);
    } else System.out.println(res);
  }
}
