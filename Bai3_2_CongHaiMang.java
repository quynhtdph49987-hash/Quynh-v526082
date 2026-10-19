import java.util.Arrays;
import java.util.Scanner;

public class Bai3_2_CongHaiMang {
    // Mảng ngắn hơn được xem như có giá trị 0 ở các vị trí còn thiếu.
    public static int[] congHaiMang(int[] mang1, int[] mang2) {
        int doDai = Math.max(mang1.length, mang2.length);
        int[] ketQua = new int[doDai];
        for (int i = 0; i < doDai; i++) {
            int giaTri1 = i < mang1.length ? mang1[i] : 0;
            int giaTri2 = i < mang2.length ? mang2[i] : 0;
            ketQua[i] = giaTri1 + giaTri2;
        }
        return ketQua;
    }

    private static int[] nhapMang(Scanner scanner, String tenMang) {
        System.out.printf("Nhập số phần tử của %s: ", tenMang);
        int n = scanner.nextInt();
        if (n < 0) {
            throw new IllegalArgumentException("Số phần tử phải lớn hơn hoặc bằng 0.");
        }
        int[] mang = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("%s[%d] = ", tenMang, i);
            mang[i] = scanner.nextInt();
        }
        return mang;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int[] mang1 = nhapMang(scanner, "mảng 1");
            int[] mang2 = nhapMang(scanner, "mảng 2");
            System.out.println("Mảng tổng: " + Arrays.toString(congHaiMang(mang1, mang2)));
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}