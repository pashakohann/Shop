package com.epam.shop.service.dto.model;

import java.time.LocalDate;
import java.util.Objects;

public class AccountDto extends AbstractModelDto<Integer> {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String telephoneNumber;
    private String email;
    private String city;
    private String street;
    private Integer flat;
    private Double amount;
    private Integer userId;

    public AccountDto() {
    }

    public AccountDto(Integer id) {
        super(id);
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getFlat() {
        return flat;
    }

    public void setFlat(Integer flat) {
        this.flat = flat;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountDto that = (AccountDto) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(dateOfBirth, that.dateOfBirth) && Objects.equals(telephoneNumber, that.telephoneNumber) && Objects.equals(email, that.email) && Objects.equals(city, that.city) && Objects.equals(street, that.street) && Objects.equals(flat, that.flat) && Objects.equals(amount, that.amount) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dateOfBirth, telephoneNumber, email, city, street, flat, amount, userId);
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", flat=" + flat +
                ", amount=" + amount +
                ", userId=" + userId +
                '}';
    }

    public static class Builder {
        private Integer id;
        private String firstName;
        private String lastName;
        private LocalDate dateOfBirth;
        private String telephoneNumber;
        private String email;
        private String city;
        private String street;
        private Integer flat;
        private Double amount;
        private Integer userId;

        public Builder() {

        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder withTelephoneNumber(String telephoneNumber) {
            this.telephoneNumber = telephoneNumber;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Builder withStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder withFlat(Integer flat) {
            this.flat = flat;
            return this;
        }

        public Builder withAmount(Double amount) {
            this.amount = amount;
            return this;
        }

        public Builder withUserId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public AccountDto build() {
            AccountDto account = new AccountDto();
            account.setId(this.id);
            account.setFirstName(this.firstName);
            account.setLastName(this.lastName);
            account.setDateOfBirth(this.dateOfBirth);
            account.setTelephoneNumber(this.telephoneNumber);
            account.setEmail(this.email);
            account.setCity(this.city);
            account.setStreet(this.street);
            account.setFlat(this.flat);
            account.setAmount(this.amount);
            account.setUserId(this.userId);
            return account;
        }


    }
}
