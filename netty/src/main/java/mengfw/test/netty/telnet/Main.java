package mengfw.test.netty.telnet;

public class Main {
    public static void main(String[] args) {
        NettyTelnetServer server  = new NettyTelnetServer();
        try {
            server.open();
        } catch (InterruptedException e) {
            server.close();
            e.printStackTrace();
        }
    }
}
