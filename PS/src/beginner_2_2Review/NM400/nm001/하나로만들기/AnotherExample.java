package beginner_2_2Review.NM400.nm001.하나로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
/*
 * 다른 풀이
 * URL :https://www.acmicpc.net/source/37189032
 * 
 * 
 * 차이점 : 
 * 1. 내 계산식은 트리 최하단에서 값을 찾아 오는 방향으로 진행했다면 해당 값은 트리 가장 윗부분에서 하단으로 내려가는 방식을 택했다.
 * 2. dp 배열을 사용하지 않아 값을 저장하지 않는다.
*/

public class AnotherExample {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		System.out.println(recur(N,0));
	}

	static int recur(int N, int count){
		if(N<2){
			return count;
		}
		
		// 이렇게 최소값 
		return Math.min(recur(N/2, count+1+(N%2)), recur(N/3, count+1+(N%3)));
	}
}