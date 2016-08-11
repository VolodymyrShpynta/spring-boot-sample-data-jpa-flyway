package com.sample.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
@Table(name = "LECTURER")
public class Lecturer {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY, optional = false)
    @Fetch(FetchMode.SELECT)
    @PrimaryKeyJoinColumn
    private LecturerLobHolder lobHolder;
}
