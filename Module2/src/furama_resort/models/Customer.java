package furama_resort.models;

public class Customer {
    private String hoTen;
    private String ngaySinh;
    private String gioiTinh;
    private String cmnd;
    private String soDT;
    private String email;
    private String loaiKhach;
    private String diaChi;
    private Services dichVu;
    // thuộc tính sử dụng dịch vụ có kiểu đối tượng là Services

    public Customer() {
    }

    public Customer(String hoTen, String ngaySinh, String gioiTinh, String CMND, String soDT, String email, String loaiKhach, String diaChi) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.cmnd = CMND;
        this.soDT = soDT;
        this.email = email;
        this.loaiKhach = loaiKhach;
        this.diaChi = diaChi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoaiKhach() {
        return loaiKhach;
    }

    public void setLoaiKhach(String loaiKhach) {
        this.loaiKhach = loaiKhach;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Services getDichVu() {
        return dichVu;
    }

    public void setDichVu(Services dichVu) {
        this.dichVu = dichVu;
    }

    public String showInfo(){
        return "Họ và Tên: " + hoTen
                + " _ Ngày Sinh: " + ngaySinh
                + " _ Giới Tính: " + gioiTinh
                + " _ CMND: " + cmnd
                + " _ Số Điện Thoại: " + soDT
                + " _ Email: " + email
                + " _ Loại Khách: " + loaiKhach
                + " _ Địa chỉ: " + diaChi;
    }
}
