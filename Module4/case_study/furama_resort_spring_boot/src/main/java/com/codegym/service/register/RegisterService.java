package com.codegym.service.register;

import com.codegym.entity.employee.Employee;
import com.codegym.entity.login.AppRole;
import com.codegym.entity.login.AppUser;

import java.util.List;

public interface RegisterService {
    List<Employee> findAllEmployee();

    List<String> findAllNameEmployee();

    List<AppRole> findAllAppRole();

    boolean checkRole(AppUser appUser, Long id);

    String saveUser(AppUser appUser, Long id);
}
