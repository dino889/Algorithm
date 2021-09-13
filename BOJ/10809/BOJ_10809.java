import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * @title 알파벳 찾기
 * @date 210910
 * @author Jiwoo Choi
 */
public class BOJ_10809 {
  private static char[] S;
  private static int[] res;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    S = br.readLine().toCharArray();
    res = new int[26];
    Arrays.fill(res, -1);
    // a -> 97
    for (int i = S.length - 1; i >= 0; i--) {
      for (int j = 0; j < 26; j++) {
        int trans = (int)S[i] - 97;
        if(trans == j){
          res[j] = i;
        }
      }
    }

    for (int i : res) {
      sb.append(i).append(" ");
    }
    sb.setLength(sb.length()-1);
    System.out.println(sb);
  }
  
}
