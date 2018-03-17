package sample.UserClasses;

import java.util.ArrayList;
import java.util.List;

public class Captain extends Student {

    private List<Student> studentsOfThisGroup = new ArrayList<>();

    public String checkPeoples(Lecture lecture){
        String endString = "";
        for (Student student :
                studentsOfThisGroup) {
            if(student.getLecture() == lecture)
                endString += ("Student " + student.getName() + " on lecture\n");
            else
                endString += ("Student " + student.getName() + " not on lecture\n");
        }

        return endString;
    }

    public Captain(String name)
    {
        super(name);
    }

    public void setStudentsOfThisGroup(List<Student> studentsOfThisGroup) {
        this.studentsOfThisGroup = studentsOfThisGroup;
    }
}
