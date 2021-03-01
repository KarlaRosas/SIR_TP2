/**Utilisateur**/
package domain;

import domain.Fiche;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Utilisateur {
    private Long id;

    private String name;

   private List<Fiche> fiches = new ArrayList<Fiche>();


    public Utilisateur() {
    }

    public Utilisateur(String name, Fiche fiche) {
        this.name = name;
        this.fiches.add(fiche);
    }

    public Utilisateur(String name) {
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

    @ManyToMany
    public List<Fiche> getFiches() {
        return fiches;
    }

    public void setFiches(List<Fiche> fiches) {
        this.fiches = fiches;
    }

    @Override
    public String toString() {
        return "Utilisateur [id=" + id + ", name=" + name + ", tableau="
                + fiches.get(0).getName() + "]";
    }

}
