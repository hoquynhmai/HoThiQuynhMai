package bai7_abstract_class_interface.thuc_hanh.animal;

import bai7_abstract_class_interface.thuc_hanh.edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }
// Edible
    @Override
    public String howToEat() {
        return "could be fried";
    }
}