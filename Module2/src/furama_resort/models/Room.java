package furama_resort.models;

public class Room extends Services {
    private String dichVuMienPhiDiKem;

    public Room() {
    }

    public Room(String id, String tenDichVu, String dienTichSuDung, String giaThue, String soLuongNguoiThue, String kieuThue, String dichVuMienPhiDiKem) {
        super(id, tenDichVu, dienTichSuDung, giaThue, soLuongNguoiThue, kieuThue);
        this.dichVuMienPhiDiKem = dichVuMienPhiDiKem;
    }

    public String getDichVuMienPhiDiKem() {
        return dichVuMienPhiDiKem;
    }

    public void setDichVuMienPhiDiKem(String dichVuMienPhiDiKem) {
        this.dichVuMienPhiDiKem = dichVuMienPhiDiKem;
    }

    @Override
    public String showInfo() {
        return "Room"
                + super.toString()
                ;
    }
}
