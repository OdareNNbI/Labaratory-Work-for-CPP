package sample.UserClasses;

import java.util.ArrayList;
import java.util.List;

/**
 * The base class for student and captain
 *
 * @author Maxim Ambrazhey
 * @version 1.0
 * @since 2018
 */
public abstract class AbstractStudent {
    /**
     * Property - student name
     */
    protected String name;
    /**
     * Property - list of student marks, which student get on lectures
     */
    protected List<Integer> marks = new ArrayList<>();


    /**
     * Get student marks
     *
     * @return student marks
     */
    public List<Integer> getMarks() {
        return marks;
    }

    /**
     * Set student marks
     *
     * @param marks set marks
     */
    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    /**
     * Attend student on lecture
     *
     * @param lecture lecture, which student want attend
     */
    public void attendLecture(Lecture lecture) {
        Journal.getJournal().setStudentOnLecture(this,lecture);
        marks.add(lecture.addStudent(this));
    }

    /**
     * get student name
     *
     * @return student name
     */
    public String getName() {
        return name;
    }


    /**
     * Constructor - create abstract student
     *
     * @param name - nameof student
     */
    public AbstractStudent(String name) {
        this.name = name;
    }

}
