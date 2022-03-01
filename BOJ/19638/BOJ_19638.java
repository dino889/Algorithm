import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @num 19638
 * @title 센티와 마법의 뿅망치
 * @author Jiwoo Choi
 * @date 22.02.28.
 */

public class BOJ_19638 {
  

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // 센티를 제외한 거인의 나라의 인구수 N (1 ≤ N ≤ 105)
    int H = Integer.parseInt(st.nextToken()); // 센티의 키를 나타내는 정수 Hcenti (1 ≤ Hcenti ≤ 2 × 109)
    int T = Integer.parseInt(st.nextToken()); // 마법의 뿅망치의 횟수 제한 T (1 ≤ T ≤ 105)
  
    //높은 숫자가 우선 순위인 int 형 우선순위 큐 선언
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    for (int i = 0; i < N; i++) {
      pq.offer(Integer.parseInt(br.readLine()));  // 각 거인의 키
    }

    int cnt = 0;
    for (int i = 0; i < T; i++) {
      if(pq.peek() < H) { // 제일 키 큰 거인이 센티의 키보다 크면
        break;
      }

      int h = pq.poll();
      if(h <= 1) {
        pq.offer(h);
      } else {
        pq.offer(h / 2);
      }
      cnt++;
    }

    if(pq.peek() >= H) {
      sb.append("NO").append('\n').append(pq.peek());
    } else {
      sb.append("YES").append('\n').append(cnt);
    }
    System.out.println(sb.toString());
  
  }
}
