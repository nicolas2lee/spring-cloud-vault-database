package tao.vault.demo.postgre.webapp.model;

import tao.vault.demo.postgre.webapp.entity.UserEntity;

public final class User {
    private final String id;
    private final String firstName;
    private final String lastName;

    public User(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static User fromEntity(UserEntity entity){
        return new User(entity.getPersonId(), entity.getFirstName(), entity.getLastName());
    }

    public String getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public UserEntity toEntity() {
        final UserEntity entity = new UserEntity();
        entity.setPersonId(id);
        entity.setFirstName(firstName);
        entity.setLastName(lastName);
        return entity;
    }
}
