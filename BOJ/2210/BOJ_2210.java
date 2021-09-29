import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ_2210 {
	private static int [][] map;
	private static int[] dx = {-1, 1, 0, 0};
  private static int[] dy = {0, 0, -1, 1};
  private static int [] arr ;
  private static ArrayList<String> list;

  private static void dfs(int x, int y , int depth) {
		//탈출조건
		if(depth > 6) {
			//정답 배열에 있는 정수 뽑아서 스트링으로 변환
			String str = "";
			for(int i = 0 ; i<arr.length; i++) 
				str+= Integer.toString(arr[i]);
			
			
			//리스트에 없다면 넣음(중복 제거)
			if(list.indexOf(str) < 0)
				list.add(str);
			
			return;
		}
		
		
		//depth 6될때까진 배열 채움
		arr[depth-1] = map[x][y];
		
		//동서남북 변수
		for(int i = 0 ; i < 4 ; i ++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			//동서남북 범위 벗어나지않으면 전부 dfs호출
			if(nx>=0 && nx<5 && ny>=0 && ny<5) 
				dfs(nx,ny,depth+1);
			
		}
	}
	public static void main(String[] args ) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		map = new int [5][5]; //맵 상태
		arr= new int [6]; //6자리 정답담는 배열
		//맵 세팅
		for (int i = 0; i < 5; i++) {
      st=new StringTokenizer(br.readLine());
      for (int j = 0; j < 5; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
		
		list = new ArrayList<>();
		for(int i = 0 ; i < 5 ; i++) 
			for(int j = 0 ; j < 5 ; j++) 
      dfs(i,j,1);

		System.out.println(list.size());
	}
}