package beginner_2_1.NM300.nm003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		
		//값 입력
		int operCnt = Integer.parseInt(scan.readLine());
		// 값 저장할 배열 설정
		int[][] reqArr = new int[operCnt][2];
		
		
		//for문 2개 사용
//		for(int i =0; i<operCnt; i++) {
//			String req = scan.readLine();
//			String[] reqArr2 = req.split(" ");
//			reqArr[i][0] = Integer.parseInt(reqArr2[0]);
//			reqArr[i][1] = Integer.parseInt(reqArr2[1]);
//		}
//		
//		for(int i = 0; i<operCnt; i++) {
//			int c = div(reqArr[i][0], reqArr[i][1]);
//			System.out.println((reqArr[i][0]*reqArr[i][1])/c);
//		}
		
		//for문을 1개 사용
		String ans = "";
		
		for(int i = 0 ; i<operCnt; i++) {
			String req = scan.readLine();
			String[] reqArr2 = req.split(" ");
			reqArr[i][0] = Integer.parseInt(reqArr2[0]);
			reqArr[i][1] = Integer.parseInt(reqArr2[1]);
			int c = div(reqArr[i][0], reqArr[i][1]);
			ans = ans + Integer.toString((reqArr[i][0]*reqArr[i][1])/c) + "\n";
		}
		
		System.out.print(ans);
	}
	
	public static int div(int a, int b) {
		if(a<b) {
			int c = a;
			a = b;
			b = c;
		}
		
		//동일하게 재귀함수 적용
		if(b==0) {
			return a;
		}
		
		return div(b, a%b);
	}
}
