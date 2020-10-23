package com.codegym.controller;

import com.codegym.entity.Student;
import com.codegym.service.ClassStudentService;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping({"/student", ""})
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassStudentService classStudentService;

    @RequestMapping(method = RequestMethod.GET)
//    @GetMapping(value = "/")
    public String goListStudent(Model model, @PageableDefault(size = 2) Pageable pageable,
                                @RequestParam Optional<String> keyword) {

        String keywordOld = "";
        if (keyword.isPresent()) {
            keywordOld = keyword.get();
            model.addAttribute("listStudent", studentService.findByNameContaining(pageable, keywordOld));
        } else {
            model.addAttribute("listStudent", studentService.findAll(pageable));
        }

        model.addAttribute("keywordOld", keywordOld);

        return "list_student";
    }

    @GetMapping("/detail")
    public String goDetailStudent(@RequestParam Integer id, Model model) {
        model.addAttribute("studentDetail", studentService.findById(id));
        return "detail_student";
    }

    @GetMapping("/detail/{idStudent}")
    public String goDetailStudentPathVariable(@PathVariable(value = "idStudent") Integer id, Model model) {
        model.addAttribute("studentDetail", studentService.findById(id));
        return "detail_student";
    }

    @GetMapping("/create")
    public String goCreateStudent(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("listClassStudent", this.classStudentService.findAll());

        return "create_student";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student, RedirectAttributes redirectAttributes) {

        this.studentService.save(student);
        redirectAttributes.addFlashAttribute("message", "Create student NG!");

        return "redirect:/student";
    }

    @GetMapping("/update")
    public String goUpdateStudent(Model model, @RequestParam Integer id) {
        model.addAttribute("student", this.studentService.findById(id));

        return "update_student";
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute Student student) {
        this.studentService.save(student);

        return "redirect:/";
    }
}
