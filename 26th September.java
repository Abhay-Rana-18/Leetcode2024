class MyCalendar {
    TreeMap<Integer, Integer>map;
    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer B1 = map.floorKey(start);
        Integer B2 = map.ceilingKey(start);

        if ((B1==null || map.get(B1)<=start) && (B2==null || end<=B2)) {
            map.put(start, end);
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
