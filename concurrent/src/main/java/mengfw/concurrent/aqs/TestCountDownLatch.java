package mengfw.concurrent.aqs;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(4);
        for (int i = 0;i < 5;i ++){
            new Thread(new Runnable() {

                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("run ");
                    latch.countDown();
                }
            }).start();
        }
        new Thread(new Runnable() {
            public void run() {
                try {
                    latch.await();
                    System.out.println("end 2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        latch.await();
        System.out.println("end ");

    }
}
