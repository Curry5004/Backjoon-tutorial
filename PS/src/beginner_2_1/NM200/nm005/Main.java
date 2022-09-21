package beginner_2_1.NM200.nm005;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/*
 * 문제
 * URL : https://www.acmicpc.net/problem/1406
 *  * */

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		 * 문자열 입력
		 * */
		String text = scan.readLine();
		/*
		 * ArrayList에서 LinkedList로 변경
		 * */
		List<Character> result = new LinkedList<>();
		for(int i=0; i<text.length(); i++) {
			result.add(text.charAt(i));
		}
		/*
		 * 커서는 숫자 오른쪽에 있다고 생각하자.
		 * */
		int pointer = result.size();
		
		
		/*
		 * 명령어 개수 입력
		 * */
		int totalCount = Integer.parseInt(scan.readLine());
		
		
		
		for(int i = 0; i<totalCount; i++) {
			/*
			 * 우선 받는다.
			 * */
			char[] input = scan.readLine().toCharArray();
			
			switch(input[0]) {
				case 'L':
					/*
					 * Vali : 현재 포인터가 맨 앞보다 앞에있는가?
					 * */
					if(0==pointer) {
						break;
					}
					
					pointer--;
					break;
				case 'D':
					/*
					 * Vali : 현재 포인터가 맨 뒤보다 뒤에있는가?
					 * */
					if(result.size()==pointer) {
						break;
					}
					
					pointer++;
					break;
				case 'B':
					/*
					 * Vali : 현재 포인터가 맨 앞보다 앞에있는가?
					 * */
					if(0==pointer) {
						break;
					}
					result.remove(pointer-1);
					pointer--;
					break;
				case 'P':
					/*
					 * 말 그대로 값 추가
					 * */
					result.add(pointer,input[2]);
					pointer++;
					break;
				
			}
		}
		
		String ans = "";
		for(int i=0; i<result.size();i++) {
			ans = ans+result.get(i);
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   //할당된 버퍼에 값 넣어주기
		bw.write(ans);   //버퍼에 있는 값 전부 출력
		bw.flush();   //남아있는 데이터를 모두 출력시킴
		bw.close();   //스트림을 닫음
	}
}
