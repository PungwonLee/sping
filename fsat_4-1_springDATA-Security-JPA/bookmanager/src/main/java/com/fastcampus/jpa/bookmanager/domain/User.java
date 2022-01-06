package com.fastcampus.jpa.bookmanager.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;



@NoArgsConstructor      //생성자만
@AllArgsConstructor     //모든 멤버
@RequiredArgsConstructor//꼭 필수로 들어가야하는 멤버 ex) notnull 있는 것
@Data
@Entity
@Builder
public class User {
    @Id
//    @GeneratedValue //자동으로 숫자가 증가하게.
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NonNull
    private String name;
    @NonNull
    private String email;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Address> addressList;
}
