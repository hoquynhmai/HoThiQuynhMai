package com.codegym.config;

import com.codegym.entity.AppRole;
import com.codegym.entity.AppUser;
import com.codegym.entity.ClassStudent;
import com.codegym.entity.UserRole;
import com.codegym.repository.AppRoleRepository;
import com.codegym.repository.AppUserRepository;
import com.codegym.repository.ClassStudentRepository;
import com.codegym.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AppRoleRepository appRoleRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private ClassStudentRepository classStudentRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (appRoleRepository.findByRoleName("ROLE_ADMIN") == null
                && appRoleRepository.findByRoleName("ROLE_USER") == null) {
            AppUser appUserDbAdmin = new AppUser(
                    "dbadmin1",
                    "$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu",
                    true);
            AppUser appUserDbUser = new AppUser(
                    "dbuser1",
                    "$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu",
                    true);
            AppRole appRoleAdmin = new AppRole("ROLE_ADMIN");
            AppRole appRoleUser = new AppRole("ROLE_USER");

            appRoleRepository.save(appRoleAdmin);
            appRoleRepository.save(appRoleUser);
            appUserRepository.save(appUserDbAdmin);
            appUserRepository.save(appUserDbUser);
            userRoleRepository.save(new UserRole(appUserDbAdmin, appRoleAdmin));
            userRoleRepository.save(new UserRole(appUserDbAdmin, appRoleUser));
            userRoleRepository.save(new UserRole(appUserDbUser, appRoleUser));

            classStudentRepository.save(new ClassStudent(1, "C0620G1"));
            classStudentRepository.save(new ClassStudent(2, "C0920G1"));
        }
    }
}
