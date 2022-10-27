package beginner_2_2Review.NM400.nm001.하나로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
/*
 * 문제
 * URL :https://www.acmicpc.net/problem/1463
 * 
 * 1. 입력부
 *   1.1. 입력 받은 숫자 받아와 Integer로 변환한다..
 *   
 *   
 *  2. 로직
 *    2.1. 우선 dp를 담을 배열을 생성한다.
 *    2.2. 1은 무조건 0번만에 된다.
 *    2.3. 2는 무조건 1번만에 된다.
 *    2.4. 3은 무조건 1번만에 된다.
 *    		=> 이 상기 3가지를 가장 하단의 트리값으로 상정하고 트리를 전개한다.
 *    		=> 입력부에서 받은 값 만큼 전개한다.
 *    2.5. 1이상의 모든 수는 n-1의 경우를 가지고 있다.
 *    		=> 트리 전개할 때 이 수를 기본으로 받아준다.
 *    2.6. x>=2일 때 연산을 마친 모든 숫자들은 x-y 이하의 수들로 이루어진다. (y<x)
 *    		=> 이미 연산이 끝난 값들을 dp에 저장하여 연산할 필요가 없이 바로 가져온다.
 *    		=> 이 때 바로 받아온 값들의 수를 비교하여 가장 작은 수를 골라낸다 -> 가장 최선의 수!
 *    2.7. 4이상의 값들은 무조건 한번의 연산을 필요로 한다.
 *    		=> dp에서 값을 가져오고 1씩 더해준다.
 *    
 *  3. 출력
 *    3.1. 2.에서 연산을 마친 값을 가져온다.
  *  * */

public class Solved {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 1. 입력부
		int num = Integer.parseInt(scan.readLine());
								// 가장 큰 수를 확인하는 변수
		
		int[] dp = new int[(int) Math.pow(10, 6) +1];
		
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		
		//입력부에서 받은 값 만큼 전개한다.
		for(int i=4; i<=num; i++) {
			System.out.printf("===============f(%d)로직 진입===============\n", i);
			
			//1이상의 모든 수는 n-1의 경우를 가지고 있다.
			int result = dp[i-1];
			int result2 =0;						//%2==0일 때 출력용 변수. 나눠지지 않는다면 0, 나눠진다면 dp[i/2] 값을 출력한다.
			int result3 =0;						//%3==0일 때 출력용 변수. 나눠지지 않는다면 0, 나눠진다면 dp[i/3] 값을 출력한다.
			
			
			if(i%2==0) {
				result2 = dp[i/2]; 
				result = result>dp[i/2] ? dp[i/2] : result;
			}

			if(i%3==0) {
				result3 = dp[i/3];
				result = result>dp[i/3] ? dp[i/3] : result;
			}
			
			System.out.printf("f(%s) : f(%s) : f(%s) = %d : %d : %d (결과값이 0이면 2 || 3로 나누었을 떄 나누어 떨어지지 않는다.) \n", i+"-"+1, i+"/"+2, i+"/"+3, dp[i-1], result2, result3);
			
			//dp에서 값을 가져오고 1씩 더해준다.
			dp[i] = result+1;
			System.out.printf("f(%d) = %d \n", i, dp[i]);
		}
		
		System.out.println(dp[num]);
	}
}