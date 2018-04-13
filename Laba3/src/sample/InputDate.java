package sample;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import sample.UserClasses.Lecture;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Class with information and input data windows
 */
public class InputDate {
    /**
     * Window for input name
     * @param name information for input field
     * @param isStudent it captain or not
     * @return object name
     */
    public static String show(String name,boolean isStudent) {
        HBox hBox = new HBox();
        TextField inputName = new TextField();
        Text inputNameText = new Text("Введите имя");
        CheckBox isCaptain = new CheckBox("Сароста");

        hBox.setSpacing(5);
        hBox.getChildren().addAll(inputNameText, inputName);


        Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
        if (isStudent) {
            hBox.getChildren().add(isCaptain);
        }

        dialog.getDialogPane().setContent(hBox);
        dialog.setContentText(name);


        Optional<ButtonType> result = dialog.showAndWait();
        if (isStudent && isCaptain.isSelected()){
            Controller.isCaptain = true;
        }
        return inputName.getText();
    }

    /**
     * Choose lecture in list
     * @param list all access lectures
     * @return chosen by lecture
     */
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

    /**
     * Show which student on lecture and not on lecture
     * @param studentValue information about student
     */
    public static void showStudents(String studentValue)
    {
        if(studentValue.isEmpty()) studentValue = "На лекция никого нету, идите домой";
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Список студентов");
        alert.setContentText(studentValue);

        alert.show();
    }

    /**
     * Show that you don't select Lecture
     */
    public static void notSelectLecture()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Лекция");
        alert.setContentText("Выберите лекцию");

        alert.show();
    }

    /**
     * Show that this people not on lecture
     */
    public static void notOnLecture()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Лекция");
        alert.setContentText("Вы не на лекции, наверное спите? Какое проверять?");

        alert.show();
    }
}
