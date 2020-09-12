package bai20_solid.on_tap.models;

public class AnimalXK extends Animal {
    private String giaXuatKhau;
    private String quocGiaNhapSP;

    public AnimalXK() {
    }

    public AnimalXK(int idSP, String maSP, String tenSP, String giaBan, String soLuong, String nhaSanXuat, String giaXuatKhau, String quocGiaNhapSP) {
        super(idSP, maSP, tenSP, giaBan, soLuong, nhaSanXuat);
        this.giaXuatKhau = giaXuatKhau;
        this.quocGiaNhapSP = quocGiaNhapSP;
    }


    public String getGiaXuatKhau() {
        return giaXuatKhau;
    }

    public void setGiaXuatKhau(String giaXuatKhau) {
        this.giaXuatKhau = giaXuatKhau;
    }

    public String getQuocGiaNhapSP() {
        return quocGiaNhapSP;
    }

    public void setQuocGiaNhapSP(String quocGiaNhapSP) {
        this.quocGiaNhapSP = quocGiaNhapSP;
    }

    @Override
    public String hienThiThongTin() {
        return "Sản Phẩm Xuất Khẩu: "
                + super.toString()
                + " _ Giá Xuất Khẩu: " + giaXuatKhau
                + " _ Quốc Gia Nhập SP: " + quocGiaNhapSP;
    }
}
