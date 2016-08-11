package com.sample.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "LECTURER")
public class LecturerLobHolder {

    @Id
    @Column(name = "ID")
    @Basic(optional = false)
    private long id;

    @Lob
    @Column(name = "META_DATA")
    private String metaData;
}
