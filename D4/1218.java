import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        map.put('>', '<');

        for(int t=1; t<=10; t++) {
            int N = Integer.parseInt(br.readLine());
            String s = br.readLine();

            char[] stack = new char[N];
            int top = -1;
            int answer = 1;

            loop: for(char ch: s.toCharArray()) {
                switch (ch) {
                    case '(': case '[': case '{': case '<':
                        stack[++top] = ch;
                        break;
                    case ')': case ']': case '}': case '>':
                        if(top >= 0 && stack[top] == map.get(ch))
                            top--;
                        else {
                            answer = 0;
                            break loop;
                        }
                }
            }

            bw.write("#" + t + " " + answer + "\n");
        }

        bw.flush();
        bw.close();
    }
}