package beginner_2_1.NM200.nm003;

import java.io.*;

/*
 * 모범답안
 * URL : https://www.acmicpc.net/source/10663368
 * */

public class Main2 {

	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int cnt = 0, j = 0;
		
		for(int i = 0; i < cases; i++) {
			//배열로 진행. 
			char arr[] = br.readLine().toCharArray();
			//1차 벨리. 처음부터 )가 나오면 VPS가 안되니 벨리 진행
			if(arr[0]==')') sb.append("NO\n");
			else {
				/*
				 * 2차 벨리. (,) 갯수 비교해서 검증하는
				 * 기획 의도 자체는 나랑 같아보이나 풀어내느 방식이 더 깔끔하다.
				 * 나는 for문과 int 변수 2개를 사용하여 두 변수값을 비교하는 방향으로 진행했었다
				 * 해당 코드는 (일떄의 변수와 )일 때의 변수를 같은 값을 사용하여 __, +=를 사용하여 검증하고있다
				 * 그리고 모든 for문을 통과한 뒤 두 변수를 비교하여 검증했던 것에 비하여 해당 코드는 cnt값이 0보다 작아지는것을 즉각적으로 감지하여
				 * 검증 도중에도 VPS에 일치하지 않으면 즉각적으로 검증이 중단되게 설계하였다
				 * 
				 * 요약
				 * 1) 기획은 동일하나 나와 설계가 다름
				 * 2) 변수를 한개만 사용, FOR문 안에 검증로직을 넣어 거짓일시 즉각적으로 검증이 종료되게 설계
				 * */
				for(j = 0; j < arr.length; j++) {
					if(arr[j] == '(') cnt ++;
					if(arr[j] == ')') cnt --;
					
					if(cnt < 0) {
						sb.append("NO\n");
						break;
					}
				}
				
				/*여기서 J를 검증할 필요가 있는가? 어차피 여기까지 넘어온 시점에서 J와 arr의 길이는 동일할 것으로 보인다.*/
//				if(j == arr.length) {
//					if(cnt == 0) sb.append("YES\n");
//					else sb.append("NO\n");
//				}
				
				
				//해당 코드를 자세히 살펴보니 (로 시작하고 (랑 )의 갯수가 맞으면 VPS가 안나올 수가 없다.
				//이 코드를 작성한 개발자는 이 점을 착안하여 바로 벨리데이션으로 들어간 듯.
				if(cnt == 0) sb.append("YES\n");
				else sb.append("NO\n");
				
				cnt = 0;
			}
		}
		
		System.out.println(sb);
	}

}