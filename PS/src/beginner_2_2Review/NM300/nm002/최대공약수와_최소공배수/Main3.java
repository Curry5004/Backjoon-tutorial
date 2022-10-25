package beginner_2_2Review.NM300.nm002.최대공약수와_최소공배수;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 모범 답안
 * */

public class Main3 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int gcd = gcd(a, b);
        
        System.out.println(gcd);
        System.out.println(a * b / gcd);
        br.close();
    }
    
    //재귀 함수 사용
    private static int gcd(int a, int b) {
    	if (b == 0) {
    		return a;
    	}
    	return gcd(b, a % b);
    }

}