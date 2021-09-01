import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_10163 {
	static int[][] arr;
	static int N;
	static int x, y, w, h;
	static int result;
	
	static Scanner sc = new Scanner(System.in);
	
	public static void input() {
		x = sc.nextInt();
		y = sc.nextInt();
		w = sc.nextInt();
		h = sc.nextInt();
	}
	
	public static void solve() {
		
		for (int t = 1; t <= N; t++) {
			
			input();
			
			if(w == 1 && h == 1) {
				System.out.println(1);
				continue;
			}
			
			for (int i = x; i < x + w; i++) {
				for (int j = y; j < y + h; j++) {
					arr[i][j] = t;
				}
			}
		}
		

		for (int t = 1; t <= N; t++) {
			
			result = 0;
			
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if(arr[i][j] == t) {
						result++;
					}
				}
			}
			System.out.println(result);
		}
	}
	
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringBuilder sb = new StringBuilder();
//		StringTokenizer st;
		
		N = sc.nextInt();	// 색종이의 장수
		
		if(N == 1) {
			input();
			System.out.println(w * h);
		}
		else if(N <= 10) {
			arr = new int[101][101];
			solve();
		}
		else {
			arr = new int[1001][1001];
			solve();
		}
	}
}
