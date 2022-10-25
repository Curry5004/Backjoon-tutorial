package beginner_2_2Review.NM200.nm007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * 모범 답안
 * URL : https://www.acmicpc.net/source/47419356
 *  * */


public class Main2 {
   public static void main(String[] args) throws IOException{
      // BufferedReader로 입력받는다.
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());

      // N크기의 배열을 생성한다.
      int[] arr = new int[N];
      int K = Integer.parseInt(st.nextToken());
      int index = K - 1;

      // 1 ~ N까지 입력받는다.
      for(int i = 0; i < N; i++) {
         arr[i] = i+1;
      }
      
      /*
       * 우선 해당 Index의 값이 바로 앞으로 가니까 정답에 index값을 넣어줌
       * 이렇게 진행해주면 내 Method에서 isEmpty를 사용하여 진행할 수 있었을꺼 같다.
       * */
      sb.append("<").append(arr[index]);

      /*
       * 기존 arr에 index를 뺀 뒤의 값을 ~ 마지막 부분 까지 복사한다.
       * 
       * */
      System.arraycopy(arr, index+1, arr, index, --N - index);
      while(N>0) {
         
         /*
          * 1) N번째 위치에 해당하는 값을 구하기 위해 해당 index 값을 사용
          * 2) 모든 순서가 순환하여 다시 앞 순서로 넘어갈 때를 대비하여 나머지 연산자로 index 값을 벨리데이션 해준다.
          * */
         index = (index + K - 1) % N;
         sb.append(", ").append(arr[index]);
         System.arraycopy(arr, index+1, arr, index, --N - index);
      }
      sb.append(">");
      System.out.println(sb.toString());
   }
}