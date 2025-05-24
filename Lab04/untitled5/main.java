public class Main {
    public static void main(String[] args) {
        // Tạo công ty
        CongTy congTy = new CongTy("ABC Corp", 1000000);  // Lợi nhuận công ty là 1 triệu

        // Tạo các nhân viên
        CanBoHopDong cbhd1 = new CanBoHopDong("Nguyen Van A", 7000);
        CanBoCoHuu cbch1 = new CanBoCoHuu("Tran Thi B", 5000, 2.0);
        TruongPhong tp1 = new TruongPhong("Le Van C", 6000, 2.5, 1000);
        CanBoQuanLy cbql1 = new CanBoQuanLy("Pham Thi D", 5500, 2.2, congTy);
        GiamDoc gd1 = new GiamDoc("Hoang Van E", 8000, 3.0, 2000, congTy);

        // Thêm nhân viên vào công ty
        congTy.themNV(cbhd1);
        congTy.themNV(cbch1);
        congTy.themNV(tp1);
        congTy.themNV(cbql1);
        congTy.themNV(gd1);

        // In thông tin nhân viên
        congTy.inThongTin();

        // Tính và in tổng lương
        double tongLuong = congTy.tinhTongLuong();
        System.out.println("Tổng lương toàn công ty: " + tongLuong);
    }
}
