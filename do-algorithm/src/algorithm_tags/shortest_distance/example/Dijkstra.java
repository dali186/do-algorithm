package algorithm_tags.shortest_distance.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

    public static class Node implements Comparable<Node> {
        private int vertex;
        private int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        public int getVertex() {
            return vertex;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    private static final int INF = Integer.MAX_VALUE;

    public static void dijkstra(List<List<Node>> graph, int start) {
        int V = graph.size();
        int[] distances = new int[V];
        Arrays.fill(distances, INF);
        distances[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentVertex = current.getVertex();
            int currentDistance = current.getDistance();

            if (currentDistance > distances[currentVertex]) continue;

            for (Node neighbor : graph.get(currentVertex)) {
                int newDistance = distances[currentVertex] + neighbor.getDistance();

                if (newDistance < distances[neighbor.getVertex()]) {
                    distances[neighbor.getVertex()] = newDistance;
                    pq.offer(new Node(neighbor.getVertex(), newDistance));
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (distances[i] == INF) {
                System.out.println("Node " + i + " is unreachable from start node.");
            } else {
                System.out.println("Distance from start to node " + i + " is " + distances[i]);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Node(1, 10));
        graph.get(0).add(new Node(2, 3));
        graph.get(1).add(new Node(2, 1));
        graph.get(1).add(new Node(3, 2));
        graph.get(2).add(new Node(1, 4));
        graph.get(2).add(new Node(3, 8));
        graph.get(2).add(new Node(4, 2));
        graph.get(3).add(new Node(4, 7));
        graph.get(4).add(new Node(3, 9));

        dijkstra(graph, 0);
    }
}
