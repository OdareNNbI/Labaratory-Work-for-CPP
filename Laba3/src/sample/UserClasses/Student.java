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
public class Student extends AbstractStudent{
    /**
     * Constructor - create Student object
     * @param name student name
     */
    public Student(String name)
    {
        super(name);
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
