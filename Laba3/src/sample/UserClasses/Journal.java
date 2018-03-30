package sample.UserClasses;

import java.util.ArrayList;
import java.util.List;

public class Journal {
    private static Journal journal;

    List<AbstractStudent> students = new ArrayList<>();

    private String captainResult = "Not check";
    private String teacherResult= "Not check";

    private static void setJournal()
    {
            journal = new Journal();
    }

    public static Journal getJournal() {
        if(journal == null) setJournal();
        return journal;
    }

    public void addStudent(AbstractStudent abstractStudent)
    {
        students.add(abstractStudent);
    }

    public String setResult(Subject lecture,boolean isCaptain)
    {
        String result = isCaptain?captainResult:teacherResult;
        result = "";
        for (AbstractStudent student:
             students) {
            if(student.getLecture() == lecture)
                result += "Student : " + student.getName() + " on lecture " + lecture + '\n';
            else
                result += "Student : " + student.getName() + " not on lecture " + lecture+'\n';
        }

        return result;
    }

    public List<AbstractStudent> getStudents() {
        return students;
    }
}
