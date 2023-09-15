package org.example;

import org.hibernate.cache.spi.support.AbstractRegion;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
//        List<Member> result = em.createQuery(
//                "select m From Member m where m.name like '%kim%'",
//                Member.class
//        ).getResultList();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> query = cb.createQuery(Member.class);

        Root<Member> m = query.from(Member.class);

        CriteriaQuery<Member> cq = query.select(m);
        String name = "daflk";
        if(name != null){
            cq = cq.where(cb.equal(m.get("name"), "kim"));
        }
        em.createQuery(cq).getResultList();

        tx.commit();
    } catch (Exception e) {
        tx.rollback();
    } finally {
        em.close(); //커넥션을 다 물고 있기 때문에 꼭 닫아줘야 한다.
    }
        emf.close();
    }
}