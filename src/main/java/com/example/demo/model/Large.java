package com.example.demo.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by YF-20170911 on 2018/11/20.
 */
@Entity
@Data
@Table
@ToString(exclude={"store"})
public class Large {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String author;

    private String remark;

    private  String a;

    private String b;

    private String c;

    private String d;
}
