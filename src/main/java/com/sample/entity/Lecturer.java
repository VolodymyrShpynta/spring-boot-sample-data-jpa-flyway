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
@Table(name = "lecturer")
public class Lecturer {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    /*
        Fake one-to-one unidirectional mapping to achieve lazy loading of LOBs
        (There is a bug in lazy loading of LOBs)
    */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @Fetch(FetchMode.SELECT)
    @PrimaryKeyJoinColumn
    private LecturerLobHolder lobHolder;
}
