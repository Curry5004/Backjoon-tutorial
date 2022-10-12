package beginner_2_1.NM300.nm008.factorialCount0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
/*
 * 모범 답안.
 * URL :https://st-lab.tistory.com/165
 * 
 * 차이점
 * 1) 2 * 5 곱하였을 때 뒷자리가 0이 나오는 성질을 이용하여 문제풀이를 진행한다.
 * 
 * 로직
 * 주요 목표 :  N!에서 2와 5의 갯수를 구한다.
 * 2) 1*2*3*4*...(n-1)*(n)이 될 떄 각 n번쨰 순서의 값에 5가 몇번 들어갔는지를 확인한다.
 * 3) N! 팩토리얼의 값을 하나씩 가져온다.
 * 4) 가져온 값을 나머진 연산자로 사용하여 5로 나누어준다. 
 * 5) n%5의 값이 0이 되지 않을떄 까지 연산하여 해당 값에 있는 5의 곱의 갯수를 구한다.
 * 6) 연산이 끝난 뒤 5의 곱의 갯수를 파악하여 0의 갯수를 파악한다. 
 * 
 *  * */

public class Refactoring {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 1. 입력부
		int num = Integer.parseInt(scan.readLine());
		
		
		// 2. 로직
		int cnt = 0; 						//5의 곱의 수가 들어갈 변수;
		
		//N!에서 n번쨰 값을 for문을 통하여 하나씩 받아온다.
		for(int i = 1; i<=num; i++) {
			int element = i;				//N번째 요소 
			
			while(element%5==0) {			//목적 : n번쨰 값에 5의 배수가 들어있는가?
				++cnt;
				element = element/5;
			}
		}
		
		System.out.println(cnt);
		
	}
}