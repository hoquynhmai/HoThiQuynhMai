package furama_resort.models;

public class House extends Services {
    private String tieuChuanPhong;
    private String moTaTienNghiKhac;
    private String soTang;

    public House() {
    }

    public House(String id, String tenDichVu, String dienTichSuDung, String giaThue, String soLuongNguoiThue, String kieuThue, String tieuChuanPhong, String moTaTienNghiKhac, String soTang) {
        super(id, tenDichVu, dienTichSuDung, giaThue, soLuongNguoiThue, kieuThue);
        this.tieuChuanPhong = tieuChuanPhong;
        this.moTaTienNghiKhac = moTaTienNghiKhac;
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

    public String getSoTang() {
        return soTang;
    }

    public void setSoTang(String soTang) {
        this.soTang = soTang;
    }

    @Override
    public String showInfo() {
        return "House: "
                + super.toString()
                + " _ Tiêu chuẩn phòng: " + tieuChuanPhong
                + " _ Mô Tả Tiện Nghi Khác: " + moTaTienNghiKhac
                + " _ Số tâng: " + soTang;
    }
}
