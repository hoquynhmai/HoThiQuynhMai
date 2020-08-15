package bai11_dsa_stack_queue.bai_tap.opitional.to_chuc_hop_ly_dermering_su_dung_queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Demerging {
    public static void main(String[] args) {
        Queue<NhanVien> nu = new LinkedList<>();
        Queue<NhanVien> nam = new LinkedList<>();
        List<NhanVien> nhanVienList = new ArrayList<>();
        System.out.println("- Danh sách nhân viên: ");
        nhanVienList.add(new NhanVien("Hồ Thị Quỳnh Mai","Nữ","15/05/1995"));
        nhanVienList.add(new NhanVien("Hồ Thị Hồng Nhung","Nữ","02/01/1993"));
        nhanVienList.add(new NhanVien("Trương Hoàng","Nam","01/06/1990"));
        nhanVienList.add(new NhanVien("Trần Thị Thu Ánh","Nữ","01/01/1995"));
        nhanVienList.add(new NhanVien("Nguyễn Văn A","Nam","05/01/1994"));
        System.out.println(nhanVienList);

        for(NhanVien element: nhanVienList){
            if(element.getGioiTinh().equals("Nữ")){
                nu.add(element);
            } else {
                nam.add(element);
            }
        }
        System.out.println("\n- Danh sách nhân viên Nữ");
        System.out.println(nu);
        System.out.println("\n- Danh sách nhân viên Nam");
        System.out.println(nam);
    }
}
