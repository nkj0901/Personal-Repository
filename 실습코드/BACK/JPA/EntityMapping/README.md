# 엔티티 맵핑
___
- 객체와 테이블 매핑 @Entity, @Table
- 필드와 컬럼 매핑 @Column
- 기본 키 매핑 @Id
- 연경관계 매핑 @ManyToOne, @JoinColumn

## @Entity
- 이게 붙으면 JPA가 관리하는 엔티티라는 뜻
- JPA를 사용해서 테이블과 매핑할 클래스는 @Entity 필수

- 주의
  * 기본 생성자 필수(파라미터가 없는 public 또는 protected 생성자)
  * final 클래스, enum, interface,inner 클래스 사용x
  * 필드에 final 사용 금지

- 속성   
  - name 기본값은 클래스 이름이다. 하지만 @Entity(name="") 또는 @Table(name="")이렇게 지정해줄 수 있다.

## 데이터베이스 스키마 자동 생성
- DDL을 애플리케이션 실행 시점에 자동으로 생성 
- 이렇게 생성된 DDL은 개발 장비에서만 사용하고 운영 서버에서는 사용하면 안된다.
- persistence.xml에 <property name="hibernate.hbm2ddl.auto" valu="create"/>
  - create : 기존 테이블 삭제 후 다시 생성
  - create-drop : create와 같으나 종료시점에 테이블 drop
  - update : 변경분만 반영(운영 DB에는 사용하면 안됨), 추가만 가능. 지우는 것은 안된다.
  - validate : 엔티티와 테이블이 정상 매핑 되었는지만 확인
  - none : 사용하지 않음

## DDL 생성 기능
- 제약조건 추가 : 필수, 10자 이하
  - column(nullable = false, length = 10)
  - 실행에 영향을 주는 것이 아니라 데이터베이스 제약 조건만 추가하는 것이다.

## 필드와 컬럼 매핑

```agsl
@Entity
public class Member {

    @Id
    private Long id;
    @Column(name = "name") //컬럼 매핑, DB와 객체의 이름이 다를 때 name 사용
    private String username;
    private Integer age;
    @Enumerated(EnumType.STRING) //DB에는 enum이 없음. enum타입 매핑
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP) //날짜 타입 매핑(date, time, timestamp 설정)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Lob //varchar를 넘어서는 굉장히 큰 아이가 들어올 때. String이면 cLob으로 매핑
    private String description;
    @Transient // 특정 필드를 컬럼에 매핑하지 않음(매핑 무시)
    private String tmp;
}
```

* enum
  -  열거형(enumerated type)이라고 부른다. 열거형은 서로 연관된 상수들의 집합이라고 할 수 있다.
  -  class Fruit{ public static final Fruit Apple = new Fruit(); } = enum Fruit{ Apple } 

#### @Column 
  - insertable, updatable : 등록, 변경 가능 여부
  - nullable(DDL) : null값의 허용 여부. false로 설정하면 DDL 생성 시 not null 제약조건이 붙는다.
  - unique(DDL) : @Table의 uniqueConstraints와 같지만 한 컬럼에 간단히 유니크 제약 조건을 걸 때 사용
  - columnDefinition(DDL) : 데이터베이스 컬럼 정보를 직접 줄 수 있다. ex) varchar(100) default 'EMPTY'
  - length(DDL) : 문자 길이 제약 조건, String 타입에만 사용한다.
  - precision, scale(DDL) : BigDecimal 타입에서 사용한다.(BigInteger도 사용할 수 있다.) precision은 소수접을 포함한 전체 자릿수를, scale은 소수의 자릿수다. 참고로 double, float 타입에는 적용되지 않는다. 아주 큰 숫자나 정밀한 소수를 다루어야 할 때만 사용한다.

#### @Enumerated
  - EnumType.ORDINAL : enum 순서를 데이터베이스에 저장 (순서가 바뀔 수 있기 때문에 사용하지말 것)
  - EnumType.STRING : enum 이름을 데이터베이스에 저장

