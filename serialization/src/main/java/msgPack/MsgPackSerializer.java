package msgPack;

import bean.Person;
import com.google.common.base.Stopwatch;
import org.msgpack.MessagePack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MsgPackSerializer {
    public static void main(String[] args) throws IOException {
        for (int i = 0;i<100;i++){
            Person person = new Person();
            msgPack2Byte(person);
        }
    }
    public static byte[] msgPack2Byte(Object o) throws IOException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        MessagePack messagePack = new MessagePack();
        byte[] bytes = messagePack.write(o);
        System.out.println("msgPack2Byte cost " + stopwatch.elapsed(TimeUnit.NANOSECONDS) + " ms");
        System.out.println("msgPack2Byte result length " + bytes.length);
        return bytes;
    }

}
