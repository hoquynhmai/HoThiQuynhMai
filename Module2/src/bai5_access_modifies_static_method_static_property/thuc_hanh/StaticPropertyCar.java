package bai5_access_modifies_static_method_static_property.thuc_hanh;

public class StaticPropertyCar {
    private String name;

    private String engine;

    public static int numberOfCars;

    public StaticPropertyCar(String name, String engine) {

        this.name = name;

        this.engine = engine;

        numberOfCars++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }
}
