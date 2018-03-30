package sample.UserClasses;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStudent {
    /**
     * Property - student name
     */
    protected String name;
    /**
     * Property - lecture, on which attend student
     */
    protected Lecture lecture;
    /**
     * Property - list of student marks, which student get on lectures
     */
    protected List<Integer> marks = new ArrayList<>();


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

    public AbstractStudent(String name)
    {
        this.name = name;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }
}
