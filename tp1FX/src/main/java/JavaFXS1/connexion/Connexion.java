package JavaFXS1.connexion;

public class Connexion {
    private String id;
    private String password;
    private boolean valid;

    // Constructeur
    public Connexion(String id, String password, boolean valid) {
        this.id = id;
        this.password = password;
        this.valid = valid;
    }
    
    public Connexion() {
    	id = null;
    	password = null;
    	valid = false;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public boolean isValid() {
        return valid;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
    
    public boolean testerValidite() {
    	valid = id != null && !id.isEmpty() && !id.isBlank();
    	return valid;
    }

    // toString
    @Override
    public String toString() {
        return "Connexion{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", valid=" + valid +
                '}';
    }
}