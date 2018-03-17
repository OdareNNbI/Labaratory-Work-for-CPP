package sample.UserClasses;

import java.util.ArrayList;
import java.util.List;

/**
 * Main student in group extends Student class
 *
 * @author Maxim Ambrazhey
 * @version 1.0
 * @since 2018
 */
public class Captain extends Student {

    /**
     * Property - list of university students
     */
    private List<Student> studentsOfThisGroup = new ArrayList<>();

    /**
     * Check students on lecture
     * @param lecture lecture, on which captain check students
     * @return string with information about students on lecture
     */
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

    /**
     * Constructor - create captain class
     * @param name captain name
     */
    public Captain(String name)
    {
        super(name);
    }

    /**
     * Set list of student
     * @param studentsOfThisGroup list student in university
     */
    public void setStudentsOfThisGroup(List<Student> studentsOfThisGroup) {
        this.studentsOfThisGroup = studentsOfThisGroup;
    }
}
