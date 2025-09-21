package JavaFXS1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
    
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/application.fxml"));
        Parent racine = loader.load();
        
        Scene scene = new Scene(racine);
        stage.setScene(scene);
        stage.show();
        
    }catch (Exception ie){
      ie.printStackTrace();
    }


    }

    public static void main(String[] args) {
        launch();
    }

}
