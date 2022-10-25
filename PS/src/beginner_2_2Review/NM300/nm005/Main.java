package beginner_2_2Review.NM300.nm005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * 문제
 * URL : https://www.acmicpc.net/problem/1929
 * 
 * 해당 문제는 정말 에라토네스의 채를 필요로 하는 문제.
 * 
 * 이전 004번 문제에서 만들었던 함수를 리펙토링 하는 방향으로 진행
 * 
 * 아쉬웠던 점.
 * 1) 이미 소수가 아니라고 검증 된 수까지 다시 검증하여 시간 소요가 오래걸렸다고 생각.
 * 
 * 달라진 점
 * 1) 이전 값에는 10000 이라는 종료 지점을 하드코딩 하였으나 이번엔 범위가 있기에 범위의 개념을 추가하는 방향으로 리펙토링이 필요하다.
 * 
 * 개선안
 * 1) Queue 자료구조를 사용하여 해결해보고자 한다.
 *   -> List를 사용하지 않을 수 있다.
 *   -> 걸러진 수는 바로바로 제거해줌으로 써 같은 값을 또다시 검증하는 일 없도록 한다.
 *   
 * 값을 옮기는 것이 쉽지 않다...
 *  * */

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

		String[] b = scan.readLine().split(" ");
		int test = sieve(Integer.parseInt(b[0]),Integer.parseInt(b[1]));
		int ans = 0;


		System.out.println(ans);
	}

	public static int sieve(int start, int end) {

		Queue<Integer> que = new LinkedList<>();
		List<Integer> benList = new ArrayList<>();
		
		//우선 자료구조에 범위의 값들을 전부 삽입
		for(int i = start; i<=end; i++) {
			que.add(i);
		}
		
		while(que.peek()%2==0 && que.peek()%3==0) {
			que.poll();
		}
		
//		int a = que.peek();
		int b = 0;
		
//		que.add(que.peek());
//        que.poll();
//		int len = que.size();
        
        for(int i = 0; i<que.size(); i++) {
        	int a = que.peek();
        	que.add(que.peek());
            que.poll();
        	while(a!=b) {
        		b = que.peek();
        		if(b%a==0) {
            		benList.add(b);
            	}
            	que.add(que.peek());
                que.poll();
                b = que.peek();
        	}
        	que.add(que.peek());
            que.poll();
        	que.removeAll(benList);
        }
        
		
		
		return 1;
	}
}