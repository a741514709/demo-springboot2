package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

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



    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE},optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "catagory_id")
    private Catagory catagory;



}
