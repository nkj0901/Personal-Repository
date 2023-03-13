package org.example;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    //메니저를 불러와서 코드를 짜면 된다.
    //데이터베이스 커넥션을 하나 받아온거라고 생각하면 된다.
    EntityManager em = emf.createEntityManager();

    //매니저한테 tx 받아오기
    EntityTransaction tx = em.getTransaction();
    //tx 시작
    tx.begin();

    try {
        Team team1 = new Team();
        team1.setName("aaa");
        em.persist(team1);

        Team team2 = new Team();
        team2.setName("aaa");
        em.persist(team2);

        Member member1 = new Member();
        member1.setName("asdf");
        member1.setTeam(team1);
        em.persist(member1);

        Member member2 = new Member();
        member2.setName("asdf");
        member2.setTeam(team2);
        em.persist(member2);

        em.flush();
        em.clear();

        List<Member> members = em.createQuery("select m from Member m", Member.class)
                .getResultList();

        System.out.println(members.size());

        tx.commit();
    } catch (Exception e) {
        tx.rollback();
    } finally {
        em.close(); //커넥션을 다 물고 있기 때문에 꼭 닫아줘야 한다.
    }
        emf.close();
    }
}