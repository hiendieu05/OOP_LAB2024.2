package hust.soict.hespi.aims.screen.customer.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import hust.soict.hespi.aims.store.Store;
import hust.soict.hespi.aims.cart.Cart;

import hust.soict.hespi.aims.media.Media;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;

import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.stage.Stage;

public class ViewStoreController {

    private Store store;
    private Cart cart;

    public ViewStoreController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane gridPane;

    @FXML
    void btnViewCartPressed(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Cart.fxml"));
            loader.setControllerFactory(controllerClass -> new CartController(store, cart));

            Parent cartRoot = loader.load();
            Stage currentStage = (Stage)((Button) event.getSource()).getScene().getWindow();

            currentStage.setScene(new Scene(cartRoot));
            currentStage.setTitle("Cart Screen");
            currentStage.show();

        } catch (IOException e) {
            System.err.println("Không thể tải Cart.fxml: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        final String ITEM_FXML = "screen/customer/view/Item.fxml";

        if (store == null || store.getItemsInStore() == null) {
            System.err.println("Store hoặc danh sách sản phẩm chưa được khởi tạo.");
            return;
        }

        int column = 0;
        int row = 1;

        for (Media item : store.getItemsInStore()) {
            try {
                FXMLLoader itemLoader = new FXMLLoader(getClass().getResource(ITEM_FXML));
                ItemController itemController = new ItemController(cart);
                itemLoader.setController(itemController);

                Parent itemNode = itemLoader.load();
                itemController.setData(item);

                gridPane.add(itemNode, column++, row);
                GridPane.setMargin(itemNode, new Insets(20, 10, 10, 10));

                if (column == 3) {
                    column = 0;
                    row++;
                }

            } catch (IOException e) {
                System.err.println("Lỗi khi tải Item.fxml: " + e.getMessage());
                e.printStackTrace();
            } catch (ClassCastException e) {
                System.err.println("Lỗi ép kiểu Media: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
