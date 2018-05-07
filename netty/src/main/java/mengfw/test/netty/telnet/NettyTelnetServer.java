package mengfw.test.netty.telnet;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class NettyTelnetServer {
    private static final int PORT = 8888;
    private EventLoopGroup bossGroup = new NioEventLoopGroup(1);
    private EventLoopGroup workGrop = new NioEventLoopGroup(10);
    private ServerBootstrap serverBootstrap;
    public void open() throws InterruptedException {
        serverBootstrap = new ServerBootstrap()
                .option(ChannelOption.SO_BACKLOG,1024)
                .group(bossGroup,workGrop)
                .channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new NettyTelnetInitializer());
        ChannelFuture future = serverBootstrap.bind(PORT).sync();
        future.channel().closeFuture().sync();
    }

    public void close(){
        bossGroup.shutdownGracefully();
        workGrop.shutdownGracefully();
    }

}
