package beginner_2_1.NM200.nm001;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

		
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
					int num = Integer.parseInt(dum[1]);
					result.add(num);
					count++;
					continue;
				case "pop":
					if(result.size()==0) {
						result2 = -1;
					} else {
						result2 = result.get(endNum);
						result.remove(endNum);
					}
					break;
				case "size":
					result2 = endNum+1;
					break;
				case "empty":
					if(endNum+1==0) {
						result2 = 1;
					} else {
						result2 = 0;
					}
					break;
				case "top":
					if(endNum+1==0) {
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
}