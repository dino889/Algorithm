import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * @title 문자열 반복
 * @date 210909
 * @author Jiwoo Choi
 */
public class BOJ_2675 {
  private static int T, R;
  private static char[] S;


  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = null;

    T = Integer.parseInt(br.readLine());
    while(T-- > 0){
      st = new StringTokenizer(br.readLine());

      R = Integer.parseInt(st.nextToken());
      S = st.nextToken().toCharArray();

      for (int i = 0; i < S.length; i++) {
        for (int j = 0; j < R; j++) {
          sb.append(S[i]);
        }
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
}
