package beginner_2_2Review.NM200.nm008.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/*
 * 모범답안 참고
 * 문제 : 덱
 * URL : https://www.acmicpc.net/source/46483015
 * 
 * 1. Dequeue를 직접 사용
 * 2. 상항 연산자를 사용
 * 3. 출력을 가장 마지막에 그리고 StringBuilder를 사용 -> 이것이 속도 단축에 가장 큰 영향을 줌.
 * 
 * 
 *  * */

public class Main3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 몇회 실행될지 값 받아오기
		int a = Integer.parseInt(scan.readLine());
		
		// Deque 자료 구조를 그대로 사용
		Deque<Integer> deque = new ArrayDeque<>();
		

		for (int i = 0; i < a; i++) {
			String[] order = scan.readLine().split(" ");
			switch (order[0]) {
				case "push_front":
					deque.addFirst(Integer.parseInt(order[1]));
					break;
				case "push_back":
					deque.addLast(Integer.parseInt(order[1]));
					break;
				case "pop_front":
					sb.append((deque.isEmpty() ? -1 : deque.pollFirst()) + "\n");
					break;
				case "pop_back":
					sb.append((deque.isEmpty() ? -1 : deque.pollLast()) + "\n");
					break;
				case "size":
					sb.append(deque.size() + "\n");
					break;
				case "empty":
					sb.append((deque.isEmpty() ? 1 : 0) + "\n");
					break;
				case "front":
					sb.append((deque.isEmpty() ? -1 : deque.peekFirst()) + "\n");
					break;
				case "back":
					sb.append((deque.isEmpty() ? -1 : deque.peekLast()) + "\n");
					break;
			}
		}
		System.out.println(sb);
	}
}
