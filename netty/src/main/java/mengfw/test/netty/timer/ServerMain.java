package mengfw.test.netty.timer;

/**
 * Created by mengfw on 2018/5/7.
 */
public class ServerMain {
    public static void main(String[] args) throws InterruptedException {
        TimerServer server = new TimerServer();
        try {
            server.open();
        } catch (InterruptedException e) {
            server.close();
            e.printStackTrace();
        }

    }
}
