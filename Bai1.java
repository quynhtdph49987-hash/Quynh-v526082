import java.util.Scanner;

public class Bai1 {
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

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }
    }

    // DuongThang được xác định bởi hai điểm A và B.
    static class DuongThang {
        private Diem A;
        private Diem B;

        public DuongThang(Diem A, Diem B) {
            if (A == null || B == null) {
                throw new IllegalArgumentException("Hai đầu mút không được để trống.");
            }
            this.A = A;
            this.B = B;
        }

        public Diem getA() {
            return A;
        }

        public Diem getB() {
            return B;
        }

        public double tinhDoDai() {
            double dx = B.getX() - A.getX();
            double dy = B.getY() - A.getY();
            return Math.sqrt(dx * dx + dy * dy);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tọa độ hai điểm A và B:");
        System.out.print("Ax = ");
        double ax = scanner.nextDouble();
        System.out.print("Ay = ");
        double ay = scanner.nextDouble();
        System.out.print("Bx = ");
        double bx = scanner.nextDouble();
        System.out.print("By = ");
        double by = scanner.nextDouble();

        DuongThang duongThang = new DuongThang(new Diem(ax, ay), new Diem(bx, by));
        System.out.printf("Độ dài đoạn thẳng AB = %.2f%n", duongThang.tinhDoDai());
        scanner.close();
    }
}