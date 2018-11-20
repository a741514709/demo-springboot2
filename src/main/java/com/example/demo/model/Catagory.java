package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by YF-20170911 on 2018/11/19.
 */
@Entity
@Table
@Data
public class Catagory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;


    @JsonIgnore
    @OneToMany(mappedBy = "catagory")
    private Set<Product> products;
}
