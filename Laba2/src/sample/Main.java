package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class create new Scene
 */
public class Main extends Application {
    /**
     * Property - main gui in program
     */
    static GUI gui;
    @Override
    public void start(Stage primaryStage) throws Exception{
        gui = new GUI();
        Scene scene = new Scene(gui,500,300);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
        new Controller();
    }

    /**
     * Create window
     * @param args command line
     */
    public static void main(String[] args) {

    launch(args);
    }


}
