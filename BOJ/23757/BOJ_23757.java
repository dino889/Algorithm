import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @num 23757
 * @title 아이들과 선물 상자
 * @author Jiwoo Choi
 * @date 22.04.12.
 */

public class BOJ_23757 {
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // 선물 상자의 수
    int M = Integer.parseInt(st.nextToken()); // 아이들의 수

    PriorityQueue<Integer> presentCnt = new PriorityQueue<>(Collections.reverseOrder());
    Queue<Integer> wantCnt = new LinkedList<>();
    
    String[] input = br.readLine().split(" ");
    for (String num : input) {
      presentCnt.offer(Integer.parseInt(num));
    }

    input = br.readLine().split(" ");
    for (String num : input) {
      wantCnt.offer(Integer.parseInt(num));
    }

    boolean chk = false;
    
    while(!wantCnt.isEmpty()) {
      int n = wantCnt.poll();
      int maxV = presentCnt.peek();
      // System.out.println("n : " + n + "\nmaxV: " + maxV);
      if(maxV >= n) { // 4 >= 3
        // int next = presentCnt.poll();
        presentCnt.offer(maxV - n);
        presentCnt.poll();
      } else {
        chk = true;
      }
    }

    System.out.println(chk ? 0 : 1);
  }
}
