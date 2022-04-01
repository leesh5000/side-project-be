package com.somoim.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
@Entity
public class User extends BaseEntity {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 100, unique = true)
    @NotNull
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email", length = 512, unique = true)
    @NotNull
    private String email;

    @Column(name = "image_url", length = 512)
    @NotNull
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    @NotNull
    private AuthProvider provider;

    @Column(name = "provider_id")
    private String providerId;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserMeeting> userMeetings = new ArrayList<>();

    public void setUsername(String username) {
        this.username = username;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

