package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import sample.UserClasses.*;

import java.util.ArrayList;


public class Controller {
    GUI gui = Main.gui;
    University university = new University();

    public Controller()
    {
        gui.addTeacherButton.setOnAction((x)->addTeacher());
        gui.addStudentButton.setOnAction((x)->addStudent());
        gui.addLectureButton.setOnAction((x)->addLecture());
    }

    public void addTeacher()
    {
        String name = InputDate.show("Введите имя преподавателя");
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

    public void addStudent()
    {
        String name = InputDate.show("Введите имя студента");
        if( name == null || name.isEmpty()) return;
        university.addStudent(new Captain(name));

        gui.studentsListVBox.getChildren().clear();

        for (Student student:
                university.getStudentsList()) {
            Button button = new Button(student.getName());
            button.setOnAction((x)->showInfo(student));

            gui.studentsListVBox.getChildren().add(button);
        }
    }

    public void addLecture()
    {
        String name = InputDate.show("Введите название лекции");
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

    public void showInfo(Teacher teacher)
    {
        gui.infoVBox.getChildren().clear();
        gui.infoVBox.getChildren().add(new Text("Имя: " + teacher.getName()));
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

    public void showInfo(Student student) {
        gui.infoVBox.getChildren().clear();
        gui.infoVBox.getChildren().add(new Text("Имя: " + student.getName()));
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

    public void showInfo(Lecture lecture)
    {
        gui.infoVBox.getChildren().clear();
        gui.infoVBox.getChildren().add(new Text("Имя: " + lecture.getName()));
    }


}
