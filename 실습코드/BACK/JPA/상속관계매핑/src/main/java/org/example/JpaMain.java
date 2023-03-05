package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class JpaMain {
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
            member.setCreateBy("kim");
            member.setName("user1");
            member.setCreatedDate(LocalDateTime.now());

            em.persist(member);

            em.flush();
            em.close();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); //커넥션을 다 물고 있기 때문에 꼭 닫아줘야 한다.
        }
        emf.close();
    }
}
