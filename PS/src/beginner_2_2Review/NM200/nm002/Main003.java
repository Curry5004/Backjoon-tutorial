package beginner_2_2Review.NM200.nm002;


/*
 * 모범 답안
 * URL : https://www.acmicpc.net/source/20455868
 * */

import java.io.*;
import java.util.*;

public class Main003 {

    public static void main(String[] args) throws IOException {        
        Reader.init(System.in);

        StringBuilder answer = new StringBuilder();
        int T = Reader.nextInt();
        while (T-- > 0) {
            char[] line = Reader.nextLine().toCharArray();

            int start = 0;
            
            //나처럼 split 하지 않고 한 줄의 String을 전부 Char로 받아버린다.
            for (int i = 0; i < line.length; i++) {
                char ch = line[i];
                
                /*
                 * 스페이스바 Validation
                 * */
                if (ch == ' ') {
                	/*
                	 * 1) 처음엔 공란이 들어올 수 없다
                	 * 2) 그러므로 스페이스바가 있는 배열 숫자는 0보다 크다
                	 * 3) 따라서 앞에 단어가 존재하므로 -- 식을 사용하여 거꾸로 값을 넣어줘버림
                	 * */
                    for (int j = i - 1; j >= start; j--) {
                        answer.append(line[j]);
                    }
                    
                    /*
                     * Start의 의도는?
                     * */
                    answer.append(' ');
                    start = i + 1;
                }

                /*
                 * 모든 벨리데이션이 끝났다면?
                 * */
                if (i == line.length - 1) {
                    for (int j = line.length - 1; j >= start; j--) {
                        answer.append(line[j]);
                    }
                }
            }
            answer.append('\n');
        }

        System.out.println(answer);
    }

    static class Reader {

        static BufferedReader reader;
        static StringTokenizer tokenizer;

        public static void init(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input));
        }

        public static String nextLine() throws IOException {
            return reader.readLine();
        }

        public static String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public static void close() {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {

                }
            }
        }
    }
}
