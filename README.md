# 🖥️ TP1 JavaFX — Application Multi-Fenêtres avec FXML et CSS

Application de bureau JavaFX réalisée dans le cadre du **TP1 d'Interface Homme-Machine** à l'Université Le Havre Normandie. Ce projet explore les fondamentaux de JavaFX : construction d'interfaces via FXML, stylisation CSS, gestion d'événements, fenêtres modales et architecture MVC.

---

## 📋 Présentation

Le projet contient deux points d'entrée illustrant des approches complémentaires de JavaFX :

| Application | Classe | Approche |
|---|---|---|
| **App** (formulaire FXML) | `JavaFXS1.App` | Interface déclarative via FXML avec contrôleur, formulaire d'inscription |
| **MonApplication** (application complète) | `JavaFXS1.MyApp.MonApplication` | Interface programmatique avec barre de menus, sélection de fichiers, connexion modale et saisie de villes |

### Fonctionnalités de MonApplication

- **Menu Fichiers** — Sélection de fichiers via `FileChooser` (filtres : `.txt`, `.pdf`, `.java`, `*.*`) et option quitter
- **Connexion utilisateur** — Fenêtre modale FXML avec champs identifiant/mot de passe, validation et annulation
- **Déconnexion** — Affichage de confirmation avec l'identifiant de l'utilisateur
- **Ajout de ville** — Dialogue `TextInputDialog` pour saisir un nom de ville avec validation (non vide)
- **Journal d'activité** — Chaque action est tracée par un `Label` ajouté dynamiquement dans le `VBox` principal

---

## 🏗️ Architecture du projet

```
tp1FX/
├── pom.xml                                         # Configuration Maven (Java 11 + JavaFX 21/23)
└── src/main/
    ├── java/JavaFXS1/
    │   ├── App.java                                # Point d'entrée FXML (formulaire simple)
    │   │
    │   ├── MyApp/
    │   │   └── MonApplication.java                 # Point d'entrée principal (interface complète)
    │   │
    │   └── connexion/
    │       ├── Connexion.java                      # Modèle de données (id, password, validité)
    │       ├── FenetreConnexion.java               # Stage modale chargeant connexion.fxml
    │       ├── ControllerConnexion.java            # Contrôleur FXML de la fenêtre de connexion
    │       ├── Controller1.java                    # Contrôleur FXML du formulaire d'inscription
    │       └── Controller2.java                    # Contrôleur alternatif (valider/annuler)
    │
    └── resources/
        ├── application.fxml                        # Vue FXML — formulaire d'inscription
        ├── connexion.fxml                          # Vue FXML — fenêtre de connexion
        ├── application.css                         # Styles CSS (background, boutons, labels)
        └── background.png                          # Image de fond de l'interface
```

---

## 🧩 Concepts et Patterns implémentés

### 1. Architecture MVC avec FXML

L'interface de connexion suit le pattern **Model-View-Controller** :

```
connexion.fxml (Vue)
    ↕ binding @FXML
ControllerConnexion (Contrôleur)
    ↕ manipulation
Connexion (Modèle)
```

- La **Vue** est déclarée en FXML (`GridPane`, `TextField`, `PasswordField`, `Button`)
- Le **Contrôleur** est lié via l'attribut `fx:controller` et accède aux composants via `@FXML`
- Le **Modèle** `Connexion` encapsule les données d'authentification avec validation

### 2. Fenêtre modale (Dialog pattern)

`FenetreConnexion` hérite de `Stage` et utilise `Modality.APPLICATION_MODAL` + `showAndWait()` pour bloquer l'interaction avec la fenêtre parent jusqu'à la fermeture. Le contrôleur est injecté manuellement après le chargement FXML via `loader.getController()`, permettant de partager l'objet `Connexion` entre la fenêtre modale et l'application principale.

```java
FXMLLoader loader = new FXMLLoader(getClass().getResource("/connexion.fxml"));
Parent racine = loader.load();
ControllerConnexion controlleur = (ControllerConnexion) loader.getController();
controlleur.setConnexion(connexion);
controlleur.setFenetre(this);
initModality(Modality.APPLICATION_MODAL);
showAndWait();
```

### 3. Gestion d'événements (Event Handlers)

Le projet illustre trois styles de gestion d'événements JavaFX :

| Style | Exemple | Utilisation |
|---|---|---|
| Classe interne nommée | `EcouteurConnexion`, `EcouteurFichier`, `EcouteurVille` | Logique complexe |
| Expression lambda | `item4.setOnAction(e -> ...)` | Action simple (déconnexion) |
| Binding FXML | `onAction="#actionValider"` | Liaison déclarative vue ↔ contrôleur |

### 4. Stylisation CSS

L'application utilise une feuille de style CSS externe (`application.css`) avec :

- Image de fond personnalisée via `-fx-background-image`
- Effets visuels : `dropshadow`, `innershadow` sur les textes et labels
- Boutons avec dégradé linéaire et effet hover inversé
- Typographie personnalisée (Arial Black, Arial Narrow)

---

## ⚙️ Prérequis

- **Java** 11+
- **Maven** 3.x
- **JavaFX** 21+ (géré automatiquement par Maven via les dépendances `openjfx`)

## 🚀 Compilation et exécution

```bash
cd tp1FX

# Compiler
mvn clean compile

# Lancer MonApplication (application complète)
mvn javafx:run -Djavafx.mainClass=JavaFXS1.MyApp.MonApplication

# Lancer App (formulaire FXML simple)
mvn javafx:run -Djavafx.mainClass=JavaFXS1.App
```

Ou via compilation classique :

```bash
mvn package
java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -jar target/tp1FX-1.0-SNAPSHOT.jar
```

---

## 📚 Technologies

- **Java 11** — Langage principal
- **JavaFX 21/23** — Framework d'interface graphique moderne (remplaçant de Swing)
- **FXML** — Langage déclaratif XML pour la définition des interfaces
- **CSS** — Stylisation des composants JavaFX
- **Maven** — Build et gestion de dépendances (plugin `javafx-maven-plugin`)

---
