package furama_resort.models;

public class Villa extends Services {
    private String tieuChuanPhong;
    private String moTaTienNghiKhac;
    private String dienTichHoBoi;
    private String soTang;

    public Villa() {
    }

    public Villa(String id, String tenDichVu, String dienTichSuDung, String giaThue, String soLuongNguoiThue, String kieuThue, String tieuChuanPhong, String moTaTienNghiKhac, String dienTichHoBoi, String soTang) {
        super(id, tenDichVu, dienTichSuDung, giaThue, soLuongNguoiThue, kieuThue);
        this.tieuChuanPhong = tieuChuanPhong;
        this.moTaTienNghiKhac = moTaTienNghiKhac;
        this.dienTichHoBoi = dienTichHoBoi;
        this.soTang = soTang;
    }

    public String getTieuChuanPhong() {
        return tieuChuanPhong;
    }

    public void setTieuChuanPhong(String tieuChuanPhong) {
        this.tieuChuanPhong = tieuChuanPhong;
    }

    public String getMoTaTienNghiKhac() {
        return moTaTienNghiKhac;
    }

    public void setMoTaTienNghiKhac(String moTaTienNghiKhac) {
        this.moTaTienNghiKhac = moTaTienNghiKhac;
    }

    public String getDienTichHoBoi() {
        return dienTichHoBoi;
    }

    public void setDienTichHoBoi(String dienTichHoBoi) {
        this.dienTichHoBoi = dienTichHoBoi;
    }

    public String getSoTang() {
        return soTang;
    }

    public void setSoTang(String soTang) {
        this.soTang = soTang;
    }

    @Override
    public String showInfo() {
        return "Villa: "
                + super.toString()
                + " _ Tiêu chuẩn phòng: " + tieuChuanPhong
                + " _ Mô Tả Tiện Nghi Khác: " + moTaTienNghiKhac
                + " _ Diện tích Hồ Bơi: " + dienTichHoBoi
                + " _ Số tầng: " + soTang;
    }
}
