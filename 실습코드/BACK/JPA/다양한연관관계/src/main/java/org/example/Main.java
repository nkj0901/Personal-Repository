package org.example;

import javax.persistence.*;

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

        Member member = new Member();
        member.setUsername("member1");

        em.persist(member);

        Team team = new Team();
        team.setName("TeamA");
        team.getMembers().add(member);

        em.persist(team);

//        //멤버가 속한 팀을 찾기
//        Member findMember = em.find(Member.class, member.getId());
//        Team findTeam = findMember.getTeam();
//        System.out.println("findTeam = " + findTeam.getName());
//
//        //팀바꾸기 (팀 db에서 가져와서 업데이트하기)
//        Team newTeam = em.find(Team.class, 100L);
//        findMember.setTeam(newTeam);

        tx.commit();
    } catch (Exception e) {
        tx.rollback();
    } finally {
        em.close(); //커넥션을 다 물고 있기 때문에 꼭 닫아줘야 한다.
    }
        emf.close();
    }
}