package beginner_2_1.NM400.nm004.하나둘셋더하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
/*
 * 문제
 * URL :https://www.acmicpc.net/problem/9095
 * 
 * 1. 입력부
 *   1.1. 입력 받은 숫자 받아와 Integer로 변환한다
 *   1.2. 1.1. 에서 받은 값 만큼 배열 생성
 *   1.3. 1.1. 숫자만큼 for문을 돌려 숫자를 받아온 뒤 배열에 저장
 *   1,4. 받아온 값중 가장 큰 값을확인한다. -> 로직에서 기준이 되는 값.
 *   
 * 2. 로직
     2.1. 가장 큰 만큼 배열 생성 -> dp 배열
     2.2. 가장 큰 값까지만 연산 진행.
     2.2. 이번 풀이는 하향으로 내려간다.
 *     - f(1) = 1 이다.
 *     - f(2) = 2 이다.
 *     - f(3) = 4 이다.
 *     - f(4) = 7
 *     - f(5) = 13 
 *     - 점화식 f(n) = f(n-3) + f(n-2) + f(n-1)
 *   2.3. 1부터 가장 큰 값까지 연산하는 방식으로 진행
 *   
 * 3. 출력부
 *   3.1. 입력된 값들을 for문을 사용하여 빼오고 이 값의 계산값을 dp에서 가져와 출력
 *   
 * 
 * 
 * 이전에 풀었던 방향과 동일
  *  * */

public class Solved2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 1. 입력부
		int num = Integer.parseInt(scan.readLine());		// 가장 큰 수를 확인하는 변수
		
		//입력 값 받을 배열 생성
		int[] input = new int[num];
		int maximum = 0;
		
		for(int i =0; i<num; i++) {
			input[i] = Integer.parseInt(scan.readLine());
			if(input[i]>maximum) {
				maximum=input[i];
			}
		}
		
		//로직
		//dp 생성
		int[] dp = new int[maximum+2];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
	
	
		
		for(int x : input) {
			System.out.println(re(x, dp));
		}
		
	}
	
	static int re(int num, int[] dp) {
		if(dp[num]!=0) return dp[num];
		return dp[num] = re(num-3, dp) + re(num-2, dp) + re(num-1, dp);
	}
}