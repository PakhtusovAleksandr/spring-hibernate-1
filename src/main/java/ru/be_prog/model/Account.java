package ru.be_prog.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "accounts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Account {

    @Id
    private UUID id;

    @Column(name="name")
    private String name;

    @Column(name="lastname")
    private String lastName;

    //Связь с Profile, указываем его главным
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    // каскад - выполняет действия со связ сущ, orphanRemovel -
    // удаление сущности, если через сеттер задаем null или новый (удаление мусора)

    @JoinColumn(name = "profile_id")
    private Profile profile;
}