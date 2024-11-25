class Solution {
    int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int slidingPuzzle(int[][] board) {
        int row = board.length, col = board[0].length;
        int n = board.length;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                sb.append(board[i][j]);
            }
        }
        String str = sb.toString();
        Queue<String> queue = new LinkedList<>();
        String find = "123450";
        queue.offer(str);
        HashSet<String> set = new HashSet<>();
        set.add(str);
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                String cur = queue.poll();
                int idx = cur.indexOf('0');
                int i = idx / col, j = idx % col;
                if(cur.equals(find)) return step;
                for(int[] d : dir){
                    int ii = i + d[0];
                    int jj = j + d[1];
                    if(ii < 0 || ii >= row || jj < 0 || jj >= col) continue;
                    String temp = convt(cur, idx, ii * col + jj);
                    if(!set.add(temp)) continue;
                    queue.offer(temp);
                }
            }
            step++;
        }
        return -1;
    }
    public String convt(String s, int i, int j){
        char[] c = s.toCharArray();
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
        return String.valueOf(c);
    }
}
