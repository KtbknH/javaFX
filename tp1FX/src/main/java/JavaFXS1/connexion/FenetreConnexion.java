package JavaFXS1.connexion;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class FenetreConnexion extends Stage {
	
	private Connexion connexion;
	
    public FenetreConnexion() {
	    try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/connexion.fxml"));
	        Parent racine = loader.load(); //la balise racine
	        
	        //partie intéressante pour faire le lien avec les variable d'intance
	        //du controlleur qui provient pas du fichier fxml
	        ControllerConnexion controlleur = (ControllerConnexion)loader.getController();
	        connexion = new Connexion("","",false);
	        controlleur.setConnexion(connexion);
	        controlleur.setFenetre(this);   
	        
	        Scene scene = new Scene(racine);
	        setScene(scene);
	        initModality(Modality.APPLICATION_MODAL);
	        showAndWait();
	        
	    }catch (Exception ie){
	      ie.printStackTrace();
	    }

    }
    
    public Connexion getConnexion() {
    	return connexion;
    }



}

