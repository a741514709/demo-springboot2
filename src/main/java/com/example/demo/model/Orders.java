package com.example.demo.model;

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
public class Orders {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="createTime")
    private Date orderCreateTime;

    @Column(name="modifyTime")
    private Date orderModifyTime;

    @ManyToMany(cascade =CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinTable(name="Order_Product",joinColumns=@JoinColumn(name="order_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="product_id",referencedColumnName = "id"))
    private Set<Product> products;

    @ManyToOne(cascade = CascadeType.PERSIST,optional = false)
    @JoinColumn(name = "user_id")
    private User user;

}
