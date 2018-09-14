package mengfw.concurrent.thread;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final Object lock = new Object();
        final List<String> list = new ArrayList<String>();
        final Thread t3 = new Thread(new Runnable() {
            public void run() {
                while (true){
                    synchronized (lock){
                        System.out.println("in 3");
                        if(list.size() != 2){
                            try {
                                System.out.println("wait 3");
                                lock.wait();

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else {
                            list.add("武");
                            System.out.println("add 3");
                            lock.notifyAll();
                            System.out.println("notify 3");
                            break;
                        }
                    }
                }
            }
        });
        t3.start();
        final Thread t2 = new Thread(new Runnable() {
            public void run() {
                while(true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock){
                        System.out.println("in 2");
                        if(list.size() != 1){
                            try {
                                System.out.println("wait 2");
                                lock.wait();

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else {
                            list.add("凡");
                            System.out.println("add 2");
                            lock.notifyAll();
                            System.out.println("notify 2");
                            break;
                        }
                    }
                }
            }
        });
        t2.start();
        final Thread t1 = new Thread(new Runnable() {
            public void run() {
                while(true){
                    synchronized (lock){
                        System.out.println("in 1");
                        if(list.size() != 0){
                            try {
                                System.out.println("wait 1");
                                lock.wait();

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else {
                            list.add("孟");
                            System.out.println("add 1");
                            lock.notifyAll();
                            System.out.println("notify 1");
                            break;
                        }
                    }
                }

            }
        });
        t1.start();

        t1.join();
        t2.join();
        t3.join();
        for (String s:list){
            System.out.println(s);
        }
    }

}
