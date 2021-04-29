package tao.vault.demo.postgre.webapp.service;

import org.springframework.stereotype.Service;
import tao.vault.demo.postgre.webapp.model.User;
import tao.vault.demo.postgre.webapp.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll().stream()
                .map(User::fromEntity)
                .collect(Collectors.toList());
    }

    public User addUser(User u){
        return User.fromEntity(userRepository.save(u.toEntity()));
    }
}
