package algorithm_tags.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * [추월](https://www.acmicpc.net/problem/2002)
 */
public class Boj2002 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cars = Integer.parseInt(reader.readLine());

        Map<String, Integer> enterMap = new LinkedHashMap<>();
        for (int i = 0; i < cars; i++) {
            enterMap.put(reader.readLine(), i);
        }

        int result = 0;
        for (int i = 0; i < cars; i++) {
            String exitCar = reader.readLine();
            Iterator<String> iterator = enterMap.keySet().iterator();
            while (iterator.hasNext()) {
                if (enterMap.get(exitCar) > enterMap.get(iterator.next())) {
                    result++;
                    break;
                }
            }
            enterMap.remove(exitCar);
        }
        System.out.println(result);
    }
}
