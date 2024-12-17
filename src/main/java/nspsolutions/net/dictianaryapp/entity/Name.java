package nspsolutions.net.dictianaryapp.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Name {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "name", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Meaning> meanings = new ArrayList<>();

    // Constructors
    public Name() {}

    public Name(String name) {
        this.name = name;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Meaning> getMeanings() {
        return meanings;
    }

    public void addMeaning(Meaning meaning) {
        meanings.add(meaning);
        meaning.setName(this);
    }

    public void removeMeaning(Meaning meaning) {
        meanings.remove(meaning);
        meaning.setName(null);
    }
}

