package com.sport.mvc.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User extends Model {

    private static final long serialVersionUID = -8950386400041310256L;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "phone")
    private String phone;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "district")
    private String district;

//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "session_history_id")
//    private SessionHistory sessionHistory;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "role_id")
//    private Role role;
//
//    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Group> groups = new HashSet<>();
//
//
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "user_sport", joinColumns = @JoinColumn(name = "user_id", nullable = false, updatable = false),
//            inverseJoinColumns = @JoinColumn(name = "sport_id", nullable = false, updatable = false))
//    private Set<Sport> sports = new HashSet<>();
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "price_id")
//    private Price price;
//
//    public User() {
//        super();
//    }
//
//    public User(Long id) {
//        super(id);
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public Date getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(Date birthday) {
//        this.birthday = birthday;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surName) {
//        this.surname = surName;
//    }
//
//    public Set<Sport> getSports() {
//        return sports;
//    }
//
//    public void setSports(Set<Sport> sports) {
//        this.sports = sports;
//    }
//
//    public Set<Group> getGroups() {
//        return groups;
//    }
//
//    public void setGroups(Set<Group> groups) {
//        this.groups = groups;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    public String getDistrict() {
//        return district;
//    }
//
//    public void setDistrict(String district) {
//        this.district = district;
//    }
//
//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//
//    public SessionHistory getSessionHistory() {
//        return sessionHistory;
//    }
//
//    public void setSessionHistory(SessionHistory sessionHistory) {
//        this.sessionHistory = sessionHistory;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Price getPrice() {
//        return price;
//    }
//
//    public void setPrice(Price price) {
//        this.price = price;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        User user = (User) o;
//
//        if (name != null ? !name.equals(user.name) : user.name != null) return false;
//        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
//        if (email != null ? !email.equals(user.email) : user.email != null) return false;
//        if (birthday != null ? !birthday.equals(user.birthday) : user.birthday != null) return false;
//        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
//        if (username != null ? !username.equals(user.username) : user.username != null) return false;
//        if (password != null ? !password.equals(user.password) : user.password != null) return false;
//        if (city != null ? !city.equals(user.city) : user.city != null) return false;
//        if (country != null ? !country.equals(user.country) : user.country != null) return false;
//        if (district != null ? !district.equals(user.district) : user.district != null) return false;
//        if (sessionHistory != null ? !sessionHistory.equals(user.sessionHistory) : user.sessionHistory != null)
//            return false;
//        if (role != null ? !role.equals(user.role) : user.role != null) return false;
//        if (groups != null ? !groups.equals(user.groups) : user.groups != null) return false;
//        if (sports != null ? !sports.equals(user.sports) : user.sports != null) return false;
//        return price != null ? price.equals(user.price) : user.price == null;
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = name != null ? name.hashCode() : 0;
//        result = 31 * result + (surname != null ? surname.hashCode() : 0);
//        result = 31 * result + (email != null ? email.hashCode() : 0);
//        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
//        result = 31 * result + (phone != null ? phone.hashCode() : 0);
//        result = 31 * result + (username != null ? username.hashCode() : 0);
//        result = 31 * result + (password != null ? password.hashCode() : 0);
//        result = 31 * result + (city != null ? city.hashCode() : 0);
//        result = 31 * result + (country != null ? country.hashCode() : 0);
//        result = 31 * result + (district != null ? district.hashCode() : 0);
//        result = 31 * result + (sessionHistory != null ? sessionHistory.hashCode() : 0);
//        result = 31 * result + (role != null ? role.hashCode() : 0);
//        result = 31 * result + (groups != null ? groups.hashCode() : 0);
//        result = 31 * result + (sports != null ? sports.hashCode() : 0);
//        result = 31 * result + (price != null ? price.hashCode() : 0);
//        return result;
//    }

    @Column(name = "isactive")
    private String isactive;

    @Column(name = "isnonexpired")
    private String isnonexpired;

    @Column(name = "isnonlocked")
    private String isnonlocked;


    public User() {
        super();
    }

    public User(Long id) {
        super(id);
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "role_id")
    private Role role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surName) {
        this.surname = surName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsactive() {
        return isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }

    public String getIsnonexpired() {
        return isnonexpired;
    }

    public void setIsnonexpired(String isnonexpired) {
        this.isnonexpired = isnonexpired;
    }

    public String getIsnonlocked() {
        return isnonlocked;
    }

    public void setIsnonlocked(String isnonlocked) {
        this.isnonlocked = isnonlocked;
    }

    public User(Role role, String username, String password, String email) {
        this.role = role;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
