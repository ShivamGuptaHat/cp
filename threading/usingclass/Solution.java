package threading.usingclass;



class AnotherThread extends Thread{
    @Override
    public void run() {
        System.out.println("From: " + Thread.currentThread().getName());
    }
}

public class Solution {
    public static void main(String[] args) {
        AnotherThread at = new AnotherThread();
        at.setName("AnotherThread");
        at.start();
        System.out.println("From: " + Thread.currentThread().getName());
    }
}
