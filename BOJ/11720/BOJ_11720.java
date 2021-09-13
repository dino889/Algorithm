import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @title 숫자의 합
 * @date 210910
 * @author Jiwoo Choi
 */
public class BOJ_11720 {
  private static int N, res;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    N = Integer.parseInt(br.readLine());
    char[] tmp = br.readLine().toCharArray();
    res = 0;
    for (char c : tmp) {
      res += c - '0';
    }
    System.out.println(res);
  }
  
}
