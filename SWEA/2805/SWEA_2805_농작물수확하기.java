import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_2805_농작물수확하기 {
	public static int[][] arr;
	public static int N;
	
	public static int solve() {
		int result = 0;
		int center = N/2;
		// 중앙 (N/2, N/2)
		
		// i      j
		// 0      2(center)
		// 1    1 2 3
		// 2  0 1 2 3 4		//i까지 빼기
		// 3    1 2 3
//		// 4      2
//		for (int i = 0; i <= center; i++) {
//			for (int j = center - i; j <= center + i; j++) { // i == 0 j == 2
//				result += arr[i][j];
//			}
//		}
//		
//		for (int i = center + 1; i < N; i++) {
//			for (int j = i - center; j < i; j++) { // i == 3 j == 1, 2, 3
//				result += arr[i][j];
//			}
//		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = center - cnt; j <= center + cnt; j++) {
				result += arr[i][j];
			}
			if( i >= center) {
				cnt--;
			} else {
				cnt++;
			}
		}
		
//		int b = 0; int begin, end, gap = 0;
//		for (int i = 0; i < arr.length; i++) {
//			begin = center - gap;
//			end = center + gap;
//			for (int j = begin; j <= end; j++) {
//				b += arr[i][j];
//			}
//			if(i < center) gap++;
//			else gap--;
//		}
		
		
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N][N];
			String[] str;
			for (int i = 0; i < N; i++) {
				str = br.readLine().split("");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(str[j]);
				}
			}
			
			
			
			
			sb.append("#").append(t).append(" ").append(solve()).append("\n");
		}
		System.out.println(sb);
	} 
	
	

}
