class MyQueue {
    public int []stack1 = new int [100];
    public int []stack2 = new int[100];
    int top1 = -1;
    int top2 = -1;
    public MyQueue() {
        
    }
    
    public void push(int x) {
        stack1[++top1] = x;

         int []temp = new int[100];
        int top = top1;
        int ptr = -1;
        while (top!=-1) {
            temp[++ptr] = stack1[top--];
        }
        stack2 = temp;
        top2 = ptr;

    }
    
    public int pop() {
       int rem = stack2[top2];
       top2 = top2 - 1;
        // System.out.println(rem);

        int []temp = new int[100];
        int ptr = -1;
        int top = top2;
        while(top!=-1) {
            temp[++ptr] = stack2[top--];
        }
        stack1 = temp;
        top1 = ptr;
        return rem;
    }
    
    public int peek() {
        return stack2[top2];
    }
    
    public boolean empty() {
        return top2==-1;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
