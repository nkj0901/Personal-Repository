# JPA 시작하기
___

1. 프로젝트 생성   
groupId : jpa.basic (프로젝트를 대표하는 이름)
artifactId: ex1-hello-jpa (root 컨텍스트)
version: 1.0.0   
   

2. 라이브러리 추가     
   ```agsl
   <?xml version="1.0" encoding="UTF-8"?>
    <project xmlns="http://maven.apache.org/POM/4.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>jpa-basic</groupId>
    <artifactId>ex1-hello-jpa</artifactId>
    <version>1.0.0</version>
    <dependencies>
    <!-- JPA 하이버네이트 -->
    <dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-entitymanager</artifactId>
    <version>5.3.10.Final</version>
    </dependency>
    <!-- H2 데이터베이스 -->
    <dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <version>1.4.199</version>
    </dependency>
    </dependencies>
    </project>
    ```
   
3. JPA 설정하기 
    - persistence.xml
    - /META-INF/persistence.xml 위치
    - persistence-unit name으로 지정
    - javax.persistence로 시작: JPA 표준 속성
    - hibernate로 시작: 하이버네이트 전용 속성
   ```agsl
    <?xml version="1.0" encoding="UTF-8"?>
    <persistence version="2.2"
    xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd">
    <persistence-unit name="hello">
    <properties>
    <!-- 필수 속성 
    javax는 다른 구현체를 써도 된다.
    hibernate는 하이버네이트 전용 속성
    -->
    <property name="javax.persistence.jdbc.driver" value="org.h2.Driver"/>
    <property name="javax.persistence.jdbc.user" value="sa"/>
    <property name="javax.persistence.jdbc.password" value=""/>
    <property name="javax.persistence.jdbc.url" value="jdbc:h2:tcp://localhost/~/test"/>
   <!-- 데이터베이스 방언을 정의 
    데이터베이스마다 조금씩 다르다. 이것을 정의해주는 단계
    • H2 : org.hibernate.dialect.H2Dialect
    • Oracle 10g : org.hibernate.dialect.Oracle10gDialect
    • MySQL : org.hibernate.dialect.MySQL5InnoDBDialect--> 
   <property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect"/>
    <!-- 옵션 -->
    <property name="hibernate.show_sql" value="true"/>
    <property name="hibernate.format_sql" value="true"/>
    <property name="hibernate.use_sql_comments" value="true"/>
    <!--<property name="hibernate.hbm2ddl.auto" value="create" />-->
    </properties>
    </persistence--unit>
    </persistence>
    ```
4. Persistence.createEntityManageFactory 객체 만들기
    ```agsl
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    //메니저를 불러와서 코드를 짜면 된다.
    EntityManager em = emf.createEntityManager();
    em.close();
    emf.close();
    ```
5. 객체와 테이블을 생성하고 매핑하기
- @Entity: JPA가 관리할 객체
- @Id : 데이터베이스가 PK와 매핑
```agsl
// 데이터베이스에 테이블 만들기
create table Member ( 
 id bigint not null, 
 name varchar(255), 
 primary key (id) 
)
```
```agsl
//자바 클래스 만들기
@Entity
public class Member {
@Id
private Long id;
private String name;

getter/setter 생략
```

6. JPA에서는 트렌젝션이 중요하다. tx.begin, close 해주기
```agsl
//매니저한테 tx 받아오기
EntityTransaction tx = em.getTransaction();
//tx 시작
tx.begin();

Member member = new Member();
member.setId(3L);
member.setName("helloB");

em.persist(member);

//처리할 것들이 끝났으면 tx 종료시킨다.
tx.commit();
```
테이블과 클래스의 이름이 같으면 자동으로 그 테이블에 넣어주지만,
만약 table의 이름과 class의 이름이 다르다면 @Table(name="") 이렇게 하면 된다.   
   
컬럼이 다르면 @Column(name=""); 해주면 된다.

7. tx 예외처리해주기 (try[]catch{}finally{}) 및 등록,수정,삭제,조회 해보기
```agsl
EntityManager em = emf.createEntityManager();

EntityTransaction tx = em.getTransaction();
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
```
하지만 스프링에서는 이 모든 과정을 해주니까 우리는 em.persistence만 해주면 된다.

#### * 엔티티 매니저 팩토리는 하나만 생성해서 애플리케이션 전체서 공유
#### * 엔티티 매니저는 요청이 올 때마다 만든다. 사용하고 버려야 한다. 쓰레드간 공유 x
#### * 모든 데이터 변경은 트렌젝션 안에서 실행

### 나이가 13살 이상인 회원을 모두 검색하고 싶다면?
-> JPQL을 사용한다. 테이블이 아닌 객체를 대상으로 검색하는 객체 지향 쿼리
```agsl
ex)
List<Member> result = em.createQuery("select m from Member as m", Member.class)
    .getResultList();    
```
- JPQL은 엔티티 객체를 대상으로 쿼리(장점은 방언을 변경해도 JPQL을 변경할 필요가 없다는 것)
- SQL은 데이터베이스 테이블을 대상으로 쿼리