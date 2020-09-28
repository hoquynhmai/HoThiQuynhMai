import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TranslateDictionaryServlet", urlPatterns = "/trans")
public class TranslateDictionaryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("Hello","Xin chào");
        dictionary.put("Thanks","Cảm ơn");
        dictionary.put("Sorry","Xin lỗi");
        dictionary.put("Computer","Máy Tính");
        dictionary.put("Water","Nước");

        String search = request.getParameter("english");
        String result = dictionary.get(search);

        if(result != null){
//            request.setAttribute("dictionary", "Word: " + search);
            request.setAttribute("dictionary", search + ": " + result);
        } else {
            request.setAttribute("dictionary", "Not found");
        }
        request.getRequestDispatcher("trans_dictionary.jsp").forward(request,response);
    }
}
