package tao.springcloudvaultpostgresql.service;

import org.springframework.stereotype.Service;
import tao.springcloudvaultpostgresql.model.User;
import tao.springcloudvaultpostgresql.repository.UserRepository;

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
