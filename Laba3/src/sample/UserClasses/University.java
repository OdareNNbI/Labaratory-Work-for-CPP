package sample.UserClasses;

import java.util.*;

/**
 * University - main class
 *
 * @author Maxim Ambrazhey
 * @version 1.0
 * @since 2018
 */
public class University {
    /**
     * Property - lis of teacher in university
     */
    private List<Teacher> teachersList = new ArrayList<>();

    /**
     * Property - lis of subject in university
     */
    private List<Subject> subjectsList = new ArrayList<>();

    /**
     * Add student in university
     * @param student student, which want enter in university
     */
    public void addStudent(AbstractStudent student)
    {
        Journal.getJournal().addStudent(student);
    }

    /**
     * Add teacher in university
     * @param teacher teacher, which want enter in university
     */
    public void addTeacher(Teacher teacher)
    {
        teachersList.add(teacher);
    }

    /**
     * Add lectures
     * @param lectures lectures, which you want add
     */
    public void setSubjectsPlane(Lecture ... lectures)
    {
        for (Lecture lecture:
                lectures) {
            subjectsList.add(lecture);
        }
    }

    /**
     * get list of teachers
     * @return teachers list
     */
    public List<Teacher> getTeachersList() {
        return teachersList;
    }

    /**
     * get subjects list
     * @return subject list
     */
    public List<Subject> getSubjectsList() {
        return subjectsList;
    }

}
