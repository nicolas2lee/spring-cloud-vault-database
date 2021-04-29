package tao.vault.demo.postgre.webapp.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class UserEntity {
    @Column
    @Id
    private String id;
    @Column
    private String name;

}
