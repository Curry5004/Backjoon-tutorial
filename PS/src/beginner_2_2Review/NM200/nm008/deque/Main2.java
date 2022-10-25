package beginner_2_2Review.NM200.nm008.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/*
 * 문제 : 덱
 * URL : https://www.acmicpc.net/problem/10866
 * 
 * 
 * 
 * Map 자료구조로 풀어보자.
 * 
 * 1. Front 값을 계속 넣다보니 Back값을 넘어버리면 어떡하는가? => 이미 들어가버린 Key 값은 변할 수 없으니까다 바꿔줘야한다. 
 * => Key 값을 통하여 자료구조에 들어온 값의 순서를 정렬하고 싶은데 자료구조에 한번 들어간 값은 pop이나 push에 의해 이 key 값이 변하지 않아 구현이 쉽지 않다.
 * 
 *  * */

public class Main2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		
		// 몇회 실행될지 값 받아오기
		int a = Integer.parseInt(scan.readLine());
		
		// map 사용 
		Map<Integer, Integer> map = new HashMap<>();
		// 자료구조 길이.
		int len = map.size();
		//List와 달리 Front와 Back의 위치가 고정되어 있기 때문에 이를 확인할 변수를 가지고 있어야 한다.
		int front = 0;
		int back = 0;
		

		for (int i = 0; i < a; i++) {
			String[] order = scan.readLine().split(" ");
			switch (order[0]) {
				case "push_front":
					map.put(front, Integer.parseInt(order[1]));
					--front;
					break;
				case "push_back":
					map.put(back, Integer.parseInt(order[1]));
					++back;
					break;
				case "pop_front":
					if(map.size()==0) {
						System.out.println(-1);
						break;
					}
					System.out.println(map.get(front+1));
					map.remove(front+1);
					++front;
					break;
				case "pop_back":
					if(map.size()==0) {
						System.out.println(-1);
						break;
					}
					System.out.println(map.get(back));
					map.remove(back);
					--back;
					break;
				case "size":
					System.out.println(map.size());
					break;
				case "empty":
					if(map.size()==0) {
						System.out.println(1);
					} else {
						System.out.println(0);
					}
					break;
				case "front":
					if(map.size()==0) {
						System.out.println(-1);
					}else {
						System.out.println(map.get(front+1));
					}
					break;
				case "back":
					if(map.size()==0) {
						System.out.println(-1);
					}else {
						System.out.println(map.get(back-1));
					}
					break;
			}
			
//			System.out.println(i+"번 줄 성공");
		}
	}
}
