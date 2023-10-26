package ThreadCreation;

import synchronizationdemo.Stack;

public class ThreadTester {

    public static void main(String[] args) {

        /*System.out.println("main is starting");
        Thread thread1 = new Thread1("Thread1");
//        thread1.setDaemon(true);
        thread1.start();

//        Thread thread2 = new Thread(new Thread2() , "thread2");
        Thread thread2 = new Thread(() -> {
            for(int i=0; i<5; i++) {
                System.out.println(Thread.currentThread() + "," + i);
            }
        } , "thread2");
        thread2.start();

        System.out.println("main is exiting");*/

        Stack stack = new Stack(5);

        new Thread(() -> {
                int counter = 0;
                while(++ counter < 10)
                    System.out.println("Pushed: " + stack.push(100));
            } , "Pusher").start();

        new Thread(() -> {
            int counter = 0;
            while(++ counter < 10)
                System.out.println("Popped: " + stack.pop());
        } , "Popper").start();

        System.out.println("main is exiting");
    }
}
