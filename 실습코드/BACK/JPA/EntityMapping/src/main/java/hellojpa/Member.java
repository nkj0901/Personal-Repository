package hellojpa;

//아 내가 이거 관리해야 하는 아이구나 라는 것을 알려줌
import javax.persistence.*;
import java.util.Date;

@Entity
@SequenceGenerator(name="member_seq_generator", sequenceName = "member_seq")
public class Member {

    @Id
    private Long id;
    @Column(name = "name") //DB와 객체의 이름이 다를 때 맵핑
    private String username;
    private Integer age;
    @Enumerated(EnumType.STRING) //DB에는 enum이 없음. 이렇게 설정
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP) //시간(date, time, timestamp 설정)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Lob //varchar를 넘어서는 굉장히 큰 아이가 들어올 때
    private String description;

}
