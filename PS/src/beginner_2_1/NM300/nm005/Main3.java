package beginner_2_1.NM300.nm005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 * 모범
 * URL :https://www.acmicpc.net/source/12599998
 * 
 * 배수로 하여 소수를 제거하는 로직은 동일.
 * 
 * 공통점
 * 1) 우선 2부터 n(최대값) 까지의 모든 소수를 구해준 다음 그 채에서 최소범위와 최대 범위의 내부의 소수를 검증한다.
 * 
 * 차이점 
 * 1) 모든 값을 넣는 공정을 거치지 않고 배열 생성과 Validation을 동시에진행
 * 
 *  * */

public class Main3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] b = scan.readLine().split(" ");

		int start = Integer.parseInt(b[0]);
		int end = Integer.parseInt(b[1]);

		// 자료구조 생성
		boolean[] sie = new boolean[end + 1];

		// 자료 구조에 갑 삽입
//      for(int i=1; i<=end; i++) {
//         sie[i]=1;
//      }

//      sie[1]=0;

		//
		for (int i = 2; i <= end; i++) {
			if (sie[i]) continue;

			if (i >= start) sb.append(i + "\n");

			// 배수 제거
			for (int x = i * 2; x <= end; x += i) {
				sie[x] = true;
			}
		}
		System.out.println(sb);
	}

}