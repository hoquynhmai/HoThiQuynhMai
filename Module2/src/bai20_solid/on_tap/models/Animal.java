package bai20_solid.on_tap.models;

public abstract class Animal {
    private int idSP;
    private String maSP;
    private String tenSP;
    private String giaBan;
    private String soLuong;
    private String nhaSanXuat;

    public Animal() {
    }

    public Animal(int idSP, String maSP, String tenSP, String giaBan, String soLuong, String nhaSanXuat) {
        this.idSP = idSP;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.nhaSanXuat = nhaSanXuat;
    }

    public int getIdSP() {
        return idSP;
    }

    public void setIdSP(int idSP) {
        this.idSP = idSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(String giaBan) {
        this.giaBan = giaBan;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public abstract String hienThiThongTin();

    @Override
    public String toString() {
        return "ID SP: " + idSP
                + " _ Mã SP: " + maSP
                + " _ Tên SP: " + tenSP
                + " _ Giá bán: " + giaBan
                + " _ Số Lượng: " + soLuong
                + " _ Nhà sản xuất: " + nhaSanXuat;
    }
}
