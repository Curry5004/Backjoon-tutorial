package beginner_2_1.NM300.nm009.조합_0의_개수;

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
 * URL :https://www.acmicpc.net/problem/2004
 * 
 * 
 * 이항 계수을 물어보는 문제이다. 앞서서 나온 문제의 연장이다.
 * 
 * Point
 * 1) 조합의 개념에 대하여 알고있는가?
 * 2) 0의 자리가 나오는 조건에 대해서 알고있는가?
 * 
 * 
 * 기획
 * 
 * 1. 입력부
 *   1.1 2개의 숫자가 스페이스로 띄어쓰기 된 채 한줄로 들어온다.
 *   1.2. BufferedReader을 사용하여 값을 String으로 받아온 뒤 Split을 사용하여 값을 잘라낸 뒤 Integer로 파서한다.
 *   
 * 2. 로직
 *   2.1. 분자부 분모부로 나눈다.
 *   2.2. 해당 공식은 분자, 분모 모두 펙토리얼을 사용하기 때문에 전 문제에서 펙토리얼 Method를 활용한다.
 *   2.3. 분자, 분모의 값을 각각 구한 다음 분자를 문모로 나누어서 해를 구한다.
 * 
 * 3. 출력부
 *   3.1. 로직에서 나온 해를 출력한다.
 * 
 * 문제점
 * 1) 기존의 코드를 활용한다면 시간초과가 발생한다. 해당 코드 리펙토링이 필요.
 *   기존 로직 : N! 일 때 1~N까지를 for문으로 돌려 이 값들의 5의 배수를 구했다
 *   개선안 : 1~N에서 5의 배수값만 뽑아서 5의  갯수를 구할 수 있지 않을까?
 *   		가령 10!에서 5의 배수를 구한다면 기존 코드에선 1,2,3,4,5...10을 for문을 통하여 나열하지만 5,10 이처럼 5의 배수만 뽑아낼 수 있다면 기존 코드보다 5배나 빠르다.
 *   코딩
 *    1) method에 5의 배수값이 들어갈 변수 선언
 *    2) for문을 통하여 5와 곱해질 값들을 1부터 시작하여 x씩 올려준다.
 *    3) 만약 1번의 변수 * x <= N 이 넘어간다면 그때 종결을시킨다.
 *    4) 이 값을 통해 얻어낸 5의 지수를 구한다.
 * 
 *  * */

public class Solved {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 1. 입력부
		//BufferedReader을 사용하여 값을 String으로 받아온 뒤 Split을 사용하여 값을 잘라낸 뒤 Integer로 파서한다.
		String input = scan.readLine();
		String[] num = input.split(" ");
		int n = Integer.parseInt(num[0]); 
		int m = Integer.parseInt(num[1]); 
		
		//로직
		//분자, 분모로 값을 나누어 각각의 값을 구한다.
		
	    int twoCnt = get(n, 2) - get(m, 2) - get(n - m, 2);
        int fiveCnt = get(n, 5) - get(m, 5) - get(n - m, 5);
        
        System.out.println(Math.min(twoCnt, fiveCnt));
    }
    
    private static int get(int n, int k) {
        int cnt = 0;
        
        while(n >= k) {
            cnt += n / k;
            n /= k;
        }
        
        return cnt;
    }
}