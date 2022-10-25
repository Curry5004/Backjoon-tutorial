package beginner_2_2Review.NM300.nm004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 * 모범 문제
 * URL : https://www.acmicpc.net/source/10081016
 * 
 * 에라토스테네스의 채를 사용하지 않음
 * 
 * 소수의 특성을 이용 => 주된 골짜. 소수는 1과 자기 자신만을 약수를 가진다 = 이 2가지 수 외에 다른 약수를 가지면 이는 소수가 아니다.
 * 
 * 이것을 사용하여 문제를 풀이. 처음에 접근 했던 방식과 유사했던 방식이다.
 * 
 *  * */

public class Main3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(scan.readLine());
		String[] b = scan.readLine().split(" ");
		int ans = 0;

		for (String c : b) {
			int test = Integer.parseInt(c);
			boolean count = true;
			//약수 갯수
			
			//만약 1이 들어오면 바로 통과
			if(test==1) continue;
			
			//1과 자기 자신을 제외하고 약수가 있는가?
			for(int i =2; i<test; i++) {
				if(test%i == 0) {
					count = false;
				}
			}
			
			if(count) {
				++ans;
			}
			
		}

		System.out.println(ans);
	}
}