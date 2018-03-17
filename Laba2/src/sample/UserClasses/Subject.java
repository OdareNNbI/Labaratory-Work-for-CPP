package sample.UserClasses;

/**
 * Subject class
 *
 * @author Maxim Ambrazhey
 * @version 1.0
 * @since 2018
 */
public class Subject {
    /**
     * Property - Subject name
     */
    protected String name;

    /**
     * Get subject name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * set subject name
     * @param name subject name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Constructor - create subject object
     * @param name subject name
     */
    public Subject(String name)
    {
        this.name  = name;
    }
}
