import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_1655 {
  private static int N;
  private static List<Integer> list;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    list = new ArrayList<>();

    N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      list.add(Integer.parseInt(br.readLine()));

      int len = list.size();
      Collections.sort(list);
      if(len % 2 == 0)  { // 입력받은 수의 길이가 짝수이면
        int num1 = list.get(len / 2 - 1);
        int num2 = list.get(len / 2);
        if(num1 < num2) { 
          // System.out.println(num1);
          bw.write(num1);
          bw.flush();
          // sb.append(num1);
        } else { 
          // System.out.println(num2);
          bw.write(num2);
          bw.flush();
          // sb.append(num2);
        }
      } else {
        // System.out.println(list.get(len / 2));
        bw.write(list.get(len / 2));
        bw.flush();
        // sb.append(list.get(len / 2));
      }
      // System.out.println(sb);
      // sb.setLength(0);
    }
    bw.close();
  }
}