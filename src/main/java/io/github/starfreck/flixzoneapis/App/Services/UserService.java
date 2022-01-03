package io.github.starfreck.flixzoneapis.App.Services;

import io.github.starfreck.flixzoneapis.App.Models.Auth.User;
import io.github.starfreck.flixzoneapis.App.Repositories.UserRepository;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    /**
     * Important Method from UserDetailsService
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user;
        Optional<User> userOptional;

        // Auth via Telegram ID
        if (NumberUtils.isDigits(username)) {
            userOptional = userRepository.findUserByTelegramId(username);
            userOptional.orElseThrow(() ->new UsernameNotFoundException("User not found with "+username));
            user = userOptional.get();
            // Remove Password
            user.setPassword("");
        }
        // Auth via Username & Password
        else
        {
            userOptional = userRepository.findUserByUsername(username);
            userOptional.orElseThrow(() ->new UsernameNotFoundException("User not found with "+username));
            user = userOptional.get();
        }
        org.springframework.security.core.userdetails.User springBootUser = new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),user.getAuthorities());
        return springBootUser;
    }

    public Set<User> getAllUsers(String type) {

        Set<User> users = new HashSet<>();
        if(type.equalsIgnoreCase("admin")){
            userRepository.findUsersByUserType(1).forEach(users::add);
        } else if(type.equalsIgnoreCase("user")){
            userRepository.findUsersByUserType(2).forEach(users::add);
        } else {
            userRepository.findAll().forEach(users::add);
        }
        return users;
    }

    public User getUser(long id) {
        return userRepository.findById(id).get();
    }

    public void addUser(User user) {
        // only Add if it doesn't exist (The Check Point)
        if(
            !userRepository.existsUserByEmail(user.getEmail()) &&
            !userRepository.existsUserByUsername(user.getUsername()) &&
            !userRepository.existsUserByTelegramId(user.getTelegramId())
        ){
            userRepository.save(user);
        }
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    // Telegram User Specific Services

    public User getTelegramUser(String telegramId) {
        return userRepository.findUserByTelegramId(telegramId).get();
    }

    public void updateTelegramUser(User user) {

        User oldUser = getTelegramUser(user.getTelegramId());

        // Update All Information
        oldUser.setTelegramId(user.getTelegramId());
        oldUser.setUsername(user.getUsername());
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setLanguageCode(user.getLanguageCode());

        userRepository.save(oldUser);
    }
}
