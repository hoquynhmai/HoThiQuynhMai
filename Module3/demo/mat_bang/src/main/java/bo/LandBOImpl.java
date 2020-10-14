package bo;

import common.Validation;
import dao.LandDAO;
import dao.LandDAOImpl;
import model.Land;
import model.LandStatus;
import model.LandType;

import java.util.List;

public class LandBOImpl implements LandBO {
    LandDAO landDAO = new LandDAOImpl();

    @Override
    public List<Land> findAllLand() {
        return this.landDAO.findAllLand();
    }

    @Override
    public Land findByID(String id) {
        return this.landDAO.findByID(id);
    }

    @Override
    public List<Land> findByFloor(String floor) {
        return this.landDAO.findByFloor(floor);
    }

    @Override
    public String save(Land land) {
        boolean check = true;
        String message = "";

        if (testID(land.getId())) {
            check = false;
            message += "Invalid ID ! ID is exists ! Please input ID other ,";
        } else if (Validation.regexID(land.getId())) {
            check = false;
            message += "Invalid ID ! Format id is LA-XXX with X is number from 0 to 9 ,";
        }
        if(Validation.regexAreaAndPrice(land.getArea())){
            check = false;
            message += "Invalid area ! Area must be greater than 0 ,";
        }
        if(Validation.regexPositiveIntegers(land.getFloor())){
            check = false;
            message += "Invalid floor ! Floor must be positive integer and greater than 0 ,";
        }
        if(Validation.regexAreaAndPrice(land.getPrice())){
            check = false;
            message += "Invalid price ! Price must be greater than 0 !";
        }

        if (check){
            message = this.landDAO.save(land);
        }

        return message;

//        return this.land.save(land);
    }

    @Override
    public String update(Land land) {

        boolean check = true;
        String message = "";

        if(Validation.regexAreaAndPrice(land.getArea())){
            check = false;
            message += "Invalid area ! Area must be greater than 0 ,";
        }
        if(Validation.regexPositiveIntegers(land.getFloor())){
            check = false;
            message += "Invalid floor ! Floor must be positive integer and greater than 0 ,";
        }
        if(Validation.regexAreaAndPrice(land.getPrice())){
            check = false;
            message += "Invalid price ! Price must be greater than 0 !";
        }

        if (check){
            message = this.landDAO.update(land);
        }
        return message;

//        return this.landDAO.update(land);
    }

    @Override
    public void delete(String id) {
        this.landDAO.delete(id);
    }

    @Override
    public List<LandType> findAllLandType() {
        return this.landDAO.findAllLandType();
    }

    @Override
    public List<LandStatus> findAllLandStatus() {
        return this.landDAO.findAllLandStatus();
    }

    private boolean testID(String id) {
        List<String> listID = this.landDAO.findAllIDLand();
        for (String idExist : listID) {
            if (idExist.equals(id)) {
                return true;
            }
        }
        return false;
    }
}
