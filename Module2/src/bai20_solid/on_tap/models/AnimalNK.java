package bai20_solid.on_tap.models;

public class AnimalNK extends Animal {
    private String giaNhapKhau;
    private String tinhThanhNhap;
    private String thueNhapKhau;

    public AnimalNK() {
    }


    public AnimalNK(int idSP, String maSP, String tenSP, String giaBan, String soLuong, String nhaSanXuat, String giaNhapKhau, String tinhThanhNhap, String thueNhapKhau) {
        super(idSP, maSP, tenSP, giaBan, soLuong, nhaSanXuat);
        this.giaNhapKhau = giaNhapKhau;
        this.tinhThanhNhap = tinhThanhNhap;
        this.thueNhapKhau = thueNhapKhau;
    }

    public String getGiaNhapKhau() {
        return giaNhapKhau;
    }

    public void setGiaNhapKhau(String giaNhapKhau) {
        this.giaNhapKhau = giaNhapKhau;
    }

    public String getTinhThanhNhap() {
        return tinhThanhNhap;
    }

    public void setTinhThanhNhap(String tinhThanhNhap) {
        this.tinhThanhNhap = tinhThanhNhap;
    }

    public String getThueNhapKhau() {
        return thueNhapKhau;
    }

    public void setThueNhapKhau(String thueNhapKhau) {
        this.thueNhapKhau = thueNhapKhau;
    }

    @Override
    public String hienThiThongTin() {
        return "Sản Phẩm Nhập Khẩu: "
                + super.toString()
                + " _ Giá nhập khẩu: " + giaNhapKhau
                + " _ Tỉnh thành nhập: " + tinhThanhNhap
                + " _ Thuế nhập khẩu: " + thueNhapKhau;
    }
}
