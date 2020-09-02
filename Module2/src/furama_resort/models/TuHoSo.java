package furama_resort.models;

import furama_resort.commons.DocGhiFileCSV;

import java.io.IOException;
import java.util.List;
import java.util.Stack;

public class TuHoSo {
    public Stack<Employee> stack = new Stack<>();

    public TuHoSo() throws IOException {
        List<Employee> employeeList = DocGhiFileCSV.docFileEmployee();
        for(Employee element : employeeList){
            stack.push(element);
        }
    }
}
