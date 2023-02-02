package ru.kata.spring.boot_security.demo.saveuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;

@Component
public class AddUsersAndRole {


    private final RoleService roleServer;
    private final UserService userService;

    @Autowired
    public AddUsersAndRole(RoleService roleServer, UserService userService) {
          this.roleServer = roleServer;
        this.userService = userService;
            }


    @PostConstruct
    public void addContent () {
        Role user = new Role(1,"ROLE_USER");
        Role admin = new Role(2,"ROLE_ADMIN");
        roleServer.save(user);
        roleServer.save(admin);

        User user1 = new User("Admin","123",35,"Admin@Admin.ru");
        User user2 = new User("Vasy","123",30,"Vasy@Vasy.ru");
        User user3 = new User("Sof","123",24,"Sof@Sof.ru");
        User user4 = new User("Den","123",30,"Den@Den.ru");

        user1.addRole(user);
        user1.addRole(admin);
        user2.addRole(user);
        user3.addRole(user);
        user4.addRole(user);

        userService.register(user1);
        userService.register(user2);
        userService.register(user3);
        userService.register(user4);

    }
}
