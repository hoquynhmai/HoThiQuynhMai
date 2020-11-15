package com.codegym.service.register.impl;

import com.codegym.entity.employee.Employee;
import com.codegym.entity.login.AppRole;
import com.codegym.entity.login.AppUser;
import com.codegym.repository.employee.EmployeeRepository;
import com.codegym.repository.login.AppRoleRepository;
import com.codegym.repository.login.AppUserRepository;
import com.codegym.service.UserDetailsServiceImpl;
import com.codegym.service.register.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AppRoleRepository appRoleRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public List<Employee> findAllEmployee() {
        return this.employeeRepository.findAll();
    }

    @Override
    public List<String> findAllNameEmployee() {
        List<Employee> employeeListExits = this.employeeRepository.findAll();
        List<AppUser> appUserListExits = this.appUserRepository.findAll();
        List<String> employeeNameListExits = new ArrayList<>();
        List<String> appUserNameListExits = new ArrayList<>();

        for (Employee element : employeeListExits) {
            employeeNameListExits.add(element.getName());
        }

        for (AppUser element : appUserListExits) {
            appUserNameListExits.add(element.getUserName());
        }

        employeeNameListExits.removeAll(appUserNameListExits);

        return employeeNameListExits;
    }

    @Override
    public List<AppRole> findAllAppRole() {
        return this.appRoleRepository.findAll();
    }

    @Override
    public boolean checkRole(AppUser appUser, Long id) {
        Employee employee = new Employee();
        List<Employee> employeeList = this.employeeRepository.findAll();
        for (Employee element : employeeList) {
            if (element.getName().equals(appUser.getUserName())) {
                employee = element;
            }
        }

        if (!((employee.getPosition().getName().equals("Manager"))
                || (employee.getPosition().getName().equals("Director")))
                && id == 1) {
            return true;
        }
        return false;
    }

    @Override
    public String saveUser(AppUser appUser, Long id) {
        appUser.setEncrytedPassword(this.bCryptPasswordEncoder.encode(appUser.getEncrytedPassword()));
        appUser.setUserId((long) (Math.random() * 1000));
        appUser.setEnabled(true);
        this.userDetailsService.saveNewUser(appUser);
        this.userDetailsService.saveUserRole(appUser, id);
        return "Register Successfully !";
    }
}
