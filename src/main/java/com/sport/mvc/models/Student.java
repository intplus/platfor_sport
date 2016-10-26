package com.sport.mvc.models;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student extends Model {

    private static final long serialVersionUID = -8950386400041310256L;

    @Column(name = "name")
    @Size(min=3, max=30)
    private String name;

    @Size(min=3, max=30)
    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "birthday")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Past
    private Date birthday;

    @Column(name = "string_birthday")
    private String strBirthday;

    @Column(name = "age")
    private String age;

    @Column(name = "phone")
    @Pattern(regexp = "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$",
    message = "{pattern.invalid.phone}")
    private String phone;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Phone> phones = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_group", joinColumns = @JoinColumn(name = "student_id", nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "group_id", nullable = false, updatable = false))
    private Set<Group> groups = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_sport", joinColumns = @JoinColumn(name = "student_id", nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "sport_id", nullable = false, updatable = false))
    private Set<Sport> sports = new HashSet<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CustomerCard> cards = new HashSet<>();

    @OneToMany(mappedBy = "student" , cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "status_id")
    private Status status;

    public Student() {
        super();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getStrBirthday() {
        return strBirthday;
    }

    public void setStrBirthday(String strBirthday) {
        this.strBirthday = strBirthday;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<CustomerCard> getCards() {
        return cards;
    }

    public void setCards(Set<CustomerCard> cards) {
        this.cards = cards;
    }


    public Set<Sport> getSports() {
        return sports;
    }

    public void setSports(Set<Sport> sports) {
        this.sports = sports;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surName) {
        this.surname = surName;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }


    public String getPhone() {
        return phone;
    }
}
