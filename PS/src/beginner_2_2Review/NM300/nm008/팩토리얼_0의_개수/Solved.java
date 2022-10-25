package beginner_2_2Review.NM300.nm008.팩토리얼_0의_개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
/*
 * 문제
 * URL :https://www.acmicpc.net/problem/1676
 * 
 * 기획
 * 
 * 1. 입력부
 *   1.1. 입력 받은 숫자를 받아온다.
 *   
 * 2. 로직 
 *   2.1. 받은 숫자만큼 팩토리얼로 값은 연산한다.
 *   2.2. 받은 숫자를 String 값으로 변환한다.
 *   2.3. String의 길이를 연산
 *   2.3. indexof를 활용하여 을 찾는다.
 *   2.4. for문을 사용 가감 연산자를 사용하여 0이 나오지 않을 때 까지 반복한다.
 *   2.4. 0이 더이상 나오지 않으면 찾는것을 종결하고 값을 출력한다.
 *   
 *   
 *   에러 리포트
 *   1) overflow 발생
 *     해결책 : int가 아니라 long 타입으로 변경
 *     결과 : long으로 하여도 값을 넘어버린다.
 *     해결책 : 해당 연산값을 받을 수 있는 연산자를 찾아본 결과 BigInteger를 확인. 이를 활용
 *     결과 : 해결
 *   2) indexOf에 대해 확실히 다르게 이해했다
 *     문제점
 *     	 1) 처음 의도
 *       기존 indexOf를 사용하여 index 지점을 뒤에서 부터 진행하여 0을 찾는다
 *       -> 만약 0이 존재한다면 index 값을 하나씩 줄여 index를 줄인다
 *       -> 다시 indexOf를 사용하고 이를 index 값이 0이 아닐 때 까지 반복한다.
 *       -> index값에 0이 아닌 숫자가 오면 indexOf를 사용하였을 때 -1이 나온다.
 *       -> 이 떄 index 값을 기록하여 몇번째 자리까지 0이 있는지 기록한다.
 *       
 *       2) 문제점
 *       -> indexOf는 해당 index 에 찾고자 하는 숫자가 있는지 확인하는 함수가 아니라 index 부터 끝 지점까지 찾아주는 로직으로써 index에 있는 값이 0이 아니더라도 계속해서 로직이 돌아가게 된다.
 *     해결책 : charAt을 index에 원하는 값이 있는지 확인한다.
 *     결과 : 해결
 *     
 *     
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
		
		// 2. 로직
		BigInteger multi = new BigInteger("1");					//정답 변수 선정
			
		//for문을 통하여 연산 진행
		for(int i=1; i<=num; i++) {
			//팩토리얼로 곱하여준다.
			multi = multi.multiply(BigInteger.valueOf(i));
		}
		
		//String으로 값을변경
		String numStr = multi.toString();
		
		int len = numStr.length();		//String의 길이를 연산.
		int ans = 0;					//정답
		
		for(int i = len-1; i>0; i--){
			if(numStr.charAt(i)!='0') {
				break;
			}
			++ans;
		}
		
		System.out.println(ans);
		
	}
}