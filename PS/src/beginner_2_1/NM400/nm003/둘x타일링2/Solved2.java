
package beginner_2_1.NM400.nm003.둘x타일링2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 문제
 * URL :https://www.acmicpc.net/problem/11727
 * 
 * 1. 입력부
 *   1.1. 입력 받은 숫자 받아와 Integer로 변환한다..
 *   
 * 2. 로직
 *   2.1. DP 결과 값을 담을 배열을 생성한다.
 *   2.1. f(n) = f(n-1)+ f(n-2)*2이다.
 *   2.2. f(1) = 1 이다.
 *   2.3. f(2) = 3 이다.
 *   
 *   이번엔 반대로 위에서 아래로 내려가는 방향으로 진행
 * 
 * 
  *  * */

public class Solved2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 1. 입력부
		int num = Integer.parseInt(scan.readLine());
								// 가장 큰 수를 확인하는 변수
		//로직
		//dp 생성
		int[] dp = new int[num+2];
		
		dp[1] = 1;
		dp[2] = 3;
		
		int result = re(num, dp)%10007;
		
		System.out.println(result);
	
		
	}
	static int re(int num, int[] dp) {
		if(dp[num]!=0) return dp[num];								//출구 조건
		System.out.println("f("+num+")");
		System.out.println("db result");
		for(int i: dp) {
			System.out.print(i+" ");
		}
		System.out.println();
		return dp[num] = re(num-1, dp)+2*re(num-2,dp);		//점화식과 동시에 DP 생성
	}
	
}