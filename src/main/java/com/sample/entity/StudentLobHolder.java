package com.sample.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/*
    Fake one-to-one bidirectional mapping to achieve lazy loading of LOBs
    (There is a bug in lazy loading of LOBs)
*/

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class StudentLobHolder {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name = "gen", strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(name = "property", value = "student"))
    @Basic(optional = false)
    private long id;

    @Lob
    @Column(name = "meta_data")
    private String metaData;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    public Student student;
}
