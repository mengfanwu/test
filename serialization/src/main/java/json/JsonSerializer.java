package json;

import bean.Person;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

public class JsonSerializer {
    public static void main(String[] args) {
        for (int i = 0;i<100;i++){
            Person person = new Person();
            fastJson2Byte(person);
        }
    }

    public static byte[] fastJson2Byte(Person p){
        Stopwatch stopwatch = Stopwatch.createStarted();
        String json = JSONObject.toJSONString(p);
        byte[] bytes = json.getBytes();
        System.out.println("fastJson2Byte cost " + stopwatch.elapsed(TimeUnit.NANOSECONDS) + " ms");
        System.out.println("fastJson2Byte result length " + bytes.length);
        return bytes;
    }
}
