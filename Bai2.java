import java.util.Scanner;

public class Bai2 {
    // Diem biểu diễn một điểm trong mặt phẳng tọa độ Oxy.
    static class Diem {
        private double x;
        private double y;

        public Diem(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public double khoangCach(Diem diemKhac) {
            double dx = diemKhac.x - x;
            double dy = diemKhac.y - y;
            return Math.sqrt(dx * dx + dy * dy);
        }
    }

    static class TamGiac {
        private Diem A;
        private Diem B;
        private Diem C;

        public TamGiac(Diem A, Diem B, Diem C) {
            if (A == null || B == null || C == null) {
                throw new IllegalArgumentException("Ba đỉnh tam giác không được để trống.");
            }
            this.A = A;
            this.B = B;
            this.C = C;
        }

        public double tinhChuVi() {
            return A.khoangCach(B) + B.khoangCach(C) + C.khoangCach(A);
        }

        public double tinhDienTich() {
            double nuaChuVi = tinhChuVi() / 2.0;
            double ab = A.khoangCach(B);
            double bc = B.khoangCach(C);
            double ca = C.khoangCach(A);
            double giaTri = nuaChuVi * (nuaChuVi - ab) * (nuaChuVi - bc) * (nuaChuVi - ca);
            return Math.sqrt(Math.max(0.0, giaTri));
        }
    }

    static class ChuNhat {
        private double chieuDai;
        private double chieuRong;

        public ChuNhat(double chieuDai, double chieuRong) {
            if (chieuDai <= 0 || chieuRong <= 0) {
                throw new IllegalArgumentException("Chiều dài và chiều rộng phải lớn hơn 0.");
            }
            this.chieuDai = chieuDai;
            this.chieuRong = chieuRong;
        }

        public double tinhChuVi() {
            return 2 * (chieuDai + chieuRong);
        }

        public double tinhDienTich() {
            return chieuDai * chieuRong;
        }
    }

    static class HinhTron {
        private Diem O;
        private double banKinh;

        public HinhTron(Diem O, double banKinh) {
            if (O == null || banKinh <= 0) {
                throw new IllegalArgumentException("Tâm phải hợp lệ và bán kính phải lớn hơn 0.");
            }
            this.O = O;
            this.banKinh = banKinh;
        }

        public double tinhChuVi() {
            return 2 * Math.PI * banKinh;
        }

        public double tinhDienTich() {
            return Math.PI * banKinh * banKinh;
        }
    }

    private static void inThongTin(String ten, double chuVi, double dienTich) {
        System.out.printf("%s: chu vi = %.2f, diện tích = %.2f%n", ten, chuVi, dienTich);
    }

    public static void main(String[] args) {
        // Khởi tạo tùy ý hai hình thuộc mỗi loại.
        TamGiac tamGiac1 = new TamGiac(new Diem(0, 0), new Diem(3, 0), new Diem(0, 4));
        TamGiac tamGiac2 = new TamGiac(new Diem(1, 1), new Diem(5, 1), new Diem(1, 4));
        ChuNhat chuNhat1 = new ChuNhat(4, 5);
        ChuNhat chuNhat2 = new ChuNhat(2.5, 6);
        HinhTron hinhTron1 = new HinhTron(new Diem(0, 0), 3);
        HinhTron hinhTron2 = new HinhTron(new Diem(2, 1), 2.5);

        inThongTin("Tam giác 1", tamGiac1.tinhChuVi(), tamGiac1.tinhDienTich());
        inThongTin("Tam giác 2", tamGiac2.tinhChuVi(), tamGiac2.tinhDienTich());
        inThongTin("Chữ nhật 1", chuNhat1.tinhChuVi(), chuNhat1.tinhDienTich());
        inThongTin("Chữ nhật 2", chuNhat2.tinhChuVi(), chuNhat2.tinhDienTich());
        inThongTin("Hình tròn 1", hinhTron1.tinhChuVi(), hinhTron1.tinhDienTich());
        inThongTin("Hình tròn 2", hinhTron2.tinhChuVi(), hinhTron2.tinhDienTich());
    }
}