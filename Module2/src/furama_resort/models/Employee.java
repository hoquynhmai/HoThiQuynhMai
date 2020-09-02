package furama_resort.models;

import java.util.Comparator;

public class Employee {
    private String maSoNV;
    private String hoTenNV;
    private String tuoiNV;
    private String diaChiNV;

    public Employee() {
    }

    public Employee(String maSoNV,String hoTenNV, String tuoiNV, String diaChiNV) {
        this.maSoNV = maSoNV;
        this.hoTenNV = hoTenNV;
        this.tuoiNV = tuoiNV;
        this.diaChiNV = diaChiNV;
    }

    public String getMaSoNV() {
        return maSoNV;
    }

    public void setMaSoNV(String maSoNV) {
        this.maSoNV = maSoNV;
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
        return "Mã số NV: " + maSoNV
                + " _ Họ và Tên Nhân Viên: " + hoTenNV
                + " _ Tuổi Nhân Viên: " + tuoiNV
                + " _ Địa Chỉ: " + diaChiNV;
    }
}
