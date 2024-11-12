package algorithm_tags.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/***
 * [크로아티아 알파벳](https://www.acmicpc.net/problem/2941)
 * 1. char 배열로 문자열을 입력받는다.
 * 2. 큐를 생성한다.
 * 3. char 배열의 값을 하나씩 큐에 넣는다.
 *      3-1. 이때, 영문이 아닌 값을 만나면 큐에서 하나 꺼내서 현재 값과 붙여서 크로아티아 알파벳과 비교한다.
 *      3-2. z인 경우 하나를 더 꺼낸 뒤, 비교한다.
 * 4. 큐의 들어있는 갯수를 출력한다.
 */
public class Boj2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] charList = reader.readLine().toCharArray();
        Stack<Character> charStack = new Stack<>();

        for(char al : charList) {
            if (!charStack.isEmpty() && al == '-') {
                charStack.pop();
            } else if (!charStack.isEmpty() && al == 'j'){
                char preChar = charStack.pop();
                if (preChar != 'n' && preChar != 'l') {
                    charStack.add(preChar);
                }
            } else if (al == '=') {
                char preChar = charStack.pop();
                if (!charStack.isEmpty() && preChar == 'z') {
                    char formerChar = charStack.pop();
                    if (formerChar != 'd') {
                        charStack.add(formerChar);
                    }
                } else if (preChar != 'c' && preChar != 's' && preChar != 'z') {
                    charStack.add(preChar);
                }
            }
            charStack.add(al);
        }

        System.out.println(charStack.size());
    }
}
