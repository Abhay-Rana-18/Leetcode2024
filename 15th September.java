class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Character,Integer> vals= new HashMap<>();
        vals.put('a',1);
        vals.put('e',2);
        vals.put('i',4);
        vals.put('o',8);
        vals.put('u',16);

        int ghost=0;
        int maxLen=0;

        //Remembering where i have seen this last 
        int[] memory =new int[32];//32 because 1 + 2 + 4 + 8 + 16 = 31 ans 0 index takes -1 to denote its starting point
        Arrays.fill(memory,-5);
        memory[0]=-1;//before starting i haven't seen anything so i've seen 0 before traversing the array
        char[] c = s.toCharArray();
        for(int i=0;i<c.length;i++){
            char chr =c[i];
            ghost^=vals.getOrDefault(chr,0);//xor only vowels

            if(memory[ghost]==-5){//-5 indicates i haven't seen the anser before like a^i or i
                memory[ghost]=i;//so im updating where i have seen it
            }else{//if its not -5 means ive seen it somewhere 
                //so subtracting current place with previous place would give me the result
                maxLen=Math.max(maxLen,i-memory[ghost]); 
            }
        }

        return maxLen;
    }
    
}
