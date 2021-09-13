import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @title 단어 공부
 * @date 210909
 * @author Jiwoo Choi
 */
public class BOJ_1157 {
  private static char[] input;
  private static int[] cnt;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    input = br.readLine().toUpperCase().toCharArray();  // 입력을 대문자 변환
    cnt = new int[26];  // A ~ Z 크기만큼 count 배열 생성
    for (int i = 0; i < input.length; i++) {
      cnt[(int)input[i] - 65]++; // A -> 65
    }
    
    int idx = 0, max = 0, overlap = 0;
    
    for (int i = 0; i < 26; i++) {
      if(cnt[i] > max){
        idx = i;  // 최대값이 들어있는 배열의 인덱스 저장
        max = cnt[i]; // 최대값
      }
    }

    for (int i = idx; i < 26; i++) {  // 최대값이 들어있는 인덱스 이후에
      if(max == cnt[i]){  // 동일한 최대값이 있다면
        overlap++;
      }
    }

    int value = idx + 65;
    char res = overlap == 1 ? (char)value : '?';

    System.out.println(res);

  }
}
