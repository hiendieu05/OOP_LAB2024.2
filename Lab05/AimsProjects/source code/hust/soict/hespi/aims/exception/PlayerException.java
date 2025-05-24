package hust.soict.hespi.aims.exception;

/**
 * Lớp PlayerException kế thừa từ Exception,
 * dùng để biểu diễn các lỗi liên quan đến trình phát (player).
 */
public class PlayerException extends Exception {

    /**
     * Constructor mặc định.
     */
    public PlayerException() {
        super();
    }

    /**
     * Constructor với một thông điệp lỗi.
     *
     * @param message Thông điệp lỗi.
     */
    public PlayerException(String message) {
        super(message);
    }

    /**
     * Constructor với một thông điệp lỗi và một nguyên nhân gốc.
     *
     * @param message Thông điệp lỗi.
     * @param cause   Nguyên nhân gốc.
     */
    public PlayerException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor với một nguyên nhân gốc.
     *
     * @param cause Nguyên nhân gốc.
     */
    public PlayerException(Throwable cause) {
        super(cause);
    }
}
