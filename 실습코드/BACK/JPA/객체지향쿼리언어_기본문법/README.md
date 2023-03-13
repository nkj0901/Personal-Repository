## JPA는 다양한 쿼리 방법을 지원
- JPQL
- JPA Criteria
- QueryDSL
- 네이티브 SQL
- JDBC API 직접 사용, MyBatis, SpringJdbcTemplate 함께 사용

## JPQL
- JPA를 사용하면 엔티티 객체를 중심으로 개발
- 문제는 검색 쿼리
- 검색을 할 때도 테이블이 아닌 엔티티 객체를 대상으로 검색하는 객체 지향 쿼리
- 모든 DB 데이터를 개체로 변환해서 검색하는 것은 불가능
- 애플리케이션이 필요한 데이터만 DB에서 불러오려면 결국 검색 조건이 포함된 SQL이 필요함
- JPA는 SQL을 추상화한 JPQL이라는 개체 지향 쿼리 언어 제공
- SQL과 문법 유사, SELECT, FROM, WHERE, GROUP BY, HAVING, JOIN 지원

- JPQL은 엔티티 객체를 대상으로 쿼리
- SQL은 데이터베이스 테이블을 대상으로 쿼리
- SQL을 추상화해서 특정 데이터베이스 SQL에 의존 X
- JPQL을 한마디로 정의하면 객체 지향 SQL

```agsl
List<Member> result = em.createQuery(
        "select m From Member m where m.name like '%kim%'",
        Member.class
    ).getResultList();
```
-> 동적 쿼리를 만들기 어렵다. 문자를 다 더해서 만들어야 하기 때문에

#### Criteria
- 문자가 아닌 자바코드로 JPQL을 작성할 수 있음
- JPQL 빌더 역할
- JPA 공식 기능
- 단점 : 너무 복잡하고 실용성이 없다.
- Creteria 대신에 QueryDSL 사용 권장

```agsl
//Criteria 사용 준비
CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<Member> query = cb.createQuery(Member.class);

//루트 클래스 (조회를 시작할 클래스)
Root<Member> m = query.from(Member.class);

//쿼리 생성 CriteriaQuery<Member> cq =
CriteriaQuery<Member> cq = query.select(m);
String name = "daflk";
if(name != null){
    cq = cq.where(cb.equal(m.get("name"), "kim"));
}
em.createQuery(cq).getResultList();
```

#### QueryDSL 소개
```agsl
JPAFactoryQuery query = new JPAQueryFactory(em);
QMember m = QMember.member;

List<Member> list = query.selectFrom(m)
    .where(m.age.gt(18))
    .orderBy(m.name.desc())
    .fetch();
```

- 문자가 아닌 자바코드로 JPQL을 작성할 수 있음
- JPQL 빌더 역할
- 컴파일 시점에 문법 오류를 찾을 수 있음
- 동적 쿼리 작성 편리함
- 단순하고 쉬움
- 실무 사용 권장
* QueryDSL 사이트에 설명이 아주 되어 있음. JPQL만 알면 된다.

#### 네이티브 SQL 소개
- JPA가 제공하는 SQL을 직접 사용하는 기능
- JPQL로 해결할 수 없는 특정 데이터베이스에 의존적인 기능
- 예) 오라클 CONNECT BY, 특정 DB 만 사용하는 SQL 힌트
```agsl
String sql = "SELECT ID, AGE, TEAM_ID, NAME FROM MEMBER WHERE NAME = 'kim'";
List<Member> resultList = em.createNative
```

#### JDBC 직접 사용. SpringJdbcTemplate 등
flush는 commit할 때, query를 날릴 때 em가 수행
- JPA를 사용하면서 JDBC 커넥션을 직접 사용하거나, 스프링 jdbcTemplate, 마이바티스 등을 함께 사용
- 단 연속성 컨텍스트를 적절한 시점에 강제로 플러시 필요
- JPA를 우휘해서 SQL을 실행하기 직전에 영속성 컨텍스트 수동 플러시(db커넥션에 쿼리를 수행하면 영속성 컨텍스트에 들어가지 않음. 강제로 플러시해야 함)

jpql, queryDSL 섞어쓰자~!

#### JPQL
- JPQL은 객체지향 쿼리 언어다. 따라서 테이블을 대상으로 쿼리하는 것이 아니라 엔티티 객체를 대상으로 쿼리한다.
- JPQL은 SQL을 추상화해서 특정데이터베이스 SQL에 의존하지 않는다.
- JPQL은 결국 SQL로 변환된다.

