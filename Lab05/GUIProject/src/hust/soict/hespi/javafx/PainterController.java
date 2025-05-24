package hust.soict.hespi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.input.MouseEvent; // Import MouseEvent

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton penRadioButton; // Cần @FXML cho penRadioButton
    @FXML
    private RadioButton eraserRadioButton; // Cần @FXML cho eraserRadioButton
    @FXML
    private ToggleGroup toolToggleGroup; // Cần @FXML cho toolToggleGroup

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) { // Sử dụng MouseEvent
        Color color;
        if (eraserRadioButton.isSelected()) {
            color = Color.WHITE; // Màu nền = xóa
        } else {
            color = Color.BLACK; // Bút vẽ
        }
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, color); // Sử dụng 'color'
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void toolSelected(ActionEvent event) {
        // Bạn có thể thêm logic xử lý khi chọn công cụ (bút/tẩy) ở đây nếu cần
    }
}