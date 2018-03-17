package sample.UserClasses;

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

    public String checkPeoples(Lecture lecture)
    {
        String endString = "";
        for (Student student :
                students) {
            if(student.getLecture() == lecture)
              endString += ("Student " + student.getName() + " on lecture\n");
            else
                endString += ("Student " + student.getName() + " not on lecture\n");
        }

        return endString;
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
