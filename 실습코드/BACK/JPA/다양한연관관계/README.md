# 연관관계 매핑 시 고려사항 3가지
___
1. 다중성
  - 다대일: @ManyToOne
  - 일대다 : @OneToMany
  - 일대일 : @OneToOne
  - 다대다 : @ManyToMany
  * 사실 다대다는 실무에선 사용하면 안되는 것이다. 다대일을 제일 많이 쓰고 일대다도 많이 쓰인다. 일대일도 가끔 씀.
2. 단방향, 양방향
   - 테이블 
     - 외래 키 하나로 양쪽 조인 가능
     - 사실 방향이라는 개념이 없음
   - 객체
     - 참조용 필드가 있는 쪽으로만 참조 가능
     - 한쪽만 참조하면 단방향
     - 양쪽이 서로 참조하면 양방향(사실 양방향이라는 것은 없음. 객체 입장에서는 방향이 하나. 사실은 단방향이 두 개 있는 것이다. 이해하기 쉽도록 말은 만든 것뿐)
3. 연관관계의 주인
   - 테이블은 외래 키 하나로 두 테이블이 연관관계를 맺음
   - 객체 양방향 관계는 A->B, B->A처럼 참조가 2군데
   - 객체 양방향 관계는 참조가 2군데 있음. 둘 중 테이블의 외래 키를 관리할 곳을 지정해야 함
   - 연관관계의 주인 : 외래 키를 관리하는 참조
   - 주인의 반대편 : 외래 키에 영향을 주지 않음. 단순 조회만 가능

### 다대일 [N:1]
member, team
- 가장 많이 사용하는 연관관계
- 다대일의 반대는 일대다
- 양방향
  - 양방향으로 만들어도 테이블에는 전혀 영향을 주지 않음. 나중에 필요하면 만들어주자. mappedBy 꼭 넣어주자.
  - 외래 키가 있는 쪽이 연관관계의 주인
  - 양쪽을 서로 참조하도록 개발

### 일대다 [1:N]
team, member
- 여기에서는 1이 연관관계의 주인이다.
- 이 모델은 권장하진 않는다.
- 여기서는 team이 연관관계의 주인이 된다.
- 엔티티가 관리하는 외래 키가 다른 테이블에 있음. 외래키가 없는 객체를 변경했을 때, 외래키가 있는 객체가 변경됨.. 뭔가 불편...
- team을 수정하면 member 업데이트하는 쿼리가 또 나감. 연관관계 관리를 위해 추가로  update sql 실행
- JoinColumn을 사용하지 않은면 디폴트로 중간 테이블이 생성됨. 생략하지 않도록 주의하자.

* 실무에서는 보통 세터를 안쓴다. 생성자에서 완성되게 만든다.
* 되도록 일대다 단방향 매핑보다는 다대일 양방향 매핑을 사용하자. 참조를 하나 더 넣는 한이 있더라도 다대일 단방향으로

#### 일대다 양방향
- 매핑이 공식적으로 존재하지 않는다.
- 읽기 전용 필드를 사용해 양방향처럼 사용하는 방법
- 다대일 양방향을 사용하자
```agsl
@ManyToOne
@JoinColumn(insertabel = false, updatable = false)
private Team team;
```

### 일대일 관계 [1:1]
member, locker
- 일대일 관계이기 때문에 주 테이블이나 대상 테이블 중에 외래 키 선택 가능
- 외래키에 데이터베이스 유니크(UNI) 제약조건 추가
- 다대일 양방향 매핑처럼 외래키가 있는 곳이 연과관계의 주인
- 반대편은 mappedBy 적용
- 대상 테이블에 외래 키가 있을 때 단방향 지원 불가. 양방향 관계는 지원
```agsl
// member를 주 테이블로 잡았을 때.
@OneToOne
@JoinColumn(name = "LOCKER_ID")
private Locker locker;

// locker 파일에 양방향으로 하려면 다음 코드를 추가
@OneToOne(mappedBy = "locker")
private Member member;
```

- 주 테이블에 외래 키 
  - 주 객체가 대상 객체의 참조를 가지는 것 처럼 주 테이블에 외래 키를 두고 대상 테이블을 찾음
  - 객체지향 개발자들이 선호하는 방식으로 JPA 매핑이 편리하다.
  - 장점 : 주 테이블만 조회해도 대상 테이블에 데이터가 있는지 확인가능하다
  - 단점 : 값이 없으면 외래 키에 null 허용

- 대상 테이블 외래 키
  - 대상 테이블에 외래 키가 존재
  - 전통적인 데이터베이스 개발자 선호
  - 장점 : 주 테이블과 대상 테이블을 일대일에서 일대다 관계로 변경할 때 테이블 구조 유지
  - 단점 : 프록시 기능의 한계로 지연 로딩으로 설정해도 항상 즉시 로딩됨(프록시는 뒤에 설명) 

### 다대다
member, product
- 실무에서 쓰지 않는 것을 추천한다.
- 관계형 데이터베이스는 정규화된 테이블 2개로 다대다 관계를 표현할 수 없다. 보통 member_product라는 중간테이블을 만들어 낸다. 연결 테이블을 추가해서 일대다, 다대일 관계로 풀어내야 한다.
- 객체는 컬렉션을 사용해서 객체 2개로 다대다 관계 가능. 각자 list를 가지면 된다.
- @ManyToMany 사용
- @JoinTable로 연결 테이블 지정
- 다대다 매핑 : 단방향, 양방향 가능
- 양방향은 @ManyToMany(mappedBy="")
```agsl
@ManyToMany
@JoinTable(name = "MEMBER_PRODUCT")
private List<Product> product = new ArrayList<>();
    
@ManyToMany(mappedBy = "products")
private List<Member> members = new ArrayList<>();
```

#### 다대다 매핑의 한계
- 편리해 보이지만 실무에서 사용 x
- 연결 테이블이 단순히 연결만 하고 끝내지 않음
- 중간 테이블에 주문시간, 수량 같은 데이터를 추가해야 하는데 여기에서는 그럴 수 없음

#### 다대다 한계 극복
- 연결 테이블용 엔터티 추가(연결 테이블을 엔티티로 승격)
- @ManyToMany -> @OneToMany, @ManyToOne
```agsl
@Entity
public class MemberProduct {

@Id
@GeneratedValue
private Long id;

@ManyToOne
@JoinColumn(name = "MEMBER_ID")
private Member member;

@ManyToOne
@JoinColumn(name = "PRODUCT_ID")
private Product product;

//내가 원하는 멤버변수를 추가할 수 있음
private int orderMount
}

@OneToMany(mappedBy = "product")'
private List<MemberProduct> memberProducts = new ArrayList<>();

@OneToMany(mappedBy = "member")
private List<MemberProduct> memberProducts = new ArrayList<>();

```

* 웬만하면 pk는 쓸데없는 값으로 설정해라. 복합키나 의미있는 값을 쓰지 말고 다 테이블 마다 제너레이트벨류하는 것이 최고다.