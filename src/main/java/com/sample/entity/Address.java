package com.sample.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Volodymyr Shpynta on 11/20/2015.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "ADDRESS")
public class Address {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "STREET")
    private String street;

    @Column(name = "PHONE")
    private String phone;
}
