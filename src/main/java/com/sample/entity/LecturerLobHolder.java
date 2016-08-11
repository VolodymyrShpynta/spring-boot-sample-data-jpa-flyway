package com.sample.entity;

import lombok.*;

import javax.persistence.*;

/*
    Fake one-to-one unidirectional mapping to achieve lazy loading of LOBs
    (There is a bug in lazy loading of LOBs)
*/

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lecturer")
public class LecturerLobHolder {

    @Id
    @Column(name = "id")
    @Basic(optional = false)
    private long id;

    @Lob
    @Column(name = "meta_data")
    private String metaData;
}
