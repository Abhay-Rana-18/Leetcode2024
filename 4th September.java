class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String> hs = new HashSet<>();
        for (int[] obstacle : obstacles) {
            hs.add(obstacle[0] + "," + obstacle[1]);
        }

        int dx[]={0,1,0,-1};
        int dy[]={1,0,-1,0};

        int dir=0;

        int row=0;
        int col=0;

        int ans=0;
        for(int i=0;i<commands.length;i++)
        {
            if(commands[i]==-1)
            dir=(dir+1)%4;
            else if(commands[i]==-2)
            dir=(dir+3)%4;
            else
            {
                int steps=commands[i];
                while(steps>0)
                {
                    int newr=row+dx[dir];
                    int newc=col+dy[dir];
                    String nextPosition=newr+","+newc;
                    if(hs.contains(nextPosition))
                    break;
                    row=newr;
                    col=newc;
                    ans = Math.max(ans, row*row + col*col);
                    steps--;
                }
            }
        }
        return ans;
    }
}