#### @Temporal
  - TemporalType.DATE : 날짜, 데이터베이스 date 타입과 매핑
  - TemporalType.TIME : 시간, 데이터베이스 time 타입과 매핑
  - TemporalType.TIMESTAMP : 날짜와 시간, 데이터베이스 timestamp타입과 매핑
  - 참고 : LocalDate, LocalDateTime을 사용할 때는 생략 가능(최신 하이버네이트 지원)

#### @Lob
  - 지정할 수 있는 속성이 없다.
  - 매핑하는 필드 타입이 문자면 CLOB, 나머지는 BLOB 매핑

## 기본키 맵핑
  - @id : 직접 아이디를 셋팅
  - @GeneratedValue(strategy=기본값 GenerateionType.AUTO) : 자동으로 숫자값을 만들어주는 것
    - IDENTITY 전략
      - 기본 키 생성을 데이터베이스에 위임 ex) MySQL은 auto-increment 
      - 영속성 컨텍스트에 넣기 위해서는 PK가 있어야 한다. ID를 insert한 이후에 알 수 있다. 그래서 identity 전략만 em.persist()하면 바로 쿼리가 날아간다. 자동으로 jpa가 리턴값을 받아서 저장하기 때문에 바로 id를 조회할 수 있다.
       
    - SEQUENCE 전략
      - ORACLE에서 많이 사용. Long을 사용하는 것이 좋다. 데이터베이스에 이전 값을 가져와서 다음 값으로 설정. 
      - SEQUENCE도 IDENTITY 전략과 마찬가지로 ID를 insert한 이후에 알 수 있다. 그래서 em.persist하면 jpa가 next value를 조회하는 쿼리를 날린다. 실제 쿼리는 커밋할 때 날아감
      - allocationSize() default 값은 50. 디비에서 미리 50개를 땡겨서 메모리에서 50개를 쓰다가 50개 다쓰면 또 50개 땡겨옴. 왔다갔다해서 성능이 안좋아지는 것을 방지. 웹서버가 내려가면 숫자 구멍이 생길 수 있음. 서버가 여러대여도 상관없음. 어떤 애는 1-50, 어땐 애는 51-100을 할당 받음
    ```agsl
    @SequenceGenerator( //SequenceGenerator 이렇게 설정해줄 수도 있음
    name = “MEMBER_SEQ_GENERATOR",
    sequenceName = “MEMBER_SEQ", //매핑할 데이터베이스 시퀀스 이름
    initialValue = 1, allocationSize = 1)
    ```
       
    - TABLE 전략
      - 키 생성 전용 테이블을 하나 만들어서 데이터베이스 시퀀스를 흉내내는 전략. 어떤 데이터베이스는 시퀀스를 쓰고 어떤 데이터베이스는 오토 인크리먼트를 쓰니까 선택을 했어야 했는데 이건 모든 데이터베이스에서 쓸 수 있다. 별도의 테이블을 활용하는거니까 성능 문제가 있을 수 있음. 
    ```agsl
    @TableGenerator(
    name = "MEMBER_SEQ_GENERATOR",
    table = "MY_SEQUENCES",
    //테이블에 입력될 때마다 MEMBER_SEQ 값이 1씩 늘어남
    pkColumnValue = “MEMBER_SEQ", allocationSize = 1)
    ```   
    
    - AUTO는 데이터베이스 방언에 맞춰 세개 중에 하나가 선택된다.

## 권장하는 식별자 전략
  - 기본 키 전략 조건 : null 아님, 유일, 변하면 안된다.
  - 미래까지 이 조건을 만족하는 자연키는 찾기 어렵다. 대리키(대체키)를 사용하자. 비지니스와 전혀 상관없는 것을 사용하는 것이 좋다.
  - 예를 들어 주민등록번호도 기본 키로 적절하지 않다.
  - 권장 : Long형 + 대체키 + 키 생성전략 사용