package eu.nurenur.stigdaniel.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "artworks")
@Entity
public class Artwork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column
    private String title;

    @Column
    private String filePath;

    @Column
    private String medium;

    @Column
    private String description;

    @Column
    private LocalDate date;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Artwork_Tag",
            joinColumns = { @JoinColumn(name = "artwork_id") },
            inverseJoinColumns = { @JoinColumn(name = "character_id") }
    )
    private List<Character> characters;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @PrePersist
    protected void onCreate() {
        this.updatedAt = this.createdAt = LocalDateTime.now();
    }

    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @PrePersist
    protected  void onUpdated() {
        this.updatedAt = LocalDateTime.now();
    }

    public Artwork(
            String title,
            String filePath,
            String medium,
            String description,
            LocalDate date
    ) {
        this.title = title;
        this.filePath = filePath;
        this.medium = medium;
        this.description = description;
        this.date = date;
    }

    public Artwork(
            String title,
            String filePath,
            String medium,
            String description
    ) {
        this.title = title;
        this.filePath = filePath;
        this.medium = medium;
        this.description = description;
    }
}
