package com.epam.shop.dao.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * in this model was implemented pattern Builder
 *The Builder pattern separates the algorithm for the step-by-step construction of
 * a complex product (object) from its external representation so that different
 * representations of this product can be obtained using the same algorithm.
 * Building a product step by step means building it piece by piece.
 */
public class Account extends AbstractModel<Integer> {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String telephoneNumber;
    private String email;
    private String city;
    private String street;
    private Integer flat;
    private BigDecimal amount;
    private Integer userId;

    public Account() {
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

    public void setFlat(int flat) {
        this.flat = flat;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(firstName, account.firstName) && Objects.equals(lastName, account.lastName) && Objects.equals(dateOfBirth, account.dateOfBirth) && Objects.equals(telephoneNumber, account.telephoneNumber) && Objects.equals(email, account.email) && Objects.equals(city, account.city) && Objects.equals(street, account.street) && Objects.equals(flat, account.flat) && Objects.equals(amount, account.amount) && Objects.equals(userId, account.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dateOfBirth, telephoneNumber, email, city, street, flat, amount, userId);
    }

    @Override
    public String toString() {
        return "Account{" +
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
        private BigDecimal amount;
        private Integer userId;

        public Builder() {

        }

        public Builder withId(int id) {
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

        public Builder withFlat(int flat) {
            this.flat = flat;
            return this;
        }

        public Builder withAmount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Builder withUserId(int userId) {
            this.userId = userId;
            return this;
        }

        public Account build() {
            Account account = new Account();
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
