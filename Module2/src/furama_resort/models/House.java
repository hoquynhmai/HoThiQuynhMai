package furama_resort.models;

public class House extends Services {
    private String tieuChuanPhong;
    private String moTaTienNghiKhac;
    private int soTang;

    public House() {
    }

    public House(String id, String nameServices, double areaUse, double rentCosst, int amountOfPeople, String rentType, String tieuChuanPhong, String moTaTienNghiKhac, int soTang) {
        super(id, nameServices, areaUse, rentCosst, amountOfPeople, rentType);
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

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
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
