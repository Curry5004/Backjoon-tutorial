package beginner_2_2Review.NM200.nm001.스택;


/*
 * 
 * 문제 : https://www.acmicpc.net/problem/10828
 * 
 * 스택에 잘 알고있는지 확인
 * 스택 클레스를 쓰지 않고 직접 만들어서 구현해보았다.
 * 
 * 
 * 
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

		// List 객체를 사용하였다. 해당 객체는 배열의 크기가 가변적이서여 OutofBound 에러가 발생하지 않아 사용에 적합하다 생각하였다.
		List<Integer> result = new ArrayList<>();
		int count = 0;
		int totalCount = Integer.parseInt(scan.readLine());
		
		while(count<totalCount) {
			String req = scan.readLine();
			String[] dum = req.split(" ");
			int endNum = result.size()-1;
			int result2 = 0;
			
			switch(dum[0]) {
				case "push":
					printInMethod("push", result);
					int num = Integer.parseInt(dum[1]);
					result.add(num);
					count++;
					printOutMethod("push", result);
					continue;
				case "pop":
					printInMethod("pop", result);
					if(result.size()==0) {
						System.out.println("Stack에 숫자 없음");
						result2 = -1;
					} else {
						result2 = result.get(endNum);
						System.out.println("사라질 숫자 "+result2);
						result.remove(endNum);
					}
					printOutMethod("pop", result);
					break;
				case "size":
					printInMethod("siez", result);
					result2 = endNum+1;
					break;
				case "empty":
					printInMethod("empty", result);
					if(endNum+1==0) {
						result2 = 1;
					} else {
						result2 = 0;
					}
					break;
				case "top":
					printInMethod("top", result);
					if(endNum+1==0) {
						System.out.println("Stack에 숫자가 존재하지 않는다.");
						result2 = -1;
					} else {
						result2 = result.get(endNum);
					}
					break;
			}
			System.out.println(result2);
			count++;
		}
	}
	
	static void printInMethod(String cmd, List<Integer> result) {
		System.out.println("=========="+cmd+" 시작==========");
		System.out.println("현재 Stack의 상태");
		for(int i : result) {
			System.out.print(i+" ");
		}
		System.out.println();
	}

	static void printOutMethod(String cmd, List<Integer> result) {
		System.out.println(cmd+" 종료");
		System.out.println("현재 Stack의 상태");
		for(int i : result) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("=========="+cmd+" 종결==========");
	}
}