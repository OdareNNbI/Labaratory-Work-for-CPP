package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import sample.UserClasses.*;

import java.util.ArrayList;

/**
 * Controller between {@link GUI} and {@link University}
 *
 * @author Maxim Ambrazhey
 * @since 2018
 * @version 1.0
 */
public class Controller {
    /**
     * Property - main GUI on window
     */
    GUI gui = Main.gui;
    /**
     * Property - is captain it or not
     */
    static boolean isCaptain;
    /**
     * University in our program
     */
    University university = new University();

    /**
     * Constructor - create controller class
     */
    public Controller()
    {
        gui.addTeacherButton.setOnAction((x)->addTeacher());
        gui.addStudentButton.setOnAction((x)->addStudent());
        gui.addLectureButton.setOnAction((x)->addLecture());
    }

    /**
     * Add teacher in University and Interface
     */
    public void addTeacher()
    {
        String name = InputDate.show("Введите имя преподавателя",false);
        if( name == null || name.isEmpty()) return;
        university.addTeacher(new Teacher(name));

        gui.teachersListVBox.getChildren().clear();

        for (Teacher teacher:
                university.getTeachersList()) {
            Button button = new Button(teacher.getName());
            button.setOnAction((x) -> showInfo(teacher));

            gui.teachersListVBox.getChildren().add(button);
        }
    }
    /**
     * Add student in University and Interface
     */
    public void addStudent()
    {
        isCaptain = false;
        String name = InputDate.show("Введите имя студента",true);
        if( name == null || name.isEmpty()) return;
        if(isCaptain)
        university.addStudent(new Captain(name));
        else university.addStudent(new Student(name));

        gui.studentsListVBox.getChildren().clear();

        for (Student student:
                university.getStudentsList()) {
            Button button = new Button(student.getName());
            button.setOnAction((x)->showInfo(student));

            gui.studentsListVBox.getChildren().add(button);
        }
    }
    /**
     * Add lecture in University and Interface
     */
    public void addLecture()
    {
        String name = InputDate.show("Введите название лекции",false);
        if( name == null || name.isEmpty()) return;
        university.setSubjectsPlane(new Lecture(name));

        gui.lecturesListVBox.getChildren().clear();

        for (Subject lecture:
                university.getSubjectsList()) {
            Button button = new Button(((Lecture)lecture).getName());
            button.setOnAction((x)->showInfo((Lecture)lecture));
            gui.lecturesListVBox.getChildren().add(button);
        }
    }

    /**
     * Show information about teacher in GUI
     * @param teacher information about teacher
     */
    public void showInfo(Teacher teacher)
    {
        gui.infoVBox.getChildren().clear();
        gui.infoVBox.getChildren().add(new Text("Name: " + teacher.getName()));
        if(teacher.getSubject() != null)
        gui.infoVBox.getChildren().add(new Text("Лекция: " + ((Lecture)teacher.getSubject()).getName()));

        HBox functionHBox = new HBox();
        functionHBox.setSpacing(5);
        functionHBox.setAlignment(Pos.CENTER);

        Button takeLecture = new Button("Провести лекцию");
        takeLecture.setOnAction((x)->{
            Lecture lecture = InputDate.chooseLectures((ArrayList)university.getSubjectsList());
            if(lecture != null)
            teacher.readLecture(lecture);
            else InputDate.notSelectLecture();
        });

        Button checkStudents = new Button("Проверить посещение");
        checkStudents.setOnAction((x)->{
            if(teacher.getSubject() != null) {
                String endString = teacher.checkPeoples((Lecture) teacher.getSubject());
                InputDate.showStudents(endString);
            }
            else
            {
                InputDate.notSelectLecture();
            }
        });

        functionHBox.getChildren().addAll(takeLecture,checkStudents);
        gui.infoVBox.getChildren().add(functionHBox);
    }

    /**
     * Show information about student in GUI
     * @param student information about student
     */
    public void showInfo(Student student)
    {
        gui.infoVBox.getChildren().clear();
        gui.infoVBox.getChildren().add(new Text("Name: " + student.getName()));
        if(student.getLecture() != null)
        gui.infoVBox.getChildren().add(new Text("Лекция: " + student.getLecture()));

        if (student.getMarks().isEmpty() == false) {
            gui.infoVBox.getChildren().add(new Text(student.toString()));
        }

        HBox functionHBox = new HBox();
        functionHBox.setSpacing(5);
        functionHBox.setAlignment(Pos.CENTER);

        Button takeLecture = new Button("Посетить лекцию");
        takeLecture.setOnAction((x)->{
            Lecture lecture = InputDate.chooseLectures((ArrayList)university.getSubjectsList());
            if(lecture != null)
            {
                student.attendLecture(lecture);
            }
            else InputDate.notSelectLecture();
        });

        if(student.getClass() == Captain.class)
        {
            Button checkStudents = new Button("Проверить посещение");
            checkStudents.setOnAction((x)->{
                Lecture lecture = student.getLecture();
                if(lecture == null)
                {
                    InputDate.notOnLecture();
                }else
                {
                    InputDate.showStudents(((Captain)student).checkPeoples(lecture));
                }
            });
            functionHBox.getChildren().addAll(takeLecture,checkStudents);
        }
        else
            functionHBox.getChildren().addAll(takeLecture);
        gui.infoVBox.getChildren().add(functionHBox);
    }

    /**
     * Show information about lecture in GUI
     * @param lecture information about lecture
     */
    public void showInfo(Lecture lecture)
    {
        gui.infoVBox.getChildren().clear();
        gui.infoVBox.getChildren().add(new Text("Name: " + lecture.getName()));
    }


}
