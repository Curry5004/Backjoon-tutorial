package beginner_2_1.NM300.nm002;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * 공식 참고
 * URL : https://www.youtube.com/watch?v=Obs-HC5j5bI
 *  * */

public class Main2 {
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
      
      String req = scan.readLine();
      String[] dum = req.split(" ");
      int a = Integer.parseInt(dum[0]);
      int b = Integer.parseInt(dum[1]);
      
      int c = div(a,b);
      
      System.out.println(c);
      System.out.println((a*b)/c);
      
   }

   //유클리드 호제법
    public static int div(int a, int b) {
    	//a,b 순서 바꾸기
    	if(a<b) {
    		int c = a;
    		a = b;
    		b = c;
    	}
    	
    	while(a%b!=0) {
    		int c = a%b;
    		a = b;
    		b = c;
    	}
    	
    	return b;
    }
}