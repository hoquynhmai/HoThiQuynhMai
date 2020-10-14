package controller;

import bo.CategoryBO;
import bo.CategoryBOImpl;
import bo.ProductBO;
import bo.ProductBOImpl;
import model.Category;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DisplayServlet",urlPatterns = {"","/home"})
public class DisplayServlet extends HttpServlet {
    ProductBO productBO=new ProductBOImpl();
    CategoryBO categoryBO=new CategoryBOImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        switch (action){
            case "create":
                create(request,response);
                break;
            case "delete":
                detele(request,response);
                break;
            case "search":
                search(request,response);
                break;
        }

    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("nameProduct");
        String price=request.getParameter("price");
        List<Product> productList=null;
        if (name.equals("")){
            productList=this.productBO.findProductByPrice(price);
        }else if (price.equals("")){
            productList=this.productBO.findProductByName(name);
        }else {
            productList=this.productBO.findProductByNameAndPrice(name,price);
        }

        List<Category> categoryList=this.categoryBO.findAllCategory();
        request.setAttribute("categoryList",categoryList);
        request.setAttribute("productList",productList);
        request.getRequestDispatcher("display.jsp").forward(request,response);

    }

    private void detele(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        this.productBO.delete(id);
        this.showListProduct(request,response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("productName");
        String price=request.getParameter("price");
        String quantity=request.getParameter("quantity");
        String color=request.getParameter("color");
        String description=request.getParameter("description");
        String category=request.getParameter("category");
        Product product=new Product(name,price,quantity,color,description,category);
        String message=this.productBO.create(product);
        List<Product> productList=this.productBO.findAllProduct();
        List<Category> categoryList=this.categoryBO.findAllCategory();
        if (message.equals("OK")){
            request.setAttribute("message",message);
            this.showListProduct(request,response);
        }else {
            request.setAttribute("productList",productList);
            request.setAttribute("categoryList",categoryList);
            request.setAttribute("message",message);
            request.setAttribute("product",product);
            request.getRequestDispatcher("display.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            default:
                showListProduct(request,response);
                break;
        }

    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Category> categoryList=this.categoryBO.findAllCategory();
        request.setAttribute("categoryList",categoryList);
        request.getRequestDispatcher("create.jsp").forward(request,response);
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList=this.productBO.findAllProduct();
        List<Category> categoryList=this.categoryBO.findAllCategory();
        request.setAttribute("productList",productList);
        request.setAttribute("categoryList",categoryList);
        request.getRequestDispatcher("display.jsp").forward(request,response);
     }
}
