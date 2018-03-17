package sample;

import javafx.scene.control.*;
import sample.UserClasses.Lecture;

import java.util.ArrayList;
import java.util.Optional;

public class InputDate {


    public static String show(String name)
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Input name");
        dialog.setContentText(name);


        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            return result.get();
        }
        return null;
    }

    public static Lecture chooseLectures(ArrayList<Lecture> list)
    {
        ChoiceDialog<Lecture> dialog = new ChoiceDialog<Lecture>(null, list);
        dialog.setTitle("Choice lecture");
        dialog.setContentText("Choose your lecture:");


        Optional<Lecture> result = dialog.showAndWait();
        if (result.isPresent()){
            return result.get();
        }

        return  null;
    }

    public static void showStudents(String studentValue)
    {
        if(studentValue.isEmpty()) studentValue = "На лекция никого нету, идите домой";
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Список студентов");
        alert.setContentText(studentValue);

        alert.show();
    }

    public static void notSelectLecture()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Лекция");
        alert.setContentText("Выберите лекцию");

        alert.show();
    }

    public static void notOnLecture()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Лекция");
        alert.setContentText("Вы не на лекции, наверное спите? Какое проверять?");

        alert.show();
    }
}
