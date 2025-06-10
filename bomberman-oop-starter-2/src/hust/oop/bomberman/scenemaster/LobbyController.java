package hust.oop.bomberman.scenemaster;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import hust.oop.bomberman.BombermanGame;
import hust.oop.bomberman.GameController;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class LobbyController extends SceneController implements Initializable {

    private Scene playingScene;
    double scaleValue = 0;

    public void setPlayingScene(Scene playingScene) {
        this.playingScene = playingScene;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        URL lobbyURL = BombermanGame.class.getResource("/UI_fxml/LobbyScene.fxml");
        if (location.equals(lobbyURL)) {
            // Không cần thiết lập bảng điểm nữa
        }
    }

    @FXML
    public void clickPlayButton() {
        TextInputDialog getNameInputDialog = new TextInputDialog("Messi");
        getNameInputDialog.setTitle(stage.getTitle());
        getNameInputDialog.setHeaderText("Cho xin cái tên");
        getNameInputDialog.setContentText("Điền vào: ");
        getNameInputDialog.setGraphic(new ImageView("lobbyTexture/name.png"));
        Optional<String> nameInput = getNameInputDialog.showAndWait();
        if (!nameInput.isPresent()) gameController.setUsername("Messi");
        else gameController.setUsername(nameInput.get());

        GameController.gameStatus = GameController.GameStatus.GAME_START;
        stage.setScene(playingScene);
    }

    @FXML
    public void clickQuitButton() {
        Alert alert = new Alert(Alert.AlertType.WARNING,
                "Có thật là muốn thoát không ?",
                ButtonType.YES, ButtonType.CANCEL);
        alert.setHeaderText(null);
        alert.setTitle("EXIT Notification");
        alert.setGraphic(new ImageView("lobbyTexture/quitNotification.png"));
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.YES) {
            System.exit(0);
        }
    }

    public void clickAudioButton() {
        GameController.audioController.setMuted(!GameController.audioController.isMuted());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setGraphic(new ImageView("lobbyTexture/audioNotification.png"));
        alert.setTitle("AUDIO Notification");
        alert.setHeaderText(null);
        alert.setContentText("Audio has been turned " + (GameController.audioController.isMuted() ? "off!" : "on!"));
        alert.showAndWait();
    }


    public void updateStatus() {

    }
}
