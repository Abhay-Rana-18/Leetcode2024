class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i=0; i<m; i++) {
            int min = 0;
            for (int j=0; j<n; j++) {
                if (matrix[i][j]<matrix[i][min]) {
                    min = j;
                }
            }
            boolean isAdd = true;
            for (int k=0; k<m; k++) {
                if (matrix[i][min]<matrix[k][min]) {
                    isAdd = false;
                    break;
                }
            }
            if (isAdd) {
                ans.add(matrix[i][min]);
            }
        }
        return ans;
    }
}
