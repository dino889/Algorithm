import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 홀수만더하기 {
	public static int[] input = new int[10];
	
	public static int solve() {
		int res = 0;
		
		for (int i = 0; i < input.length; i++) {
			if(input[i] % 2 == 1) {
				res += input[i];
			}
		}
		
		return res;
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
			
			
			sb.append("#").append(t).append(" ").append(solve()).append("\n");
		}
		System.out.println(sb);
	}
}
