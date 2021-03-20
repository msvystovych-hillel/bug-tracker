package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.OrderBy;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user")
public class Role {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "role_to_ap",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "action_point_id"))
    @BatchSize(size = 10)
    @OrderBy(clause = "ID DESC")
//    @Fetch(FetchMode.SUBSELECT)
//    @Fetch(FetchMode.JOIN)
//    @Fetch(FetchMode.SELECT)
    private List<ActionPoint> actionPoints;

//    @OrderColumn
//    @Transient
//    @Sort
//    @OrderBy
//    @Where

//    Inheritance

//    Caching:
//    Level 1 Session
//    Level 2 SessionFactory
//    Level 3 EhCache
}
