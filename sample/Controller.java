package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import sample.Strategy.FileStrategy;
import sample.Strategy.ReadFileStrategy;
import sample.Strategy.URLStrategy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Controller for UI
 *
 */

public class Controller {
    @FXML
    private Pane pane;
    @FXML
    private Button browseButton;
    @FXML
    private Button countButton;
    @FXML
    private Button clearButton;
    @FXML
    private TextField address;
    @FXML
    private TextArea result;

    private ReadFileStrategy readFileStrategy  ;

    /**
     * Controller for browse button
     * @param actionEvent button click
     */
    public void handleBrowseButton(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(null);

        if (file != null){
            address.setText(file.getAbsolutePath());

        }
        else {
            System.out.println("File not found");
        }







    }

    /**
     * set Strategy for URL or File
     * @param readFileStrategy
     */

    public void setReadFileStrategy(ReadFileStrategy readFileStrategy) {
        this.readFileStrategy = readFileStrategy;
    }

    /**
     * Controller for count button
     * @param actionEvent button click
     */

    public void handleCountButton(ActionEvent actionEvent) {

        String resultText;
        String fileName = address.getText();

        try {
            URL u = new URL(fileName);
            this.setReadFileStrategy(new URLStrategy());
             resultText = readFileStrategy.readFile(fileName);
        }catch (MalformedURLException e){
            File file = new File(fileName);
            this.setReadFileStrategy(new FileStrategy());
             resultText = readFileStrategy.readFile(fileName);



        }





        result.setText(resultText);

        result.setFont(Font.font("Helvetica", FontWeight.BOLD,20));














    }


    /**
     * Controller for clear button
     * @param actionEvent
     */

    public void handleClearButton(ActionEvent actionEvent) {
        address.clear();

        result.clear();
    }
}
