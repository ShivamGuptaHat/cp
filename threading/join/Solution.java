package threading.join;


public class Solution {
    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("From: " + Thread.currentThread().getName());
                try{
                    Thread.sleep(300l);
                }catch (InterruptedException e){}
            }
        });
        t1.setName("Thread1");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("From: " + Thread.currentThread().getName());
                try{
                    t1.join();
//                  t1.join(1000); thread t2 will wait 1 sec for thread t1 to complete
                }catch (InterruptedException e){}
                System.out.println("Thread1 is done, now i'm started!!");
            }
        });

        t2.setName("Thread2");
        t2.start();
    }
}
