import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SWEA_1221_GNS {
  public static int len;
  public static String[] input;
  public static int[] cnt;
  public static HashMap<String, Integer> stringToint;
  public static HashMap<Integer, String> intTostring;

  public static void initStringToint(){
    stringToint= new HashMap<>();
    stringToint.put("ZRO", 0);
    stringToint.put("ONE", 1);
    stringToint.put("TWO", 2);
    stringToint.put("THR", 3);
    stringToint.put("FOR", 4);
    stringToint.put("FIV", 5);
    stringToint.put("SIX", 6);
    stringToint.put("SVN", 7);
    stringToint.put("EGT", 8);
    stringToint.put("NIN", 9);
  }

  public static void initIntTostirng(){
    intTostring = new HashMap<>();
    intTostring.put(0, "ZRO");
    intTostring.put(1, "ONE");
    intTostring.put(2, "TWO");
    intTostring.put(3, "THR");
    intTostring.put(4, "FOR");
    intTostring.put(5, "FIV");
    intTostring.put(6, "SIX");
    intTostring.put(7, "SVN");
    intTostring.put(8, "EGT");
    intTostring.put(9, "NIN");
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    int TC = Integer.parseInt(br.readLine());
    for (int t = 1; t <= TC; t++) {
      st = new StringTokenizer(br.readLine());
      st.nextToken(); // #1 넘기기
      len = Integer.parseInt(st.nextToken()); 

      cnt = new int[10];  // 0 ~ 9
      initIntTostirng();
      initStringToint();

      st = new StringTokenizer(br.readLine(), " ");
      
      for (int i = 0; i < len; i++) {
        cnt[stringToint.get(st.nextToken())]++;
      }


      // System.out.println();
      // for (int i = 0; i < 10; i++){
      //   // System.out.print(input[i] + "\t");
      //   System.out.print(cnt[i] + "\t");
      // }
      sb.append("#").append(t).append("\n");
      for (int i = 0; i < 10; i++) {
        for (int j = 0; j < cnt[i]; j++) {
          sb.append(intTostring.get(i)).append(" ");
        }
      }
      // sb.append("\n");
    } 
    System.out.println(sb);
  }
}

// ZRO ONE TWO THR FOR FIV SIX SVN EGT NIN  
