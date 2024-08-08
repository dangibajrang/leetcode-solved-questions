class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int index = 0;
        int steps = 1;
        int x = rStart, y = cStart;
        
        result[index++] = new int[] {x, y};
        
        // Directions: East, South, West, North
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        while (index < rows * cols) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < steps; j++) {
                    x += dx[i];
                    y += dy[i];
                    
                    if (x >= 0 && x < rows && y >= 0 && y < cols) {
                        result[index++] = new int[] {x, y};
                    }
                }
                // Increase steps after completing two directions (East and South or West and North)
                if (i % 2 == 1) {
                    steps++;
                }
            }
        }
        
        return result;
    }
}
