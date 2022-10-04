package beginner_2_1.NM200.nm008.deque;

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
 * List를 사용하는 것이 Dequeue를 구현하기에 가장 최적의 자료구조라고 생각하였다.
 * 
 * 1. 길이가 가변적이다
 * 2. front와 back의 위치를 확인 하기가 쉽다 = front틑 항상 0, back은 항상 길이의 -1
 * 
 * 
 *  * */

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		
		// 몇회 실행될지 값 받아오기
		int a = Integer.parseInt(scan.readLine());
		
		// List 사용 
		List<Integer> list = new ArrayList<>();
		// 자료구조 길이.
		int len = list.size();
		

		for (int i = 0; i < a; i++) {
			String[] order = scan.readLine().split(" ");
			switch (order[0]) {
				case "push_front":
					list.add(0, Integer.parseInt(order[1]));
					++len;
					break;
				case "push_back":
					list.add(len, Integer.parseInt(order[1]));
					++len;
					break;
				case "pop_front":
					if(len==0) {
						System.out.println(-1);
						break;
					}
					System.out.println(list.get(0));
					list.remove(0);
					--len;
					break;
				case "pop_back":
					if(len==0) {
						System.out.println(-1);
						break;
					}
					System.out.println(list.get(len-1));
					list.remove(len-1);
					--len;
					break;
				case "size":
					System.out.println(len);
					break;
				case "empty":
					if(len==0) {
						System.out.println(1);
					} else {
						System.out.println(0);
					}
					break;
				case "front":
					if(len==0) {
						System.out.println(-1);
					}else {
						System.out.println(list.get(0));
					}
					break;
				case "back":
					if(len==0) {
						System.out.println(-1);
					}else {
						System.out.println(list.get(len-1));
					}
					break;
			}
			
//			System.out.println(i+"번 줄 성공");
		}
	}
}
