package mengfw.test.netty.http;

public class Main {
    public static void main(String[] args) {
        NettyHttpServer server  = new NettyHttpServer();
        try {
            server.open();
        } catch (InterruptedException e) {
            server.close();
            e.printStackTrace();
        }
    }
}
