package hust.soict.hespi.aims.cart;

import java.util.Collections;
import hust.soict.hespi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Lớp Cart đại diện cho giỏ hàng chứa các đối tượng Media.
 */
public class Cart {
    // Danh sách các sản phẩm đã được đặt trong giỏ hàng
    private ObservableList<Media> mediaList = FXCollections.observableArrayList();

    /**
     * Thêm một sản phẩm vào giỏ hàng nếu chưa tồn tại.
     * @param media sản phẩm cần thêm
     */
    public void addMedia(Media media) {
        if (mediaList.contains(media)) {
            System.out.println("Sản phẩm đã có trong giỏ hàng!");
        } else {
            mediaList.add(media);
            System.out.println("Đã thêm: " + media.getTitle());
        }
    }

    /**
     * Xóa một sản phẩm khỏi giỏ hàng.
     * @param media sản phẩm cần xóa
     */
    public void removeMedia(Media media) {
        if (mediaList.contains(media)) {
            mediaList.remove(media);
            System.out.println("Đã xóa sản phẩm: " + media.getTitle());
        } else {
            System.out.println("Không tồn tại sản phẩm này trong giỏ!");
        }
    }

    /**
     * Tính tổng chi phí của các sản phẩm trong giỏ hàng.
     * @return tổng chi phí
     */
    public float totalCost() {
        float total = 0f;
        for (Media media : mediaList) {
            total += media.getCost();
        }
        return total;
    }

    /**
     * In nội dung giỏ hàng ra màn hình.
     */
    public void printCart() {
        System.out.println("********** GIỎ HÀNG **********");
        int index = 1;
        for (Media media : mediaList) {
            System.out.println(index++ + ". " + media.toString());
        }
        System.out.printf("Tổng chi phí: %.2f\n", totalCost());
        System.out.println("******************************");
    }

    /**
     * Lấy danh sách sản phẩm đã đặt.
     * @return danh sách sản phẩm
     */
    public ObservableList<Media> getItemsOrdered() {
        return mediaList;
    }

    /**
     * Sắp xếp giỏ hàng theo tiêu đề rồi đến giá.
     */
    public void sortByTitleCost() {
        Collections.sort(mediaList, Media.COMPARE_BY_TITLE_COST);
    }

    /**
     * Sắp xếp giỏ hàng theo giá rồi đến tiêu đề.
     */
    public void sortByCostTitle() {
        Collections.sort(mediaList, Media.COMPARE_BY_COST_TITLE);
    }

    /**
     * Tìm kiếm sản phẩm theo tiêu đề.
     * @param title tiêu đề cần tìm
     * @return sản phẩm nếu tìm thấy, null nếu không
     */
    public Media searchByTitle(String title) {
        for (Media media : mediaList) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    /**
     * Tìm kiếm sản phẩm theo ID.
     * @param id ID cần tìm
     * @return sản phẩm nếu tìm thấy, null nếu không
     */
    public Media searchById(int id) {
        for (Media media : mediaList) {
            if (media.getId() == id) {
                return media;
            }
        }
        return null;
    }

    /**
     * Xóa toàn bộ sản phẩm trong giỏ hàng.
     */
    public void clear() {
        mediaList.clear();
    }
}
