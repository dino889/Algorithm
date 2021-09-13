import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @title 상수
 * @date 210909
 * @author Jiwoo Choi
 */
public class BOJ_2908 {
  private static char[] A, B;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    A = st.nextToken().toCharArray();
    B = st.nextToken().toCharArray();

    // swap
    swap(A);
    swap(B);
    System.out.println(A[0] + " " + A[2]);

    int a = Integer.parseInt(String.valueOf(A));
    int b = Integer.parseInt(String.valueOf(B));

    System.out.println(a > b ? a : b);
    

  }
  private static void swap(char[] arr){
    char tmp = arr[0];
    arr[0] = arr[2];
    arr[2] = tmp;
  }
}
