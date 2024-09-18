class Solution {
    public String largestNumber(int[] nums) {
        // Step 1: Convert int[] to Integer[]
        Integer[] numsArr = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        // Step 2: Sort the array using a custom comparator
        Arrays.sort(numsArr, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                String aStr = a.toString();
                String bStr = b.toString();
                
                // Compare based on concatenated strings to form the largest number
                return (bStr + aStr).compareTo(aStr + bStr);
            }
        });

        // Step 3: Build the largest number by concatenating the sorted numbers
        StringBuilder ans = new StringBuilder();
        for (int num : numsArr) {
            ans.append(num);
        }

        // Step 4: Edge case: if the largest number is "0", return "0"
        if (ans.charAt(0) == '0') {
            return "0";
        }
        
        return ans.toString();
    }
}
