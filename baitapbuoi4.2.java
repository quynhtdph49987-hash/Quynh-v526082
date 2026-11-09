import java.util.ArrayList;
import java.util.List;

/**
 * Lớp điểm 2D.
 * x, y là protected để lớp con (Point3D) truy cập trực tiếp.
 */
class Point2D {
    protected double x;
    protected double y;

    public Point2D() {
        this(0, 0);
    }

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    /** Tính khoảng cách giữa 2 điểm. */
    public double distanceTo(Point2D other) {
        double dx = x - other.x;
        double dy = y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /** Xác định điểm đối xứng qua gốc tọa độ. */
    public Point2D symmetric() {
        return new Point2D(-x, -y);
    }

    /** Tịnh tiến điểm đi một vị trí với độ lệch Δx, Δy. */
    public void translate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }
}

/**
 * Lớp điểm 3D kế thừa từ Point2D.
 * z là private, chỉ truy cập qua getter/setter.
 */
class Point3D extends Point2D {
    private double z;

    public Point3D() {
        super();
        this.z = 0;
    }

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() { return z; }
    public void setZ(double z) { this.z = z; }

    /**
     * Tính khoảng cách giữa 2 điểm 3D (ghi đè distanceTo của Point2D).
     * Nếu other chỉ là điểm 2D thì coi z = 0.
     */
    @Override
    public double distanceTo(Point2D other) {
        double dx = x - other.getX();
        double dy = y - other.getY();
        double otherZ = (other instanceof Point3D) ? ((Point3D) other).z : 0;
        double dz = z - otherZ;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    /** Định nghĩa lại hàm xác định điểm đối xứng qua gốc tọa độ. */
    @Override
    public Point3D symmetric() {
        return new Point3D(-x, -y, -z);
    }

    /** Tịnh tiến điểm đi một vị trí với độ lệch Δx, Δy và Δz. */
    public void translate(double dx, double dy, double dz) {
        super.translate(dx, dy);
        this.z += dz;
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f, %.2f)", x, y, z);
    }
}


public class Main {
    public static void main(String[] args) {
        // 1. Tạo danh sách điểm gồm 2D và 3D
        List<Point2D> points = new ArrayList<>();
        points.add(new Point2D(1, 2));
        points.add(new Point3D(1, 2, 3));
        points.add(new Point2D(4, 6));
        points.add(new Point3D(4, 6, 8));
        points.add(new Point2D(-3, 5));
        points.add(new Point3D(-2, 0, 7));

        System.out.println("Danh sách điểm ban đầu:");
        print(points);

        // 2. Tổng khoảng cách (giữa các điểm liên tiếp trong từng nhóm)
        List<Point2D> list2D = new ArrayList<>();
        List<Point3D> list3D = new ArrayList<>();
        for (Point2D p : points) {
            if (p instanceof Point3D) list3D.add((Point3D) p);
            else list2D.add(p);
        }

        double sum2D = 0;
        for (int i = 0; i < list2D.size() - 1; i++) {
            sum2D += list2D.get(i).distanceTo(list2D.get(i + 1));
        }
        double sum3D = 0;
        for (int i = 0; i < list3D.size() - 1; i++) {
            sum3D += list3D.get(i).distanceTo(list3D.get(i + 1));
        }
        System.out.printf("%nTổng khoảng cách các điểm 2D: %.4f%n", sum2D);
        System.out.printf("Tổng khoảng cách các điểm 3D: %.4f%n", sum3D);

        // 3. Đưa các điểm đối xứng vào danh sách (đa hình: gọi đúng symmetric())
        int n = points.size();
        for (int i = 0; i < n; i++) {
            points.add(points.get(i).symmetric());
        }

        System.out.println("\nDanh sách sau khi thêm các điểm đối xứng:");
        print(points);

        // Demo tịnh tiến
        Point2D a = new Point2D(0, 0);
        a.translate(1, 2);
        Point3D b = new Point3D(0, 0, 0);
        b.translate(1, 2, 3);
        System.out.println("\nSau tịnh tiến: 2D = " + a + ", 3D = " + b);
    }

    private static void print(List<Point2D> list) {
        for (int i = 0; i < list.size(); i++) {
            Point2D p = list.get(i);
            String type = (p instanceof Point3D) ? "3D" : "2D";
            System.out.printf("  %2d. [%s] %s%n", i + 1, type, p);
        }
    }
}
