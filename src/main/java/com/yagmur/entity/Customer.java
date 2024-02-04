package com.yagmur.entity;
import com.yagmur.utility.EStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_customers")
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String surname;
    @Column(length = 50)
    @Email
    private String email;
    @Column(length = 15)
    private String phone;
    @Column(length = 32)
    private String password;
    @Column(length = 32)
    private String repassword;
    @Column(length = 200)
    private String address;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<VirtualTryOnImage> virtualTryOnImages;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EStatus status = EStatus.PENDING;
}
