/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gym;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyHoiVien {
    private ArrayList<HoiVien> danhSach = new ArrayList<>();

    private boolean KiemTraTrungID(String id) {
        for (HoiVien hv : danhSach) {
            if (hv.getID().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public void ThemHoiVien() {
        HoiVien hv = new HoiVien();
        hv.NhapHoiVien();

        if (KiemTraTrungID(hv.getID())) {
            System.out.println("Lỗi: Mã hội viên '" + hv.getID() + "' đã tồn tại. Không thể thêm mới!");
            return;
        }

        danhSach.add(hv);
        System.out.println("Thêm hội viên thành công!");
    }

    //  Hàm sửa thông tin (có lựa chọn từng phần)
    public void SuaThongTin(String id) {
        Scanner sc = new Scanner(System.in);
        for (HoiVien hv : danhSach) {
            if (hv.getID().equalsIgnoreCase(id)) {
                System.out.println("\n Thông tin hiện tại:");
                hv.XemThongTinChiTiet();

                int chon;
                do {
                    System.out.println("\nChọn thông tin cần sửa:");
                    System.out.println("1. Họ tên");
                    System.out.println("2. Giới tính");
                    System.out.println("3. Địa chỉ");
                    System.out.println("4. Số điện thoại");
                    System.out.println("5. Trạng thái");
                    System.out.println("0. Thoát sửa");
                    System.out.print("Chọn: ");
                    chon = sc.nextInt();
                    sc.nextLine(); // bỏ dòng thừa

                    switch (chon) {
                        case 1:
                            System.out.print("Nhập họ tên mới: ");
                            hv.setHoTen(sc.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhập giới tính mới: ");
                            hv.setGioiTinh(sc.nextLine());
                            break;
                        case 3:
                            System.out.print("Nhập địa chỉ mới: ");
                            hv.setDiaChi(sc.nextLine());
                            break;
                        case 4:
                            System.out.print("Nhập số điện thoại mới: ");
                            hv.setSDT(sc.nextLine());
                            break;
                        case 5:
                            System.out.print("Nhập trạng thái mới: ");
                            hv.setTrangThai(sc.nextLine());
                            break;
                        case 0:
                            System.out.println("Đã thoát chế độ sửa.");
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ!");
                    }

                    if (chon != 0) {
                        System.out.println("Đã cập nhật thông tin!");
                    }

                } while (chon != 0);
                return;
            }
        }
        System.out.println("Không tìm thấy hội viên có ID " + id);
    }

    public void XoaHoiVien(String id) {
        danhSach.removeIf(hv -> hv.getID().equalsIgnoreCase(id));
        System.out.println("Đã xóa hội viên có ID " + id + " (nếu có).");
    }

    public void TimKiemHoiVienTheoTen(String ten) {
        boolean found = false;
        for (HoiVien hv : danhSach) {
            if (hv.getHoTen().equalsIgnoreCase(ten)) {
                hv.XemThongTinChiTiet();
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy hội viên tên " + ten);
    }

    public void XemTatCa() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }
        for (HoiVien hv : danhSach) {
            hv.XemThongTinChiTiet();
        }
    }
}


