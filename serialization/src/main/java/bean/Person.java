package bean;

import org.msgpack.annotation.Message;

import java.io.Serializable;
import java.util.Date;
@Message
public class Person implements Serializable{
    private String name;
    private int age;
    private Date brith;

    public Person() {
        name = "mengfanwu";
        age = 25;
        brith = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBrith() {
        return brith;
    }

    public void setBrith(Date brith) {
        this.brith = brith;
    }
}
