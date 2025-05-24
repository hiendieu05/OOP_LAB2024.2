package hust.soict.hespi.aims.screen.customer.controller;

import hust.soict.hespi.aims.cart.Cart;
import hust.soict.hespi.aims.media.Media;
import hust.soict.hespi.aims.media.Playable;
import hust.soict.hespi.aims.exception.PlayerException;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {

    private Cart cart;
    private Media media;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnAddToCart;

    public ItemController(Cart cart) {
        this.cart = cart;
    }

    public void setData(Media media) {
        this.media = media;

        lblTitle.setText(media.getTitle());
        lblCost.setText(String.format("%.2f $", media.getCost()));

        boolean isPlayable = media instanceof Playable;
        btnPlay.setVisible(isPlayable);
        btnPlay.setManaged(isPlayable);

        if (!isPlayable) {
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        if (cart != null && media != null) {
            cart.addMedia(media);
            System.out.println("Added " + media.getTitle() + " to cart.");

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Thành công");
            alert.setHeaderText(null);
            alert.setContentText("Đã thêm '" + media.getTitle() + "' vào giỏ hàng!");
            alert.showAndWait();
        } else {
            System.err.println("Cart or media is null.");

            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText(null);
            alert.setContentText("Không thể thêm sản phẩm vào giỏ hàng.");
            alert.showAndWait();
        }
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Đang phát Media");
                alert.setHeaderText(null);
                alert.setContentText("Đang phát: " + media.getTitle());
                alert.showAndWait();
            } catch (PlayerException e) {
                System.err.println("PlayerException: " + e.getMessage());
                e.printStackTrace();

                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Lỗi Phát Media");
                alert.setHeaderText("Không thể phát Media!");
                alert.setContentText(e.getMessage() + "\n\nChi tiết lỗi: " + e.toString());
                alert.showAndWait();
            }
        } else {
            System.out.println("Media không thể phát.");

            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Không thể phát");
            alert.setHeaderText(null);
            alert.setContentText("Mục đã chọn không thể phát.");
            alert.showAndWait();
        }
    }

    @FXML
    public void initialize() {
        // Logic được xử lý trong setData()
    }
}
