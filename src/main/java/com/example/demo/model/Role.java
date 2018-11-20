package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by YF-20170911 on 2018/11/16.
 */
@Entity
@Table
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @JsonProperty("name")
    private String name;

    @OneToMany(mappedBy = "role")
    private Set<User> users;

    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinTable(name = "ROLE_RESOURCE",joinColumns=@JoinColumn(name = "role_id"),inverseJoinColumns = @JoinColumn(name="resource_id"))
    private Set<Resource> resources;




}
