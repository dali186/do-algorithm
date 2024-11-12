package algorithm_tags.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * [연결 요소의 개수](https://www.acmicpc.net/problem/11724)
 */
public class Boj11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] cond = reader.readLine().split(" ");
        // 노드의 개수
        int nodes = Integer.parseInt(cond[0]);
        // 간선의 개수
        int edges = Integer.parseInt(cond[1]);
        // 인접 리스트 초기화
        List<Integer>[] adj = new ArrayList[nodes + 1];
        for (int i = 1; i <= nodes; i++) {
            adj[i] = new ArrayList<>();
        }
        // 인접 리스트 정보 추가
        for (int i = 0; i < edges; i++) {
            String[] adjCond = reader.readLine().split(" ");
            int u = Integer.parseInt(adjCond[0]);
            int v = Integer.parseInt(adjCond[1]);
            adj[u].add(v);
            adj[v].add(u);
        }
        //방문이력
        boolean[] visited = new boolean[nodes + 1];
        int result = 0;

        for (int i = 1; i <= nodes; i++) {
            if (!visited[i]) {
                bfs(i, adj, visited);
                result++;
            }
        }
        System.out.println(result);
    }

    public static void bfs(int startVertex, List<Integer>[] adj, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int nextVertex : adj[currentNode]) {
                if (!visited[nextVertex]) {
                    visited[nextVertex] = true;
                    queue.add(nextVertex);
                }
            }
        }
    }
}
