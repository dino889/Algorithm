
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOJ_2108_통계학 {
	public static int N;
	public static int[] input;
	public static int[] cnt;
	
	public static int mode() {
		List<Integer> list = new ArrayList<>();
		int max = 0;
		for (int i = 0; i < 8001; i++) {
			max = Math.max(max, cnt[i]);
		}
		for (int i = 0; i < 8001; i++) {	// 최빈값이 여러 개인 경우 체크
			if(max == cnt[i]) {
				list.add(i - 4000);
			}
		}
		
		if(list.size() == 1) // 최빈 값이 1개라면
			return list.get(0);
		else {
			Collections.sort(list);
			return list.get(1);	// 최빈 값이 여러 개인 경우 두번째로 작은 값
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		if(N == 1) {
			int num = Integer.parseInt(br.readLine());
			sb.append(num).append("\n").append(num).append("\n").append(num).append("\n").append(0);
		}
		else {
			input = new int[N];
			cnt = new int[8001];
			
			double sum = 0;
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(br.readLine());
				sum += input[i];
				cnt[input[i] + 4000]++;	 // 절대값 4000을 넘지 않는다 == -4000 ~ 4000
			}
			sb.append(Math.round(sum /= N)).append("\n");	// 산술평균
			
			Arrays.sort(input);
			sb.append(input[N/2]).append("\n");	// 중앙값
			
			sb.append(mode()).append("\n");
			
			sb.append(input[N-1] - input[0]).append("\n"); // 범위
		}
		
		
		System.out.println(sb);
		
	}

}
