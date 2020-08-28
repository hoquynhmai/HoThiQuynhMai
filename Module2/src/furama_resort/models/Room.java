package furama_resort.models;

public class Room extends Services {
    private String dichVuMienPhiDiKem;

    public Room() {
    }

    public Room(String id, String nameServices, double areaUse, double rentCosst, int amountOfPeople, String rentType, String dichVuMienPhiDiKem) {
        super(id, nameServices, areaUse, rentCosst, amountOfPeople, rentType);
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
