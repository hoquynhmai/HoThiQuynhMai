package com.codegym.controller;

import com.codegym.entity.Book;
import com.codegym.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping({"", "/book"})
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String home(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);
        return "home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("bookSave", new Book());
        return "create";
    }

    @PostMapping("/save")
    public String save (Book book, RedirectAttributes redirectAttributes){
        bookService.save(book);
        redirectAttributes.addFlashAttribute("message","Create Successfully");
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) throws Exception {
        model.addAttribute("bookEdit", bookService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Book book, RedirectAttributes redirectAttributes) {
        bookService.update(book);
        redirectAttributes.addFlashAttribute("message", "Update Successfully");
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) throws Exception {
        model.addAttribute("bookDelete", bookService.findById(id));
        return "delete";
    }

    @PostMapping("/remove")
    public String remove(Book book, RedirectAttributes redirectAttributes) {
        bookService.delete(book.getId());
        redirectAttributes.addFlashAttribute("message", "Delete Successfully");
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) throws Exception {
        model.addAttribute("bookView", bookService.findById(id));
        return "detail_view";
    }
}
