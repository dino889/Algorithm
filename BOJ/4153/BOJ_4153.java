import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @title 직각삼각형
 * @date 210910
 * @author Jiwoo Choi
 */
public class BOJ_4153 {
  private static int a, b, c;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    
    while(true) {
      st = new StringTokenizer(br.readLine(), " ");
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      
      if(a == 0 && b == 0 && c == 0){
        break;
      }

      int max = Math.max(a, Math.max(b, c));

      
      if (max == a) {
        a *= a;
        b *= b;
        c *= c;
        System.out.println(b + c == a ? "right" : "wrong");
      } else if(max == b) {
        a *= a;
        b *= b;
        c *= c;
        System.out.println(a + c == b ? "right" : "wrong");
      } else if(max == c){
        a *= a;
        b *= b;
        c *= c;
        System.out.println(a + b == c ? "right" : "wrong");
      }
    }
  }
}