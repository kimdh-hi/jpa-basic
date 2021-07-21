package com.dhk.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<Member> list = new ArrayList<>();
        list.add(new Member(1L, "kim"));
        list.add(new Member(2L, "lee"));

        Member member = list.get(0);
        member.setName("수정된 이름");

        System.out.println(list.get(0).getName());
    }

    @AllArgsConstructor
    @Getter @Setter
    static class Member{
        private Long id;
        private String name;
    }
}
