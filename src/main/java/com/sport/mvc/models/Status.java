package com.sport.mvc.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "status")
public class Status extends Model {

    private static final long serialVersionUID = -5380958355394845918L;

    @Column(name = "title", length = 25, insertable = false, updatable = false)
    private String title;

    @Column(name = "description", length = 255)
    private String description;

//    @OneToMany(mappedBy = "status")
//    private Set<User> users = new HashSet<>();

    public Status() {
        super();
    }

    public Status(Long id) {
        super(id);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
