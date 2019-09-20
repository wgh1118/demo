package com.wanggh.demo.jpa;

import lombok.Data;

import javax.persistence.*;

/**
 * @author wanggh
 */
@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;
}
