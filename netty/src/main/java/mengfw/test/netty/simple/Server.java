package mengfw.test.netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.nio.ByteBuffer;
import java.util.List;

public class Server {
    public static void main(String[] args) throws InterruptedException {
        ServerBootstrap sb = new ServerBootstrap();
        sb.group(new NioEventLoopGroup(),new NioEventLoopGroup())
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG,1024)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new ServerHandler2());
                    }
                });
        ChannelFuture future = sb.bind(8888).sync();
        future.channel().closeFuture().sync();
    }

    private static class ServerHandler extends ChannelInboundHandlerAdapter{
        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("channel is active");
        }

        int count;
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ByteBuf buf = (ByteBuf) msg;
            int leng = ("QUERY TIME ORDER" + count + System.getProperty("line.separator")).getBytes().length;
            count ++;
            System.out.println("begin to read");
            ByteBuf slice = buf.readSlice(leng);
            byte[] arr = new byte[leng];
            slice.readBytes(arr);
            slice.release();
            System.out.println(new String(arr));
        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            super.channelReadComplete(ctx);
        }
    }
    static class ServerHandler2 extends ByteToMessageDecoder{
        int count;
        @Override
        protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
            int leng = ("QUERY TIME ORDER" + count + System.getProperty("line.separator")).getBytes().length;
            if(in.readableBytes() < leng){
                return;
            }
            count ++;
            System.out.println("begin to read");
            byte[] arr = new byte[leng];
            in.readBytes(arr);
            System.out.println(new String(arr));
        }
    }
}
