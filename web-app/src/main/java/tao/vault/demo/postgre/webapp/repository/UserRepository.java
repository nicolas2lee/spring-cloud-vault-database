package tao.vault.demo.postgre.webapp.repository;

import org.springframework.data.repository.CrudRepository;
import tao.vault.demo.postgre.webapp.entity.UserEntity;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, String> {
    List<UserEntity> findAll();
}
