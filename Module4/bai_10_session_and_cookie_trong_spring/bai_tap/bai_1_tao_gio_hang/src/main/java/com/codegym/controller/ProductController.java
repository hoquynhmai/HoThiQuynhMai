package com.codegym.controller;

import com.codegym.entity.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"", "/product"})
@SessionAttributes(value = "productCast")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ModelAttribute("productCast")
    public List<Product> productListNew() {
        return new ArrayList<>();
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", this.productService.findAll());
        return "home";
    }

    @GetMapping("/create")
    public String goCreate(Model model) {
        model.addAttribute("productCreate", new Product());
//        model.addAttribute("productList",this.productService.findAll());
        return "create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        this.productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Create Successfully");
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("productEdit", productService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirectAttributes) {
        productService.update(product);
        redirectAttributes.addFlashAttribute("message", "Update Successfully");
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String remove(@PathVariable Integer id, Model model) {
        model.addAttribute("productDelete", productService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        productService.delete(product.getId());
        redirectAttributes.addFlashAttribute("message", "Delete Successfully");
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("productView", productService.findById(id));
        return "detail_view";
    }

    @GetMapping("/{id}/addProduct")
    public String themHang(@SessionAttribute(value = "productCast") List<Product> productCast, @PathVariable Integer id) {
        Product product = this.productService.findById(id);
        product.setQuantity("1");
        productCast.add(product);
        return "list_product_buy";
    }
}
