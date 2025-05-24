abstract class NhanVien {
    protected String tenNhanVien;

    public NhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public abstract double tinhLuong();
    public abstract void inThongTin();
}

interface QuanLy {
    double tinhHoaHong();
}

class CanBoCoHuu extends NhanVien {
    protected double luongCoBan;
    protected double heSoLuong;

    public CanBoCoHuu(String ten, double luongCoBan, double heSoLuong) {
        super(ten);
        this.luongCoBan = luongCoBan;
        this.heSoLuong = heSoLuong;
    }

    public void tangHeSoLuong(double tang) {
        heSoLuong += tang;
    }

    @Override
    public double tinhLuong() {
        return luongCoBan * heSoLuong;
    }

    @Override
    public void inThongTin() {
        System.out.println("Tên: " + tenNhanVien + ", Lương: " + tinhLuong());
    }
}

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
        System.out.println("Tên: " + tenNhanVien + ", Lương hợp đồng: " + tinhLuong());
    }
}

class GiamDoc extends CanBoCoHuu implements QuanLy {
    private double phuCap;
    private double loiNhuanCongTy;

    public GiamDoc(String ten, double luongCoBan, double heSoLuong, double phuCap, double loiNhuanCongTy) {
        super(ten, luongCoBan, heSoLuong);
        this.phuCap = phuCap;
        this.loiNhuanCongTy = loiNhuanCongTy;
    }

    @Override
    public double tinhHoaHong() {
        return 0.05 * loiNhuanCongTy;
    }

    @Override
    public double tinhLuong() {
        return super.tinhLuong() + phuCap + tinhHoaHong();
    }

    @Override
    public void inThongTin() {
        System.out.println("GĐ: " + tenNhanVien + ", Lương: " + tinhLuong());
    }
}

class CanBoQuanLy extends CanBoCoHuu implements QuanLy {
    private double loiNhuanCongTy;

    public CanBoQuanLy(String ten, double luongCoBan, double heSoLuong, double loiNhuanCongTy) {
        super(ten, luongCoBan, heSoLuong);
        this.loiNhuanCongTy = loiNhuanCongTy;
    }

    @Override
    public double tinhHoaHong() {
        return 0.002 * loiNhuanCongTy;
    }

    @Override
    public double tinhLuong() {
        return super.tinhLuong() + tinhHoaHong();
    }

    @Override
    public void inThongTin() {
        System.out.println("CBQL: " + tenNhanVien + ", Lương: " + tinhLuong());
    }
}

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
        System.out.println("TP: " + tenNhanVien + ", Lương: " + tinhLuong());
    }
}

class CongTy {
    private String tenCongTy;
    private int soNhanVien;
    private double loiNhuan;
    private final int SO_NV_MAX = 100;
    private NhanVien[] danhSachNhanVien;

    public CongTy(String tenCongTy, double loiNhuan) {
        this.tenCongTy = tenCongTy;
        this.loiNhuan = loiNhuan;
        danhSachNhanVien = new NhanVien[SO_NV_MAX];
        soNhanVien = 0;
    }

    public boolean themNV(NhanVien nv) {
        if (soNhanVien < SO_NV_MAX) {
            danhSachNhanVien[soNhanVien++] = nv;
            return true;
        }
        return false;
    }

    public void inThongTin() {
        System.out.println("Công ty: " + tenCongTy);
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
}
