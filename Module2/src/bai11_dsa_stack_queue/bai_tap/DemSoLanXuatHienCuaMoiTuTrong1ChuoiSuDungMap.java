package bai11_dsa_stack_queue.bai_tap;

import java.util.TreeMap;

public class DemSoLanXuatHienCuaMoiTuTrong1ChuoiSuDungMap {
    public static void main(String[] args) {
        String str = "TÔI LÀ AI AI LÀ TÔI TÔI KHÔNG BIẾT";
        System.out.println("Chuỗi đã nhập: " + str);

        String string = str.toLowerCase();
        System.out.println("Chuyển chữ hoa thành chữ thường: " + string);

        String[] array = string.split("\\s");
        TreeMap<String, Integer> map = new TreeMap<>();
        for (String element: array){
            if(map.containsKey(element)){
                map.put(element,(map.get(element) + 1));
            } else {
                map.put(element,1);
            }
        }
        System.out.println(map);
    }
}
