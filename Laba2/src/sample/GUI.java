package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class GUI extends Pane{

    Button addTeacherButton;
    Button addStudentButton;
    Button addLectureButton;

    VBox teachersListVBox;
    VBox studentsListVBox;
    VBox lecturesListVBox;

    VBox infoVBox;


    public GUI(){
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(5, 5,5, 10));

        addTeacherButton = new Button("Нанять преподавателя");
        addStudentButton = new Button("Зачислить студента");
        addLectureButton = new Button("Добавить лекцию");

        teachersListVBox = new VBox(5);
        studentsListVBox = new VBox(5);
        lecturesListVBox = new VBox(5);


        VBox vBoxTeachers = addScrollPane(addTeacherButton,teachersListVBox,"Преподаватели");
        vBoxTeachers.setAlignment(Pos.CENTER);
        vBoxTeachers.setSpacing(5);

        VBox vBoxStudents = addScrollPane(addStudentButton,studentsListVBox,"Студенты");
        vBoxStudents.setAlignment(Pos.CENTER);
        vBoxStudents.setSpacing(5);

        VBox vBoxLectures = addScrollPane(addLectureButton,lecturesListVBox,"Лекции");
        vBoxLectures.setAlignment(Pos.CENTER);
        vBoxLectures.setSpacing(5);

        gridPane.add(vBoxTeachers, 0, 0);
        gridPane.add(vBoxStudents, 1, 0);
        gridPane.add(vBoxLectures, 2, 0);
        gridPane.add(new Separator(), 0, 1, 3, 1);

        infoVBox = new VBox();
        infoVBox.setAlignment(Pos.CENTER);
        infoVBox.setSpacing(5);

        gridPane.add(infoVBox,0,2,3,1);

        this.getChildren().add(gridPane);
    }

    private VBox addScrollPane(Button addButton,VBox list, String string){
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(list);
        scrollPane.setPrefHeight(80);


        Separator separator = new Separator();

        VBox currentVBox = new VBox(5);
        currentVBox.setAlignment(Pos.CENTER);
        currentVBox.setPrefWidth(150);
        currentVBox.setPrefHeight(150);
        currentVBox.getChildren().addAll(addButton, separator, new Text(string), scrollPane);
        return currentVBox;
    }

}
