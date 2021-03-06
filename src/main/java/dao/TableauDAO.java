package dao;

import domain.Fiche;
import domain.Tableau;
import javafx.scene.control.Tab;
import jpa.EntityManagerHelper;

import javax.persistence.EntityTransaction;
import java.util.List;

public class TableauDAO {

    public void saveTableau(Tableau tableau) {
        EntityTransaction tab = EntityManagerHelper.getEntityManager().getTransaction();

        tab.begin();
        EntityManagerHelper.getEntityManager().persist(tableau);
        tab.commit();
    }
    public List<Tableau> getAllTableauxDao() {
        String query = "select tab from Tableau as tab";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tableau.class).getResultList();
    }

    public List<Tableau> getAllTableaux1() {
        String query = "select tab from Tableau as tab where tab.name='tableau1'";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tableau.class).getResultList();
    }

    public List<Tableau> getAllTableaux2() {
        String query = "select tab from Tableau as tab where tab.name='tableau2'";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tableau.class).getResultList();
    }

    public List<Tableau> getAllTableauxSansSectionDao() {
        String query = "select tab from Tableau as tab where tab.sections is EMPTY";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tableau.class).getResultList();
    }


    public List<Tableau> getAllTableauxNamelong6() {
        String query = "select tab from Tableau as tab " +
                "where LENGTH(tab.name) = 6";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tableau.class).getResultList();
    }

    public List<Tableau> getFirstTableau() {
        String query = "select tab from Tableau as tab ORDER BY tab.name ASC";
        return EntityManagerHelper.getEntityManager().
                createQuery(query, Tableau.class)
                .setFirstResult(1).setMaxResults(1)
                .getResultList();
    }
    public List<Tableau> getLastTableau() {
        String query = "select tab from Tableau as tab ORDER BY tab.name DESC";
        return EntityManagerHelper.getEntityManager().
                createQuery(query, Tableau.class)
                .setFirstResult(1).setMaxResults(1)
                .getResultList();
    }

    public List<Tableau> getAllTableauxNatifs() {
        String query = "select * from Tableau";
        return EntityManagerHelper.getEntityManager().
                createNativeQuery(query, Tableau.class).getResultList();
    }
    public List<Tableau> getAllTableauxWithSectionsLoaded() {
        String query = "SELECT tab from Tableau as tab "
                + "where tab.name='tableau1' join fetch tab.section.name";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tableau.class).getResultList();
    }


}
