package beginner_2_1.NM200.nm007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
      
      String req = scan.readLine();
      String[] dum = req.split(" ");
      int totalNum = Integer.parseInt(dum[0]);
      int pointNum = Integer.parseInt(dum[1]);
      String res = "<";
      
      
      /*
       * 큐 생성
       * */
      Queue<Integer> que = new LinkedList<>();
      
      /*
       * 숫자 삽입
       * */
      for(int i = 0; i<totalNum; i++) {
         que.add(i+1);
      }
      
      /*
       * que가 1이 될 때 까지 계속 돌려서 빼준다.
       * */
      while(que.size()!=1) {
         /*
          * 앞에 있는 것을 뒤로 넣어준다!
          * n-1개를 뒤로 넣어주고 n번째를 제거
          * */
         for(int i = 0; i<pointNum-1; i++) {
            que.add(que.peek());
            que.poll();
         }
         
         res = res + que.poll()+", ";
      }
      
      /*
       * 마지막 남은 숫자는 ,을 빼고 넣어야 하니 while 끝난 뒤에 넣어준다.
       * */
      res = res + que.poll()+">";
      
      System.out.println(res);
      
   }

}