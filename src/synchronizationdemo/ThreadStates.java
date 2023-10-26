package synchronizationdemo;

public class ThreadStates {
    public static void main(String[] args) {
        Thread thread = new Thread(() ->  {
            try {
                Thread.sleep(1);
                for(int i=10000; i>0; i--);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }, "States");

        thread.start();

        while(true) {
            Thread.State state = thread.getState();
            System.out.println(state);
            if(state == Thread.State.TERMINATED) break;
        }
    }
}
