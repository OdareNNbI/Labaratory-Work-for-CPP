package sample.UserClasses;

import java.util.ArrayList;
import java.util.List;

/**
 * List of student
 *
 * @author Maxim Ambrazhey
 * @version 1.0
 * @since 2018
 */
public class Journal {
    /**
     * Static value journal
     */
    private static Journal journal;

    /**
     * List of students
     */
    private List<JournalString> students = new ArrayList<>();

    /**
     * Check from captain
     */
    private String captainResult = "Not check";

    /**
     * check lecture, which student was attend
     * @param student student
     * @return lecture, if selected student attended on anything lecture and null, if not attended
     */
    public Lecture isOnLecture(AbstractStudent student)
    {
        for (JournalString journalString :
                students) {
            if (journalString.getStudent() == student)
                return journalString.getLecture();
        }

        return  null;
    }

    /**
     * return list of student and information about their lecture
     * @return journal strings
     */
    public List<JournalString> getStudents() {
        return students;
    }

    /**
     * Initialize journal
     */
    private static void setJournal()
    {
            journal = new Journal();
    }

    /**
     * get journal
     * @return journal
     */
    public static Journal getJournal() {
        if(journal == null) setJournal();
        return journal;
    }

    /**
     * Add student in list
     * @param abstractStudent student
     */
    public void addStudent(AbstractStudent abstractStudent)
    {
        students.add(new JournalString(abstractStudent));
    }

    /**
     * add student on selected lecture
     * @param student student
     * @param lecture lecture
     */
    public void setStudentOnLecture(AbstractStudent student,Lecture lecture)
    {
        for (JournalString string:
             students) {
            if(string.getStudent() == student) {
                string.setOnLecture(lecture);
                break;
            }
        }
    }

    /**
     * Set check from teacher or student
     * @param lecture lecture, on which you can check people
     * @return string with check
     */
    public String setResult(Subject lecture)
    {
        captainResult = "";
        for (JournalString student:
             students) {
            if(student.isOnLecture() && student.getLecture() == lecture)
                captainResult += "Student : " + student + " on lecture " + lecture + '\n';
            else
                captainResult += "Student : " + student + " not on lecture " + lecture + '\n';
        }

        return captainResult;
    }



}
