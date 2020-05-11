package gtsfq5foodlogger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Griffin Schulte
 */
public class LogViewerController extends SceneSwitch implements Runnable, Initializable, AlertInterface {
    
    private Stage stage;
    Log log;
    
    private Thread thread = null;
    private String time = "", month = "", day = "";
    private SimpleDateFormat format;
    private Date date;
    private Calendar calendar;
    
    @FXML
    private TextArea breakfast;
    
    @FXML
    private TextArea snackOne;
    
    @FXML
    private TextArea lunch;
    
    @FXML
    private TextArea snackTwo;
    
    @FXML
    private TextArea dinner;
    
    @FXML
    private Label dateLabel;
    
    @FXML
    private Label clockLabel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        thread = new Thread(this);
        thread.start();
        
        log = new Log();
    }
    
    @FXML
    private void clearBreakfast(ActionEvent event) {
        breakfast.setText("");
    }
    
    @FXML
    private void clearSnackOne(ActionEvent event) {
        snackOne.setText("");
    }
    
    @FXML
    private void clearLunch(ActionEvent event) {
        lunch.setText("");
    }
    
    @FXML
    private void clearSnackTwo(ActionEvent event) {
        snackTwo.setText("");
    }
    
    @FXML
    private void clearDinner(ActionEvent event) {
        dinner.setText("");
    }
    
    @FXML
    private void clearAll(ActionEvent event) {
        breakfast.setText("");
        snackOne.setText("");
        lunch.setText("");
        snackTwo.setText("");
        dinner.setText("");
    }

    @Override
    public void run() {
        try {
            while (true) {

                calendar = Calendar.getInstance();

                format = new SimpleDateFormat("hh:mm:ss a");
                date = calendar.getTime();
                time = format.format(date);

                format = new SimpleDateFormat("MM/dd/yyyy");
                date = calendar.getTime();
                month = format.format(date);

                Platform.runLater(() -> {
                    dateLabel.setText(String.valueOf(month));
                    clockLabel.setText(time);
                });

                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            dateLabel.setText("Error");
            clockLabel.setText("Error");
        }
    }
    
    @FXML
    public void handleOpen(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            FileInputStream fileIn; 
            try {
                fileIn = new FileInputStream(file.getPath());
                ObjectInputStream in = new ObjectInputStream(fileIn); 
                
                log = (Log) in.readObject();
                
                in.close(); 
                fileIn.close(); 
                fillFormFromLog(log); 
                
            } catch (FileNotFoundException ex) {
                String message = "File not found exception occured while opening " + file.getPath(); 
                displayExceptionAlert(message, ex); 
                
            } catch (IOException ex) {
                String message = "IO exception occured while opening " + file.getPath(); 
                displayExceptionAlert(message, ex);
                
            } catch (ClassNotFoundException ex) {
                String message = "Class not found exception occured while opening " + file.getPath(); 
                displayExceptionAlert(message, ex); 
            }  
        }
    }
    
    @FXML
    public void handleSave(ActionEvent event) {
        log = createLogFromFormData(); 
        
        if(log == null){
            return; 
        }
        
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            
            try {
                FileOutputStream fileOut = new FileOutputStream(file.getPath());
                ObjectOutputStream out = new ObjectOutputStream(fileOut); 
                
                out.writeObject(log);
                out.close(); 
                fileOut.close(); 
                
            } catch (FileNotFoundException ex) {
                String message = "File not found exception occured while saving to " + file.getPath(); 
                displayExceptionAlert(message, ex); 
                
            } catch (IOException ex) {
                String message = "IOException occured while saving to " + file.getPath();
                displayExceptionAlert(message, ex);
            }
        }        
    }
    
    @FXML
    public void handleAbout(ActionEvent event) {
        showAlert();
    }
    
    private Log createLogFromFormData() {
        Log logged = new Log();
        
        logged.setBreakfast(breakfast.getText());
        logged.setSnack1(snackOne.getText());
        logged.setLunch(lunch.getText());
        logged.setSnack2(snackTwo.getText());
        logged.setDinner(dinner.getText());

        return logged;
    }
    
    private void fillFormFromLog(Log log) {
        breakfast.setText(log.getBreakfast());
        snackOne.setText(log.getSnack1());
        lunch.setText(log.getLunch());
        snackTwo.setText(log.getSnack2());
        dinner.setText(log.getDinner());
    }
    
    private void displayExceptionAlert(String message, Exception ex) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Exception Dialog");
        alert.setHeaderText("Exception!");
        alert.setContentText(message);
        alert.showAndWait();
    }

    @Override
    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Griffin's Food Logger Information");
        alert.setContentText("This is a food logger application made by Griffin Schulte for the CS3330 Final Project.");
        
        TextArea textArea = new TextArea("Ideally, whoever was using this program, would open the file throughout the day to log their meals, and eventually save"
                + " it for the last time to keep a record of their meals every day. The clock and date are on there for them to have a quick reference of when and"
                + " what day they ate that meal. I wanted to make this because a doctor had asked me to keep track of a food log, and I didn't like any of the apps"
                + " on the AppStore that did this for me. It's a very simple program, but it does what I need it to do for now.");
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(textArea, 0, 0);
        alert.getDialogPane().setExpandableContent(expContent);
        
        alert.showAndWait();
    }
}