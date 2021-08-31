import java.util.Arrays;

class Solution {
	
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;    
        // 전체인원 - 체육복 잃어 버린 사람 -> 남에게 빌려줄 수 있거나, 본인 체육복이 있거나 

        Arrays.sort(lost);
        Arrays.sort(reserve);

        // lost 배열 값과 reserve 배열 값이 같으면 체육복을 빌려줄 수 없는 상태(값 = -1)로 만든다.
        // 본인이 입어야하기 때문에 lost, reserve 둘 다 -1로 set
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] == reserve[j]){
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++;   // 본인이 입었으니 체육수업을 들을 수 있는 학생 수 + 1
                    break;
                }
            }
        }


        // lost 배열 값의 앞 뒤 숫자가 reserve 배열에 있으면
        // 다른 사람이 빌릴 수 없는 상태(값 = -1)로 만든다.
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                    reserve[j] = -1;    // 빌려줬음을 체크
                    answer++;
                    break;
                }

            }
        }


        return answer;
    }
}