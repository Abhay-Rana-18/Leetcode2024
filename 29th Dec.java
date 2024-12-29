class Solution {



    int dp[][];
    int freq[][];
    int mod = 1000000007;
    public int numWays(String[] words, String target) {
        int wordLength = words[0].length();
        int targetLength = target.length();
        dp = new int[wordLength][targetLength];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        // do some pre computation to store the frequencies of each char for every col
        // compress the n ary recursion tree to binary tree 
        // so recurrence becomes -->
        // res = ways_not_matching + ways_matching*freq(char in that col);
        freq = new int[words[0].length()][26];
        for (String word : words) {
            for (int j = 0; j < wordLength; j++) {
                int character = word.charAt(j) - 'a';
                freq[j][character]++;
            }
        }
        return (int) solve(0,0,words,target);
    }

    public long solve(int colIndex,int targetPos,String[] words,String target){
        //base case
        //insufficiency case where either u have less columns than the chars in target left to match
        if(target.length()-targetPos > words[0].length()-colIndex){
            return 0;
        }
        // targetPos reaches out of bounds means , match was successful
        if(targetPos>=target.length()){
            return 1;
        }
        if(dp[colIndex][targetPos]!=-1) return dp[colIndex][targetPos];
        //colIndex reaches out of bounds is unneccessary as its handeled in the first if guard condn
        long result = 0;
        int curPos = target.charAt(targetPos)-'a';
        //exclude case - where u skip the current col 
        result = (result+solve(colIndex+1,targetPos,words,target));
        if(freq[colIndex][curPos]>0){
            //include case
            result =result+ solve(colIndex+1,targetPos+1,words,target)*freq[colIndex][curPos];
        }

        return dp[colIndex][targetPos]=(int)(result%mod);
    }
}
