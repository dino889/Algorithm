import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * @num 10816
 * @title 숫자 카드 2
 * @author Jiwoo Choi
 * @date 21.12.16.
 */

public class BOJ_10816 {
  private static int N, M;
  private static int[] card, res;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = null;

    N = Integer.parseInt(br.readLine());
    card = new int[20000001];
    

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int input = Integer.parseInt(st.nextToken());
      if(input < 0) {
        input = Math.abs(input);
        input += 10000000;
        card[input]++;
      } else {
        card[input]++;
      }
    }

    M = Integer.parseInt(br.readLine());
    res = new int[M];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      int input = Integer.parseInt(st.nextToken());
      if(input < 0) {
        input = Math.abs(input);
        input += 10000000;
        res[i] = card[input];
      } else {
        res[i] = card[input];
      }
    }

    for (int i : res) {
      sb.append(i).append(" ");
    }

    bw.write(sb.toString());
    bw.flush();
    bw.close();

  }
}
