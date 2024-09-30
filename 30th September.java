class CustomStack {
    int[] arr;
    int index;
    public CustomStack(int maxSize) {
        arr = new int[maxSize];
    }
    
    public void push(int x) {
        if (index<arr.length) {
            arr[index++] = x;
        }
    }
    
    public int pop() {
        if (index==0) {
            return -1;
        }
        index--;
        return arr[index];
    }
    
    public void increment(int k, int val) {
        if (k>index) {
            k = index;
        }
        for (int i=0; i<k; i++) {
            arr[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
