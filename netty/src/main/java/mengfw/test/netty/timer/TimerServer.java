package mengfw.test.netty.timer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TimerServer {
    private int port = 8888;
    private ServerBootstrap serverBootstrap;
    private EventLoopGroup bossGroup = new NioEventLoopGroup(1);
    private EventLoopGroup workGroup = new NioEventLoopGroup(4);
    public void open() throws InterruptedException {
        serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup,workGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG,1024)
                .childHandler(new TimerServerChannelInitializer());
        ChannelFuture future = serverBootstrap.bind(port).sync();
        future.channel().closeFuture().sync();
    }

    public void  close(){
        workGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();
    }

}
