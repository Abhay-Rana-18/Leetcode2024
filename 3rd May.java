class Solution {
    public int compareVersion(String version1, String version2) {
        String []parts1 = version1.split("\\.");
        String []parts2 = version2.split("\\.");
        // System.out.println(Arrays.toString(parts1));
        if (parts1.length>=parts2.length) {
            for (int i=0; i<parts1.length; i++) {
            int n1 = Integer.parseInt(parts1[i]);
            if (i==parts2.length) {
                while(n1==0 && i<parts1.length) {
                    n1 = Integer.parseInt(parts1[i++]);
                }
                if (n1>0) {
                    return 1;
                }
                else {
                    return 0;
                }
            }

            int n2 = Integer.parseInt(parts2[i]);
            if (n1>n2) {
                return 1;
            }
            if(n1<n2) {
                return -1;
            }
            }
        }
        else {
            for (int i=0; i<parts2.length; i++) {
            int n2 = Integer.parseInt(parts2[i]);
            if (i==parts1.length) {
                while(n2==0 && i<parts2.length) {
                    n2 = Integer.parseInt(parts2[i]);
                    i++;
                }
                if (n2>0) {
                    return -1;
                }
                else {
                    return 0;
                }
            }

            int n1 = Integer.parseInt(parts1[i]);
            // System.out.println(i);
            // System.out.println("n1 = " + n1 +", n2 = " + n2);
            if (n1>n2) {
                return 1;
            }
            if(n1<n2) {
                return -1;
            }
        }
        }
        

        return 0;
    }
}
