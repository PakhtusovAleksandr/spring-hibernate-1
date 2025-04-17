package ru.be_prog.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "profiles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Profile {
@Id
private UUID id;

    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;

    @Column(name = "country")
    private String country;

    @Column(name = "about")
    private String about;

    //Связь с аккаунтами и делаем общий ключ id, созданный в Account
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    @ToString.Exclude
    private Account account;

}
