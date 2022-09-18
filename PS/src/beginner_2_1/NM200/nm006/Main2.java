package beginner_2_1.NM200.nm006;


/*
 * 모범답안
 * URL : https://www.acmicpc.net/problem/10845
 *  * */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		/*
		 * 바로 Que를 생성하는 방향으로 진행
		 * */
		ArrayDeque<String> deque = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		while (n-- > 0) {
			String command = br.readLine();
			/*
			 * que Method를 사용 하는 방향으로 진행.
			 * */
			switch (command) {
			case "pop":
				if (deque.isEmpty()) sb.append(-1).append("\n");
				else sb.append(deque.pollFirst()).append("\n");
				break;
			case "size":
				sb.append(deque.size()).append("\n");
				break;
			case "empty":
				if (deque.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case "front":
				if (deque.isEmpty()) sb.append(-1).append("\n");
				else sb.append(deque.peekFirst()).append("\n");
				break;
			case "back":
				if (deque.isEmpty()) sb.append(-1).append("\n");
				else sb.append(deque.peekLast()).append("\n");
				break;
			default:
				/*
				 * 아예 push 부분을 default로 생성하여 받아온 문자를 배열로 만들어 앞 단어를 vali하는 공정을 제거
				 * 이렇게 함으로써 String을 배열로 만드는 Method를 줄일 수 있어서 더욱 메모리 소모량이 적을 것으로 기대된다.
				 * */
				deque.offer(command.substring(5));
				break;
			}
		}
		System.out.print(sb);
	}
}
