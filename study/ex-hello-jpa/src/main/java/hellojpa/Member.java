package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {
    @Id                         //  @Id: pk를 매핑한것
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name",nullable = false)
    private String username;

    public Member(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

//    @Id                         //  @Id: pk를 매핑한것
//    @Column(name = "name")      //  @Column(name=""): 객체와 DB의 컬럼명이 다를때 사용한다.
//    private String username;
//
//    private Integer age;        //  Integer로 하면 DB에서도 숫자타입이 생성된다.
//
//
//    @Enumerated(EnumType.STRING)    // @Enumerated: DB에는 eNum Type이 없어서 쓴다.
//    private RoleType roleType;
//
//    @Temporal(TemporalType.TIMESTAMP)   //@Temporal: 3가지 값이있는데 Time, Date, TimeStamp(둘다)
//    private Date createdDate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//
//    @Lob                                // @Lob: 데이터베이스에 varchar를 넘는 큰컨텐츠를 쓰기위해서 쓴다.
//    private String description;
//
//    @Transient                          // @Transient: 특정 필드를 컬럼에 매핑하지 않음 (매핑 무시)
//    private int temp;

