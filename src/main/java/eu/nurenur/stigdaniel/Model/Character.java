package eu.nurenur.stigdaniel.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "characters")
@Getter
@Setter
@NoArgsConstructor
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column
    private String name;

    @Column
    private String bio;

    Character(
            String name,
            String bio
    ) {
        this.name = name;
        this.bio = bio;
    }
}
