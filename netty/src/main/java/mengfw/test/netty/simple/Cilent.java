package mengfw.test.netty.simple;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Cilent {
    public static void main(String[] args) throws InterruptedException {
        Bootstrap b = new Bootstrap();
        b.group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new Handler());
                    }
                });
        ChannelFuture future = b.connect("127.0.0.1", 8888).sync();
        future.channel().closeFuture().sync();
    }
    static class Handler extends ChannelInboundHandlerAdapter{

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            String str = "QUERY TIME ORDER" ;
            ByteBuf message;
            for (int i = 0;i<100;i++){
                 String msg = str + i + System.getProperty("line.separator");
                byte[] bytes = msg.getBytes("UTF-8");
                message = Unpooled.buffer(bytes.length);
                message.writeBytes(bytes);
                ctx.writeAndFlush(message);
            }
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            super.channelRead(ctx, msg);
        }
    }
}
