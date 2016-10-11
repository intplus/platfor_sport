package com.sport.mvc.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "coach")
public class Coach extends Model {

    private static final long serialVersionUID = -9012426419230168501L;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "country")
    private String country;

    @Column(name = "district")
    private String district;

    @Column(name = "city")
    private String city;

    @Column(name = "type_of_sport")
    private String typeOfSport;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "coach_sport", joinColumns = @JoinColumn(name = "coach_id", nullable = false, updatable = false),
    inverseJoinColumns = @JoinColumn(name = "sport_id", nullable = false, updatable = false))
    private Set<TypeOfSport> sports = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "coach_group", joinColumns = @JoinColumn(name = "coach_id", nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "group_id", nullable = false, updatable = false))
    private Set<Group> groups = new HashSet<>();


    public Coach() {
        super();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTypeOfSport() {
        return typeOfSport;
    }

    public void setTypeOfSport(String typeOfSport) {
        this.typeOfSport = typeOfSport;
    }

    public Set<TypeOfSport> getSports() {
        return sports;
    }

    public void setSports(Set<TypeOfSport> sports) {
        this.sports = sports;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
