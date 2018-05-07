package mengfw.test.netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import mengfw.test.netty.telnet.NettyTelnetInitializer;

public class NettyHttpServer {
    private static final int PORT = 8888;
    private EventLoopGroup bossGroup = new NioEventLoopGroup(1);
    private EventLoopGroup workGrop = new NioEventLoopGroup(10);
    private ServerBootstrap serverBootstrap;
    public void open() throws InterruptedException {
        serverBootstrap = new ServerBootstrap()
                .channel(NioServerSocketChannel.class)
                .group(bossGroup, workGrop)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childHandler(new NettyHttpInitizlizer());
        ChannelFuture future = serverBootstrap.bind(PORT).sync();
        future.channel().closeFuture().sync();
    }

    public void close(){
        bossGroup.shutdownGracefully();
        workGrop.shutdownGracefully();
    }
}
