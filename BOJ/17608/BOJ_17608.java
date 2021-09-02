import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17608 {
	public static int N, cnt, max;
	public static int[] input;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		max = input[N -1];
		cnt = 1;	// 보이는 막대기 포함
		for (int i = N - 2; i >= 0; i--) {
			if(input[i] > max) {
				max = input[i];	// 최대값 갱신 	- 최대값 이후에 기준보다 크고 최대값보다 작은 수가 있을 수도 있음.
				cnt++;
			}
		}
//		sb.append(cnt);
		System.out.println(cnt);
	}
	
}
