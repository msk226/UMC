package spring.umc.domain;

import jakarta.persistence.*;
import lombok.*;
import spring.umc.domain.base.BaseEntity;

import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Embedded
    private Address address;

    @Column(nullable = false)
    private String info;

    private Float rate;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Food> foods;
}


