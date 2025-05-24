public class Main {
    public static void main(String[] args) {
        // Tạo công ty
        CongTy congTy = new CongTy("Trung tâm tiếng anh Aplus", 1000000);  // Lợi nhuận công ty là 1 triệu

        // Tạo các nhân viên
        CanBoHopDong cbhd1 = new CanBoHopDong("Nguyễn Thị Hương Giang", 7000);
        CanBoCoHuu cbch1 = new CanBoCoHuu("Thái Mỹ Anh", 5000, 2.0);
        TruongPhong tp1 = new TruongPhong("Nguyễn Thị Huế", 6000, 2.5, 1000);
        CanBoQuanLy cbql1 = new CanBoQuanLy("Lê Hải Nam", 5500, 2.2, congTy);
        GiamDoc gd1 = new GiamDoc("Trịnh Thành Trung", 8000, 3.0, 2000, congTy);

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

// Interface QuanLy
interface QuanLy {
    double tinhHoaHong();
}

// Abstract class NhanVien
abstract class NhanVien {
    protected String tenNhanVien;

    public NhanVien(String ten) {
        this.tenNhanVien = ten;
    }

    public abstract double tinhLuong();
    public abstract void inThongTin();
}

// Class CanBoCoHuu
class CanBoCoHuu extends NhanVien {
    protected double luongCoBan;
    protected double heSoLuong;

    public CanBoCoHuu(String ten, double luongCoBan, double heSoLuong) {
        super(ten);
        this.luongCoBan = luongCoBan;
        this.heSoLuong = heSoLuong;
    }

    @Override
    public double tinhLuong() {
        return luongCoBan * heSoLuong;
    }

    public void tangHeSoLuong(double hs) {
        this.heSoLuong += hs;
    }

    @Override
    public void inThongTin() {
        System.out.println("Can Bo Co Huu: " + tenNhanVien + ", Luong: " + tinhLuong());
    }
}

// Class CanBoHopDong
class CanBoHopDong extends NhanVien {
    private double luongHopDong;

    public CanBoHopDong(String ten, double luongHopDong) {
        super(ten);
        this.luongHopDong = luongHopDong;
    }

    @Override
    public double tinhLuong() {
        return luongHopDong;
    }

    @Override
    public void inThongTin() {
        System.out.println("Can Bo Hop Dong: " + tenNhanVien + ", Luong: " + tinhLuong());
    }
}

// Class GiamDoc
class GiamDoc extends CanBoCoHuu implements QuanLy {
    private double phuCap;
    private CongTy congTy;

    public GiamDoc(String ten, double luongCoBan, double heSoLuong, double phuCap, CongTy congTy) {
        super(ten, luongCoBan, heSoLuong);
        this.phuCap = phuCap;
        this.congTy = congTy;
    }

    @Override
    public double tinhHoaHong() {
        return 0.05 * congTy.getLoiNhuan();
    }

    @Override
    public double tinhLuong() {
        return super.tinhLuong() + phuCap + tinhHoaHong();
    }

    @Override
    public void inThongTin() {
        System.out.println("Giam Doc: " + tenNhanVien + ", Luong: " + tinhLuong());
    }
}

// Class CanBoQuanLy
class CanBoQuanLy extends CanBoCoHuu implements QuanLy {
    private CongTy congTy;

    public CanBoQuanLy(String ten, double luongCoBan, double heSoLuong, CongTy congTy) {
        super(ten, luongCoBan, heSoLuong);
        this.congTy = congTy;
    }

    @Override
    public double tinhHoaHong() {
        return 0.002 * congTy.getLoiNhuan();
    }

    @Override
    public double tinhLuong() {
        return super.tinhLuong() + tinhHoaHong();
    }

    @Override
    public void inThongTin() {
        System.out.println("Can Bo Quan Ly: " + tenNhanVien + ", Luong: " + tinhLuong());
    }
}

// Class TruongPhong
class TruongPhong extends CanBoCoHuu {
    private double phuCap;

    public TruongPhong(String ten, double luongCoBan, double heSoLuong, double phuCap) {
        super(ten, luongCoBan, heSoLuong);
        this.phuCap = phuCap;
    }

    @Override
    public double tinhLuong() {
        return super.tinhLuong() + phuCap;
    }

    @Override
    public void inThongTin() {
        System.out.println("Truong Phong: " + tenNhanVien + ", Luong: " + tinhLuong());
    }
}

// Class CongTy
class CongTy {
    private String tenCongTy;
    private int soNhanVien;
    private double loiNhuan;
    private static final int SO_NV_MAX = 100;
    private NhanVien[] danhSachNhanVien;

    public CongTy(String ten, double loiNhuan) {
        this.tenCongTy = ten;
        this.loiNhuan = loiNhuan;
        this.soNhanVien = 0;
        this.danhSachNhanVien = new NhanVien[SO_NV_MAX];
    }

    public boolean themNV(NhanVien nv) {
        if (soNhanVien < SO_NV_MAX) {
            danhSachNhanVien[soNhanVien++] = nv;
            return true;
        }
        return false;
    }

    public void inThongTin() {
        System.out.println("Cong ty: " + tenCongTy);
        for (int i = 0; i < soNhanVien; i++) {
            danhSachNhanVien[i].inThongTin();
        }
    }

    public double tinhTongLuong() {
        double tong = 0;
        for (int i = 0; i < soNhanVien; i++) {
            tong += danhSachNhanVien[i].tinhLuong();
        }
        return tong;
    }

    public double getLoiNhuan() {
        return loiNhuan;
    }
}