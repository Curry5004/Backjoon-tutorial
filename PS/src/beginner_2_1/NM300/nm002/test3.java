package beginner_2_1.NM300.nm002;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class test3 {
   public static void main(String[] args) throws Exception{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       String[] request = br.readLine().split(" ");

       int a = Integer.parseInt( request[0] );
       int b = Integer.parseInt( request[1] );

       int min = Integer.MAX_VALUE; // 최소 공배수
       int max = 0; // 최대 공약수

       for( int i = 1, size = a * b ; i <= size ; ++i ) {
           if( a % i == 0 && b % i == 0 ) 
        	   max = ( max > i ) ? max : i;

           if( i % a == 0 && i % b == 0 ) 
        	   min = ( min > i ) ? i : min;
       }

       System.out.println( max + "\n" + min );
   }
}