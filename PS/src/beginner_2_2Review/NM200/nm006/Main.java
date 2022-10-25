package beginner_2_2Review.NM200.nm006;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/*
 * 문제
 * URL : https://www.acmicpc.net/problem/10845
 *  * */

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

		/*
		 * 몇회 반복할 것인지 생성
		 * */
		int totalCount = Integer.parseInt(scan.readLine());
		
		/*
		 * Queue 역할을 수행할 List 생성
		 * */
		
		List<Integer> que = new ArrayList<Integer>();
		int alpha = que.size();
		
		for(int i = 0; i<totalCount; i++) {
			String req = scan.readLine();
			String[] dum = req.split(" ");
			int result2 = 0;
			int endNum =0;
			
			switch(dum[0]) {
				case "push":
					/*
					 * 값 추가
					 * */
					int pushNum = Integer.parseInt(dum[1]);
					que.add(0, pushNum);	
					continue;
				case "pop":
					endNum = endNumVali(que);
					if(endNum==-1) {
						result2= -1;
					} else {
						result2 = que.get(endNum);
						que.remove(endNum);	
					}
					break;
				case "size":
					endNum = endNumVali(que);
					if(endNum==-1) {
						result2= 0;
					} else {
						result2 = endNum+1;
					}
					break;
				case "empty":
					endNum = endNumVali(que);
					if(endNum==-1) {
						result2= 1;
					} else {
						result2 = 0;
					}
					break;
				case "front":
					endNum = endNumVali(que);
					if(endNum==-1) {
						result2= -1;
					} else {
						result2 = que.get(endNum);
					}
					break;
				case "back":
					endNum = endNumVali(que);
					if(endNum==-1) {
						result2= -1;
					} else {
						result2 = que.get(0);
					}
					break;
			}
			
			System.out.println(result2);
			
		}
	}
	
	public static int endNumVali(List que) {
		int endNum = que.size();
		if(endNum==0) {
			return -1;
		}
		return endNum-1;
	}
}
