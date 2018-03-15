package sample;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private String name;
    private Subject subject;
    private List<Student> students = new ArrayList<>();

    public void readLecture(Lecture lecture)
    {
        subject = lecture;
    }

    public void checkPeoples(Lecture lecture)
    {
        for (Student student :
                students) {
            System.out.println("Student " + student.getName() + " on lecture");
        }
    }

    public Teacher(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
