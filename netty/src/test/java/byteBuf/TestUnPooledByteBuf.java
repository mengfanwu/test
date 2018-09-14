package byteBuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.buffer.UnpooledByteBufAllocator;

public class TestUnPooledByteBuf {
    public static void main(String[] args) {
        ByteBuf a = Unpooled.buffer(20);
        a.writeInt(1000);
        ByteBuf b = a.readSlice(20);
        byte[] array = b.array();
        System.out.println(array.length);
        b.release();
        a.release();
        byte[] array2 = b.array();
        System.out.println(array2.length);

    }
}
