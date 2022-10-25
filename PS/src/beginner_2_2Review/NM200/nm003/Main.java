package beginner_2_2Review.NM200.nm003;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * 문제
괄호 문자열(Parenthesis String, PS)은 두 개의 괄호 기호인 ‘(’ 와 ‘)’ 만으로 구성되어 있는 문자열이다. 그 중에서 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열(Valid PS, VPS)이라고 부른다. 한 쌍의 괄호 기호로 된 “( )” 문자열은 기본 VPS 이라고 부른다. 만일 x 가 VPS 라면 이것을 하나의 괄호에 넣은 새로운 문자열 “(x)”도 VPS 가 된다. 그리고 두 VPS x 와 y를 접합(concatenation)시킨 새로운 문자열 xy도 VPS 가 된다. 예를 들어 “(())()”와 “((()))” 는 VPS 이지만 “(()(”, “(())()))” , 그리고 “(()” 는 모두 VPS 가 아닌 문자열이다. 

여러분은 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다. 

입력
입력 데이터는 표준 입력을 사용한다. 입력은 T개의 테스트 데이터로 주어진다. 입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다. 각 테스트 데이터의 첫째 줄에는 괄호 문자열이 한 줄에 주어진다. 하나의 괄호 문자열의 길이는 2 이상 50 이하이다. 

출력
출력은 표준 출력을 사용한다. 만일 입력 괄호 문자열이 올바른 괄호 문자열(VPS)이면 “YES”, 아니면 “NO”를 한 줄에 하나씩 차례대로 출력해야 한다. 
 * */

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		
		int totalCount = Integer.parseInt(scan.readLine());
		
		for(int i = 0; i<totalCount; i++) {
			/*
			 * 우선 배열로 나눈다.
			 * */
			char[] dum = scan.readLine().toCharArray();
			List<Character> dumString = new ArrayList<>();
			for (int j = 0; j < dum.length; j++) {
				dumString.add(j, dum[j]);
			}
			String result = vali1(dumString);
			
			System.out.println(result);
		}
	}
	
	public static String vali1(List<Character> arr) {
		
		/*
		 * 1) 길이 홀짝 Vali
		 * 길이가 짝이면 절대로 VPS가 나올 수 없다.
		 * Why? () 짝을 맞출 수 없기 떄문
		 * */
		
		if(arr.size()%2==1) {
			return "NO";
		}
		
		/*
		 * 2) 짝 개수 Vali
		 * VPS에서 (와 )의 갯수가 동일해야지만 VPS가 성립된다.
		 * 해당 갯수를 비교한다면 검증 로직까지 가지 않고도 종결 시킬 수 있다.
		 * */
		
		int resA=0;
		int resB=0;
				
		for(char a : arr) {
			if(a=='(') {
				resA++;
			} else {
				resB++;
			}
		}
		//숫자가 안맞음 = VPS가 될 수 없음
		if(resA!=resB) {
			return "NO";
		}
		
		/*
		 * 3) 반복 여부 조회
		 * */
		boolean onOff = true;
		
		while(onOff) {
			/*
			 * VPS 제거 로직을 탔는가?
			 * 탔다는 것은 제거할 로직이 없다는 뜻
			 * */
			boolean onOff2 = true;
			/*
			 * List 길이 조회
			 * */
			
			try {
				for(int i = 0; i<arr.size(); i++) {
					if(arr.get(i)=='(' && arr.get(i+1)==')') {
						//list는 하나 재거되면 그거에 맞게 숫자가 당겨주니까 제거를 두번 재훈다.
						arr.remove(i);
						arr.remove(i);
						/*
						 * 다음으로 숫자 밀어주기
						 * */
						i--;
						/*
						 * 탔으면 숫자 올려줌
						 * */
						onOff2 = false;
					}
				}
			} catch(IndexOutOfBoundsException e){
				
			}


			/*
			 * 종료 Validation
			 * 1) VPS 제거로직을 안탔어야 한다.
			 * */
			
			if(onOff2) {
				onOff = false;
			}
		}
		
		if(arr.size()>0) {
			return "NO";
		} else {
			return "YES";
		}
	}
}
