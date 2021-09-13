import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @title 음계
 * @date 210909
 * @author Jiwoo Choi
 */

public class BOJ_2920 {
  private static int[] num;
  private static String res;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    num = new int[9];
    for (int i = 1; i < 9; i++) {
      num[i] = Integer.parseInt(st.nextToken());
    }
    int asc = 0, desc = 0, mix = 0;
    for (int i = 1; i < 9; i++) {
      if(num[i] == i) {
        asc++;
        // res = "ascending";
      } else if(num[i] == 9-i){
        desc++;
        // res = "descending";
      } else {
        mix++;
        // res = "mixed";
      }
    }

    if(asc == 8) {
      res = "ascending";
    } else if(desc == 8){
      res = "descending";
    } else {
      res = "mixed";
    }

    System.out.println(res);
  }
}
