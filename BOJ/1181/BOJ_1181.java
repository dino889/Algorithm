import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @num 1181
 * @title 단어 정렬
 * @author Jiwoo Choi
 * @date 21.12.15.
 */

public class BOJ_1181 {
  private static int N;
  private static TreeMap<Integer, TreeSet<String>> word;
  

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(br.readLine());
    word = new TreeMap<Integer, TreeSet<String>>();

    for (int i = 0; i < N; i++) {
      String input = br.readLine();
      int len = input.length();

      if(!word.containsKey(len)){
        word.put(len, new TreeSet<String>());
      }
      word.get(len).add(input);
    }

    while(!word.isEmpty()) {
      TreeSet<String> tmp = word.pollFirstEntry().getValue();

      for (String str : tmp) {
        // System.out.println(str);
        sb.append(str).append('\n');
      }
    }

    // for (String str : word) {
    //   sb.append(str).append('\n');
    // }
    
    bw.write('\t' + sb.toString());
    bw.flush();
    bw.close();
  }
}
