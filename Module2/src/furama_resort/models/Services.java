package furama_resort.models;

public abstract class Services {
    private String id;
    private String tenDichVu;
    private double dienTichSuDung;
    private double giaThue; //giá thuê
    private int soLuongNguoiThue; //số lượng người
    private String kieuThue; //kiểu thuê

    public Services() {
    }

    public Services(String id, String nameServices, double areaUse, double rentCosst, int amountOfPeople, String rentType) {
        this.id = id;
        this.tenDichVu = nameServices;
        this.dienTichSuDung = areaUse;
        this.giaThue = rentCosst;
        this.soLuongNguoiThue = amountOfPeople;
        this.kieuThue = rentType;
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

    public double getAreaUse() {
        return dienTichSuDung;
    }

    public void setAreaUse(double areaUse) {
        this.dienTichSuDung = areaUse;
    }

    public double getRentCost() {
        return giaThue;
    }

    public void setRentCost(double rentCost) {
        this.giaThue = rentCost;
    }

    public int getAmountOfPeople() {
        return soLuongNguoiThue;
    }

    public void setAmountOfPeople(int amountOfPeople) {
        this.soLuongNguoiThue = amountOfPeople;
    }

    public String getRentType() {
        return kieuThue;
    }

    public void setRentType(String rentType) {
        this.kieuThue = rentType;
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
