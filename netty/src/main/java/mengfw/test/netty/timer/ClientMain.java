package mengfw.test.netty.timer;

/**
 * Created by mengfw on 2018/5/7.
 */
public class ClientMain {
    public static void main(String[] args) throws InterruptedException {
        TimerClient client = new TimerClient();
        client.connect("127.0.0.1",8888);
    }
}
