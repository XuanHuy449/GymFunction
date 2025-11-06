/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gym;

import java.util.*;
import java.text.SimpleDateFormat;

public class TheHoiVien {
    private String MaThe;
    private String LoaiThe;      // "Buoi", "Thang", "Nam"
    private int ThoiHan;         // Số ngày hoặc số tháng tùy loại
    private Date NgayBatDau;
    private Date NgayHetHan;
    private double GiaTien;
    private String TinhTrang;
    private String IDHoiVien;

    private static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    public TheHoiVien(String IDHoiVien) {
        this.IDHoiVien = IDHoiVien;
    }

    //  Tạo thẻ mới
    public void TaoTheMoi() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã thẻ: ");
        MaThe = sc.nextLine();

        System.out.print("Chọn loại thẻ (Buoi/Thang/Nam): ");
        LoaiThe = sc.nextLine().trim();

        NgayBatDau = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(NgayBatDau);

        switch (LoaiThe.toLowerCase()) {
            case "buoi":
                System.out.print("Chọn thời hạn (3 hoặc 7 ngày): ");
                ThoiHan = sc.nextInt();
                if (ThoiHan == 3) {
                    cal.add(Calendar.DATE, 3);
                    GiaTien = 120000;
                } else if (ThoiHan == 7) {
                    cal.add(Calendar.DATE, 7);
                    GiaTien = 250000;
                } else {
                    System.out.println("️ Không hợp lệ, mặc định 1 ngày.");
                    cal.add(Calendar.DATE, 1);
                    ThoiHan = 1;
                    GiaTien = 50000;
                }
                break;

            case "thang":
                System.out.print("Chọn thời hạn (3 hoặc 7 tháng): ");
                ThoiHan = sc.nextInt();
                if (ThoiHan == 3) {
                    cal.add(Calendar.MONTH, 3);
                    GiaTien = 1000000;
                } else if (ThoiHan == 7) {
                    cal.add(Calendar.MONTH, 7);
                    GiaTien = 2000000;
                } else {
                    System.out.println("️ Không hợp lệ, mặc định 1 tháng.");
                    cal.add(Calendar.MONTH, 1);
                    ThoiHan = 1;
                    GiaTien = 400000;
                }
                break;

            case "nam":
                ThoiHan = 12; // 12 tháng = 1 năm
                cal.add(Calendar.YEAR, 1);
                GiaTien = 3500000;
                break;

            default:
                System.out.println("️ Loại thẻ không hợp lệ, mặc định là 'Buoi 1 ngày'");
                LoaiThe = "Buoi";
                cal.add(Calendar.DATE, 1);
                ThoiHan = 1;
                GiaTien = 50000;
        }

        NgayHetHan = cal.getTime();
        TinhTrang = "Còn hiệu lực";
        System.out.println(" Tạo thẻ mới thành công!");
    }

    //  Gia hạn thêm
    public void GiaHanThe() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(NgayHetHan);

        switch (LoaiThe.toLowerCase()) {
            case "buoi":
                cal.add(Calendar.DATE, ThoiHan);
                GiaTien += (ThoiHan == 3 ? 120000 : 250000);
                break;
            case "thang":
                cal.add(Calendar.MONTH, ThoiHan);
                GiaTien += (ThoiHan == 3 ? 1000000 : 2000000);
                break;
            case "nam":
                cal.add(Calendar.YEAR, 1);
                GiaTien += 3500000;
                break;
        }

        NgayHetHan = cal.getTime();
        System.out.println(" Gia hạn thành công! Ngày hết hạn mới: " + df.format(NgayHetHan));
    }

    //  Cập nhật tình trạng (hết hạn / còn hiệu lực)
    public void CapNhatTinhTrang() {
        Date now = new Date();
        if (now.after(NgayHetHan)) {
            TinhTrang = "Hết hạn";
        } else {
            TinhTrang = "Còn hiệu lực";
        }
    }

    //  Ghi nhận thanh toán
    public void GhiNhanThanhToan() {
        System.out.println(" Ghi nhận thanh toán: " + GiaTien + " VNĐ cho thẻ " + MaThe);
    }

    //  Hiển thị thông tin
    public void XemThongTinThe() {
        CapNhatTinhTrang();
        System.out.println("\n===== THÔNG TIN THẺ =====");
        System.out.println("Mã thẻ: " + MaThe);
        System.out.println("Loại thẻ: " + LoaiThe);
        System.out.println("Thời hạn: " + ThoiHan + (LoaiThe.equalsIgnoreCase("Buoi") ? " ngày" : " tháng"));
        System.out.println("Ngày bắt đầu: " + df.format(NgayBatDau));
        System.out.println("Ngày hết hạn: " + df.format(NgayHetHan));
        System.out.println("Giá tiền: " + GiaTien);
        System.out.println("Tình trạng: " + TinhTrang);
    }

    public String getIDHoiVien() { return IDHoiVien; }
    public String getLoaiThe() { return LoaiThe; }
}
