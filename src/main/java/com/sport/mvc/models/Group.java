package com.sport.mvc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "group")
public class Group extends Model {

    private static final long serialVersionUID = 5110150966894003873L;

    @Column(name = "name")
    private String name;

    @Column(name = "discription")
    private String discription;

//    @ManyToMany(mappedBy = "groups")
//    private Set<Coach> treiners = new HashSet<>();

//    @ManyToMany(mappedBy = "groups2")
//    private Set<User> users = new HashSet<>();

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

//    public Set<Coach> getTreiners() {
//        return treiners;
//    }
//
//    public void setTreiners(Set<Coach> treiners) {
//        this.treiners = treiners;
//    }

//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }
}
