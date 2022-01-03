package io.github.starfreck.flixzoneapis.App.Repositories;

import io.github.starfreck.flixzoneapis.App.Models.Auth.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface UserRepository extends CrudRepository<User,Long> {

    public Optional<User> findUserByUsername(String username);
    public Optional<User> findUserByTelegramId(String telegramId);
    public Optional<User> findUserByEmail(String email);
    public Set<User> findUsersByUserType(int type);

    public boolean existsUserByEmail(String email);
    public boolean existsUserByTelegramId(String telegramId);
    public boolean existsUserByUsername(String username);

}
