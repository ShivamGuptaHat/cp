package threading.using_runnable;

public class Solution {
    public static void main(String[] args) {
        //Using runnable interface
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("From: " + Thread.currentThread().getName());
            }
        });
        t.setName("Runnable class");
        t.start();
        System.out.println("From: " + Thread.currentThread().getName());
    }
}
