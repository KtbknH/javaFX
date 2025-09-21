package JavaFXS1.MyApp;

import java.io.File;
import java.util.Optional;

import JavaFXS1.connexion.Connexion;
import JavaFXS1.connexion.FenetreConnexion;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class MonApplication extends Application{
	
	private FenetreConnexion f;
	private String myid;
	VBox pane;

	@Override
	public void start(Stage stage) throws Exception {
		
		pane = new VBox();
		pane.setAlignment(Pos.TOP_CENTER);
		pane.setFillWidth(true);
		

		
		MenuBar bar = new MenuBar();
		
		Menu fich = new Menu("Fichiers");
		Menu fen = new Menu("Fenetres");
		
		MenuItem item1 = new MenuItem("Choisir un fichier");
		MenuItem item2 = new MenuItem("Quitter");
		
		item1.addEventHandler(ActionEvent.ACTION , new EcouteurFichier());
		
		
		
		MenuItem item3 = new MenuItem("Connexion");
		MenuItem item4 = new MenuItem("Déconnexion");
		MenuItem item5 = new MenuItem("Ajouter une ville");
		item5.addEventHandler(ActionEvent.ACTION , new EcouteurVille());
		
		item3.setOnAction(new EcouteurConnexion());
		item4.setOnAction(e -> pane.getChildren().add(new Label("déconnexion réussie de " +  myid)));
		
		
		
		fich.getItems().addAll(item1, item2);
		fen.getItems().addAll(item3, item4, item5);
		
		bar.getMenus().addAll(fich, fen);

		
		pane.getChildren().add(bar);

		
		Scene scene = new Scene(pane, 500, 400);
		stage.setScene(scene);
		stage.show();
	}
	
	private class EcouteurConnexion implements EventHandler<ActionEvent> {
		
		@Override
		public void handle(ActionEvent e) {
			pane.getChildren().add(new Label("Ouverture de la fenetre de Connexion"));
			f = new FenetreConnexion();
			Connexion c  = f.getConnexion();
			myid = c.getId();
			if(!c.testerValidite()) {
				pane.getChildren().add(new Label("connexion annulée..."));
			}else {
				pane.getChildren().add(new Label("connexion réussie de " + c.getId()));
			}
			
		}
	}
	
    private class EcouteurFichier implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Fichiers Texte", "*.txt"),
                new ExtensionFilter("Fichiers PDF", "*.pdf"),
                new ExtensionFilter("Fichiers Java", "*.java"),
                new ExtensionFilter("All Files", "*.*")
            );
            File selectedFile = fileChooser.showOpenDialog(null);
            if (selectedFile != null) {
                pane.getChildren().add(new Label("Fichier sélectionné : " + selectedFile.getName()));
            }
        }
        
    }
    
    private class EcouteurVille implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
        	pane.getChildren().add(new Label("Ouverture de la fenetre de la sélection d'unr ville"));
            TextInputDialog dialogue = new TextInputDialog("nom ville");
            dialogue.setTitle("Ajouter une ville");
            dialogue.setHeaderText("Choisir une ville");
            dialogue.setContentText("Nom :");
            
            Optional<String> result = dialogue.showAndWait();
            result.ifPresent(nomVille -> {if(!nomVille.isBlank())
            	pane.getChildren().add(new Label("Ville ajoutée : " + nomVille));
            		});
            }
    }
	
	
	public static void main(String[] args) {
		launch();
	}

}
