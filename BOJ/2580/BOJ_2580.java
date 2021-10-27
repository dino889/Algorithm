import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2580 {
  private static int N;
  private static int[][] sudoku;
  private static List<Node> list;
  
  private static class Node{
    int x, y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  private static boolean check(int x, int y, int idx) {
    for(int i = 0; i < N; i++) {
      if(sudoku[x][i] == idx || sudoku[i][y] == idx) {
        return false;
      }
    }
    for (int i = (x / 3) * 3; i < (x / 3) * 3 + 3; i++) {
      for (int j = (y / 3) * 3; j < (y / 3) * 3 + 3; j++) {
        if(sudoku[i][j] == idx) {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean dfs(int idx) {
    if(idx == list.size()) return true;
    
    Node node = list.get(idx);
    int x = node.x; // i
    int y = node.y; // j
    for (int i = 1; i <= N; i++) {
      if(check(x, y, i)) {
        sudoku[x][y] = i;
        if(dfs(idx + 1)) {
          return true;
        }
        sudoku[x][y] = 0;
      }
    }
    return false;
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    StringBuilder sb = new StringBuilder();
    N = 9;
    sudoku = new int[N][N];
    list = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        sudoku[i][j] = Integer.parseInt(st.nextToken());
        if(sudoku[i][j] == 0) {
          list.add(new Node(i, j));
        }
      }
    }

    dfs(0);
    System.out.println("-------------------------------");
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        sb.append(sudoku[i][j]).append(" ");
        // System.out.print(sudoku[i][j] + " ");
      }
      sb.append("\n");
      // System.out.println();
    }
    System.out.println(sb.toString());

    
  }
}