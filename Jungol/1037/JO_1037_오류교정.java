import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.concurrent.ArrayBlockingQueue;

public class JO_1037_오류교정 {
	
	public static int n;
	public static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];	// 각각의 행과 열은 1부터 시작한다.
		
		int[] rSum = new int[n+1];
		int[] cSum = new int[n+1];
		
		
		for (int i = 1; i < n+1; i++) {	// 1 ~ n
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
//				rSum[i] += arr[i][j];
//				cSum[i] += arr[j][i];
			}
		}


		for (int i = 1; i < n+1; i++) {	// 1 ~ n
			for (int j = 1; j < n+1; j++) {
				rSum[i] += arr[i][j];
				cSum[i] += arr[j][i];
			}
		}
		
		int r = 0, c = 0, rCnt = 0, cCnt = 0;
		
		for (int i = 1; i < cSum.length; i++) {
			if(rSum[i] % 2 != 0) {
				r = i;
				rCnt++;
			}
			if(cSum[i] % 2 != 0) {
				c = i;
				cCnt++;
			}
		}
		
		if(r == 0 && c == 0) {
			sb.append("OK").append("\n");
		}
		else if(r != 0 && c != 0  && (rCnt == 1 && cCnt == 1)) {
			sb.append("Change bit (").append(r).append(",").append(c).append(")").append("\n");
		}
		else {
			sb.append("Corrupt").append("\n");
		}

		
		System.out.println(sb);
		
	}
}

//	ArrayList<Integer> vertical = new ArrayList<Integer>();		
//	ArrayList<Integer> horizontal = new ArrayList<Integer>();
//	
//	for (int i = 1; i < n+1; i++) {	// 1 ~ n
//		int sumRow = 0;
//		int sumCol = 0;
//		
//		
//		for (int j = 1; j < n+1; j++) {
//			rSum[i] += arr[i][j];
//			cSum[i] += arr[j][i];
//		}
//		if(sumRow % 2 == 1) horizontal.add(i);
//		if(sumCol % 2 == 1) vertical.add(i);
//	}
//	
//	int vSize = vertical.size();
//	int hSize = horizontal.size();
//	if(vSize == 0 && hSize == 0) {
//		System.out.println("OK");
//	} else if(vSize == 1 && hSize == 1) {
//		System.out.println(horizontal.get(0) + 1, vertical.get(0)+1);
//	} else {
//		System.out.println("Corrupt");
//	}

