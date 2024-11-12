package algorithm_tags.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * [생태학](https://www.acmicpc.net/problem/4358)
 */
public class Boj4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> treeMap = new TreeMap<>();
        int treeCnt = 0;

        while (true) {
            String tree = reader.readLine();
            if (tree == null || tree.equals("")) break;

            treeMap.put(tree, treeMap.getOrDefault(tree, 0) + 1);
            treeCnt++;
        }

        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            double ratio = entry.getValue() * 100.0 / treeCnt;
            String result = entry.getKey() + " " + String.format("%.4f", ratio);

            System.out.println(result);
        }
    }
}
