package bai20_solid.on_tap.commons;

import bai20_solid.on_tap.models.Animal;

import java.util.Comparator;

public class SapXep implements Comparator<Animal> {

    @Override
    public int compare(Animal sanPham1, Animal sanPham2) {
        int ketQua = Integer.parseInt(sanPham1.getGiaBan()) - Integer.parseInt(sanPham2.getGiaBan());
        if (ketQua != 0) return ketQua;
        else return sanPham1.getTenSP().compareTo(sanPham2.getTenSP());
    }
}
