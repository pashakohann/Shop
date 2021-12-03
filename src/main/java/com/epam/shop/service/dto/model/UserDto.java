package com.epam.shop.service.dto.model;

import com.epam.shop.dao.model.UserRole;

import java.time.LocalDateTime;
import java.util.Objects;


public class UserDto extends AbstractModelDto<Integer> {
    private UserRole role;
    private String account;
    private String password;
    private LocalDateTime registrationDate;

    public UserDto() {
    }

    public UserDto(Integer id) {
        super(id);
    }

    public UserDto(UserRole role, String account, String password, LocalDateTime registrationDate) {
        this.role = role;
        this.account = account;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
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
        UserDto userDto = (UserDto) o;
        return role == userDto.role && Objects.equals(account, userDto.account) && Objects.equals(password, userDto.password) && Objects.equals(registrationDate, userDto.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, account, password, registrationDate);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", role=" + role +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
