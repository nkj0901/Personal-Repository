# 영속성 전이(CASCADE)와 고아객체
___

## 영속성 전이(CASCADE)

- Parent를 저장할 때 child를 모두 저장해 주는 기능
- 영속성 전이는 연관관계를 매핑하는 것과 아무 관련이 없음. 엔티티를 영속화할 때 연관된 엔티티도 함께 영속화하는 편리함을 제공할 뿐이다.

- CASCADE 종류
  - ALL : 모두 적용
  - PERSIST : 영속 (삭제하면 안될 때)
  
  <아래는 안 중요>
  - REMOVE :  삭제
  - MERGE : 병합
  - REFRESH : 리프레쉬
  - DETACH : DETACH

```agsl
@Entity
public class Parent {

@Id
@GeneratedValue
private Long id;

private String name;

@OneToMany(mappedBy = "parent")
private List<Child> childList = new ArrayList<>();
}
```
```agsl
@Entity
public class Child {

@Id
@GeneratedValue
private Long id;

private String name;

@ManyToOne
@JoinColumn(name = "parent_id")
private Parent parent;
}
```
```agsl
Child child1 = new Child();
Child child2 = new Child();

Parent parent = new Parent();
parent.addChild(child1);
parent.addChild(child2);

em.persist(parent);
em.persist(child1);
em.persist(child2);

tx.commit();
```
- em.persist를 3번 호출해야 한다.
- 그냥 Parent만 persist 하는 방법
```agsl
@OneToMany(mappedBy = "parent", cascadeType.All)
private List<Child> childList = new ArrayList<>();
```
** 단일 소유자일 때 쓰는 것이 좋다.
** CHILD가 하나일 때 쓰는 것이 좋다. 여러 CHILD와 연관 되어 있을 때는 안쓰는 것이 좋다.
** 라이프사이클이 유사할 때 쓰는 것이 좋다.

## 고아객체
- 고아 객체 제거 : 부모 엔티티와 연관관계가 끊어진 자식 엔티티를 자동으로 삭제
- orphanRemoval = true;
- 참조하는 곳이 하나일 때 사용해야 한다.
- 특정 엔티티가 개인 소유할 때 사용
- @OneToOne, @OneToMany만 가능
- 참고 : 개념적으로 부모를 제거하면 자식은 고아가 된다. 따라서 고아 객체 제거 기능을 활성화 하면, 부모를 제거할 때 자식도 함께 제거된다. 이것은 CascadeType.REMOVE처럼 동작한다.

```agsl
@OneToMany(mappedBy = "parent", cascadeType.All, orphanRemoval = true)
private List<Child> childList = new ArrayList<>();
```
```agsl
Parent findParent = em.findParent(Parent.class, parent.getId());
//자식 객체 삭제하는 쿼리가 나간다.
findParent.getChildList().remove(0);
```

## 영속성 전이 + 고아객체, 생명주기
- CascadeType.All + orphanRemovel=true
- 스스로 생명주기를 관리하는 엔티티는 em.persist()로 영속화, em.remove()로 제거
- 두 옵션을 모두 활성화하면 부모 엔티티를 통해서 자식의 생명주기를 관리할 수 있음 (생성과 삭제를 관리하므로)
    -> 부모의 생명주기는 영속성 컨텍스트가 관리하지만, Child의 생명주기는 Parent가 관리하게 된다.
- 도메인 주도 설계(DDD)의 Aggregate Root개념을 구현할 때 유용

## 글로벌 페치 전략 설정
- 모든 연관관계를 지연 로딩으로 설정
- @ManyToOne, @OneToOne은 기본이 즉시 로딩이므로 지연 로딩으로 변경
