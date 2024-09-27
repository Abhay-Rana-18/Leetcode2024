class Event {
    int start;
    int end;
    public Event(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
class MyCalendarTwo {
    List<Event>bookings;
    List<Event>overlapped;
    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlapped = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (Event e: overlapped) {
            if (doesOverlap(e, start, end)) {
                return false;
            }
        }

        for (Event e: bookings) {
            if (doesOverlap(e, start, end)) {
                overlapped.add(add(e, start, end));
            }
        }

        bookings.add(new Event(start, end));
        return true;
    }

    public boolean doesOverlap(Event e, int start, int end) {
        return Math.max(e.start, start) < Math.min(e.end, end);
    }

    public Event add(Event e, int start, int end) {
        return new Event(Math.max(e.start, start), Math.min(e.end, end));
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
