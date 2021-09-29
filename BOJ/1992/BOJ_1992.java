import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992 {
	
	private static int[][] img;		// 흑백 이미지
	private static StringBuilder sb = new StringBuilder();

  private static void QuadTree(int x, int y, int size) {
		
		if(isPossible(x, y, size)) {
			sb.append(img[x][y]);
			return;
		}
		
		int newSize = size / 2;	
		
		sb.append('(');
		
		QuadTree(x, y, newSize);			
		QuadTree(x, y + newSize, newSize);	
		QuadTree(x + newSize, y, newSize);	
		QuadTree(x + newSize, y + newSize, newSize);
		
		sb.append(')');

	}
	
	
	private static boolean isPossible(int x, int y, int size) {
		int value = img[x][y];
		
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if(value != img[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		img = new int[N][N];	
        
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for(int j = 0; j < N; j++) {
				img[i][j] = str.charAt(j) - '0';
			}
		}
		
		QuadTree(0, 0, N);
		System.out.println(sb.toString());
	}
}