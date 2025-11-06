/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gym;

import java.util.Scanner;

public class Gym {
    public static void main(String[] args) {
        QuanLyHoiVien ql = new QuanLyHoiVien();
        Scanner sc = new Scanner(System.in);
        int chon;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm hội viên");
            System.out.println("2. Xem danh sách");
            System.out.println("3. Tìm hội viên theo tên");
            System.out.println("4. Sửa thông tin hội viên");
            System.out.println("5. Xóa hội viên");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            chon = sc.nextInt();
            sc.nextLine(); // bỏ dòng thừa

            switch (chon) {
                case 1:
                    ql.ThemHoiVien();
                    break;
                case 2:
                    ql.XemTatCa();
                    break;
                case 3:
                    System.out.print("Nhập tên cần tìm: ");
                    String ten = sc.nextLine();
                    ql.TimKiemHoiVienTheoTen(ten);
                    break;
                case 4:
                    System.out.print("Nhập ID hội viên cần sửa: ");
                    String idSua = sc.nextLine();
                    ql.SuaThongTin(idSua);
                    break;
                case 5:
                    System.out.print("Nhập ID cần xóa: ");
                    String idXoa = sc.nextLine();
                    ql.XoaHoiVien(idXoa);
                    break;
                case 0:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (chon != 0);
    }
}

