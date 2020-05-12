package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Strategy.FileStrategy;
import sample.Strategy.ReadFileStrategy;
import sample.Strategy.URLStrategy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * initialize class for run the application.
 *
 * @author Suchon Prasert
 */

public class Main extends Application {
    private ReadFileStrategy readFileStrategy  ;
    /**
     * Initrialize screen.
     *
     *
     */

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("project.fxml"));
        primaryStage.setTitle("Readability by Suchon Prasert");
        primaryStage.setScene(new Scene(root, 800, 300));
        primaryStage.show();

    }
    /**
     * set Strategy for URL or File
     * @param readFileStrategy
     */

    public void setReadFileStrategy(ReadFileStrategy readFileStrategy) {
        this.readFileStrategy = readFileStrategy;
    }

    /**
     * Run application.
     * @param args text from command line
     */


    public static void main(String[] args) {
        if (args.length==0) {
        launch(args);

    }else {CommandLine commandLine = new CommandLine();
    commandLine.readFromCommandLine(args);




                    }



                }
            }

