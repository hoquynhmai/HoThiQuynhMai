package bo;

import common.Validation;
import dao.ProductDAO;
import dao.ProductDAOImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LandBOImpl implements LandBO {
    ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public List<Land> findAllLand() {
        return this.productDAO.findAllLand();
    }

    @Override
    public Land findByID(String id) {
        return this.productDAO.findByID(id);
    }

    @Override
    public List<Land> findByFloor(String floor) {
        return this.productDAO.findByFloor(floor);
    }

    @Override
    public List<Land> findByArea(String area) {
        return this.productDAO.findByArea(area);
    }

    @Override
    public List<Land> findByFloorAndArea(String floor, String area) {
        return this.productDAO.findByFloorAndArea(floor, area);
    }

    @Override
    public String save(Land land) {
        boolean check = true;
        String message = "";

        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date dateStart;
        Date dateEnd;
        long getDaysDiff = 0;
        try {
            String startDate = land.getStartDate();
            String endDate = land.getEndDate();

            dateStart = simpleDateFormat.parse(startDate);
            dateEnd = simpleDateFormat.parse(endDate);
            long getDiff = dateEnd.getTime() - dateStart.getTime();
            getDaysDiff = getDiff / (24 * 60 * 60 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (getDaysDiff < 7) {
            check = false;
            message += "Invalid date end ! Date End must be greater than Date Start ,";
        }
        if (testID(land.getId())) {
            check = false;
            message += "Invalid ID ! ID is exists ! Please input ID other ,";
        } else if (Validation.regexID(land.getId())) {
            check = false;
            message += "Invalid ID ! Format id is LA-XXX with X is number from 0 to 9 ,";
        }
        if (Validation.regexAreaAndPrice(land.getArea())) {
            check = false;
            message += "Invalid area ! Area must be greater than 0 ,";
        }
        if (Validation.regexPositiveIntegers(land.getFloor())) {
            check = false;
            message += "Invalid floor ! Floor must be positive integer and greater than 0 ,";
        }
        if (Validation.regexAreaAndPrice(land.getPrice())) {
            check = false;
            message += "Invalid price ! Price must be greater than 0 !";
        }

        if (check) {
            message = this.productDAO.save(land);
        }

        return message;

//        return this.land.save(land);
    }

    @Override
    public String update(Land land) {

        boolean check = true;
        String message = "";


        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date dateStart;
        Date dateEnd;
        long getDaysDiff = 0;
        try {
            String startDate = land.getStartDate();
            String endDate = land.getEndDate();

            dateStart = simpleDateFormat.parse(startDate);
            dateEnd = simpleDateFormat.parse(endDate);
            long getDiff = dateEnd.getTime() - dateStart.getTime();
            getDaysDiff = getDiff / (24 * 60 * 60 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (getDaysDiff < 7) {
            check = false;
            message += "Invalid date end ! Date End must be greater than Date Start ,";
        }
        if (Validation.regexAreaAndPrice(land.getArea())) {
            check = false;
            message += "Invalid area ! Area must be greater than 0 ,";
        }
        if (Validation.regexPositiveIntegers(land.getFloor())) {
            check = false;
            message += "Invalid floor ! Floor must be positive integer and greater than 0 ,";
        }
        if (Validation.regexAreaAndPrice(land.getPrice())) {
            check = false;
            message += "Invalid price ! Price must be greater than 0 !";
        }

        if (check) {
            message = this.productDAO.update(land);
        }
        return message;

//        return this.landDAO.update(land);
    }

    @Override
    public void delete(String id) {
        this.productDAO.delete(id);
    }

    @Override
    public List<LandType> findAllLandType() {
        return this.productDAO.findAllLandType();
    }

    @Override
    public List<LandStatus> findAllLandStatus() {
        return this.productDAO.findAllLandStatus();
    }

    private boolean testID(String id) {
        List<String> listID = this.productDAO.findAllIDLand();
        for (String idExist : listID) {
            if (idExist.equals(id)) {
                return true;
            }
        }
        return false;
    }
}
