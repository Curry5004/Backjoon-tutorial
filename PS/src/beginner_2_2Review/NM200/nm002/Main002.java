package beginner_2_2Review.NM200.nm002;

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
			System.out.println("입력 받은 값 : "+input);
			String[] input2 = input.split(" ");
			System.out.println("입력 받은 문장을 단위로 끊어준다.");
			System.out.print(input2[0]);
			for(int y=1; y<input2.length; y++) {
				System.out.print(", "+input2[y]);
			}
			System.out.println();
			System.out.println("각 단어의 알파벳을 뒤집어준다.");
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
				System.out.println("변환 될 단어 : "+input2[x]);
				for(int y=0; y<ans2Size; y++) {
					ans3 = ans3 + ans2[ans2Size-1-y];
				}
				System.out.println("변환 완료된 단어 : "+ans3);
				ans1[x] = ans3;
			}
			/*
			 * 배열 합쳐주기
			 * */
			String ans4 = "";
			/*
			 * 첫글자는 하드코딩으로 넣어준다.
			 * */

			System.out.println("뒤집어진 단어를 하나씩 넣어준다.");
			ans4 = ans4 + ans1[0];
			for(int l=1; l<ans1Size; l++) {
				ans4 = ans4 + " " +ans1[l];
				System.out.println(ans4);
			}
			/*빵야*/
			System.out.println("======== 결과 ========");
			System.out.println(ans4);
			
		}
	}
}
