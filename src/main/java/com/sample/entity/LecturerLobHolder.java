package com.sample.entity;

import lombok.*;

import javax.persistence.*;

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
