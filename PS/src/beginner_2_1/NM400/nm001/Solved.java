package beginner_2_1.NM400.nm001;

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
 * 2. 로직
 * 숫자는 어떻게 이루어져 있는가?
 *   2.1. 입력받은 값이 1이 될 때 까지 검증 로직을 돌린다.
 *   2.1. 받아온 값이 2,3 으로 나뉘어지는지 확인하고 만약 그렇지 않다면 1을 빼준다. 그 
 *   2.2. 만약 나뉘어진다면 2,3으로 값으로 나누어 값이 나뉘어지지않을 때 까지 입력받은 값을 나누어준다.
  *  * */

public class Solved {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 1. 입력부
		int num = Integer.parseInt(scan.readLine());
								// 가장 큰 수를 확인하는 변수
		
		// 2. 로직
		int cnt = 0;
		while(num!=1) {
			if(num%2!=0 && num%3!=0) {
				--num;
				++cnt;
				continue;
			}
			
			while(num%2==0) {
				num/=2;
				++cnt;
			}
			
			
			while(num%3==0) {
				num/=3;
				++cnt;
			}
		}
		System.out.println(cnt);
	}
}