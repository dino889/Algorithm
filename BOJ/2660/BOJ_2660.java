import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @num 2660
 * @title 회장뽑기
 * @author Jiwoo Choi
 * @date 21.12.12.
 */

public class BOJ_2660 {
  private static int num;
  // private static List<List<Integer>> graph = new ArrayList<>();
  private static int[][] graph;
  private static List<Integer> res = new ArrayList<>();

  private static void floyd() {
    for (int k = 1; k < num + 1; k++) {
      for (int i = 1; i < num + 1; i++) {
        for (int j = 1; j < num + 1; j++) {
          if(i == j)  continue;
          graph[i][j] =  Math.min(graph[i][j], graph[i][k] + graph[k][j]);
          // graph.get(i).set(j, Math.min(graph.get(i).get(j), graph.get(i).get(k) + graph.get(k).get(j)));
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    StringBuilder sb = new StringBuilder();

    num = Integer.parseInt(br.readLine());

    graph = new int[num + 1][num + 1];

    for (int i = 0; i < num + 1; i++) {
      Arrays.fill(graph[i], 51);
    }
    // for (int i = 0; i < num + 1; i++) {
    //   graph.add(new ArrayList<>());
    //   Collections.fill(graph.get(i), 51);
    // }

    
    while(true) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      
      if(s == -1 && e == -1) {
        break;
      }

      // graph.get(s).add(e);
      // graph.get(e).add(s);
      graph[s][e] = 1;
      graph[e][s] = 1;
    }

    floyd();


    int[] scores = new int[num + 1];
    int min = Integer.MAX_VALUE; //회장 점수 
    for(int i = 1; i <= num; i++) {
      for(int j = 1; j <= num; j++) {
        // scores[i] = Math.max(scores[i], graph.get(i).get(j));
        if(i == j || graph[i][j] == 51) continue;
        scores[i] = Math.max(scores[i], graph[i][j]);
      }
      min = Math.min(min, scores[i]);
    }


    for (int i = 1; i < num + 1; i++) {
      if(scores[i] == min){
        res.add(i);
      }
    }
    
    sb.append(min).append(" ").append(res.size()).append("\n");

    Collections.sort(res);

    for (int i = 0; i < res.size(); i++) {
      sb.append(res.get(i)).append(" ");
    }

    System.out.println(sb);

  }
}
