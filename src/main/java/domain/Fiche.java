/**Employee**/
package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Fiche {
    private Long id;

    private String name;

    private Section section;

    private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

    private List<Tars> tars = new ArrayList<Tars>();


    public Fiche() {
    }

    public Fiche(String name, Section section) {
        this.name = name;
        this.section = section;
    }

    public Fiche(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @OneToMany(mappedBy = "fiche", cascade = CascadeType.PERSIST)
    public List<Tars> getTars() {
        return tars;
    }

    public void setTars(List<Tars> tars) {
        this.tars = tars;
    }

    @ManyToOne
    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @ManyToMany(mappedBy = "fiches", cascade = CascadeType.PERSIST)
    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }


    @Override
    public String toString() {
        return "Fiche [id=" + id + ", name=" + name + ", section="
                + "]";
    }

}
