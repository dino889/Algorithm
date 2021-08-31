import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 평균값구하기 {

	public static int[] input = new int[10];
	
	public static double solve() {
	
		double avg = 0;
		for (int i = 0; i < input.length; i++) {
			avg += input[i];
		}
		
		return avg / 10;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= TC; t++) {
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < input.length; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			sb.append("#").append(t).append(" ").append(Math.round(solve())).append("\n");
			
		}
		System.out.println(sb);
		
	}
}
