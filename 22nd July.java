class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (heights[j]>heights[i]) {
                    int temp = heights[j];
                    heights[j] = heights[i];
                    heights[i] = temp;
                    String t = names[j];
                    names[j] = names[i];
                    names[i] = t;
                }
            }
        }
        return names;
    }
}
