/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gym;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class HoiVien {
    private String ID;
    private String HoTen;
    private String GioiTinh;
    private Date NgaySinh;
    private String DiaChi;
    private String SDT;
    private Date NgayDangKy;
    private String TrangThai;
    
    private TheHoiVien theHoiVien; //  Mỗi hội viên có 1 thẻ duy nhất

    // Định dạng ngày
    private static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    public HoiVien() {} // constructor mặc định

    public HoiVien(String ID, String hoTen, String gioiTinh, Date ngaySinh,
                   String diaChi, String SDT, Date ngayDangKy, String trangThai) {
        this.ID = ID;
        this.HoTen = hoTen;
        this.GioiTinh = gioiTinh;
        this.NgaySinh = ngaySinh;
        this.DiaChi = diaChi;
        this.SDT = SDT;
        this.NgayDangKy = ngayDangKy;
        this.TrangThai = trangThai;
    }

    // Hàm nhập thông tin hội viên từ bàn phím
    public void NhapHoiVien() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Nhập mã hội viên (ID): ");
            ID = sc.nextLine();

            System.out.print("Nhập họ tên: ");
            HoTen = sc.nextLine();

            System.out.print("Nhập giới tính: ");
            GioiTinh = sc.nextLine();

            System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
            String ngaySinhStr = sc.nextLine();
            NgaySinh = df.parse(ngaySinhStr);

            System.out.print("Nhập địa chỉ: ");
            DiaChi = sc.nextLine();

            System.out.print("Nhập số điện thoại: ");
            SDT = sc.nextLine();

            NgayDangKy = new Date(); // tự động lấy ngày hiện tại

            TrangThai = "Đang hoạt động";

            System.out.println("Nhập hội viên thành công!\n");
        } catch (Exception e) {
            System.out.println("Lỗi khi nhập dữ liệu: " + e.getMessage());
        }
    }

    public String getID() {
        return ID;
    }

    public String getHoTen() {
        return HoTen;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public Date getNgayDangKy() {
        return NgayDangKy;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setNgayDangKy(Date NgayDangKy) {
        this.NgayDangKy = NgayDangKy;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    public void TaoTheHoiVien() {
        if (theHoiVien == null) {
            theHoiVien = new TheHoiVien(ID);
            theHoiVien.TaoTheMoi();
        } else {
            System.out.println("️ Hội viên này đã có thẻ!");
        }
    }
    
    

    // Hiển thị thông tin chi tiết
    public void XemThongTinChiTiet() {
        System.out.println("ID: " + ID + " | Họ tên: " + HoTen + " | Giới tính: " + GioiTinh);
        System.out.println("Ngày sinh: " + df.format(NgaySinh) + " | Địa chỉ: " + DiaChi);
        System.out.println("SDT: " + SDT + " | Ngày đăng ký: " + df.format(NgayDangKy) + " | Trạng thái: " + TrangThai);
        if (theHoiVien != null) {
            theHoiVien.XemThongTinThe();
        } else {
            System.out.println(" Hội viên chưa có thẻ.");
        }
        System.out.println("-------------------------------------------------");
    }
}


