import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @title 아스키 코드
 * @date 210910
 * @author Jiwoo Choi
 */
public class BOJ_11654 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char c = br.readLine().charAt(0);
    System.out.println((int)c);
  }
}
