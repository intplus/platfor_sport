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

    @Column(name = "comment")
    private String comment;

    @ManyToMany(mappedBy = "groups")
    private Set<Coach> treiners = new HashSet<>();

    @ManyToMany(mappedBy = "groups")
    private Set<User> users = new HashSet<>();

    public Group() {
        super();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Set<Coach> getTreiners() {
        return treiners;
    }

    public void setTreiners(Set<Coach> treiners) {
        this.treiners = treiners;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
