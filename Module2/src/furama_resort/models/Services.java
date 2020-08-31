package furama_resort.models;

public abstract class Services {
    private String id;
    private String tenDichVu;
    private String dienTichSuDung;
    private String giaThue;
    private String soLuongNguoiThue;
    private String kieuThue;

    public Services() {
    }


    public Services(String id, String tenDichVu, String dienTichSuDung, String giaThue, String soLuongNguoiThue, String kieuThue) {
        this.id = id;
        this.tenDichVu = tenDichVu;
        this.dienTichSuDung = dienTichSuDung;
        this.giaThue = giaThue;
        this.soLuongNguoiThue = soLuongNguoiThue;
        this.kieuThue = kieuThue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public String getDienTichSuDung() {
        return dienTichSuDung;
    }

    public void setDienTichSuDung(String dienTichSuDung) {
        this.dienTichSuDung = dienTichSuDung;
    }

    public String getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(String giaThue) {
        this.giaThue = giaThue;
    }

    public String getSoLuongNguoiThue() {
        return soLuongNguoiThue;
    }

    public void setSoLuongNguoiThue(String soLuongNguoiThue) {
        this.soLuongNguoiThue = soLuongNguoiThue;
    }

    public String getKieuThue() {
        return kieuThue;
    }

    public void setKieuThue(String kieuThue) {
        this.kieuThue = kieuThue;
    }

    public abstract String showInfo();

    @Override
    public String toString() {
        return "ID: " + id
                + " _ Tên dịch vụ: " + tenDichVu
                + " _ Diện tích sử dụng: " + dienTichSuDung
                + " _ Giá thuê: " + giaThue
                + " _ Số lượng người: " + soLuongNguoiThue
                + " _ Kiểu thuê: " + kieuThue;
    }
}
