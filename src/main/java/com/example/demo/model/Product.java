package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by YF-20170911 on 2018/11/19.
 */
@Entity
@Table
@Data
public class Product {

    @Id
    @GeneratedValue
    private Integer id;


    @Column(name="createTime")
    private Date productCreateTime;

    @Column(name="modifyTime")
    private Date productModifyTime;

    @JsonIgnore
    @ManyToMany(mappedBy ="products")
    private Set<Orders> orders;

    @ManyToOne(cascade = CascadeType.PERSIST,optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "catagory_id")
    private Catagory catagory;



}
