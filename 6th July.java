class Solution {
    public int passThePillow(int n, int time) {
        if (time<n) {
            return time+1;
        }
        if (n<2) {
            return n;
        }
        if (n==2) {
            return (time%n)+1;
        }
        int rem = time%(n-1);
        int side = time/(n-1);
        if (side%2==0) {
            return rem+1;
        }
        else {
            return n-rem;
        }
    }
}
