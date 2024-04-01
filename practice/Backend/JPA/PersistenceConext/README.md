# 영속성 컨텍스트
___

### JPA에서 가장 중요한 2가지
1. 객체와 관계형 데이터베이스 매핑하기
2. 영속성 컨텍스트(1차 캐시가 영속성 컨텍스트라고 보면 된다.)

### 엔티티를 영구 저장하는 환경이라는 뜻. EntityManager.persist(entity);

- 엔티티 매니저를 만들면 영속성 컨텍스트가 1:1로 생성된다.
- 엔티티의 생명주기
  1. 비영속(new/transient) : 영속성 컨텍스트와 전혀 관계가 없는 새로운 상태
  2. 영속(managed) : 영속성 컨텍스트에 관리되는 상태
  3. 준영속(detached) : 영속성 컨테스트에 저장되었다가 분리된 상태
  4. 삭제(removed) : 삭제된 상태

  - 객체만 생성한 상태(비영속)
  - 객체를 저장한 상태(영속) em.persist();
    - 사실 이때 DB에 저장되는 것이 아님. 커밋을 해야 저장이 된다.
    - 커밋을 하기 전에  detach를 하게 되면 회원 엔티티를 영속성 컨텍스트에서 분리, 준영속 상태가 된다.
    - em.remove(); 이건 진짜 영속성 객체를 삭제한다.
    ```agsl
     //비영속
     Member member = new Member();
     member.setId(100L);
     member.setName("helloJPA");

     //영속
     System.out.println("=== BEFORE ===");
     em.persist(member);
     System.out.println("=== AFTER ===");
    ```

### 영속성 컨텍스트의 이점
1. 1차 캐시에서 조회(캐시에 없으면 DB에서 조회하고 캐시에 저장한다.)
   - 엔티티매니저는 트랜젝션 단위로 만들어지기 때문에 고객의 요청마다 캐시가 생기고 사라진다. 그렇기 때문에 솔직히 많은 이점을 얻는다고는 할 수 없다. 짧은 찰나의 순간에만 이익이 있다고 할 수 있다.
   ```agsl
    System.out.println("=== BEFORE ===");
    em.persist(member);
    System.out.println("=== AFTER ===");
            
    // 여기서 select문이 실행되지 않는다. 왜냐하면 캐시 값을 가져왔기 때문이다.
    // 똑같은 것을 조회할 것은 1차 캐시에서 값을 가져온다.
    Member findMember = em.find(Member.class, 100L);
    Member findMember = em.find(Member.class, 100L);
   
    System.out.println("findMember = " + findMember.getId());
    System.out.println("findMember = " + findMember.getName());
   ```
2. 영속 엔티티의 동일성 보장
```agsl
  Member a = em.find(Member.class, 101L);
  Member b = em.find(Member.class, 101L);
  
  a == b (true)
```
1차 캐시가 있기 때문에 가능하다.
3. 엔티티 등록할 때 트랜잭션을 지원하는 쓰기 지연
```agsl
  em.persist(memberA);
  em.persist(memberB);
  //여기까지 insert sql을 데이터베이스에 보내지 않는다.
  //쓰기 지연 sql 저장소에 차곡차곡 쌓아둔다.

  //이게 제일 먼저 나오고 나중에 쿼리가 나온다
  System.out.println("============");
 
  //커밋하는 순간 flush - 데이터베이스에 쌓아있던 sql을 보낸다.
  //persistence.xml에서 <property name="hibernate.jdbc.batch_size" value="10"/> buffer 사이즈를 지정해줄 수 있다.
  transaction.commit();
  //
```

4. 엔티티 수정(변경 감지)
- jpa 목적이 db를 마치 자바 컬렉션처럼 다루기 위함이다.
- 자바 컬렉션에서도 수정뒤에 다시 넣어주지 않는다.
- commit을 처음하면 flush가 일어나게 되고 flush가 일어나면 엔티티와 스냅샷을 비교한다.
- 1차 캐시 안에는 id, entity, 스냅샷이 있다. 스냅샷은 내가 값을 읽어온 최초 시점의 상태를 스냅샷으로 떠온다.
- 비교해서 다르면 쓰기 지연 sql 저장소에 update 쿼리를 저장한다.

5. 플러시   
- 영속성 컨텍스트의 변경내용을 데이터베이스에 반영
  1. 변경감지
  2. 수정된 엔티티 쓰기 지연 sql 저장소에 등록
  3. 쓰기 지연 sql 저장소의 쿼리를 데이터베이스에 전송(등록, 수정, 삭제 쿼리)
  
  - em.flush() - 직접호출 (커밋하기 전에 쿼리를 미리 보고싶으면 쓴다.)
  - 트랜잭션 커밋 - 플러시 자동 호출
  - jpql 쿼리 실행 - 플러시 자동 호출
```agsl
//이렇게 하면 insert 쿼리가 ==== 앞에 나오게 된다.
Member member = new Member(200L, "member200");
em.persist(member);

em.flush();

System.out.println("============");
tx.commit();
```

- flush를 해도 캐시는 그대로 유지된다. 쓰기지연 sql에 있는 저장소 쿼리들이 DB에 반영이 되는 것이다.
- 플러시 모드 옵션(가급적 auot를 써라)
  - em.setFlushMode(FlushModeType.COMMIT)
    - FlushModeType.AUTO 커밋이나 쿼리를 실행할 때 플러시 (기본값)
    - FlushModeType.COMMIT 커밋할 때만 플러시

6. 준영속 상태
- 영속 상태의 엔티티가 영속성 컨텍스트에서 분리(detached)
- 영속성 컨텍스트가 제공하는 기능을 사용 못함
- 준영속 상태로 만드는 방법
  - em.detach(entity) : 특정 엔티티만 준영속 상태로 전환
  - em.clear() : 영속성 컨텍스트를 완전히 초기화. em 안에 있는 영속성 컨텍스트를 통채로 지워버린다.
  - em.close() : 영속성 컨텍스트를 종료 (닫아버리면 당연히 삭제되겠지요)
  ```agsl
  Member member = em.find(Member.class, 150L);
  member.setName("AAAAAA");
  
  em.detach(member);
  
  System.out.println("============");
  tx.commit();
  //select 쿼리만 실행되고 update 쿼리는 실행되지 않는다.
  ```

```agsl
 Member member = em.find(Member.class, 150L);
 member.setName("AAAAAA");

 em.clear();

 Member member2 = em.find(Member.class, 150L);

 System.out.println("============");
 tx.commit();
 //영속성 컨텍스트를 비웠기 때문에 select문이 두번 실행된다.
```

 