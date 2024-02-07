class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> arr = new ArrayList<>();
        int next;
        int num;
        for (int i=1; i<=9; i++) {
            next = i+1;
            num = i;
            while (num<=high && next<=9) {
                num = num * 10 + next;
                if (num>=low && num<=high) {
                    arr.add(num);
                }
                next++;
            }
        }
        Collections.sort(arr);
        return arr;   
    }
}
