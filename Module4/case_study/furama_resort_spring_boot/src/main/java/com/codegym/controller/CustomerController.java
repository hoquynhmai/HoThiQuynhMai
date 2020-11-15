package com.codegym.controller;

import com.codegym.entity.customer.Customer;
import com.codegym.entity.customer.TypeCustomer;
import com.codegym.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping({"/customer"})
public class CustomerController {
    @Autowired
    private CustomerService xService;

    @GetMapping()
    public String home(Model model, RedirectAttributes redirectAttributes, @PageableDefault(size = 3) Pageable pageable,
                       @RequestParam Optional<String> nameSearch) {
//        List<Customer> customerList = xService.findAll();
//        model.addAttribute("customerList", customerList);
        redirectAttributes.addFlashAttribute("message", "");

        String keywordOld = "";
        if (nameSearch.isPresent()) {
            keywordOld = nameSearch.get();
            model.addAttribute("customerList", xService.findByNameContaining(pageable, keywordOld));
        } else {
            model.addAttribute("customerList", xService.findAll(pageable));
        }
        model.addAttribute("keywordOld", keywordOld);
        return "customer/home_customer";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<TypeCustomer> typeCustomerList = this.xService.findAllTypeCustomer();
        model.addAttribute("typeCustomerList", typeCustomerList);

        model.addAttribute("save", new Customer());
        return "customer/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute(value = "save") Customer customer, BindingResult bindingResult,
                       RedirectAttributes redirect, Model model) {
        boolean check = false;
        List<Customer> customerList = this.xService.findAll();
        for (Customer element : customerList) {
            if (element.getId().equals(customer.getId())) {
                check = true;
                break;
            }
        }

        if (bindingResult.hasFieldErrors() || check) {
            model.addAttribute("customerList", this.xService.findAll());

            List<TypeCustomer> typeCustomerList = this.xService.findAllTypeCustomer();
            model.addAttribute("typeCustomerList", typeCustomerList);

            if(!bindingResult.hasFieldErrors()){
                model.addAttribute("message","This ID already exits");
            }

            return "customer/create";
        }

        xService.save(customer);
        redirect.addFlashAttribute("message", "Create Successfully");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable String id, Model model) {
        List<TypeCustomer> typeCustomerList = this.xService.findAllTypeCustomer();
        model.addAttribute("typeCustomerList", typeCustomerList);

        model.addAttribute("edit", xService.findById(id));
        return "customer/edit";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute(value = "edit") Customer customer, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerList", this.xService.findAll());

            List<TypeCustomer> typeCustomerList = this.xService.findAllTypeCustomer();
            model.addAttribute("typeCustomerList", typeCustomerList);

            return "customer/edit";
        }

        xService.update(customer);
        redirectAttributes.addFlashAttribute("message", "Update Successfully");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable String id, Model model) {
        model.addAttribute("delete", xService.findById(id));
//        Chuyển trang
//        return "customer/delete";

//        Delete Modal
        return "customer/home_customer";
    }


//    Chuyển trang
//    @PostMapping("/remove")
//    public String remove(Customer customer, RedirectAttributes redirectAttributes) {
//        xService.remove(customer.getId());
//        redirectAttributes.addFlashAttribute("message", "Delete Successfully");
//        return "redirect:/customer";
//    }

    @PostMapping("/remove")
    public String remove(@RequestParam String deleteId, RedirectAttributes redirectAttributes) {
        xService.remove(deleteId);
        redirectAttributes.addFlashAttribute("message", "Delete Successfully");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable String id, Model model) {
        model.addAttribute("view", xService.findById(id));
        return "customer/detail_view";
    }
}
