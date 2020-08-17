package bai12_java_collection_framework.bai_tap.luyen_tap_su_dung_arraylist_linkedlist;

public class Product {
    private String name;
    private int cost;

    public Product() {
    }

    public Product(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Name: " + name + " _ Giá: " + cost;
    }
}
