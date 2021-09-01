import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2577 {
  public static int A, B, C;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    A = Integer.parseInt(br.readLine());
    B = Integer.parseInt(br.readLine());
    C = Integer.parseInt(br.readLine());

    int temp = A * B * C;
    String tmp = Integer.toString(temp);
    String str[] = tmp.split("");

    int[] cnt = new int[10]; // 0 ~ 9
    
    for (int i = 0; i < str.length; i++) {
      cnt[Integer.parseInt(str[i])]++;
    }

    for (int i = 0; i < cnt.length; i++) {
      System.out.println(cnt[i]);
    }
  }
}
