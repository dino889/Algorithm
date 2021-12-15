import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @num 11050
 * @title 이항 계수 1
 * @author Jiwoo Choi
 * @date 21.12.15.
 */

public class BOJ_11050 {
  // nCk = n! / (n - k)!k!
  private static int[][] dp;

  private static int factorial(int n) {
    if(n <= 1) {
      return 1;
    }
    return n * factorial(n - 1);
  }

  private static int memoization(int n, int k) {
    if(dp[n][k] > 0) {
      return dp[n][k];
    }

    if(n == k || k == 0) {
      return dp[n][k] = 1;
    }

    return dp[n][k] = memoization(n - 1, k - 1) + memoization(n - 1, k);
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    dp = new int[N + 1][N + 1];

    // System.out.println(factorial(N) / (factorial((N - K)) * factorial(K)));

    System.out.println(memoization(N, K));
  }
}
