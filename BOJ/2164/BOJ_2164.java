import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @num 2164
 * @title 카드 2
 * @author Jiwoo Choi
 * @date 21.12.16.
 */

public class BOJ_2164 {
  

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    Queue<Integer> card = new LinkedList<>();

    for (int i = 1; i <= N; i++) {
      card.offer(i);
    }

    while(true) {
      if(card.size() == 1) {
        break;
      }

      card.poll();
      
      int tmp = card.poll();
      card.offer(tmp);
    }

    bw.write(card.poll().toString());
    bw.flush();
    bw.close();
  }
}
