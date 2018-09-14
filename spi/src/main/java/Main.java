import interfaces.Student;

import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        ServiceLoader<Student> load = ServiceLoader.load(Student.class);
        for (Student student:load){
            student.introduction();
        }
    }
}
