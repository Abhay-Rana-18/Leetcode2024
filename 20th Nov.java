class Solution {
    public int takeCharacters(String s, int k) {
        if (k==0) return 0;
        int ans = 0;
        int n = s.length();
        int[][] left = new int[n][3];
        int a = 0;
        int b = 0;
        int c = 0;
        int idx = -1;
        for (int i=0; i<n; i++) {
            char ch = s.charAt(i);
            if (ch=='a') {
                a++;
            }
            else if(ch=='b') {
                b++;
            }
            else {
                c++;
            }
            left[i][0] = a;
            left[i][1] = b;
            left[i][2] = c;

            // checking the condition
            if (a>=k && b>=k && c>=k) {
                idx = i;
                break;
            }
        }

        if (idx == -1) return -1;
        // System.out.println(idx);

        a=0; b=0; c=0;
        ans = idx+1;
        System.out.println(idx);
        for (int i=n-1; i>=0; i--) {
            char ch = s.charAt(i);
            if (ch=='a') {
                a++;
            }
            else if(ch=='b') {
                b++;
            }
            else {
                c++;
            }

                // System.out.println("a: "+a+left[idx][0] + ", b: "+b+left[idx][1] + ", c: "+c+left[idx][2] +", idx: "+idx+", i: "+i);
            boolean sh = false;
            while ((idx>=0) && (a+left[idx][0]>=k) && (b+left[idx][1]>=k) && (c+left[idx][2]>=k)) {
                idx--;
                sh = true;
            }

            if (sh) {
                idx++;
            }
            // System.out.println("i: "+i+", idx: "+idx);


            ans = Math.min(ans, idx+1+n-i);
            if (a>=k && b>=k && c>=k) {
                ans = Math.min(ans, n-i);
            }
        }

        return ans;

    }
}
