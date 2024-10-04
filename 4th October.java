class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        int sum = skill[0] + skill[n-1];
        long ans = skill[0] * skill[n-1];
        for (int i=1; i<n/2; i++) {
            int temp = skill[i] + skill[n-1-i];
            if (temp != sum) {
                return -1;
            }
            ans += skill[i] * skill[n-1-i];
            // System.out.println(ans);
        }
        return ans;
    }
}
