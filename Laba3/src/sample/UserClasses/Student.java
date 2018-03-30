package sample.UserClasses;

import java.util.ArrayList;
import java.util.List;

/**
 * Student in university
 *
 * @author Maxim Ambrazhey
 * @version 1.0
 * @since  2018
 */
public class Student {
    /**
     * Property - list of student marks, which student get on lectures
     */
    private List<Integer> marks = new ArrayList<>();
    /**
     * Property - student name
     */
    private String name;
    /**
     * Property - lecture, on which attend student
     */
    private Lecture lecture;

    /**
     * Get student marks
     * @return student marks
     */
    public List<Integer> getMarks() {
        return marks;
    }

    /**
     * Set student marks
     * @param marks set marks
     */
    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    /**
     * Attend student on lecture
     * @param lecture lecture, which student want attend
     */
    public void attendLecture(Lecture lecture)
    {
        this.lecture = lecture;
        marks.add(lecture.addStudent(this));
    }

    /**
     * Constructor - create Student object
     * @param name student name
     */
    public Student(String name)
    {
        this.name = name;
    }

    /**
     * get student name
     * @return student name
     */
    public String getName() {
        return name;
    }

    /**
     * get student lecture
     * @return lecture
     */
    public Lecture getLecture() {
        return lecture;
    }

    @Override
    public String toString() {
        String end = "Оценки: ";
        for (int mark :
                marks) {
            end +=(mark + " ");
        }
        return end;
    }
}
