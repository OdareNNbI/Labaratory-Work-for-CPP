package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    static GUI gui;
    @Override
    public void start(Stage primaryStage) throws Exception{
        gui = new GUI();
        Scene scene = new Scene(gui,500,300);
        primaryStage.setScene(scene);
        primaryStage.show();
        new Controller();
    }


    public static void main(String[] args) {
    launch(args);
    }


}
