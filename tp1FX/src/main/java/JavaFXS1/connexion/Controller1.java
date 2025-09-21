package JavaFXS1.connexion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class Controller1 {
  @FXML
  private Text affichage; 

  @FXML
  public void actionDeBoutton(ActionEvent event) {
    affichage.setText("Bouton actionné !");
  }
}
