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
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "phone")
    private String phone;
}
