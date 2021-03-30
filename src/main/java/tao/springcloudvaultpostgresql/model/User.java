package tao.springcloudvaultpostgresql.model;

import tao.springcloudvaultpostgresql.entity.UserEntity;

public final class User {
    private final String id;
    private final String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static User fromEntity(UserEntity entity){
        return new User(entity.getId(), entity.getName());
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public UserEntity toEntity() {
        final UserEntity entity = new UserEntity();
        entity.setId(id);
        entity.setName(name);
        return entity;
    }
}
