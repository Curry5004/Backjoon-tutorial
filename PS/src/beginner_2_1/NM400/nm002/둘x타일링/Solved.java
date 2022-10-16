package beginner_2_1.NM400.nm002.둘x타일링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
/*
 * 문제
 * URL :https://www.acmicpc.net/problem/11726
 * 
 * 1. 입력부
 *   1.1. 입력 받은 숫자 받아와 Integer로 변환한다..
 *   
 * 2. 로직
 *   2.1. DP 결과 값을 담을 배열을 생성한다.
 *   2.1. f(n) = f(n-1)+ f(n-2)이다.
 *   2.2. f(1) = 1 이다.
 *   2.3. f(2) = 2 이다.
 *   2.3. 이 기본 개념을 바탕으로 1.1에서 입력 받은 값 까지 DP 결과를 아래의 트리에서 부터 연산한다.
 * 
 * 
 * 3. 에러 리포트
 *   3.1. 1을 넣을 떄 ArrayIndexOutOfBoundsException 발생
 *     -> dp[2] 넣는 과정에서 에러가 발생 dp 생헝할 때 num+1가 아니라 num+2로 함으로써 해결
 *     -> 결과 : 해결
 *   3.2. 문제가 틀렸다고 출력.
 *     -> dp에서 모든 값을 구하고 마지착 출력 부분에서 dp[num]%10007로 풀었었는다. 이 떄 dp[num]의 값이 너무 커서 overflow가 발생하는 것 아닐까?
 *     -> dp에 입력할 때 모든 값을 넣는 것이 아니라 아예 %10007 연산을 넣고 하는 방향으로 진행해보자
 *     -> 결과 :해결
 *     
 *     
 *     
 *  여러 모범답안을 찾아보았으나 해당 방식과 동일한 방향으로 문제풀이를 진행하여 AnotherExample은 생략한다.   
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
		dp[2] = 2;
	
		for(int i=3; i<=num; i++) {
			
			dp[i] = (dp[i-1] + dp[i-2])%10007;
		}
		
		System.out.println(dp[num]);
	}
}