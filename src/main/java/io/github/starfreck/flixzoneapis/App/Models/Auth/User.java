package io.github.starfreck.flixzoneapis.App.Models.Auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;


@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(255) default ''")
    private String email;
    @Column(columnDefinition = "varchar(255) default ''")
    private String password;
    @Column(columnDefinition = "varchar(255) default ''")
    private String username;
    @Column(columnDefinition = "varchar(255) default ''")
    private String firstName;
    @Column(columnDefinition = "varchar(255) default ''")
    private String lastName;
    @Column(columnDefinition = "integer default 2")
    private int userType;
    @Column(columnDefinition = "varchar(255) default ''")
    private String telegramId;
    @Column(columnDefinition = "tinyint(1) default 0")
    private Boolean active;
    @Column(columnDefinition = "varchar(255) default 'USER'")
    private String roles;
    @Column(columnDefinition = "varchar(255) default 'en'")
    private String languageCode;


    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getTelegramId() {
        return telegramId;
    }

    public void setTelegramId(String telegramId) {
        this.telegramId = telegramId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String[] userRoles =roles.split(",");
        ArrayList<SimpleGrantedAuthority> grantedAuthority = new ArrayList<>();
        for (String role: userRoles) {
            grantedAuthority.add(new SimpleGrantedAuthority(role));
        }
        return grantedAuthority;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userType=" + userType +
                ", telegramId='" + telegramId + '\'' +
                ", active=" + active +
                ", roles='" + roles + '\'' +
                ", languageCode='" + languageCode + '\'' +
                '}';
    }
}
