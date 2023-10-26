package synchronizationdemo;

public class Stack {
    private int[] array;
    private int stackTop;
    Object lock; // if you want either of the push or pop to work one at a time, use only one object.


    public Stack(int capacity) {
        array = new int[capacity];
        stackTop = -1;
        lock = new Object();
    }

    public boolean isEmpty() {
        return stackTop < 0;
    }

    public synchronized boolean push(int element) {
            if (isFull()) return false;
            ++ stackTop;

            try { Thread.sleep(1000); } catch (Exception e) { }
            array[stackTop] = element;
            return true;

    }

    public synchronized int pop() {
            if (isEmpty()) return  Integer.MIN_VALUE;
            int obj = array[stackTop];
            array[stackTop] = Integer.MIN_VALUE;

            try { Thread.sleep(1000);} catch (Exception e) {}

            stackTop --;
            return obj;

    }

    public boolean isFull() {
        return stackTop >= array.length-1;
    }


}
