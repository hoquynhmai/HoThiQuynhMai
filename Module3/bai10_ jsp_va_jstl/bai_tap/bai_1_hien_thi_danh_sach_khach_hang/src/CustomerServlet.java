import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"","/listCustomer"})
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Huỳnh Trấn Thành","05/02/1987","Hồ Chí Minh","picture/thanh.jpg"));
        customerList.add(new Customer("Võ Vũ Trường Giang","20/04/1983","Quảng Nam","picture/giang.jpg"));
        customerList.add(new Customer("Nguyễn Chí Tài","15/08/1958","Hồ Chí Minh","picture/tai.jpg"));
        customerList.add(new Customer("Trần Khả Như","16/03/1987","Hậu Giang","picture/khanhu.jpg"));
        customerList.add(new Customer("Lê Thị Vỹ Dạ","01/09/1989","Hồ Chí Minh","picture/da.jpg"));

        request.setAttribute("list",customerList);
        request.getRequestDispatcher("customer.jsp").forward(request,response);
    }
}
