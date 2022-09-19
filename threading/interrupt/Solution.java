package threading.interrupt;

public class Solution {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++)
                    System.out.println("From: " + Thread.currentThread().getName());
                try{
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    System.out.println("Has been interrupted!!!");
                    return;
                }
                System.out.println("From: " + Thread.currentThread().getName() + " word is done successfully!!");
            }
        });

        thread.setName("runnable");
        thread.start();

        System.out.println("From: " + Thread.currentThread().getName());
        thread.interrupt(); // It will be remembered by JVM, that the moment "Runnable" thread go to sleep immediately JVM will wake that thred up
        System.out.println("After Interrupt!!");
    }
}
