import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Nguoi {
    private String hoTen;
    private int tuoi;

    public void nhap(Scanner scanner) {
        System.out.print("Họ tên: ");
        while (true) {
            String giaTri = scanner.nextLine().trim();
            if (!giaTri.isEmpty()) {
                hoTen = giaTri;
                break;
            }
            System.out.print("Họ tên không được để trống. Nhập lại: ");
        }
        tuoi = nhapSoNguyenKhongAm(scanner, "Tuổi: ");
    }

    public void xuat() {
        System.out.printf("Họ tên: %s | Tuổi: %d", hoTen, tuoi);
    }

    protected static int nhapSoNguyenKhongAm(Scanner scanner, String loiNhac) {
        while (true) {
            System.out.print(loiNhac);
            String giaTri = scanner.nextLine().trim();
            try {
                int so = Integer.parseInt(giaTri);
                if (so >= 0) {
                    return so;
                }
            } catch (NumberFormatException ignored) {
                // Hiển thị thông báo chung bên dưới.
            }
            System.out.println("Vui lòng nhập số nguyên lớn hơn hoặc bằng 0.");
        }
    }

    protected static double nhapSoThucKhongAm(Scanner scanner, String loiNhac) {
        while (true) {
            System.out.print(loiNhac);
            String giaTri = scanner.nextLine().trim();
            try {
                double so = Double.parseDouble(giaTri);
                if (Double.isFinite(so) && so >= 0) {
                    return so;
                }
            } catch (NumberFormatException ignored) {
                // Hiển thị thông báo chung bên dưới.
            }
            System.out.println("Vui lòng nhập số không âm hợp lệ.");
        }
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
}

class NhanVien extends Nguoi {
    private int snct;
    private double hsl;

    @Override
    public void nhap(Scanner scanner) {
        super.nhap(scanner);
        snct = nhapSoNguyenKhongAm(scanner, "Số năm công tác: ");
        hsl = nhapSoThucKhongAm(scanner, "Hệ số lương: ");
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf(" | Số năm công tác: %d | Hệ số lương: %.2f | Lương: %.2f triệu đồng%n",
                snct, hsl, tinhTienLuong());
    }

    public double tinhTienLuong() {
        double luongCoBan = 1.5;
        double phuCap = 0.2 * snct;
        return luongCoBan * hsl + phuCap;
    }

    public int getSnct() {
        return snct;
    }

    public void setSnct(int snct) {
        this.snct = snct;
    }

    public double getHsl() {
        return hsl;
    }

    public void setHsl(double hsl) {
        this.hsl = hsl;
    }
}

public class Buoi4 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = Nguoi.nhapSoNguyenKhongAm(scanner, "Nhập số nhân viên n (n >= 0): ");
            List<NhanVien> danhSach = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                System.out.printf("\nNhập thông tin nhân viên thứ %d:%n", i + 1);
                NhanVien nhanVien = new NhanVien();
                nhanVien.nhap(scanner);
                danhSach.add(nhanVien);
            }

            if (danhSach.isEmpty()) {
                System.out.println("Danh sách không có nhân viên.");
                return;
            }

            int soNamCongTacMax = danhSach.stream()
                    .mapToInt(NhanVien::getSnct)
                    .max()
                    .orElse(0);
            System.out.printf("\nNhân viên có số năm công tác nhiều nhất (%d năm):%n", soNamCongTacMax);
            for (NhanVien nhanVien : danhSach) {
                if (nhanVien.getSnct() == soNamCongTacMax) {
                    nhanVien.xuat();
                }
            }

            danhSach.sort(Comparator.comparingDouble(NhanVien::tinhTienLuong).reversed());
            System.out.println("\nDanh sách nhân viên theo lương từ cao đến thấp:");
            for (NhanVien nhanVien : danhSach) {
                nhanVien.xuat();
            }
        }
    }
}
