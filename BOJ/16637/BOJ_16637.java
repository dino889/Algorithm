import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @num 16637
 * @title 괄호 추가하기
 * @author Jiwoo Choi
 * @date 21.12.15.
 */

public class BOJ_16637 {
  private static int N, res = Integer.MIN_VALUE;
  private static char[] expr;
  private static List<Character> op;
  private static List<Integer> num;

  private static void dfs(int idx, int sum) {
    if(op.size() <= idx) {
      res = Math.max(res, sum);
      return;
    }

    int n = calc(op.get(idx), sum, num.get(idx + 1));
    
    dfs(idx + 1, n);

    if(idx + 1 < op.size()) {
      int n2 = calc(op.get(idx + 1), num.get(idx + 1), num.get(idx + 2));

      dfs(idx + 2, calc(op.get(idx), sum, n2));
    }
  }

  private static int calc(char op, int sum, int num) {
    switch(op) {
      case '+' :
        return sum + sum;
      case '-' :
        return sum - sum;
      case '*' :
        return sum * sum;
    }
    return 1;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    
    expr = new char[N];
    op = new ArrayList<>();
    num = new ArrayList<>();

    expr = br.readLine().toCharArray();

    for (int i = 0; i < N; i++) {
      char tmp = expr[i];
      if(!Character.isDigit(tmp)) {
        op.add(tmp);
        continue;
      }
      num.add(Character.getNumericValue(tmp));
    }

    dfs(0, num.get(0));

    System.out.println(res);

  }
}
