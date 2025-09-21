package JavaFXS1.connexion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ControllerConnexion {
	  Stage fenetre;
	  Connexion connexion;
	  
	  @FXML
	  TextField monTexte;
	  
	  @FXML
	  PasswordField monMotPasse;

	  @FXML
	  public void actionValider(ActionEvent event) {
		  connexion.setId(monTexte.getText());
		  connexion.setPassword(monMotPasse.getText());
		  fenetre.close();
	  }
	  
	  @FXML
	  public void actionAnnuler(ActionEvent event) {
		  connexion.setId(null);
		  connexion.setPassword(null);
		  fenetre.close();
	  }
	  
	    public void setConnexion(Connexion c) {
	    	connexion = c;
	    }

	  
	  public void setFenetre(Stage f) {
		  fenetre = f;
	  }
}


