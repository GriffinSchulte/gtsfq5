package gtsfq5foodlogger;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Griffin Schulte
 */
public class Gtsfq5FoodLogger extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        HBox root = new HBox();
        root.setPrefSize(300, 150);
        root.setAlignment(Pos.CENTER);
        Text message = new Text("This is not the correct scene.");
        root.getChildren().add(message);
        
        Scene scene = new Scene(root);
        
        SceneSwitch.scene = scene;
        SceneSwitch.switchTo("LoginPage");
        
        stage.setScene(scene);
        stage.show();
        
        stage.setOnCloseRequest((WindowEvent event) -> {
            System.exit(0);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
