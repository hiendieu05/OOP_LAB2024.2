import java.util.Scanner;

public class bai66 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số hàng của ma trận: ");
        int soHang = scanner.nextInt();
        System.out.print("Nhập số cột của ma trận: ");
        int soCot = scanner.nextInt();

        int[][] maTran1 = new int[soHang][soCot];
        int[][] maTran2 = new int[soHang][soCot];
        int[][] tongMaTran = new int[soHang][soCot];
        System.out.println("Nhập các phần tử của ma trận thứ nhất:");
        for (int i = 0; i < soHang; i++) {
            for (int j = 0; j < soCot; j++) {
                System.out.print("Phần tử [" + i + "][" + j + "]: ");
                maTran1[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Nhập các phần tử của ma trận thứ hai:");
        for (int i = 0; i < soHang; i++) {
            for (int j = 0; j < soCot; j++) {
                System.out.print("Phần tử [" + i + "][" + j + "]: ");
                maTran2[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < soHang; i++) {
            for (int j = 0; j < soCot; j++) {
                tongMaTran[i][j] = maTran1[i][j] + maTran2[i][j];
            }
        }
        System.out.println("Tổng của hai ma trận là:");
        for (int i = 0; i < soHang; i++) {
            for (int j = 0; j < soCot; j++) {
                System.out.print(tongMaTran[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
