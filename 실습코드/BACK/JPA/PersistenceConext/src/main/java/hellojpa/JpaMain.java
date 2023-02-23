package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
            //비영속
            Member member = new Member();
            member.setId(100L);
            member.setName("helloJPA");

            //영속
            System.out.println("=== BEFORE ===");
            em.persist(member);
            System.out.println("=== AFTER ===");

            Member findMember = em.find(Member.class, 100L);

            System.out.println("findMember = " + findMember.getId());
            System.out.println("findMember = " + findMember.getName());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); //커넥션을 다 물고 있기 때문에 꼭 닫아줘야 한다.
        }
        emf.close();
    }
}
