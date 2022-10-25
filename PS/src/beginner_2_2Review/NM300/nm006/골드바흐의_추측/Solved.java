package beginner_2_2Review.NM300.nm006.골드바흐의_추측;

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
 * URL :https://www.acmicpc.net/problem/6588
 * 
 * 기획
 * 
 * 1. 입력부
 *   1.1. n개의 숫자가 입력되고 마지막에 0이 치면 입력이 완료된다.
 *   -> 0이 들어오기 전까지 계속해서 값을 받도록 구현한다. -> Queue? 
 *   -> 들어온 값 중 가장 큰 값이 어떤 값인지 확인한다. why? 2.1 참고
 *   
 * 2. 검증 로직
 *   2.1. 에라토스테네스의 채 구현.
 *   -> 모든 홀수의 소수이므로 2는 제외한다.
 *   -> 소수를 모두 구할 필요가 있을까? 입력된 값 중 가장 큰 값을 보다 큰 소수는 들어올 수 없으니까 1000000까지 소수를 찾을 필요는 없어보인다.
 *     -> 받은 값 중 가장 큰 값 까지만 소수를 찾을 수 있도록 한다.
 *   -> 이전 코드와 달리 모든 소수를 가지고 있는 자료구조가 필요해 보인다. -> 검증 부분에서 사용
 *   -> 에라토스테네스의 채와 소수 자료구조 적재는 하나의 for문으로 끝내고싶다.
 *   
 *   => 결론 : 기존 로직을 활용하여 소수를 구하되 2는 제외하고 1에서 입력 받은 숫자 중 가장 큰 숫자까지만 찾을 수 있도록 채를 구현한다.
 *  
 *   2.2. 받아온 값들을 검증 시작
 *     2.2.1. n = a + b 가 성립한다면 n%(a+b) == 0 이 될 것이다.
 *     2.2.2. n이 검증되면 검증을 끝내고 다음에 들어온 값을 검증할 수 있도록 진행한다.
 *     2.2.3. 해당 n이 골드바흐의 추측에 일치한다면 a,b를 저장하여 출력할 수 있도록 한다.이 떄 경우의 수가 여러가지라면 b-a가 가장 큰 경우로 진행한다. a,b의 결과를 저장할 수 있는 자료구조가 필요해보인다.
 *     	-> 이중 For문을 돌릴 때 a는 가장 작은 수에서 올라가고 b는 가장 큰 값에서 내려가게끔 한다면 2.2.4.의 로직 구현은 필요없지 않을까?
 *     2.2.5. 바른 값을 찾았다면 해당 결과를 포맷에 맞게 String으로 변환하여 StringBuilder에 append 한다
 *     2.2.5. 만약 골드바흐의 측정이 틀렸다면 "Goldbach's conjecture is wrong"가 StringBuilderd에 append 한다.
 *     
 * 3. 출력
 *   3.1. 증명이 끝난 결과를 StringBuilder에 append 하여 한번에 출력할 수 있도록 한다.
 *     
 *     
 *  에러 타임라인
 *  1) 2.2.1. 수정. 
 *    문제점 : 해당 방식으로 진행할 때 a+b가 n의 약수가 되어버려 정상적으로 결과가 나오지 않는다.
 *    해결책 : 문제에 제시되어던 것 처럼 n == a+b 방향으로 진행
 *  2) 시간초과 발생
 *    해결책 : String을 리턴하지 않고 바로 그 자리에서 System.Print 하는 방향으로 진행 
 *    결과  : 동일하게 시간초과 발생
 *    해결책 : 만들어진 에라토스테네스의 채 만을 사용하여 진행
 *    결과 : 해결. 이중 For문을 돌리는 과정과 새로운 자료구조를 적재하는 과정에서 시간이 소요되었던것으로보인다.
 * 
 *  * */

public class Solved {
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
		for(int i=3; i<num; i++) {
			int a = i;
			int b = num-a;
			
			if(!priList[a] && !priList[b]) {
				return num+" = "+a+" + "+b+"\n";
			}
		}
		
		return "Goldbach's conjecture is wrong.";
		
	}

}