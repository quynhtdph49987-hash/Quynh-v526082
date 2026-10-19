import java.util.Scanner;

public class Bai3_3_NhapChuoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập các số nguyên trên một dòng, cách nhau bởi dấu cách:");
        String dongNhap = scanner.nextLine().trim();

        if (dongNhap.isEmpty()) {
            System.out.println("Số phần tử: 0; Tổng: 0");
            scanner.close();
            return;
        }

        String[] cacSo = dongNhap.split("\\s+");
        long tong = 0;
        try {
            for (String so : cacSo) {
                tong += Integer.parseInt(so);
            }
            System.out.println("Số phần tử: " + cacSo.length + "; Tổng: " + tong);
        } catch (NumberFormatException e) {
            System.out.println("Dữ liệu không hợp lệ. Hãy chỉ nhập các số nguyên, ngăn cách bằng dấu cách.");
        }
        scanner.close();
    }
}