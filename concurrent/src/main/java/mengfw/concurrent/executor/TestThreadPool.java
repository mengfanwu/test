package mengfw.concurrent.executor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool {
    public static void main(String[] args) {
        final ExecutorService service = Executors.newFixedThreadPool(5, new ThreadFactoryBuilder().setNameFormat("Orders-%d").build());
        for(int i = 0;i < 20 ; i++){
            if(i != 3 ){
                service.execute(new Runnable() {
                    public void run() {
                        System.out.println("thread = " + Thread.currentThread().getName() + " thread is "+ Thread.currentThread().getId() +" success ");
                    }
                });
            }else {
                try {
                    service.execute(new Runnable() {
                        public void run() {
                            System.out.println("thread = " + Thread.currentThread().getName() + " thread is "+ Thread.currentThread().getId() +" error ");
                            throw new RuntimeException("123");
                        }
                    });
                }catch (Exception e){
                    System.out.println("error" + e.getMessage());
                }

            }

        }
    }
}
