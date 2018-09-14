package impl;

import interfaces.Student;

public class StudentA implements Student{
    @Override
    public void introduction() {
        System.out.println("my name is A");
    }
}
