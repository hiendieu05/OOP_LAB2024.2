package hust.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import hust.oop.bomberman.audiomaster.AudioController;
import hust.oop.bomberman.scenemaster.LobbyController;
import hust.oop.bomberman.scenemaster.PlayingController;

import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import static hust.oop.bomberman.GameController.GameStatus.GAME_LOBBY;
import static hust.oop.bomberman.GameController.GameStatus.GAME_PLAYING;

public class GameController {
    /**
     * Game status control.
     */
    public enum GameStatus {
        GAME_LOBBY,
        GAME_START,
        GAME_PLAYING,
        LOAD_CURRENT_LEVEL,
        WIN_ONE,
        WIN_ALL,
        GAME_LOSE,
        GAME_PAUSE,
        GAME_UNPAUSE
    }

    private Stage stage;
    private String username = "";
    private static GameController gameController = null;

    public static GameController getGameController(Stage stage) {
        if (gameController == null) {
            gameController = new GameController(stage);
        }
        return gameController;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void plusPoint(int rewardPoint) {
        gamePoint.addAndGet(rewardPoint);
    }

    public static GameStatus gameStatus;

    public static final int MAX_LEVEL = 4;

    int currentLevelCode = 0;

    private LobbyController lobbyController;
    private PlayingController playingController;

    private AtomicInteger gamePoint = new AtomicInteger();
    /**
     * AudioController can be used anywhere to play any audio if needed.
     * See how to play audio at {@link AudioController}.
     */
    public static AudioController audioController = new AudioController();
    private Level currentLevel;

    /**
     * Constructor with available stage.
     */
    private GameController(Stage stage) {
        this.stage = stage;
        currentLevel = new Level(gamePoint);
        // Initialize database connection when GameController is created
        // initializeDatabase();
    }

    public Stage getStage() {
        return stage;
    }


    /**
     * Database
     */

    /**
     * Initializes the database connection.
     * This method attempts to establish a connection to the MySQL database.
     * If the connection fails, it prints an error message and sets the connection to null.
     */


    /**
     * Attempts to reconnect to the database if the current connection is null or closed.
     * This method is called before performing any database operation to ensure connection validity.
     * @return true if connection is successful or already valid, false otherwise.
     */


    /**
     * Closes the database connection.
     * This method should be called when the application is shutting down to release resources.
     */



    /**
     * Timer for scenes.
     */

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            render();
            try {
                update();
            } catch (SQLException e) {
                // Log the exception, but don't throw RuntimeException here
                // as it would crash the JavaFX Application Thread.
                System.err.println("Error during game update: " + e.getMessage());
                e.printStackTrace();
            }
        }
    };
    Scene playingScene;
    Scene lobbyScene;

    /**
     * Run game engine.
     */
    public void run() {
        stage.getIcons().add(new Image("/stageIcon.png"));
        stage.setTitle("BOMBERMAN");
        stage.setResizable(false);
        FXMLLoader fxmlLoader1 = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/UI_fxml/LobbyScene.fxml")));
        FXMLLoader fxmlLoader2 = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/UI_fxml/PlayingScene.fxml")));

        try {
            lobbyScene = new Scene(fxmlLoader1.load());
            playingScene = new Scene(fxmlLoader2.load());
        } catch (IOException e) {
            throw new RuntimeException("Failed to load FXML scenes: " + e.getMessage(), e);
        }

        lobbyController = (fxmlLoader1).getController();
        playingController = (fxmlLoader2).getController();

        lobbyController.setPlayingScene(playingScene);
        playingController.setLobbyScene(lobbyScene);

        lobbyController.setGameController(this);
        playingController.setGameController(this);

        gameStatus = GameStatus.GAME_LOBBY;
        stage.setScene(lobbyScene);
        stage.show();


        timer.start();
    }



    /**
     * Update all specs of game, set scenes.
     */
    private void update() throws SQLException {
        lobbyController.updateStatus();
        playingController.updateStatus();
        audioController.run();
    }

    private void render() {
        if (gameStatus == GAME_PLAYING) {
            currentLevel.render();
        }
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Render into playing canvas by gc.
     */

    public void reset() {
        gamePoint.set(0);
        currentLevelCode = 0;
        currentLevel.loadLevel(currentLevelCode);
        GameController.gameStatus = GAME_LOBBY;
    }

    /**
     * Get username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Get game points.
     */
    public int getGamePoint() {
        return gamePoint.get();
    }
}