package algorithm_tags.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * [회문](https://www.acmicpc.net/problem/17609)
 * 1. 문자열을 받는다.
 * 2. 문자열이 짝수/홀수 판단한다.
 *      2-1. 짝수의 경우, isPalindrome 메소드 실행
 */
public class Boj17609 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int reps = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < reps; i++) {
            String text = reader.readLine();

            if (text.length() % 2 == 0) {
                //짝수인 경우
                builder.append(isPalindrome(text.toCharArray()));
                builder.append("\n");
            } else {
                //홀수인 경우
                for (int j = 0; j < text.length(); j++) {
                    String rmString = text.substring(0, j) + text.substring(j + 1);
                    int palindromeResult = isPalindrome(rmString.toCharArray());
                }
            }
        }
    }

    public static int isPalindrome(char[] chars) {
        Stack<Character> preStack = new Stack<>();
        Queue<Character> postQueue = new LinkedList<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars.length / 2 > i) {
                postQueue.add(chars[i]);
            } else {
                preStack.push(chars[i]);
            }
        }

        for (int i = 0; i < chars.length / 2; i++) {
            if (postQueue.poll() != preStack.pop()) return 2;
        }

        return 0;
    }
}
