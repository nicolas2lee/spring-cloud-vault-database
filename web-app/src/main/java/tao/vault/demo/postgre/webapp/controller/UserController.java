package tao.vault.demo.postgre.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tao.vault.demo.postgre.webapp.model.User;
import tao.vault.demo.postgre.webapp.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Value("${test.password}")
    private String testPassword;

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test-password")
    public String showTestPassword(){
        log.info("show test password: {}", testPassword);
        return testPassword;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public User addUser(User user){
        return userService.addUser(user);
    }
}
