package com.dhk.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter @Setter
@Entity
public class Member {
    @Id
    private Long id;

    @Column(name = "name")
    private String username;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;
}

