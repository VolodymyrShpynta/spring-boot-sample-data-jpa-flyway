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
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

//    @OneToOne(fetch=FetchType.LAZY, optional = false, mappedBy = "employee")
//    @Fetch(FetchMode.SELECT)
//    private LobHolder bitmapHolder;
}
