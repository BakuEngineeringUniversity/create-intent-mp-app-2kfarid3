package nspsolutions.net.dictianaryapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Meaning {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String meaning;

    @ManyToOne
    @JoinColumn(name = "name_id", nullable = false)
    @JsonIgnore
    private Name name;

    // Constructors
    public Meaning() {}

    public Meaning(String meaning) {
        this.meaning = meaning;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}

