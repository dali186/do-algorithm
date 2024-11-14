package algorithm_tags.shortest_distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * [최단경로](https://www.acmicpc.net/problem/1753)
 */
public class Boj1753 {
    public static class Node implements Comparable<Node> {
        private int vertex;
        private int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        public int getVertex() {
            return this.vertex;
        }

        public int getDistance() {
            return this.distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    private static final int INF = Integer.MAX_VALUE;
    private static StringBuilder builder;

    public static void dijkstra(List<List<Node>> graph, int startVertex) {
        int vertexes = graph.size();
        int[] distances = new int[vertexes];
        Arrays.fill(distances, INF);
        distances[startVertex] = 0;

        PriorityQueue<Node> pQueue = new PriorityQueue<>();
        pQueue.offer(new Node(startVertex, 0));

        while (!pQueue.isEmpty()) {
            Node currentNode = pQueue.poll();
            int currentVertex = currentNode.getVertex();
            int currentDistance = currentNode.getDistance();

            if (currentDistance > distances[currentVertex]) continue;

            for (Node neighbor : graph.get(currentVertex)) {
                int newDistance = distances[currentVertex] + neighbor.getDistance();

                if (newDistance < distances[neighbor.getVertex()]) {
                    distances[neighbor.getVertex()] = newDistance;
                    pQueue.offer(new Node(neighbor.getVertex(), newDistance));
                }
            }
        }

        for (int i = 1; i < vertexes; i++) {
            if (distances[i] == INF) {
                builder.append("INF\n");
            } else {
                builder.append(distances[i]).append("\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        builder = new StringBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] cond = reader.readLine().split(" ");
        int vertexes = Integer.parseInt(cond[0]) + 1; // 정점 번호가 1부터 시작하므로 +1
        int edges = Integer.parseInt(cond[1]);
        int startVertex = Integer.parseInt(reader.readLine());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < vertexes; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges; i++) {
            String[] conds = reader.readLine().split(" ");
            int u = Integer.parseInt(conds[0]);
            int v = Integer.parseInt(conds[1]);
            int w = Integer.parseInt(conds[2]);

            graph.get(u).add(new Node(v, w));
        }

        dijkstra(graph, startVertex);
        System.out.print(builder.toString());
    }
}
