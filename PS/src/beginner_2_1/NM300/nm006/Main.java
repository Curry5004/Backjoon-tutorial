package beginner_2_1.NM300.nm006;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 * 문제
 * URL :https://www.acmicpc.net/problem/6588
 * 
 * 기획
 * 
 * 1. 입력부
 *   1.1. n개의 숫자가 입력되고 마지막에 0이 치면 입력이 완료된다.
 *   -> 0이 들어오기 전까지 계속해서 값을 받도록 구현한다. -> Queue? 
 *   -> 들어온 값 중 가장 큰 값이 어떤 값인지 확인한다. why? 2.1 참고
 *   
 * 2. 검증 로직
 *   2.1. 우선 모든 소수를 구해야 하니 에라토스테네스의 채가 필요하다.
 *   -> 기존에 구현하였던 로직을 사용. 
 *   -> 모든 홀수의 소수이므로 2는 제외한다.
 *   -> 소수를 모두 구할 필요가 있을까? 입력된 값 중 가장 큰 값을 보다 큰 소수는 들어올 수 없으니까 1000000까지 소수를 찾을 필요는 없어보인다.
 *     -> 받은 값 중 가장 큰 값 까지만 소수를 찾을 수 있도록 한다.
 *   -> 이전 코드와 달리 모든 소수를 가지고 있는 자료구조가 필요해 보인다. -> 검증 부분에서 사용
 *   
 *   => 결론 : 기존 로직을 활용하여 소수를 구하되 2는 제외하고 1에서 입력 받은 숫자 중 가장 큰 숫자까지만 찾을 수 있도록 채를 구현한다.
 *  
 *   2.2. 받아온 값들을 검증 시작
 *     2.2.1. n = a + b 가 성립한다면 n%(a+b) == 0 이 될 것이다.
 *     2.2.2. n이 검증되면 검증을 끝내고 다음에 들어온 값을 검증할 수 있도록 진행한다.
 *     2.2.3. 해당 n이 골드바흐의 추측에 일치한다면 a,b를 저장하여 출력할 수 있도록 한다.이 떄 경우의 수가 여러가지라면 b-a가 가장 큰 경우로 진행한다. a,b의 결과를 저장할 수 있는 자료구조가 필요해보인다.
 *     2.2.4. 다수의 a,b가 있을 경우 b-a가 가장 큰 값을 찾는 로직을 구현한다.
 *     2.2.5. 바른 값을 찾았다면 해당 결과를 포맷에 맞게 String으로 변환하여 StringBuilder에 append 한다
 *     2.2.5. 만약 골드바흐의 측정이 틀렸다면 "Goldbach's conjecture is wrong"가 StringBuilderd에 append 한다.
 *     
 * 3. 출력
 *   3.1. 증명이 끝난 결과를 StringBuilder에 append 하여 한번에 출력할 수 있도록 한다.
 *     
 *     
 * 
 *  * */

public class Main {
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