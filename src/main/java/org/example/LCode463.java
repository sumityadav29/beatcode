package org.example;

public class LCode463 {
    public static void main(String[] args) {

    }

    private boolean isWater(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return true;
        }
        return grid[i][j] == 0;
    }

    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0 ; j < grid[i].length ; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                for (int[] dir : directions) {
                    int nr = i + dir[0];
                    int nc = j + dir[1];
                    perimeter += isWater(grid, nr, nc) ? 1 : 0;
                }
            }
        }

        return perimeter;
    }
}
