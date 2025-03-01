import java.util.Scanner;

public class bai225 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số thứ nhất: ");
        double num1 = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập số thứ hai: ");
        double num2 = Double.parseDouble(scanner.nextLine());
        System.out.println("Tổng: " + (num1 + num2));
        System.out.println("Hiệu: " + (num1 - num2));
        System.out.println("Tích: " + (num1 * num2));
        if (num2 != 0) {
            System.out.println("Thương: " + (num1 / num2));
        } else {
            System.out.println("Không thể chia cho 0.");
        }

        scanner.close();
    }
}
