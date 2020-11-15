package com.codegym.controller;

import com.codegym.entity.AppUser;
import com.codegym.service.impl.UserDetailsServiceImpl;
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

    @GetMapping({"", "/login"})
    public String goLogin() {
        return "login";
    }

    @GetMapping("/403")
    public String go403() {
        return "403";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("newAppUser", new AppUser());
        model.addAttribute("appRoleList", this.userDetailsService.allAppRole());
        return "register";
    }

    @PostMapping("/registerNew")
    public String registerNew(@ModelAttribute AppUser newAppUser, @RequestParam Long[] appRole,
                              RedirectAttributes redirectAttributes) {
        boolean check = true;
        List<AppUser> appUserList = this.userDetailsService.allAppUser();
        for (AppUser appUser : appUserList) {
            if (appUser.getUserName().equals(newAppUser.getUserName())) {
                check = false;
                break;
            }
        }
        if (check) {
            newAppUser.setEncrytedPassword(this.bCryptPasswordEncoder.encode(newAppUser.getEncrytedPassword()));
            newAppUser.setUserId((long) (Math.random()*10000));
            this.userDetailsService.saveNewUser(newAppUser);
            for (Long element:appRole){
                this.userDetailsService.saveUserRole(newAppUser,element);
            }
            redirectAttributes.addFlashAttribute("message","Create Complete");
            return "redirect:/login";
        } else {
            redirectAttributes.addFlashAttribute("message","UserName is existed");
            return "redirect:/register";
        }
    }
}
