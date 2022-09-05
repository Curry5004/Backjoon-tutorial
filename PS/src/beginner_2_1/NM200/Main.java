package beginner_2_1.NM200;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Main me = new Main();
		
		Scanner scan = new Scanner(System.in);
		
		List<Integer> result = new ArrayList<>();
		int count = 0;
		int totalCount = scan.nextInt();
		
		Scanner scan2 = new Scanner(System.in);
		while(count<totalCount) {
			String req = scan2.nextLine();
			String[] dum = me.vali(req);
			switch(dum[0]) {
				case "push":
					int num = Integer.parseInt(dum[1]);
					result.add(num);
					break;
				case "pop":
					if(result.size()==0) {
						System.out.println(-1);
					} else {
						System.out.println(result.get(0));
						result.remove(0);
					}
					break;
				case "size":
					System.out.println(result.size());
					break;
				case "empty":
					int valiNum = result.size();
					if(valiNum==0) {
						System.out.println(0);
					} else {
						System.out.println(1);
					}
					break;
				case "top":
					if(result.size()==0) {
						System.out.println(-1);
					} else {
						System.out.println(result.get(0));
					}
					break;
			}
			count++;
		}
	}
	String[] vali(String val) {
		String[] result = val.split(" ");
		return result;
	};
}

