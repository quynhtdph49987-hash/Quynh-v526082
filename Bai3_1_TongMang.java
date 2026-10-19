import java.util.Scanner;

public class Bai3_1_TongMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số phần tử n: ");
        int n = scanner.nextInt();
        if (n < 0) {
            System.out.println("n phải lớn hơn hoặc bằng 0.");
            scanner.close();
            return;
        }

        int[] mang = new int[n];
        long tong = 0;
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhập phần tử thứ %d: ", i + 1);
            mang[i] = scanner.nextInt();
            tong += mang[i];
        }

        System.out.println("Tổng các phần tử trong mảng = " + tong);
        scanner.close();
    }
}