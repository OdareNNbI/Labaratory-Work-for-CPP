package sample;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private List<Integer> marks = new ArrayList<>();
    private String name;
    private Lecture lecture;

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    public void attendLecture(Lecture lecture)
    {
        this.lecture = lecture;
        marks.add(lecture.addStudent(this));
    }

    public Student(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Lecture getLecture() {
        return lecture;
    }
}
