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
        Child child1 = new Child();
        Child child2 = new Child();

        Parent parent = new Parent();
        parent.addChild(child1);
        parent.addChild(child2);

        em.persist(parent);
        em.persist(child1);
        em.persist(child2);

        tx.commit();
    } catch (Exception e) {
        tx.rollback();
    } finally {
        em.close(); //커넥션을 다 물고 있기 때문에 꼭 닫아줘야 한다.
    }
        emf.close();
    }
}