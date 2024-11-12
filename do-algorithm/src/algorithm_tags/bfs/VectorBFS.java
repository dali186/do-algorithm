package algorithm_tags.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class VectorBFS {
    private static class Graph {
        private int n;
        private ArrayList<Integer>[] adj;

        Graph(int n) {
            this.n = n;
            this.adj = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        void addEdge(int v, int w) {
            if (v > n || w > n || v < 1 || w < 1) {
                throw new IllegalArgumentException("노드 번호가 그래프 크기를 벗어났습니다.");
            }
            //방향성이 없을 경우 w -> v 도 추가해주면 된다.
            adj[v].add(w);
        }

        void BFS(int startVertex) {
            boolean[] visited = new boolean[n + 1];
            Queue<Integer> queue = new LinkedList<>();
            StringBuilder result = new StringBuilder();

            visited[startVertex] = true;
            queue.add(startVertex);

            while (!queue.isEmpty()) {
                int currentVertex = queue.poll();
                result.append(currentVertex).append("\n");

                for (int nextVertex : adj[currentVertex]) {
                    if (!visited[nextVertex]) {
                        visited[nextVertex] = true;
                        queue.add(nextVertex);
                    }
                }
            }

            System.out.print(result);
        }

        void printGraph() {
            for (int i = 1; i <= n; i++) {
                System.out.print("Node " + i + ": ");
                for (Integer node : adj[i]) {
                    System.out.print(node + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(1, 2);
        graph.addEdge(2, 5);
        graph.addEdge(5, 1);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);

        System.out.println("BFS starting from node 2:");
        graph.BFS(2);

        System.out.println("\nGraph structure:");
        graph.printGraph();
    }
}
