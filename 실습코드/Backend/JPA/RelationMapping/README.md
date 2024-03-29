# 연관관계 매핑 기초
___
- 객체와 테이블 연관관계의 차이를 이해
- 객체의 참조와 테이블의 외래 키 매핑
- 용어 이해
  - 방향(Direction) : 단방향, 양방향
  - 다중성(Multiplicity) : 다대일, 일대다, 일대일, 다대다 이해
  - 연관관계 주인(Owner) : 객체 양방향 연관관계는 관리 주인이 필요

예제 시나리오
- 회원과 팀이 있다.
- 회원은 하나의 팀에만 소속될 수 있다.
- 회원과 팀은 다대일 관계다.

객체를 테이블에 맞추어 데이터 중심으로 모델링하면, 협력관계를 만들 수 없다.
- 테이블은 외래 키로 조인을 사용해서 연관된 테이블을 찾는다.
- 객체는 참조를 사용해서 연관된 객체를 찾는다.
- 테이블과 객체 사이에는 이런 큰 간격이 있다.

### 단방향 연관관계
@ManyToOne
@JoinColumn
```agsl
@ManyToOne
@JoinColumn(name="TEAM_ID")
private Team team;
```

# 양방향 연관관계와 연관관계의 주인
___

### 양방향 매핑
- 원래 테이블에서는 방향이 없음. 조인 하면 양쪽의 정보 모두 확인할 수 있다.
- 양방향 매핑은 사실 단방향 매핑이 2개가 있는 것이다.
```agsl
//member는 단방향과 같음

@OneToMany(mappedBy = "team")
List<Member> members = new ArrayList<Member>();
```

### 연관관계의 주인과 mappedBy
- 테이블은 외래 키 하나로 두 테이블의 연관관계를 관리한다.
- 하지만 객체는 양방향 매핑으로 두 개의 관계가 존재하기 때문에 주인을 지정해줘야 한다.
- 연관관계의 주인만이 외래 키를 관리(등록, 수정)
- 주인이 아닌쪽은 읽기만 가능하다.
- 주인은 mappedBy 속성 사용 x
- 주인이 아니면 mappedBy 속성으로 주인 지정

#### 주인은 외래 키가 있는 곳을 주인으로 정해라
- 보통 외래키가 있는 곳이 다(N)
- N, 다 쪽이 주인이 된다.
- 양방향 연관관계일 때는 두 곳에 값을 모두 넣어주는 것이 좋다.
  - setTeam에 team.getMembers().add(this)하거나 추가하는 메서드를 하나 만들어 사용하면 뭔가 중요한 일을 하고 있다는 표시가 되기 때문에 member룰 넣지 않는 실수를 줄일 수 있다.
- flush, clear하면 안 넣어줘도 조회는 가능. flush, clear을 하지 않으면 1차 캐시에 있는 값을 가지고 오기 때문에 리스트 조회 불가.
- 양방향 매핑시에 무한 루프를 조심하자. ex) toString을 사용하며 team과 member 양쪽에서 toString을 소환해서 무한루프가 걸린다.
  - 웬만하면 lombok에서 toString을 쓰지마라. 써도 toString 또 호출하는 것은 빼고 써라.
  - Controller에 Entity를 절대 반환하지 마라. dto로 바꿔서 사용하자.

### 양방향 매핑 정리
- 단반향 매핑만으로도 이미 연관관계는 매핑 완료. 테이블 설계할 때 웬만하면 단방향으로 설계
- 양방향은 단지 반대방향에서 조회하는 것을 추가하는 것뿐 
- JPQL에서 역방향으로 탐색할 일이 많다. 
- 단방향 매핑을 잘하고 양방향은 필요할 때 추가해도 된다.(테이블에 영향을 주지 않음)
- 연관관계의 주인은 비즈니스 로직을 기준으로 선택하면 안된다. 주인은 외래 키의 위치를 기준으로 정해야 한다.

