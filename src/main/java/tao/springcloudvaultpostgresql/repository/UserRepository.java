package tao.springcloudvaultpostgresql.repository;

import org.springframework.data.repository.CrudRepository;
import tao.springcloudvaultpostgresql.entity.UserEntity;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, String> {
    List<UserEntity> findAll();
}
