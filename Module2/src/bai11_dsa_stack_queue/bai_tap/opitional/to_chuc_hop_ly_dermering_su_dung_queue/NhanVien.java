package bai11_dsa_stack_queue.bai_tap.opitional.to_chuc_hop_ly_dermering_su_dung_queue;

public class NhanVien {
    private String hoTen;
    private String gioiTinh;
    private String ngaySinh;

    public NhanVien() {
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    @Override
    public String toString() {
        return "Nhân Viên {" +
                "Họ Tên = '" + hoTen + '\'' +
                ", Giới Tính = '" + gioiTinh + '\'' +
                ", Ngày Sinh = " + ngaySinh +
                '}' + "\n";
    }

    public NhanVien(String hoTen, String gioiTinh, String ngaySinh) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
    }
}

