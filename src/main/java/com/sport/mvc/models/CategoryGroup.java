package com.sport.mvc.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category_group")
public class CategoryGroup extends Model {

    private static final long serialVersionUID = 1960998098645977429L;


    @OneToMany(mappedBy = "categoryGroup" , cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Group> groups = new HashSet<>();

    @Column(name = "name")
    private String name;

    @Column(name = "nameTraine")
    private String nameTraine;

    @Column(name="isMain")
    private boolean isMain;

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean main) {
        isMain = main;
    }

    public CategoryGroup() {
        super();
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameTraine() {
        return nameTraine;
    }

    public void setNameTraine(String nameTraine) {
        this.nameTraine = nameTraine;
    }
}
