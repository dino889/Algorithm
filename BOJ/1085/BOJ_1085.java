import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * @title 직사각형에서 탈출
 * @date 210910
 * @author Jiwoo Choi
 */
public class BOJ_1085 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());
    int h = Integer.parseInt(st.nextToken());
    
    int xx = x < w - x ? x : w - x;
    int yy = y < h - y ? y : h - y;
    System.out.println(xx > yy ? yy : xx);

  }
}