package producerconsumerpattern;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {

    private Queue<Integer> q;
    private int capacity;
    public BlockingQueue(int cap) {
        q = new LinkedList<>();
        capacity = cap;
    }
    public boolean add(int item) {
        synchronized (q) {
            while(q.size() == capacity)
                // do something
            {
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            q.add(item);
            q.notifyAll();    // here we are notifying all the threads that the waiting threads should be ready to execute again.
            return true;
        }
    }

    public int remove() {
        synchronized (q) {
            while(q.isEmpty())
                // do something
                // Note: Since the queue is empty, it can't remove anything. In this case, the thread has acquired the lock but still can't do anything as there is no element in the queue
                // now in this case, the thread will wait for the other thread to add something in the queue
            {
                try {
                    q.wait();                   // this thread will wait, the lock will be relinquished so that other thread can access the resource.
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            int element = q.poll();
            q.notifyAll();
            return element;
        }
    }
}
