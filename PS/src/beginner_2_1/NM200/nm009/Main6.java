package beginner_2_1.NM200.nm009;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;


/*
 * 문제
 * URL : https://www.acmicpc.net/problem/2609
 *  * 9997 9997
 * 9993 9993
 * 9998 9998
 * 9994 9994
 * 
 * 1)1차 시도. Math를 for문으로 바꿔본다
 *  * */

public class Main6 {
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
      } else {
         Map<Integer, Integer> aMap = new HashMap<>();
         Map<Integer, Integer> bMap = new HashMap<>();
         
         //입력받은 자연수 소인수 분해
         aMap = div(a);
         bMap = div(b);
         
         //최소 공약수 구하기
         int minNum = 1;
         ArrayDeque<Integer> que = new ArrayDeque<>();
         //공약수 가져오기
         for(Map.Entry<Integer, Integer> i : aMap.entrySet()) {
            for(Map.Entry<Integer, Integer> x : bMap.entrySet()) {
               if(i.getKey()==x.getKey()) {
                  que.add(i.getKey());
               }
            }
         }
         //최대 공약수 만들기
         for(Integer i : que) {
            int c = aMap.get(i)>=bMap.get(i) ? bMap.get(i) : aMap.get(i);
            minNum = minNum * (int) Math.pow(i,c);
         }

         
         System.out.println(minNum);
         
         //최소 공배수
         //왜 Set을 사용했는가? -> 중복을 허용하지 않기 때문에 이 두 Map의 Key값을 합집합으로 가져온다.
         Set<Integer> maxSet = new HashSet<Integer>();
         for(Map.Entry<Integer, Integer> i : aMap.entrySet()) {
            maxSet.add(i.getKey());
         }
         for(Map.Entry<Integer, Integer> i : bMap.entrySet()) {
            maxSet.add(i.getKey());
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

   //유클리드 호제법이 아닌 소인수 분해를 활용하여 풀이 시도
   public static Map<Integer, Integer> div(int a){
      
      //Map 생성 Key = 밑, Value = 지수
	  // 해당 Method가 끝나면 입력된 자연수가 소인수분해되어 Map에 저장된다
      Map<Integer, Integer> resMap = new HashMap<>();
      resMap.put(1, 1);
      int num2=0;
      int num3=0;
      

      //1) 2의 지수 구하기
      while(a%2==0) {
         a = a/2;
         resMap.put(2, ++num2);
      }
      
      // Vali : a가 1이 되면 리턴
      if(a==1) {
         return resMap;
      }
      
      //2) 3의 지수 구하기 
      while(a%3==0) {
         a = a/3;
         resMap.put(3, ++num3);
         
      }
      
      //Vali a가 1이 되면 리턴
      if(a==1) {
         return resMap;
      }
      
      //여기까지 왔다는 뜻은 a는 소수를 약수로 가지는 숫자라는 뜻.
      //소수 찾는 알고리즘이 있었다면 더 좋았을 듯
      
      //3) 2,3 외에 소수 약수를 탐색
      int priNumber = 5;
      while(a!=1) {
         
         int priCnt=0;
         
         //a에 소수값이 있다.
         while(a%priNumber==0) {
            a = a/priNumber;
            resMap.put(priNumber, ++priCnt);
            
         }
         
         ++priNumber;
         
      }

      return resMap;
      
   }
}