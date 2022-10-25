package beginner_2_2Review.NM400.nm003.둘x타일링2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
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
 *   2.3. 이 기본 개념을 바탕으로 1.1에서 입력 받은 값 까지 DP 결과를 아래의 트리에서 부터 연산한다.
 * 
 * 
  *  * */

public class Solved {
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
	
		for(int i=3; i<=num; i++) {
			System.out.printf("dp[%d] = (dp[%d] + dp[%d]*2)%%10007  = %d + %d \n",i,i-1,i-2,dp[i-1],dp[i-2]);
			
			dp[i] = (dp[i-1] + dp[i-2]*2)%10007;
		}
		
		System.out.println(dp[num]);
	}
}