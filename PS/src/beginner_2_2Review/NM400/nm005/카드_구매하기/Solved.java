package beginner_2_2Review.NM400.nm005.카드_구매하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
/*
 * 문제
 * URL : https://www.acmicpc.net/problem/11052
 * 
 * 1. 입력부
 *   1.1. 입력 받은 숫자 받아와 Integer로 변환한다
 *   1.2. 두번쨰로 받아온 숫자의 String 값으로 받아온다
 *   1.3. 숫자의 길이만큼의 배열을 만든다. 이 때 만드는 배열은 카드팩 (Pn) 배열이 된다.
 *   1.4. Pn 배열에 1.2. 에서 받아아온 배열을 Integer로 바꿔서 넣어줌으로써 Pn의 값을 할당한다.
 *   
 * 2. 로직
 *   - 규칙성 그림 참고
 *   2.1. 이중 for문을 구한다. 하나는 f(n)을 순환시키고 하나는 Pn을 순환시킨다. Pn에서 n 값이 증가하면 f(n)의 n값은 줄어든다.
 *   2.2. 이 떄 Pn 에서 n은 f(n)에서 n보다 클 수 없다.
 *   2.3. 크기 비교 변수를 넣어서 가장 큰 값을 구한 뒤 기존에 저장되어있는 dp와 비교한다.
 *   2.4. 만약 비교변수가 더 크면 dp와 바꾸고 그렇지 않으면 통과시킨다.  
 * 
 * 
 * 3.출력부
 *   3.1. 로직에서 끝낸 dp에서 1.1. 값을 넣고 출력시킨다.
 * 
 * 
  *  * */

public class Solved {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 1. 입력부
		int num = Integer.parseInt(scan.readLine()); // 가장 큰 수를 확인하는 변수

		// 입력 값 받을 배열 생성
		int[] price = new int[num + 1]; // 숫자의 길이만큼의 배열을 만든다. 이 때 만드는 배열은 카드팩 (Pn) 배열이 된다.
		String[] input = scan.readLine().split(" "); // 두번쨰로 받아온 숫자의 String 값으로 받아온다
		for (int i = 1; i <= num; i++) { // Pn 배열에 1.2. 에서 받아아온 배열을 Integer로 바꿔서 넣어줌으로써 Pn의 값을 할당한다.
			price[i] = Integer.parseInt(input[i - 1]);
		}

		int[] dp = new int[num + 1];

		// 2.로직부

		// f(n)용 최상위 for문으로 순환 시킨다.
		for (int i = 1; i <= num; i++) {
			System.out.println("==================================================");
			System.out.println("f(" + i + ") 계산중");
			int price2 = 0;
			for (int x = 1; x <= i; x++) { // 값 비교용 변수
				System.out.println("f("+(i-x)+") + P"+x+" 계산 중");
				price2 = dp[i - x] + price[x]; // Pn에서 n 값이 증가하면 f(n)의 n값은 줄어든다.
				System.out.println("f("+(i-x)+") + P"+x+" = "+price2+" | 현재까지 적용된 dp["+i+"] = "+dp[i]);
				if (price2 > dp[i]) { // 가장 큰 값을 확인할 수 있도록 If문을 사용하여 검증
					dp[i] = price2; // 큰 값이 존재한다면 dp에 최신화 => 가운대에 for문을 전부 돌리게 되면 f(i) 에서 가장 큰 가격이 dp에 저장된다.
				}
			}
			System.out.println("f(" + i + ")의 최대값은 " + dp[i]);
			System.out.println("==================================================");
		}

		// 3. 출력부
		System.out.println(dp[num]); // 연산이 완료된 dp[num]의 값을 출력시킨다.
	}
}