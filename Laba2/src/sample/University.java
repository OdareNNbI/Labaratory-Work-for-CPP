package sample;

import java.util.*;

public class University {
    private List<Teacher> teachersList = new ArrayList<>();
    private List<Student> studentsList = new ArrayList<>();
    private List<Subject> subjectsList = new ArrayList<>();

    public void addStudent(Student student)
    {
        if(student.getClass() == Captain.class)
            ((Captain)student).setStudentsOfThisGroup(studentsList);

        studentsList.add(student);
    }

    public void addTeacher(Teacher teacher)
    {
        teacher.setStudents(studentsList);
        teachersList.add(teacher);
    }

    public void setSubjectsPlane(String ... subjectsName)
    {
        for (String name:subjectsName
             ) {
            subjectsList.add(new Lecture(name));
        }
    }

    public List<Teacher> getTeachersList() {
        return teachersList;
    }

    public List<Subject> getSubjectsList() {
        return subjectsList;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }
}
