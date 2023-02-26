# 엔티티 맵핑
___
- 객체와 테이블 매핑 @Entity, @Table
- 필드와 컬럼 매핑 @Column
- 기본 키 매핑 @Id
- 연경관계 매핑 @ManyToOne, @JoinColumn

### @Entity
- 이게 붙으면 JPA가 관리하는 엔티티라는 뜻
- JPA를 사용해서 테이블과 매핑할 클래스는 @Entity 필수

- 주의
  * 기본 생성자 필수(파라미터가 없는 public 또는 protected 생성자)
  * final 클래스, enum, interface,inner 클래스 사용x
  * 필드에 final 사용 금지

- 속성   
  - name 기본값은 클래스 이름이다. 하지만 @Entity(name="") 또는 @Table(name="")이렇게 지정해줄 수 있다.

### 데이터베이스 스키마 자동 생성
- DDL을 애플리케이션 실행 시점에 자동으로 생성 
- 이렇게 생성된 DDL은 개발 장비에서만 사용하고 운영 서버에서는 사용하면 안된다.
- persistence.xml에 <property name="hibernate.hbm2ddl.auto" valu="create"/>
  - create : 기존 테이블 삭제 후 다시 생성
  - create-drop : create와 같으나 종료시점에 테이블 drop
  - update : 변경분만 반영(운영 DB에는 사용하면 안됨), 추가만 가능. 지우는 것은 안된다.