package jpql;

import javax.persistence.*;
import java.util.List;

public class jpaMain {
    public static void main(String[] args) {


    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
    //tx 시작
    tx.begin();

    try {

        Member member = new Member();
        member.setUsername("member1");
        em.persist(member);

        Member member1 = new Member();
        member1.setUsername("11111");
        em.persist(member1);

        TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);
        System.out.println(query.getResultList().size());

        TypedQuery<Member> query1 = em.createQuery("select m from Member m where m.username = :username", Member.class);
        query1.setParameter("username", "member1");
        Member singleResult = query1.getSingleResult();
        System.out.println(singleResult.getUsername());

        Member result = em.createQuery("select m from Member m where m.username = :username", Member.class)
                .setParameter("username", "member1")
                .getSingleResult();
        System.out.println(result.getUsername());

        List resultList = em.createQuery("select m.username, m.age from Member m").getResultList();

        Object o = resultList.get(0);
        Object[] result1 = (Object[]) o;
        System.out.println(result1[0]);
        System.out.println(result1[1]);

        List<Object[]> resultList1 = em.createQuery("select m.username, m.age from Member m")
                .getResultList();

        System.out.println(result1[0]);
        System.out.println(result1[1]);

        List<MemberDTO>  resultDTO = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class)
                .getResultList();

        MemberDTO memberDTO = resultDTO.get(0);
        System.out.println(memberDTO.getUsername());
        System.out.println(memberDTO.getAge());

        //페이징
        for(int i = 0; i < 100; i++){
            Member member2 = new Member();
            member2.setUsername("member"+i);
            member2.setAge(i);

            Team team = new Team();
            team.setName("team"+i);
            em.persist(team);

            member2.setTeam(team);
            em.persist(member2);
        }
        em.flush();
        em.clear();

        List<Member> result2 = em.createQuery("select m from Member m order by m.age desc", Member.class)
                        .setFirstResult(1)
                        .setMaxResults(10)
                        .getResultList();

        System.out.println("result size = " + result2.size());
        for(Member member3 : result2){
            System.out.println("member3 = " + member3);
        }

        String query2 = "select m from Member m inner join m.team t";
        List<Member> result3 = em.createQuery(query2, Member.class).getResultList();



        tx.commit();
    } catch (Exception e) {
        tx.rollback();
        e.printStackTrace();
    } finally {
        em.close(); //커넥션을 다 물고 있기 때문에 꼭 닫아줘야 한다.
    }
        emf.close();
    }
}
