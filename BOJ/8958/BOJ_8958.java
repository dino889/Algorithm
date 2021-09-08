import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8958 {
  private static char[] arr;
  private static int N, cnt, result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(br.readLine());
    for (int n = 0; n < N; n++) {
      arr = br.readLine().toCharArray();
      result = 0;
      cnt = 0;
      for(int i = 0; i < arr.length; i++){
        if(arr[i] == 'O'){
          cnt++;
          result += cnt;
        } else if(arr[i] == 'X'){
          cnt = 0;
        }
      }
      System.out.println(result);
    }
  }

}
