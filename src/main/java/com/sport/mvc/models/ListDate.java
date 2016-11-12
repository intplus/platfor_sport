package com.sport.mvc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "list_date")
public class ListDate extends Model{

    private static final long serialVersionUID = 2333403738240612177L;

    @Column
    private Set<Integer> dateList =  new HashSet<>();


    public ListDate() {
        super();
    }

}
