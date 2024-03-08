class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[]numbers = new int[101];
        for (int i=0; i<nums.length; i++) {
            numbers[nums[i]]++;
        }
        System.out.println(Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
        int max = numbers.length-1;
        int count = 0;
        while (numbers[max]==numbers[numbers.length-1]) {
            count+=numbers[max];
            max--;
        }
        return count;
    }
}
