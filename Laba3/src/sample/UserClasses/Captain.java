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
     * Check students on lecture
     * @param lecture lecture, on which captain check students
     * @return string with information about students on lecture
     */
    public String checkPeoples(Lecture lecture){
        return Journal.getJournal().setResult(lecture,true);
    }

    /**
     * Constructor - create captain class
     * @param name captain name
     */
    public Captain(String name)
    {
        super(name);
    }


    @Override
    public void attendLecture(Lecture lecture)
    {
        super.attendLecture(lecture);
        checkPeoples(lecture);
    }
}
