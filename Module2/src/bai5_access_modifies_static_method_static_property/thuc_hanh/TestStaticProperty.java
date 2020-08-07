package bai5_access_modifies_static_method_static_property.thuc_hanh;

public class TestStaticProperty {

    public static void main(String[] args) {

        StaticPropertyCar car1 = new StaticPropertyCar("Mazda 3","Skyactiv 3");
        System.out.println(StaticPropertyCar.numberOfCars);
        System.out.println("Car 1 : " + car1.getName() + " _ " + car1.getEngine());

        StaticPropertyCar car2 = new StaticPropertyCar("Mazda 6","Skyactiv 6");
        System.out.println(StaticPropertyCar.numberOfCars);
        System.out.println("Car 2 : " + car2.getName() + " _ " + car2.getEngine());

        StaticPropertyCar car3 = new StaticPropertyCar("Mazda 5","Skyactiv 5");
        System.out.println(StaticPropertyCar.numberOfCars);
        System.out.println("Car 3 : " + car3.getName() + " _ " + car3.getEngine());

        System.out.println("Số lượng xe được hiển thị: " + StaticPropertyCar.numberOfCars);
    }
}

