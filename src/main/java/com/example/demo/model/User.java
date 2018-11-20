package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

/**
 * Created by YF-20170911 on 2018/11/16.
 */
@Entity
@Table
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("name")
    @Size(min=2,max=10,message="姓名的长度不能为")
    @NotNull(message = "姓名不能为空")
    private String name;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birth;

    @JsonProperty("roles")
    @JoinColumn(name = "role_id")
    @ManyToOne(cascade=CascadeType.PERSIST,optional = false)
    private Role role;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Orders> orders;
}
