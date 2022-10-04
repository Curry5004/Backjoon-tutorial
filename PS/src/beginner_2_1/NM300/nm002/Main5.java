package beginner_2_1.NM300.nm002;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * 문제
 * URL : https://www.acmicpc.net/problem/2609
 * 브루트 포스
 *  * */

public class Main5 {
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
      
      String req = scan.readLine();
      String[] dum = req.split(" ");
      int a = Integer.parseInt(dum[0]);
      int b = Integer.parseInt(dum[1]);
      
      //최악의 경우
      int c = a*b;
      
      int min = 0;
      int max = 0;
      
      //
      for(int i = 1; i<=a*b; i++) {
    	  if(a%i==0 && b%i==0) {
    		  min = i;
    	  }
    	  if((c-i)%a==0 && (c-i)%b==0) {
    		  max = c-i;
    		  System.out.println(c-i);
    	  }
      }
      System.out.println(min);
      System.out.println(max);
   }
}