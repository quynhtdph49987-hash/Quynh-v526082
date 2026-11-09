/**
 * Lớp điểm 3D kế thừa từ Point2D.
 * z là private, chỉ truy cập qua getter/setter.
 */
public class Point3D extends Point2D {
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
