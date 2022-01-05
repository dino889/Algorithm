import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @num 1389
 * @title 케빈 베이컨의 6단계 법칙
 * @author Jiwoo Choi
 * @date 22.01.03.
 */

public class BOJ_1389 {
  private static int N, M;
  private static int[][] graph;
  private static int INF = Integer.MAX_VALUE / 2;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = null;

    String[] input = br.readLine().split(" ");
    N = Integer.parseInt(input[0]);
    M = Integer.parseInt(input[1]);

    graph = new int[N + 1][N + 1];

    for (int i = 0; i < N + 1; i++) {
      Arrays.fill(graph[i], INF);
    }

    
    
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());

      graph[s][e] = 1;
      graph[e][s] = 1;
    }


    // floyd
    for (int via = 1; via < N + 1; via++) { // 경유지
      for (int from = 1; from < N + 1; from++) {  // 출발지
        for (int to = 1; to < N + 1; to++) {  // 도착지
          if(from == to)  continue; // 출발지 == 도착지
          graph[from][to] = Math.min(graph[from][to], graph[from][via] + graph[via][to]);
        }
      }
    }
    

    
    int[] scores = new int[N + 1];  // 케빈 베이컨 수 담을 배열
    int min = Integer.MAX_VALUE; //회장 점수 
    
    for(int from = 1; from < N + 1; from++) {
      for(int to = 1; to < N + 1; to++) {
        if(from == to || graph[from][to] == INF) continue;
        scores[from] += graph[from][to];
      }
      min = Math.min(min, scores[from]);
    }
    

    for (int i = 1; i < N + 1; i++) {
      if(scores[i] == min){
        System.out.println(i);
        break;
      }
    }

  }
}
