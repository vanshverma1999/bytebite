package com.bytebite.user_service.model;

import com.bytebite.user_service.model.enums.UserStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Where(clause = "deleted = false")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;

    @Column(columnDefinition = "text")
    private String address;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Builder.Default
    private Boolean deleted = Boolean.FALSE;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private UserStatus userStatus = UserStatus.ACTIVE;
}
