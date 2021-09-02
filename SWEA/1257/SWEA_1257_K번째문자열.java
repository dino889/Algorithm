import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;


public class SWEA_1257_K번째문자열 {
  public static int K;
  public static String str, result;
  public static List<String> word;
  public static TreeSet<String> distinctData;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int TC = Integer.parseInt(br.readLine());

    for (int t = 1; t <= TC; t++) {

      K = Integer.parseInt(br.readLine());

      str = br.readLine();
      
      distinctData =new TreeSet<String>();

      int len = str.length();
      for (int i = 0; i < len + 1; i++) {
        for (int j = i; j < len + 1; j++) {
          distinctData.add(str.substring(i, j));
        }
      }
      // TreeSet<String> distinctData =new TreeSet<String>(word);
      // word.clear();
      // word.addAll(distinctData);
      word = new ArrayList<>(distinctData);
      // Collections.sort(word);
      // for (String string : distinctData) {
      //   System.out.print(string + "\t");
      // }
      // System.out.println();
      System.out.println(word.size());
      if(K >= word.size()){
        result = "none";
      } else result = word.get(K);

      sb.append("#").append(t).append(" ").append(result).append("\n");
    }
    System.out.println(sb);
  }
  
}
