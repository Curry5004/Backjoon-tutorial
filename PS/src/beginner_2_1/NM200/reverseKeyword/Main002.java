package beginner_2_1.NM200.reverseKeyword;

/*
 * 문제
문장이 주어졌을 때, 단어를 모두 뒤집어서 출력하는 프로그램을 작성하시오. 단, 단어의 순서는 바꿀 수 없다. 단어는 영어 알파벳으로만 이루어져 있다.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있으며, 문장이 하나 주어진다. 단어의 길이는 최대 20, 문장의 길이는 최대 1000이다. 단어와 단어 사이에는 공백이 하나 있다.

출력
각 테스트 케이스에 대해서, 입력으로 주어진 문장의 단어를 모두 뒤집어 출력한다.
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main002 {
	public static void main(String[] args) throws Exception{
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		
		int totalCount = Integer.parseInt(scan.readLine());
		
		/*
		 * String 받아서 매열로 던져준다
		 * **/
		for(int i = 0; i <totalCount; i++) {
			String input = scan.readLine();
			String[] input2 = input.split(" ");
			int inputSize = input2.length;
			String[] ans1 = new String[inputSize];
			int ans1Size = ans1.length;
			
			/*
			 * 단어 뒤집어주기
			 * */
			for(int x=0; x<inputSize; x++) {
				char[] ans2 = input2[x].toCharArray();
				int ans2Size = ans2.length;
				String ans3 = "";
				for(int y=0; y<ans2Size; y++) {
					ans3 = ans3 + ans2[ans2Size-1-y];
				}
				ans1[x] = ans3;
			}
			/*
			 * 배열 합쳐주기
			 * */
			String ans4 = "";
			/*
			 * 첫글자는 하드코딩으로 넣어준다.
			 * */
			ans4 = ans4 + ans1[0];
			for(int l=1; l<ans1Size; l++) {
				ans4 = ans4 + " " +ans1[l]; 
			}
			/*빵야*/
			System.out.println(ans4);
			
		}
	}
}
