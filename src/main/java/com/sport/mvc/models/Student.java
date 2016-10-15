package com.sport.mvc.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "student")
public class Student extends Model {

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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_group", joinColumns = @JoinColumn(name = "student_id", nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "group_id", nullable = false, updatable = false))
    private Set<Group> groups = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_sport", joinColumns = @JoinColumn(name = "student_id", nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "sport_id", nullable = false, updatable = false))
    private Set<Sport> sports2 = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "card_id")
    private CustomerCard customerCard;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    public Student() {
        super();
    }

    public Student(Long id) {
        super(id);
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

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public CustomerCard getCustomerCard() {
        return customerCard;
    }

    public void setCustomerCard(CustomerCard customerCard) {
        this.customerCard = customerCard;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }


    public Set<Sport> getSports2() {
        return sports2;
    }

    public void setSports2(Set<Sport> sports2) {
        this.sports2 = sports2;
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

}
