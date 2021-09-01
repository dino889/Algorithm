import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_10912 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			char[] s = br.readLine().toCharArray();
			int[] chk = new int['z' + 1];
			for (int i = 0; i < s.length; i++) {
				chk[s[i]]++;
			}
			StringBuilder ans = new StringBuilder();
			for (int i = 'a'; i <= 'z'; i++) {
				if(chk[i]%2 != 0)
				ans.append(Character.toString(i));
			}

			if(ans.length() == 0)
				sb.append("#").append(t).append(" ").append("Good").append("\n");
			else
			sb.append("#").append(t).append(" ").append(ans).append("\n");

			
		}
		System.out.println(sb);
	}

}
