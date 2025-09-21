package JavaFXS1.connexion;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller2 {
  @FXML
  TextField monTexte;
  @FXML
  PasswordField monMotPasse;

  @FXML
  public void actionValider(ActionEvent event) {
  
  }
  
  @FXML
  public void actionAnnuler(ActionEvent event) {
	  monTexte.setText("");
	  monMotPasse.setText("");
  }
}
