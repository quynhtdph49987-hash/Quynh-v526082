import java.util.ArrayList;
import java.util.List;

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
