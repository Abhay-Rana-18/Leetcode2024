class MyCircularDeque {
    private int capacity;
    private int front;
    private int rear;
    private int[] start;

    public MyCircularDeque(int k) {
        this.capacity = k;
        this.front = -1;
        this.rear = -1;
        this.start = new int[k];
    }
    
    public boolean insertFront(int value) {
        if(isFull())
            return false;
        if(isEmpty()){
            front = 0;
            rear = 0;
        }
        else if(front == 0)
            front = capacity - 1;
        else
            front--;
        start[front] = value;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull())
            return false;
        if(isEmpty()){
            front = 0;
            rear = 0;
        }
        else
            rear = (rear + 1) % capacity;
        start[rear] = value;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty())
            return false;
        if(front == rear){
            front = -1;
            rear = -1;
        }
        else
            front = (front + 1) % capacity;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty())
            return false;
        if(front == rear){
            front = -1;
            rear = -1;
        }
        else if(rear == 0)
            rear = capacity - 1;
        else
            rear--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty())
            return -1;
        return start[front];
    }
    
    public int getRear() {
        if(isEmpty())
            return -1;
        return start[rear];
    }
    
    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }
    
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}
