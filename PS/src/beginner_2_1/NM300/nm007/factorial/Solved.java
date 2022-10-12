package beginner_2_1.NM300.nm007.factorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/*
 * 문제
 * URL :https://www.acmicpc.net/problem/10872
 * 
 * 기획
 * 
 * 1. 입력부
 *   1.1 하나의 숫자만 들어온다. 입력과 동시에 Integer로 파서.
 *   
 * 2. 로직
 *   2.1. 입력된 값이 0이면 1을 리턴
 *   2.2. for문을 사용하여 연산 진행
 *   2.3. 증감 연산자를 사용하여 숫자를 곱함
 * 
 *  * */

public class Solved {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 1. 입력부
		int num = Integer.parseInt(scan.readLine());
		
		
		// 2. 로직
		int multi = 1;					//정답 변수 선정
			
		//for문을 통하여 연산 진행
		for(int i=1; i<=num; i++) {
			//팩토리얼로 곱하여준다.
			multi = multi * i;
		}
		System.out.println(multi);
		
	}
}