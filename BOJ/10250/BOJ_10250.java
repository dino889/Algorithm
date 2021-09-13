  import java.io.BufferedReader;
  import java.io.IOException;
  import java.io.InputStreamReader;
  import java.util.StringTokenizer;

  public class BOJ_10250 {
    private static int T, H, W, N;
    private static int[][] hotel;
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      StringTokenizer st = null;

      T = Integer.parseInt(br.readLine());
      while(T-- > 0){
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        hotel = new int[H + 1][W + 1];
        int cnt = 0, floors = 0, roomNum = 0;
        for (int i = 1; i < W + 1; i++) {
          for (int j = 1; j < H + 1; j++) {
            if(hotel[j][i] != 1){
              cnt++;
            }
            if(cnt == N){
              hotel[j][i] = 1;
              floors = j;
              roomNum = i;
              break;
            }
          }
        }
        sb.append(floors);
        if(roomNum >= 10) {
          sb.append(roomNum);
        } else { 
          sb.append(0).append(roomNum);
        }
        sb.append("\n");
        // sb.append(floors).append(0).append(roomNum).append("\n");
        System.out.print(sb);
        sb.setLength(0);
      }
    }
    
  }
