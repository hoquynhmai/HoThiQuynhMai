package furama_resort.models;

public class Employee {
    private String hoTenNV;
    private String tuoiNV;
    private String diaChiNV;

    public Employee() {
    }

    public Employee(String hoTenNV, String tuoiNV, String diaChiNV) {
        this.hoTenNV = hoTenNV;
        this.tuoiNV = tuoiNV;
        this.diaChiNV = diaChiNV;
    }

    public String getHoTenNV() {
        return hoTenNV;
    }

    public void setHoTenNV(String hoTenNV) {
        this.hoTenNV = hoTenNV;
    }

    public String getTuoiNV() {
        return tuoiNV;
    }

    public void setTuoiNV(String tuoiNV) {
        this.tuoiNV = tuoiNV;
    }

    public String getDiaChiNV() {
        return diaChiNV;
    }

    public void setDiaChiNV(String diaChiNV) {
        this.diaChiNV = diaChiNV;
    }

    @Override
    public String toString() {
        return "Họ và Tên Nhân Viên: " + hoTenNV
                + " _ Tuổi Nhân Viên: " + tuoiNV
                + " _ Địa Chỉ: " + diaChiNV;
    }
}
