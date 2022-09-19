package threading.synchronisation;

public class Solution {
    public static void main(String[] args) {
        CountDown countDown = new CountDown();
        CountDownThread t1 = new CountDownThread(countDown);
        t1.setName("Thread1");
        CountDownThread t2 = new CountDownThread(countDown);
        t2.setName("Thread2");
        t1.start();
        t2.start();
    }
}
class CountDown{
    //Thread interference | Race Condition
    private int i;
    public void doCountDown(){
        String color;
        switch (Thread.currentThread().getName()){
            case "Thread1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread2":
                color = ThreadColor.ANSI_BLACK;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }
        synchronized (this) {
            for (i = 10; i >= 1; i--) {
                System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
            }
        }
    }
}

class CountDownThread extends Thread{
    private CountDown threadCountDown;
    public CountDownThread(CountDown countDown){
        this.threadCountDown = countDown;
    }

    @Override
    public void run() {
        threadCountDown.doCountDown();
    }
}



