package com.fastcampus.jpa.bookmanager.domain;

import com.fastcampus.jpa.bookmanager.domain.listener.Auditable;
import com.fastcampus.jpa.bookmanager.domain.listener.MyEntityListener;
import com.fastcampus.jpa.bookmanager.domain.listener.UserEntityListener;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;



@NoArgsConstructor      //생성자만
@AllArgsConstructor     //모든 멤버
@RequiredArgsConstructor//꼭 필수로 들어가야하는 멤버 ex) notnull 있는 것
@Data
@Entity
@Builder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@EntityListeners(value = {AuditingEntityListener.class, UserEntityListener.class})
public class User extends BaseEntity  {
    @Id
//    @GeneratedValue //자동으로 숫자가 증가하게.
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NonNull
    private String name;
    @NonNull
    private String email;

    private Gender gender;


    @OneToMany(fetch = FetchType.EAGER)
    private List<Address> addressList;

//    @PrePersist
//    public void prePersist(){
//        this.createdAt=LocalDateTime.now();
//        this.updatedAt=LocalDateTime.now();
//    }
//
//    @PreUpdate
//    public void preUpdate(){
//        this.updatedAt=LocalDateTime.now();
//
//    }
}
