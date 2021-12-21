package com.epam.shop.dao.model;


import com.epam.shop.service.dto.model.UserRoleDto;

import java.time.LocalDateTime;
import java.util.Objects;

public class User extends AbstractModel<Integer> {
    private UserRoleDto role;
    private String account;
    private String password;
    private LocalDateTime registrationDate;

    public User() {
    }

    public User(int id) {
        super(id);
    }

    public User(UserRoleDto role, String account, String password, LocalDateTime registrationDate) {
        this.role = role;
        this.account = account;
        this.password = password;
        this.registrationDate = registrationDate;
    }



    public UserRoleDto getRole() {
        return role;
    }

    public void setRole(UserRoleDto role) {
        this.role = role;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return role == user.role && Objects.equals(account, user.account) && Objects.equals(password, user.password) && Objects.equals(registrationDate, user.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, account, password, registrationDate);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role=" + role +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
