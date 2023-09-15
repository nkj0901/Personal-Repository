회원, 주문, 배송, 주문상품, 카테고리, 상품(물품)

- 주문과 배송은 1:1(@OneToMany)
- 상품, 카테고리는 N:M(@ManyToMany)

- N:M관계는 1:N, N:1
    - 테이블의 N:M관계는 중간 테이블을 이용해서 1:N, N:1
    - 실전에서는 중간 테이블이 단순하지 않다.
    - @ManyToMany는 제약 : 필드 추가x, 엔티티 테이블 불일치
    - 실전에서는 @ManyToMany 사용x

@JoinColumn
- 외래 키를 매핑할 때 사용
- referencedColumnName: 외래 키가 참조하는 대상 테이블의 컬럼명이 다를 때 이름 설정. 기본값은 참조하고 있는 테이블의 기본 키 컬럼명

@ManyToOne
- mappedBy 속성이 없음 (insertable, updatable false로 설정했었음) -> 이건 연관관계의 주인이 되어야 한다는 뜻이다.
- 다대일 관계 매핑
- optional : false로 설정하면 연관된 엔티티가 항상 있어야 한다.
- fetch : 글로벌 페치 전략을 설정한다. 기본값 @ManyToOne = FetchType.EAGER, @OneToMany=FetchType.LAZY
