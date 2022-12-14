package beginner_2_1.NM300.nm002.최대공약수와_최소공배수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 답안 코드 리팩토링
 * 
 * 재귀 함수를 확용하여 문제 풀이
 * */


public class Main4 {
	public static void main(String args[]) throws Exception {
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		
		String req = scan.readLine();
	    String[] dum = req.split(" ");
	    int a = Integer.parseInt(dum[0]);
	    int b = Integer.parseInt(dum[1]);
	    
	    int c = div(a, b);
	    
	    System.out.println(c);
	    System.out.println((a*b)/c);
	}
	
	
	private static int div(int a, int b) {
		//a,b 순서 바꾸기
		if(a<b) {
    		int c = a;
    		a = b;
    		b = c;
    	}
		
		//재귀함수 적용
		if(b==0) {
			return a;
		}
		
		return div(b, a%b);
	}

}
