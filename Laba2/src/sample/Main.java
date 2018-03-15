package sample;

import com.sun.rowset.internal.Row;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;


import java.awt.*;

public class Main extends Application {

    private GridPane root;
    private Button addTeacherButton;
    private Button addStudentButton;
    private Button createPlanButton;
    private VBox teacherListBox;
    private VBox studentsListBox;
    private VBox lecturesListBox;

    @Override
    public void start(Stage primaryStage) throws Exception{
        root = new GridPane();
        root.setPadding(new Insets(20));
        root.setHgap(20);
        root.setVgap(40);

        addTeacherButton = new Button("Нанять преподавателя");
        addStudentButton = new Button("Зачислить студента");
        createPlanButton = new Button("Составить план занятий");


        root.add(addTeacherButton,0,0);
        root.add(addStudentButton,1,0);
        root.add(createPlanButton,2,0);

        setLecturesList();
        setStudentsList();
        setTeachersList();

        Scene scene = new Scene(root,500,300);
        primaryStage.setTitle("University");
        primaryStage.setScene(scene);

        primaryStage.show();
    }


    public static void main(String[] args) {
    launch(args);
    }

    public void setTeachersList()
    {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(5);

        teacherListBox = new VBox();
        teacherListBox.setAlignment(Pos.CENTER);

        Text teachersText = new Text("Преподаватели");
        ScrollPane scrollPane = new ScrollPane();

        scrollPane.setContent(teacherListBox);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVmax(30);


        pane.add(teachersText,0,0);
        pane.add(scrollPane,0,1);


        root.add(pane,0,1);
    }

    public void setStudentsList()
    {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(5);

        studentsListBox = new VBox();
        studentsListBox.setAlignment(Pos.CENTER);

        Text studentsText = new Text("Преподаватели");
        ScrollPane scrollPane = new ScrollPane();

        scrollPane.setContent(studentsListBox);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVmax(30);


        pane.add(studentsText,0,0);
        pane.add(scrollPane,0,1);


        root.add(pane,1,1);
    }

    public void setLecturesList()
    {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(5);

        lecturesListBox= new VBox();
        lecturesListBox.setSpacing(10);
        lecturesListBox.setAlignment(Pos.CENTER);

        Text lecturesText = new Text("Лекции");
        lecturesText.setTextAlignment(TextAlignment.CENTER);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setPrefHeight(50);
        scrollPane.setPrefWidth(100);

        lecturesListBox.getChildren().addAll(new Text((":fff")),new Text("FFF"),new Text("Fff"), new Text("fvghbjn"));
        scrollPane.setContent(lecturesListBox);

        scrollPane.setVmax(30);


        pane.add(lecturesText,0,0);
        pane.add(scrollPane,0,1);


        root.add(pane,2,1);

    }
}
