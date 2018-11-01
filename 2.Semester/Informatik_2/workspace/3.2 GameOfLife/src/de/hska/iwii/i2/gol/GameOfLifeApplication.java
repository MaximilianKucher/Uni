package de.hska.iwii.i2.gol;

import java.util.stream.Stream;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import de.hska.iwii.i2.gol.Games.Description;

/**
 * Visualisierung einer Generation des GameOfLife in einem Fenster.
 * @author Holger Vogelsang
 */
public class GameOfLifeApplication extends Application {

	/**
	 * Referenz auf die Zeichenflaeche, in der das Spiel visualiert wird.
	 */
	private GameOfLifeCanvas golCanvas;
	
	/**
	 * Referenz auf das Spiel des Benutzers.
	 */
	private GameOfLifeLogic gol = new GameOfLifeLogic();

	/**
	 * Hintergrundfarbe des Spielfeldes.
	 */
	public static final Color BACKGROUND_COLOR = new Color(230.0 / 255.0, 230.0 / 255.0, 230.0 / 255.0, 1.0);
	
	/**
	 * Standardfarbe einer Zelle.
	 */
	public static final Color DEFAULT_CELL_COLOR = new Color(80.0 / 255.0,  80.0 / 255.0, 230.0 / 255.0, 1.0);
	
	/**
	 * Dunkle Zellenfarbe fuer den Farbverlauf.
	 */
	public static final Color DARK_CELL_COLOR = DEFAULT_CELL_COLOR.darker();

	/**
	 * Helle Zellenfarbe fuer den Farbverlauf.
	 */
	public static final Color BRIGHT_CELL_COLOR = DEFAULT_CELL_COLOR.brighter();
	
	/**
	 * Aktuelle Startkonfiguration.
	 */
	private boolean[][] currentStartGeneration = Games.BLINKER2;

	/**
	 * Anzeigefenster erzeugen.
	 * @param primaryStage Hauptfenster.
	 */
    @Override
    public void start(Stage primaryStage) {
 		// Inhalt des Fensters festlegen
    	primaryStage.setTitle("GameOfLife");
    	
    	VBox pane = new VBox();
    	pane.fillWidthProperty().set(true);
    	
		// Menue hinzufuegen
		MenuBar menuBar = new MenuBar();

		Menu fileMenu = new Menu("_Datei");
		fileMenu.setMnemonicParsing(true);

		MenuItem item = new MenuItem("_Ende");
		item.setMnemonicParsing(true);
		item.setOnAction(event -> System.exit(0));

		fileMenu.getItems().add(item);

		final Menu gameMenu = new Menu("Spiele");
		Stream.of(Games.DESCRIPTIONS).forEach(d -> createMenuEntry(d, gameMenu));
		
		menuBar.getMenus().addAll(fileMenu, gameMenu);
		
        pane.getChildren().add(menuBar);
    	
		gol.setStartGeneration(currentStartGeneration);
		golCanvas = new GameOfLifeCanvas(gol, 600, 600);
		golCanvas.setStartGeneration(currentStartGeneration);
		pane.getChildren().add(golCanvas);
		VBox.setVgrow(golCanvas, Priority.ALWAYS);
		
        Scene scene = new Scene(pane);
        scene.setFill(BACKGROUND_COLOR);
        primaryStage.setScene(scene);
        primaryStage.show();

		// Zeitgesteuertes Neuzeichnen
		final PauseTransition pt = new PauseTransition(Duration.millis(100));
		pt.setCycleCount(1);
		pt.setOnFinished(event -> nextGeneration(pt));

		pt.play();
	}
    
    /**
     * Erzeugt einen neuen Menueeintrag mit einer Startsituation.
     * @param descr Beschreibung Startsituation.
     * @param gameMenu Menue, zu dem der Eintrag hinzugefuegt werden soll.
     */
    private void createMenuEntry(Description descr, Menu gameMenu) {
		MenuItem item = new MenuItem(descr.getName());
		item.setOnAction(event -> loadGame(((MenuItem) event.getSource()).getText()));
		gameMenu.getItems().add(item);
	}

	/**
     * Laedt eine neue Startsituation.
     * @param name Name der Situation.
     */
    private void loadGame(String name) {
		currentStartGeneration = Games.findGenerationByName(name);
		gol.setStartGeneration(currentStartGeneration);
		golCanvas.setStartGeneration(currentStartGeneration);
    }
    
    /**
     * Startet die Berechnung der naechsten Generation.
     * @param pt .
     */
    private void nextGeneration(PauseTransition pt) {
		if (currentStartGeneration != null) {
			gol.nextGeneration();
			golCanvas.paint();
		}
		pt.play();
    }
    
    /**
     * Start der Simulation.
     * @param args Argumente, die dem Programm uebergeben wurden.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
