import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

/**
 * @num 10989
 * @title 수 정렬하기 3
 * @author Jiwoo Choi
 * @date 21.12.15.
 */



public class BOJ_10989 {
  private static int N;
  private static int[] cnt;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());

    cnt = new int[10001];
    
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      cnt[num]++;
    }

    
    for(int i = 0; i < 10001; i++) {
      if(cnt[i] == 0) continue;

      for(int j = 0; j < cnt[i]; j++) {
          bw.write(i + "\n");
      }
    }

    bw.flush();
    bw.close();
  }
}

// public class BOJ_10989 {
//   private static int N;
//   private static PriorityQueue<Node> pq;

//   private static class Node implements Comparable<Node> {
//     int num, idx;
    
//     public Node(int num, int idx) {
//       this.num = num;
//       this.idx = idx;
//     }

//     @Override
//     public int compareTo(Node node) {
//       if(this.num == node.num) {
//         return Integer.compare(this.idx, node.idx);
//       }
//       return Integer.compare(this.num, node.num);
//     }
//   }

//   public static void main(String[] args) throws IOException {
//     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//     // StringBuilder sb = new StringBuilder();
//     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//     pq = new PriorityQueue<>();
    
//     N = Integer.parseInt(br.readLine());

//     for (int i = 0; i < N; i++) {
//       pq.offer(new Node(Integer.parseInt(br.readLine()), i));
//     }

//     while(!pq.isEmpty()) {
//       // sb.append(pq.poll().num).append("\n");
//       Node node = pq.poll();
//       // System.out.println(node.num);
//       bw.write(node.num + "\n");
//     }

//     // System.out.println(sb.toString());
//     bw.flush();
//     bw.close();
//   }
// }
