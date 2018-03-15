package sample;

import java.util.ArrayList;
import java.util.List;

public class Captain extends Student {

    private List<Student> studentsOfThisGroup = new ArrayList<>();

    public void checkPeoples(Lecture lecture)
    {
        for (Student student :
                studentsOfThisGroup) {
            if(student.getLecture() == lecture) System.out.println("Student " + student.getName() + " was on lecture");
            else System.out.println("Student " + student.getName() + " was not on lecture");
        }
    }

    public Captain(String name)
    {
        super(name);
    }

    public void setStudentsOfThisGroup(List<Student> studentsOfThisGroup) {
        this.studentsOfThisGroup = studentsOfThisGroup;
    }
}
