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

            //등록
            Member member = new Member();
            member.setId(3L);
            member.setName("helloB");
            //조회
            Member findMember = em.find(Member.class, 1L);
            System.out.println(findMember.getId());
            System.out.println(findMember.getName());
            //삭제
            em.remove(findMember);
            //수정
            //자바 객체의 값만 바꿨는데 어떻게 반영이 된거지?
            //커밋을 하기 전에 객체의 값이 바뀌면 Update 쿼리를 날린다.
            findMember.setName("helloJPA");
            em.persist(member);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); //커넥션을 다 물고 있기 때문에 꼭 닫아줘야 한다.
        }
        emf.close();
    }
}
