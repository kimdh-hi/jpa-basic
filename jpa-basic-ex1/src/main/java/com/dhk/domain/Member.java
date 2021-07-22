package com.dhk.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter @Setter
@Entity
public class Member {
    @Id @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String username;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    // 양방향 연관관계 편의 메서드
    // setter의 이름 관례를 따라가지 않는 의미있는 이름을 설정하는 것을 권장 (햇갈릴 수 있음)
    public void addMemberToTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}

