package beginner_2_1.NM300.nm005;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 * 문제
 * URL :https://www.acmicpc.net/problem/1929
 * 
 * 에라토네스의 채 사용. 이전에 작성했던 코드를 기반으로 진행
 * 
 *  * */

public class Main2 {
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      
      String[] b = scan.readLine().split(" ");
      
      int start = Integer.parseInt(b[0]);
      int end = Integer.parseInt(b[1]);
      
   // 자료구조 생성
      int[] sie = new int[end+1];
      
      //자료 구조에 갑 삽입
      for(int i=1; i<=end; i++) {
         sie[i]=1;
      }
      
      sie[1]=0;
      
      for(int i=2; i<=end; i++) {
         if(sie[i]==1) {
            int c = 2;
            while(i*c<=end) {
               sie[i*c]=0;
               ++c;
            }
         }
      }
      
      String ans = "";
      for(int i = start; i<=end; i++) {
    	  if(sie[i]==1) sb.append(i + "\n");
      }
     
      
      System.out.println(sb);
   }

}