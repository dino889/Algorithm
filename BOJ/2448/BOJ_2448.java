import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node{
  int x, y;

  public Node(int x, int y) {
      this.x = x;
      this.y = y;
  }
}

public class BOJ_2448 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();


    int N = Integer.parseInt(br.readLine());

    char[][] arr = new char[N + 1][N * 2 + 1];

    for(int i = 1; i <= N; i++) {
      for(int j = 1; j <= 2 * N; j++) {
        arr[i][j] = ' ';
      }
    }

    List<Node> list = new ArrayList<>();
    list.add(new Node(1, N));

    int target = N;

    while(true) {
      target = target / 2;
      if(target < 3) {
        break;
      }
        
      int listSize = list.size();
      for(int i = 0; i < listSize; i++) {
        Node v = list.get(i);
        list.add(new Node(v.x + target, v.y - target));
        list.add(new Node(v.x + target, v.y + target));
      }
    }

    for(int i = 0; i < list.size(); i++) {
      Node v = list.get(i);
        
      arr[v.x][v.y] = '*';
      arr[v.x+1][v.y-1] = '*'; arr[v.x+1][v.y+1] = '*';
      for(int j=v.y-2; j<=v.y+2; j++) {
        arr[v.x+2][j] = '*';
      }
    }
    
    for(int i = 1; i <= N; i++) {
      for(int j = 1; j <= 2 * N; j++) {
        if(i==N && j==2*N) {
          break;
        }
      sb.append(arr[i][j]);
      }
      if(i != N) {
        sb.append("\n");    
      }
    }

    System.out.print(sb.toString());    
  }
}