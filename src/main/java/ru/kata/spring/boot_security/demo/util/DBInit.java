package ru.kata.spring.boot_security.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DBInit {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public DBInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void addDefaultUsers() {
        Role roleUser = new Role("USER");
        Role roleAdmin = new Role("ADMIN");
        Set<Role> userSet = new HashSet<>();
        Set<Role> adminSet = new HashSet<>();

        roleService.addRole(roleUser);
        roleService.addRole(roleAdmin);

        userSet.add(roleUser);
        adminSet.add(roleUser);
        adminSet.add(roleAdmin);

        User newUser = new User("James", "Bond", (byte)30, "agent", "JB007", userSet);
        User admin = new User("Max", "Payne", (byte)45, "admin", "admin", adminSet);
        userService.saveUser(newUser);
        userService.saveUser(admin);
    }
}
