package beginner_2_1.NM200.nm009;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


/*
 * 문제
 * URL : https://www.acmicpc.net/problem/2609
 *  * */

public class Main {
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
      
      String req = scan.readLine();
      String[] dum = req.split(" ");
      int a = Integer.parseInt(dum[0]);
      int b = Integer.parseInt(dum[1]);
      
      //둘 중 숫자가 1이 있다면 바로 종결시킨다
      
      if(a==1 || b==1) {
         System.out.println(a==1 ? a : b);
         System.out.println(a*b);
      }else {
	      Map<Integer, Integer> aMap = new HashMap<>();
	      Map<Integer, Integer> bMap = new HashMap<>();
	      
	      //해당 자연수가 어떤 자연수들의 승으로 이루어져 있는지 확인하기
	      aMap = div(a);
	      bMap = div(b);
	      
	      //최소 공약수 구하기
	      int minNum = 1;
	      ArrayDeque<Integer> que = new ArrayDeque<>();
	      //공약수 가져오기
	      for(Integer i : aMap.keySet()) {
	    	  for(Integer x : bMap.keySet()) {
	    		  if(i==x) {
	    			  que.add(i);
	    		  }
	    	  }
	      }
	      //최대 공약수 만들기
	      for(Integer i : que) {
	    	  int c = aMap.get(i)>=bMap.get(i) ? bMap.get(i) : aMap.get(i);
	    	  minNum = minNum * (int) Math.pow(i,c);
	      }

	      
	      System.out.println(minNum);
	      
	      //최대 공배수
	      //왜 Set을 사용했는가? -> 중복을 허용하지 않기 때문에 이 두 Map의 Key값을 합집합으로 가져온다.
	      Set<Integer> maxSet = new HashSet<Integer>();
	      for(Integer i : aMap.keySet()) {
	    	  maxSet.add(i);
	      }
	      for(Integer i : bMap.keySet()) {
	    	  maxSet.add(i);
	      }
	      
	      int maxNum = 1;
	      for(int i : maxSet) {
	    	  //둘 다 값을 가지고 있을 경우 두 값의 지수를 비교하여 지수가 큰 값을 곱하여분다.
	    	  if(aMap.get(i)!=null && bMap.get(i)!=null) {
	    		  int c = aMap.get(i)>=bMap.get(i) ? aMap.get(i) : bMap.get(i);
	    		  maxNum = maxNum * (int) Math.pow(i,c);
	    	  } else {
	    		  if(aMap.get(i)!=null) {
	    			  maxNum = maxNum * (int) Math.pow(i,aMap.get(i));
	    		  } else {
	    			  maxNum = maxNum * (int) Math.pow(i,bMap.get(i));
	    		  }
	    	  }
	      }
	      
	      System.out.println(maxNum);

	      
      }
   }

   
   public static Map<Integer, Integer> div(int a){
      
      //관련 값 생성
      Map<Integer, Integer> resMap = new HashMap<>();
      int num2=0;
      int num3=0;

      /*
       * 2의 지수 구하기
       * */
      while(a%2==0) {
         a = a/2;
         resMap.put(2, ++num2);
         
      }
      
      /*
       * Vali a가 1이 되면 리턴
       * */
      if(a==1) {
    	 resMap.put(1, 1);
         return resMap;
      }
      
      /*
       * 3의 지수 구하기 
       * */
      while(a%3==0) {
         a = a/3;
         resMap.put(3, ++num3);
         
      }
      
      /*
       * Vali a가 1이 되면 리턴
       * */
      if(a==1) {
    	 resMap.put(1, 1);
         return resMap;
      }
      
      /*
       * 여기까지 왔다는 뜻은 a는 1이 아닌 소수가 곱해져서 만든 자연수라는 뜻
       * 소수 찾는 알고리즘이 있었다면 더 좋았을 듯
       * */
      /*
       * 2,3 다음으로 가장 작은 소수
       * */
      int priNumber = 5;
      while(a!=1) {
         
         
         int priCnt=0;
         
         //a에 소수값이 있다.
         while(a%priNumber==0) {
            a = a/priNumber;
            resMap.put(priNumber, ++priCnt);
            
         }
         
         priNumber++;
         
      }
      resMap.put(1, 1);

      return resMap;
      
   }
}