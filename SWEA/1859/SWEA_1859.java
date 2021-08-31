import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1859 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			int size = Integer.parseInt(br.readLine());
			int[] arr = new int[size];
			
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
            long sum = 0; // 마진의 누적합을 저장할 변수(최악의 경우 값의 범위를 고려해서 변수타입지정)
            int max = 0; // 매매가의 최대값을 저장할 변수
            for (int i = size-1; i >= 0; i--) { // 뒤에서 부터 시작
                if(max < arr[i]) { // 구매x , 뒤에서 앞으로 갈때 앞에 값이 계속 더 크면 구매 안해야됨
                    max = arr[i];
                } else { // 최대값이 아닌 경우
                    int num = max - arr[i]; // 현재의 마진
                    sum += num; // 누적
                }
            }
            System.out.println("#" + t + " " + sum);
            

			
			
			sb.append("#").append(t).append(" ").append(sum).append("\n");	
		}
		System.out.println(sb);
	}
}

//while(true) {
//	if(index == size - 1) break;	//
//	
//	for(int j = index; j < arr.length; j++) {
//		max = Math.max(max, arr[j]);
//		index = j;
//	}
//	
//	if(max == arr[0]) {
//		sum = 0;
//		break;
//	}
//	else {
//		sum = 0;
//		for(int j = start; j < index; j++) {
//			cnt++;
//			sum += arr[j];
//		}
//		result = (arr[index] * cnt - sum);
//		start = index;
//	}
//	max = 0;
//	
//}