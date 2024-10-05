class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int fre1[]=new int[26];
        int fre2[]=new int[26];
        int len1= s1.length();
        int len2 = s2.length();
        if(len1 > len2)
        return false;

        for(int i=0;i<len1;i++) 
            fre1[s1.charAt(i)-97]++;

        for(int i=0;i<len1;i++) 
            fre2[s2.charAt(i)-97]++;
        
        if(Arrays.equals(fre1,fre2))
            return true;

        for(int i=len1;i<len2;i++) {
             fre2[s2.charAt(i)-97]++;

             //make the out of sliding window character's frequency as 0
             fre2[s2.charAt(i-len1)-97] --;

             if(Arrays.equals(fre1,fre2))
            return true;
        }
        return false;
    }

    
}
