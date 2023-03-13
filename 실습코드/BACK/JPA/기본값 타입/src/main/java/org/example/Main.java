package org.example;

import org.hibernate.cache.spi.support.AbstractRegion;

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
        Address address = new Address("city", "street", "10000");
        Member member1 = new Member();
        member1.setName("member1");
        member1.setHomeAddress(address);

        member1.getFavoriteFoods().add("치킨");
        member1.getFavoriteFoods().add("피자");
        member1.getFavoriteFoods().add("족발");

        member1.getAddressHistory().add(new AddressEntity("old1", "streat", "1000"));
        member1.getAddressHistory().add(new AddressEntity("old2", "streat", "1000"));
        em.persist(member1);

        em.flush();
        em.clear();
        System.out.println("===========START=============");
        Member findMember = em.find(Member.class, member1.getId());

//        //수정 이렇게 할 수 없음. 불변 객체이기 때문이다.
//        //이렇게 해버리면 값타입은 사이드 이펙트가 생길 수 있음.
//        findMember.getHomeAddress().setCity("newCity");
//        //수정하려면 완전히 새로 넣어야 한다.
//        Address a = findMember.getHomeAddress();
//        findMember.setHomeAddress(new Address("newCity", a.getStreet(), a.getZipcode() ));
//
//        //치킨 => 한식
//        findMember.getFavoriteFoods().remove("치킨");
//        findMember.getFavoriteFoods().add("한식");
//
//        //equals가 있기 때문에 이렇게 구현해줘도 된다.
//        //remove는 equals로 동일한 애를 찾아서 작동하기 때문
//        findMember.getAddressHistory().remove(new AddressEntity("old1", "streat", "1000"));
//        findMember.getAddressHistory().add(new AddressEntity("newCity1", "streat", "1000"));

        tx.commit();
    } catch (Exception e) {
        tx.rollback();
    } finally {
        em.close(); //커넥션을 다 물고 있기 때문에 꼭 닫아줘야 한다.
    }
        emf.close();
    }
}