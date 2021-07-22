package com.dhk.hellojpa;

import com.dhk.domain.Member;
import com.dhk.domain.RoleType;
import com.dhk.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Team team = new Team();
            team.setTeamName("teamA");
            em.persist(team);

           Member member = new Member();
           member.setUsername("kim");
           member.setTeam(team);

           em.persist(member);

           em.flush();
           em.clear();

            List<Member> members = team.getMembers();
            for (Member member1 : members) {
                System.out.println("member1.getUsername() = " + member1.getUsername());
            }

            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }
}
