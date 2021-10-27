import java.util.Stack;
import java.util.StringTokenizer;

public class 다트게임 {

  
  // 점수|보너스|[옵션] - * || # || 없음.
  //Single(S), Double(D), Triple(T)
  public static int solution(String dartResult) {
    int answer = 0;
    dartResult = dartResult.replace("10", "P");
    int tmp = 0;  // 임시 결과
    int num = 0;  // 숫자

    char[] dart = dartResult.toCharArray();
    Stack<Integer> stack = new Stack<>();
    
    for (int i = 0; i < dart.length; i++) {
      char c = dart[i];
      if(c >= 48 && c <= 57 || c == 'P') {  // c가 숫자이면 0 ~ 9
        if(c == 'P') {
          num = 10;
        } else {
          num = c - '0';
        }
        stack.push(num);
      }
      if(c == 'S' || c == 'D' || c == 'T') {
        tmp = stack.pop();
        switch(c){
          case 'S':
            tmp = (int) Math.pow(num, 1);
            // stack.push(tmp);
            break;

          case 'D':
            tmp = (int) Math.pow(num, 2);
            // stack.push(tmp);
            break;

          case 'T':
            tmp = (int) Math.pow(num, 3);
            // stack.push(tmp);
            break;
        }
        stack.push(tmp);
      }
      if(c == '*' || c == '#') {
        switch(c) {
          case '*' :
            if(stack.size() == 1) { // *이 1개만 나온 경우
              tmp = stack.pop() * 2;
              stack.push(tmp);
            } else {
              tmp = stack.pop() * 2;
              int tmp2 = stack.pop() * 2;
              stack.push(tmp2);
              stack.push(tmp);
            }
            break;
            
          case '#' :
            tmp = stack.pop() * -1;
            stack.push(tmp);
            break;
        }
      }
    }
    while(!stack.isEmpty()){
      answer += stack.pop();
    }

    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution("1S2D*3T"));
    System.out.println(solution("1D2S#10S"));
    System.out.println(solution("1D2S0T"));
    System.out.println(solution("1S*2T*3S"));
    System.out.println(solution("1D#2S*3S"));
    System.out.println(solution("1T2D3D#"));
    System.out.println(solution("1D2S3T*"));
    System.out.println(solution("10S10S10S"));
  }
}



// char[] dartResultC = dartResult.toCharArray();
    // // StringTokenizer st = new StringTokenizer(dartResult, "");
    
    // for (int i = 1; i < dartResultC.length; i++) {
    //   int num = 0;
    //   if(dartResultC[i] == 'S' || dartResultC[i] == 'D' || dartResultC[i] == 'T') {
    //     if(dartResultC[i] == '0' && dartResultC[i - 1] == '1') {
    //       num = 10;
    //     } else {
    //       num = dartResultC[i - 1] - '0';
    //     }
    //     if(i + 1 != dartResultC.length) {
    //       if(dartResultC[i + 1] == '*') {
    //         switch(dartResultC[i]) {
    //           case 'S' :
    //             tmp = (int) Math.pow(num, 1);
    //             break;
    //           case 'D' :
    //             tmp = (int) Math.pow(num, 2);
    //             break;
    //           case 'T' :
    //             tmp = (int) Math.pow(num, 3);
    //             break;
    //         }
    //         tmp *= 2;
    //         answer += tmp;

    //       } else if(dartResultC[i + 1] == '#') {
    //         switch(dartResultC[i]) {
    //           case 'S' :
    //             tmp = (int) Math.pow(num, 1);
    //             break;
    //           case 'D' :
    //             tmp = (int) Math.pow(num, 2);
    //             break;
    //           case 'T' :
    //             tmp = (int) Math.pow(num, 3);
    //             break;
    //         }
    //         tmp *= -1;
    //         answer += tmp;

    //       }
    //     }

    //   }
      
    // }