import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2475 {
  private static int sum;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;

    st = new StringTokenizer(br.readLine());
    
    for(int i = 0; i < 5; i++){
      sum += Math.pow(Integer.parseInt(st.nextToken()), 2);
    }

    System.out.println(sum % 10);
  }
}
