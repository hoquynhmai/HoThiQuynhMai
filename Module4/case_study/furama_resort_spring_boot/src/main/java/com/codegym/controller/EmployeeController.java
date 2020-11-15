package com.codegym.controller;

import com.codegym.entity.employee.Division;
import com.codegym.entity.employee.EducationDegree;
import com.codegym.entity.employee.Employee;
import com.codegym.entity.employee.Position;
import com.codegym.service.employee.EmployeeService;
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
@RequestMapping({"/employee"})
public class EmployeeController {
    @Autowired
    private EmployeeService xService;

    @GetMapping()
    public String home(Model model, RedirectAttributes redirectAttributes, @PageableDefault(size = 3) Pageable pageable,
                       @RequestParam Optional<String> nameSearch) {
//        List<Employee> employeeList = xService.findAll();
//        model.addAttribute("employeeList", employeeList);
        redirectAttributes.addFlashAttribute("message", "");

        String keywordOld = "";
        if (nameSearch.isPresent()) {
            keywordOld = nameSearch.get();
            model.addAttribute("employeeList", xService.findByNameContaining(pageable, keywordOld));
        } else {
            model.addAttribute("employeeList", xService.findAll(pageable));
        }
        model.addAttribute("keywordOld", keywordOld);
        return "employee/home_employee";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<Division> divisionList = this.xService.findAllDivision();
        model.addAttribute("divisionList", divisionList);

        List<EducationDegree> educationDegreeList = this.xService.findAllEducationDegree();
        model.addAttribute("educationDegreeList", educationDegreeList);

        List<Position> positionList = this.xService.findAllPosition();
        model.addAttribute("positionList", positionList);

        model.addAttribute("save", new Employee());
        return "employee/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute(value = "save") Employee employee, BindingResult bindingResult,
                       RedirectAttributes redirect, Model model) {
// ------------------------- Validate ---------------------------------
        new Employee().validate(employee, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("employeeList", this.xService.findAll());

            List<Division> divisionList = this.xService.findAllDivision();
            model.addAttribute("divisionList", divisionList);

            List<EducationDegree> educationDegreeList = this.xService.findAllEducationDegree();
            model.addAttribute("educationDegreeList", educationDegreeList);

            List<Position> positionList = this.xService.findAllPosition();
            model.addAttribute("positionList", positionList);

            return "employee/create";
        }

        xService.save(employee);
        redirect.addFlashAttribute("message", "Create Successfully");
        return "redirect:/employee";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        List<Division> divisionList = this.xService.findAllDivision();
        model.addAttribute("divisionList", divisionList);

        List<EducationDegree> educationDegreeList = this.xService.findAllEducationDegree();
        model.addAttribute("educationDegreeList", educationDegreeList);

        List<Position> positionList = this.xService.findAllPosition();
        model.addAttribute("positionList", positionList);

        model.addAttribute("edit", xService.findById(id));
        return "employee/edit";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute(value = "edit") Employee employee, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {
        // ------------------------- Validate ---------------------------------
        new Employee().validate(employee, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("employeeList", this.xService.findAll());

            List<Division> divisionList = this.xService.findAllDivision();
            model.addAttribute("divisionList", divisionList);

            List<EducationDegree> educationDegreeList = this.xService.findAllEducationDegree();
            model.addAttribute("educationDegreeList", educationDegreeList);

            List<Position> positionList = this.xService.findAllPosition();
            model.addAttribute("positionList", positionList);

            return "employee/edit";
        }

        xService.update(employee);
        redirectAttributes.addFlashAttribute("message", "Update Successfully");
        return "redirect:/employee";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Integer id, Model model) {
        model.addAttribute("delete", xService.findById(id));
//        return "employee/delete";

        return "employee/home_employee";
    }

//    @PostMapping("/remove")
//    public String remove(Employee employee, RedirectAttributes redirectAttributes) {
//        xService.remove(employee.getId());
//        redirectAttributes.addFlashAttribute("message", "Delete Successfully");
//        return "redirect:/employee";
//    }

    @PostMapping("/remove")
    public String remove(@RequestParam Integer deleteId, RedirectAttributes redirectAttributes) {
        xService.remove(deleteId);
        redirectAttributes.addFlashAttribute("message", "Delete Successfully");
        return "redirect:/employee";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("view", xService.findById(id));
        return "employee/detail_view";
    }
}
