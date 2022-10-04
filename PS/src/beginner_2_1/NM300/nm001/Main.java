package beginner_2_1.NM300.nm001;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * 문제
 * URL : https://www.acmicpc.net/problem/10430
 *  * */

public class Main {
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
      
      String req = scan.readLine();
      String[] dum = req.split(" ");
      int oneNum = Integer.parseInt(dum[0]);
      int twoNum = Integer.parseInt(dum[1]);
      int threNum = Integer.parseInt(dum[2]);
      
      
      System.out.println((oneNum+twoNum)%threNum);
      System.out.println((oneNum%threNum+twoNum%threNum)%threNum);
      System.out.println((oneNum*twoNum)%threNum);
      System.out.println(((oneNum%threNum)*(twoNum%threNum))%threNum);
   }

}