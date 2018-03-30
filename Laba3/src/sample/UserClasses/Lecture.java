package sample.UserClasses;

/**
 * Lecture in university, extends Subject class
 *
 * @author Maxim Ambrazhey
 * @version 1.0
 * @since 2018
 */
public class Lecture extends  Subject{

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
        return (int)(Math.random() * 10);
    }


    @Override
    public String toString() {
        return name;
    }
}
