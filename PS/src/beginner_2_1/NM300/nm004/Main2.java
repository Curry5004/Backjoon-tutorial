package beginner_2_1.NM300.nm004;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 * 문제
 * URL : https://www.acmicpc.net/problem/1978
 * 
 * 1000 밖에 안되면 그냥 소수를 다 구하면 안돼나? -> 에라토스테네스의 채
 * 
 * 자료구조 선정
 * 1) List가 아님
 * 2) 특정 값을 찾아낼 수 있어야 함
 * 3) 값을 제거하여도 그 안에 값이 남아있어야함.
 * 
 * 우선 배열로 만들어보자
 * 
 *  * */

public class Main2 {
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
      
      int a = Integer.parseInt(scan.readLine());
      String[] b = scan.readLine().split(" ");
      int[] test = sieve(10000);
      int ans = 0;
      
      for(String c : b) {
         int d = Integer.parseInt(c);
         if(test[d]==1) {
            ++ans;
         }
      }
      
      System.out.println(ans);
   }

   public static int[] sieve(int a) {

      // 자료구조 생성
      int[] sie = new int[a+1];
      
      //자료 구조에 갑 삽입
      for(int i=2; i<=a; i++) {
         sie[i]=1;
      }
      
      for(int i=2; i<=a; i++) {
         if(sie[i]==1) {
            int b = 2;
            while(i*b<=a) {
               sie[i*b]=0;
               ++b;
            }
         }
      }
      return sie;
   }
}