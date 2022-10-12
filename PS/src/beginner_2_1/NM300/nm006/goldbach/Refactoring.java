package beginner_2_1.NM300.nm006.goldbach;

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
 * 모범 문제
 * URL :https://www.acmicpc.net/problem/6588
 * 
 * 공통점 : 
 * 1) 에라토스테네스의 채를 생성하여 소수를 찾아온다.
 * 2) n = a + b 에서 b의 값을 n - a 로 상정하여 접근하는 방식
 * 
 * 차이점 :
 * 1) for문을 돌 때 n회 만큼 돌지 않는다. n/2회 만큼 하여 반절의 값 만큼 비교한다. 
 *   -> Why? i의 값이 n/2 만큼 넘어가면 b-a < a-b 가 되며 a와 b가 자리면 변경되어 검증이 진행되니 이 떄 까지 구현될 필요가 없다.
 *   
 * 
 *  * */

public class Refactoring {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 1. 입력부
		Queue<Integer> que = new LinkedList<>();			// 숫자들을 받을 자료구조 생성
		int endPoint = 1;							// 0이 들어오는 것을 감지할 변수
		int maxNum = 1;								// 가장 큰 수를 확인하는 변수
		
		//endPoint가 0이 되면 while문이 종결되며 입력 로직이 종결된다 (0이 들어오기 전까지 계속해서 값을 받도록 구현한다.)
		while(endPoint!=0) {
			endPoint = Integer.parseInt(scan.readLine());
			que.add(endPoint);
			
			//sta에 쌓이는 수 중 가장 큰 수를 확인하는 로직 (들어온 값 중 가장 큰 값이 어떤 값인지 확인한다)
			if(endPoint>maxNum) {
				maxNum = endPoint;
			}
		}
		
		// 2. 로직
		// 2.1. 에라토네스의 채 생성
		boolean[] sie = new boolean[maxNum+1];			//에라토네스의 채 구현.
		
		
		//가장 입력값이 큰 숫자 까지만 소수를 구한다.
		for (int i = 2; i <= maxNum; i++) {
			if (sie[i]) continue;
			
			// 배수 제거
			for (int x = i * 2; x <= maxNum; x += i) {
				sie[x] = true;
			}
		}
		
		
		//sta의 값을 poll 하면서 시작
		//마지막 숫자는 0이므로 0만 남을때 까지 진행한다.
		while(que.size()!=1) {
			int num = que.poll();
			String result = vali(num, sie);
			sb.append(result);
			
		}
		
		System.out.println(sb);
	}
	
	public static String vali(int num, boolean[] priList) {
		for(int i=3; i<=num/2; i++) {
			int a = i;
			int b = num-a;
			
			if(!priList[a] && !priList[b]) {
				return num+" = "+a+" + "+b+"\n";
			}
		}
		
		return "Goldbach's conjecture is wrong.";
		
	}

}