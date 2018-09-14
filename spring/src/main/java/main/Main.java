package main;

import bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext beans = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        User user = beans.getBean(User.class);
        System.out.println(user.getName());
        System.out.println(user.getAge());
    }
}
