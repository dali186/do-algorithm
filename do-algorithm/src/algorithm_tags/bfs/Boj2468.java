package algorithm_tags.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * [안전 영역](https://www.acmicpc.net/problem/2468)
 */
public class Boj2468 {
    public static class Area {
        int level;
        int length;
        int[][] area;
        boolean[][] drown;

        public Area(int[][] area) {
            this.area = area;
            this.length = area.length;
        }

        public void setLevel(int n) {
            this.level = n;
        }

        public void setDrown() {
            drown = new boolean[length][length];

            for (int i = 0; i < area.length; i++) {
                for (int j = 0; j < area.length; j++) {
                    if (area[i][j] <= level) drown[i][j] = true;
                }
            }
        }

        public void bfs(int x, int y, boolean[][] visited) {
            int[] dx = {0, 0, -1, 1};
            int[] dy = {-1, 1, 0, 0};
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{x, y});
            visited[x][y] = true;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int currentX = current[0];
                int currentY = current[1];

                for (int i = 0; i < 4; i++) {
                    int nextX = currentX + dx[i];
                    int nextY = currentY + dy[i];

                    if (nextX >= 0 && nextX < length && nextY >= 0 && nextY < length && !drown[nextX][nextY] && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }

        public int countAreas() {
            int areas = 0;
            boolean[][] visited = new boolean[length][length];

            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (!drown[i][j] && !visited[i][j]) {
                        bfs(i, j, visited);
                        areas++;
                    }
                }
            }
            return areas;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());

        int[][] cond = new int[size][size];
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            String[] list = reader.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                int level = Integer.parseInt(list[j]);
                cond[i][j] = level;
                if (maxValue <= level) maxValue = level;
            }
        }

        Area area = new Area(cond);
        int result = 0;
        for (int i = 0; i < maxValue; i++) {
            area.setLevel(i);
            area.setDrown();
            int areas = area.countAreas();
            result = Math.max(result, areas);
        }
        System.out.println(result);
    }
}
