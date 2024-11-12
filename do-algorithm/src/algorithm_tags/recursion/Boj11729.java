package algorithm_tags.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [하노이 탑 이동 순서](https://www.acmicpc.net/problem/11729)
 */
public class Boj11729 {
    static StringBuilder builder;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        builder = new StringBuilder();
        cnt = 0;
        recursionHanoi(N, 1, 2, 3);

        System.out.println(cnt + "\n" + builder);
    }

    public static void recursionHanoi(int n, int from, int temp, int to) {
        cnt++;
        if (n == 1) {
            builder.append(from + " " + to + "\n");
            return;
        }

        recursionHanoi(n-1, from, to, temp);
        builder.append(from + " " + to + "\n");
        recursionHanoi(n-1, temp, from, to);
    }
}
