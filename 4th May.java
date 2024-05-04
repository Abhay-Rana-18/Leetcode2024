class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int boats = 0;
        int low = 0;
        int high = n-1;
        while (low<=high) {
            int sum = people[low]+people[high];
            if (sum<=limit) {
                boats++;
                low++;
                high--;
            }
            else {
                boats++;
                high--;
            }
        }

        return boats;
    }
}
