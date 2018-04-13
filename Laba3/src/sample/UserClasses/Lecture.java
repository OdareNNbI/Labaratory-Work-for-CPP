package sample.UserClasses;

import java.util.ArrayList;
import java.util.List;

/**
 * Lecture in university, extends Subject class
 *
 * @author Maxim Ambrazhey
 * @version 1.0
 * @since 2018
 */
public class Lecture extends  Subject{
    /**
     * list of students, who on this lecture
     */
    private List<AbstractStudent> studentsOnLecture = new ArrayList<>();

    /**
     * Constructor  set name of Lecture
     * @param name  lecture name
     */
    public Lecture(String name)
    {
        super(name);
    }

    /**
     * Add student on Lecture
     * @param student student, who attend lecture
     * @return mark, which student get on lecture
     */
    public int addStudent(AbstractStudent student)
    {
        studentsOnLecture.add(student);
        return (int)(Math.random() * 10);
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Check peoples on this lecture
     * @return string with value peoples, who on this lecture
     */
    public String checkPeoples()
    {
        String result = "";
        for (AbstractStudent student:
                studentsOnLecture) {
                result += "Student : " + student.getName() + " on lecture " + this+'\n';
        }

        return result;
    }
}
