package com.sport.mvc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "group2")
public class Group extends Model {

    private static final long serialVersionUID = 5110150966894003873L;

    @Column(name = "name")
    private String name;

    @Column(name = "discription")
    private String discription;

//    @ManyToMany(mappedBy = "groups")
//    private Set<User> treiners = new HashSet<>();

//    @ManyToMany(mappedBy = "groups2")
//    private Set<Student> users = new HashSet<>();

    public Group() {
        super();
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Set<User> getTreiners() {
//        return treiners;
//    }
//
//    public void setTreiners(Set<User> treiners) {
//        this.treiners = treiners;
//    }

//    public Set<Student> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<Student> users) {
//        this.users = users;
//    }
}
