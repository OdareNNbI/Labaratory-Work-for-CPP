package sample.UserClasses;

/**
 * String of journal with information about student and lecture
 *
 * @author Maxim Ambrazhey
 * @version 1.0
 * @since 2018
 */
public class JournalString {
    /**
     * student
     */
    private AbstractStudent student;
    /**
     * is student on lecture
     */
    private boolean onLecture;
    /**
     * lecture, witch attended student
     */
    private Lecture lecture;

    @Override
    public String toString() {
        return student.name;
    }

    /**
     * @return student
     */
    public AbstractStudent getStudent() {
        return student;
    }

    /**
     * set lecture for student
     * @param lecture lecture
     */
    public void setOnLecture(Lecture lecture)
    {
        this.lecture = lecture;
        onLecture = true;
    }

    /**
     * Constructor
     * @param student student
     */
    public JournalString(AbstractStudent student)
    {
        this.student = student;
        onLecture = false;
    }

    /**
     * @return true if student on lecture and false if not
     */
    public boolean isOnLecture() {
        return onLecture;
    }

    /**
     * @return lecture of student
     */
    public Lecture getLecture() {
        return lecture;
    }
}
