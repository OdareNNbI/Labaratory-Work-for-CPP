package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lecture extends  Subject{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lecture(String name)
    {
        this.name = name;
    }

    public int addStudent(Student student)
    {
        return (int)(Math.random() * 10);
    }

}
