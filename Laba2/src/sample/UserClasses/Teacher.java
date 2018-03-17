package sample.UserClasses;

import java.util.ArrayList;
import java.util.List;

/**
 * Teacher on university
 *
 * @author Maxim Ambrazhey
 * @since 2018
 * @version 1.0
 */
public class Teacher {
    /**
     * Property - Teacher name
     */
    private String name;
    /**
     * Property - subject, which teacher read
     */
    private Subject subject;
    /**
     * Property - list student in university
     */
    private List<Student> students = new ArrayList<>();

    /**
     * Read lecture
     * @param lecture - lecture, which teacher want read
     */
    public void readLecture(Lecture lecture)
    {
        subject = lecture;
    }

    /**
     * Check students on lecture
     * @param lecture - lecture, on which teacher will check
     * @return string, which has information about presence on lecture
     */
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

    /**
     * Constructor - create teacher object
     * @param name - teacher name
     */
    public Teacher(String name)
    {
        this.name = name;
    }

    /**
     * Get teacher name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * get subject
     * @return subject
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * set student in university
     * @param students list of students
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
