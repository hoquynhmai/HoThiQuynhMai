package com.codegym.controller;

import com.codegym.entity.employee.Employee;
import com.codegym.entity.login.AppRole;
import com.codegym.entity.login.AppUser;
import com.codegym.service.UserDetailsServiceImpl;
import com.codegym.service.employee.impl.EmployeeServiceImpl;
import com.codegym.service.register.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@SessionAttributes(value = "userLogin")
@RequestMapping({"", "/login"})
public class LoginController {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RegisterService registerService;

    @GetMapping({"/login"})
    public String goLogin() {
        return "login";
    }

    @GetMapping("/403")
    public String go403() {
        return "403";
    }

    @GetMapping("/register")
    public String register(Model model) {
        List<String> employeeNameList = this.registerService.findAllNameEmployee();
        model.addAttribute("employeeNameList", employeeNameList);

        List<AppRole> appRoleList = this.registerService.findAllAppRole();
        model.addAttribute("appRoleList",appRoleList);

        model.addAttribute("newAppUser", new AppUser());
//        model.addAttribute("appRoleList", this.userDetailsService.allAppRole());
        return "register";
    }

    @PostMapping("/registerNew")
    public String registerNew(@ModelAttribute(value = "newAppUser") AppUser appUser, @RequestParam Long appRoleId,
                              RedirectAttributes redirectAttributes) {
        if (this.registerService.checkRole(appUser, appRoleId)) {
            redirectAttributes.addFlashAttribute("message", "You can not do ADMIN !");
            return "redirect:/login/register";
        } else {
            String message = this.registerService.saveUser(appUser, appRoleId);
            redirectAttributes.addFlashAttribute("message", message);
            return "redirect:/login";
        }
    }

    @GetMapping("/error")
    public String error(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Verify username or password");
        return "redirect:/login";
    }
}
