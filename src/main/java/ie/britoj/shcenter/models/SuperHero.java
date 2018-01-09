package ie.britoj.shcenter.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
public class SuperHero implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name;
    private String pseudonym;
    private String publisher;

    @ElementCollection
    @CollectionTable(name = "allies", joinColumns = @JoinColumn(name = "superhero_id"))
    @Column(name="ally")
    private List<String> allies;

    @ElementCollection
    @CollectionTable(name = "skills", joinColumns = @JoinColumn(name = "superhero_id"))
    @Column(name="skill")
    private List<String> skills;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate firstAppearance;

    protected SuperHero(){}

    public SuperHero(String name, String pseudonym,
                     String publisher, List<String> allies,
                     List<String> skills, LocalDate firstAppearance){
        this.name = name;
        this.pseudonym = pseudonym;
        this.publisher = publisher;
        this.allies = allies;
        this.skills = skills;
        this.firstAppearance = firstAppearance;

    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public String getPublisher() {
        return publisher;
    }

    public List<String> getAllies() {
        return allies;
    }

    public List<String> getSkills() {
        return skills;
    }

    public LocalDate getFirstAppearance() {
        return firstAppearance;
    }
}
