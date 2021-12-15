import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @num 1259
 * @title 팰린드롬수
 * @author Jiwoo Choi
 * @date 21.12.15.
 */

public class BOJ_1259 {
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while(true) {
      String input = br.readLine();
  
      if(Integer.parseInt(input) == 0) {
        break;
      }
  
      char[] tmp = input.toCharArray();
  
      String comp = "";
      for (int i = tmp.length - 1; i >= 0; --i) {
        comp += tmp[i];
      }
  
      if(input.equals(comp)) {
        bw.write("yes\n");
      } else {
        bw.write("no\n");
      }
      bw.flush();
    }
    
    bw.close();
    


  }
}
