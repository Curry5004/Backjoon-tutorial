package beginner_2_2Review.NM200.nm005;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/*
 * 모범답안
 * URL : https://www.acmicpc.net/problem/1406
 *  * */

public class Main2 {
	public static void main(String[] args) throws Exception {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		 * 값을 미리 받아 줄 Stack 생성
		 * */
        Stack<Character> stack_L = new Stack<>();
        /*
         * 커서가 이동할 때 들어갈 또다른 Stack 생성.
         * 
         * 이 두 Stack 사이가 커서라 생각하면 된다.
         * */
        Stack<Character> stack_R = new Stack<>();
 
        String str = scan.readLine();
        for(int i = 0; i < str.length(); i++){
            stack_L.add(str.charAt(i));
        }
        int N = Integer.parseInt(scan.readLine());
 
        for(int i = 0; i < N; i++) {
            str = scan.readLine();
            switch (str.charAt(0)) {
                case 'L':
                	/*
                	 * 왼쪽에 있는 Stack에서 Pop 해서 오른쪽 Stack으로 add
                	 * */
                    if(!stack_L.isEmpty())
                        stack_R.add(stack_L.pop());
                    break;
                case 'D':
                	/*
                	 * L의 반대로 오 -> 왼으로 POP & ADD
                	 * */
                    if(!stack_R.isEmpty())
                        stack_L.add(stack_R.pop());
                    break;
                case 'B':
                	/*
                	 * 왼쪽에서 pop 해줘서 제거한다.
                	 * */
                    if(!stack_L.isEmpty())
                        stack_L.pop();
                    break;
                case 'P':
                	/*
                	 * 왼쪽 Stack에 넣어준다.
                	 * */
                    stack_L.add(str.charAt(2));
                    break;
            }
        }
        
        StringBuffer output = new StringBuffer();
        /*
         * 두 Stack의 값을 합쳐서 결과 값을 만들어줌
         * */
        for(char a : stack_L)
            output.append(a);
        while(!stack_R.isEmpty())
            output.append(stack_R.pop());
        
        System.out.println(output);
	}
}
