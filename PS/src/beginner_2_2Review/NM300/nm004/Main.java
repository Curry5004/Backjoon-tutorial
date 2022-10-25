package beginner_2_2Review.NM300.nm004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 문제
 * URL : https://www.acmicpc.net/problem/1978
 * 이는 올바른 접근이 아니다.
 * 
 * 초기 기획
 * 1) 소수는 1과 자기 자신을 제외하곤 약수가 없다 -> 따라서 2, 3으로 나뉘지 않으면 소수이다.
 * 
 * 오류
 * 1) 해당 기획으로 접근 하였을 때 소수의 배수는 확인하지 못한다.
 * ex) 25눈 2와 3으로 나뉘지 않지만 5로 나뉘어지므로 1, 5, 25로써 소수가 아니다.
 * 
 * 개선
 * 1) 소수의 배수에 대해서 제거해야할 필요가 있다.
 * 
 *  * */

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(scan.readLine());

		String req = scan.readLine();
		String[] dum = req.split(" ");
		String ans = "";
		for (int i = 0; i < a; i++) {
			int c = Integer.parseInt(dum[i]);
			switch (c) {
			case 1:
				break;
			case 2:
			case 3:
				ans = ans + 1;
				break;
			default:
				if (c % 2 == 0 || c % 3 == 0) {
					continue;
				}
				ans = ans + 1;
			}
		}

		System.out.println(ans.length());
	}

}
