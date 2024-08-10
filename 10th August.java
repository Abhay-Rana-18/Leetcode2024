class Solution {
    public int regionsBySlashes(String[] grid) {
        int ans = 0;
        int n = grid.length;
        boolean[][] visitedL = new boolean[n][n];
        boolean[][] visitedR = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!visitedL[i][j]) {
                    ++ans;
                    bfs(new int[]{i, j, 0}, grid, visitedL, visitedR);
                }
                if (!visitedR[i][j]) {
                    ++ans;
                    bfs(new int[]{i, j, 1}, grid, visitedL, visitedR);
                }
            }
        }
        return ans;
    }

    private void bfs(int[] curr, String[] grid, boolean[][] visitedL, boolean[][] visitedR) {
        Queue<int[]> toProc = new LinkedList<>();
        int n = grid.length;
        toProc.add(curr);
        switch (grid[curr[0]].charAt(curr[1])) {
            case '\\':
            case '/':
                if (curr[2] == 1) {
                    visitedR[curr[0]][curr[1]] = true;
                } else {
                    visitedL[curr[0]][curr[1]] = true;
                }
                break;
            case ' ':
                visitedR[curr[0]][curr[1]] = true;
                visitedL[curr[0]][curr[1]] = true;
        }
        
        while (!toProc.isEmpty()) {
            curr = toProc.poll();
            for (int[] next : adj(curr[0], curr[1], grid, curr[2])) {
                if (next[2] == 1 && visitedR[next[0]][next[1]]) {
                    continue;
                }
                if (next[2] == 0 && visitedL[next[0]][next[1]]) {
                    continue;
                }
                char slash = grid[next[0]].charAt(next[1]);
                if (slash == ' ') {
                    visitedL[next[0]][next[1]] = true;
                    visitedR[next[0]][next[1]] = true;
                } else if (next[2] == 1) {
                    visitedR[next[0]][next[1]] = true;
                } else {
                    visitedL[next[0]][next[1]] = true;
                }
                toProc.add(next);
            }
        }
    }

    private boolean outOfBound(int r, int c, int n) {
        return r < 0 || r >= n || c < 0 || c >= n;
    }

    private List<int[]> adj(int r, int c, String[] grid, int side) {
        int n = grid.length;
        char slash = grid[r].charAt(c);
        List<int[]> out = new ArrayList<>();
        switch (slash) {
            case ' ':
                if (!outOfBound(r + 1, c, n)) {
                    out.add(new int[]{r + 1, c, grid[r + 1].charAt(c) == '\\' ? 1 : 0});
                }
                if (!outOfBound(r - 1, c, n)) {
                    out.add(new int[]{r - 1, c, grid[r - 1].charAt(c) == '\\' ? 0 : 1});
                }
                if (!outOfBound(r, c + 1, n)) {
                    out.add(new int[]{r, c + 1, 0});
                }
                if (!outOfBound(r, c - 1, n)) {
                    out.add(new int[]{r, c - 1, 1});
                }
                break;
            case '\\':
                if (side == 1) {
                    if (!outOfBound(r - 1, c, n)) {
                        out.add(new int[]{r - 1, c, grid[r - 1].charAt(c) == '\\' ? 0 : 1});
                    }
                    if (!outOfBound(r, c + 1, n)) {
                        out.add(new int[]{r, c + 1, 0});
                    }
                } else {
                    if (!outOfBound(r + 1, c, n)) {
                        out.add(new int[]{r + 1, c, grid[r + 1].charAt(c) == '\\' ? 1 : 0});
                    }
                    if (!outOfBound(r, c - 1, n)) {
                        out.add(new int[]{r, c - 1, 1});
                    }
                }
                break;
            case '/':
                if (side == 1) {
                    if (!outOfBound(r + 1, c, n)) {
                        out.add(new int[]{r + 1, c, grid[r + 1].charAt(c) == '\\' ? 1 : 0});
                    }
                    if (!outOfBound(r, c + 1, n)) {
                        out.add(new int[]{r, c + 1, 0});
                    }
                } else {
                    if (!outOfBound(r - 1, c, n)) {
                        out.add(new int[]{r - 1, c, grid[r - 1].charAt(c) == '\\' ? 0 : 1});
                    }
                    if (!outOfBound(r, c - 1, n)) {
                        out.add(new int[]{r, c - 1, 1});
                    }
                }
        }
        return out;
    }
}
