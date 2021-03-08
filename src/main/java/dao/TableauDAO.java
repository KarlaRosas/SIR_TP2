package dao;

import domain.Fiche;
import domain.Tableau;
import jpa.EntityManagerHelper;

import javax.persistence.EntityTransaction;
import java.util.List;


/**Query Tableau**/
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
        String query = "select tab from Tableau as tab where tab.name='Tableau Backend'";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tableau.class).getResultList();
    }

    public List<Tableau> getAllTableaux2() {
        String query = "select tab from Tableau as tab where tab.name='Tableau Frontend'";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tableau.class).getResultList();
    }

    public List<Tableau> getAllTableauxSansSectionDao() {
        String query = "select tab from Tableau as tab where tab.sections is EMPTY";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tableau.class).getResultList();
    }


    public List<Tableau> getAllTableauxNamelong15() {
        String query = "select tab from Tableau as tab " +
                "where LENGTH(tab.name) = 15";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tableau.class).getResultList();
    }

    public List<Tableau> getTableauASC() {
        String query = "select tab from Tableau as tab ORDER BY tab.name ASC";
        return EntityManagerHelper.getEntityManager().
                createQuery(query, Tableau.class)
                .setFirstResult(0).setMaxResults(10)
                .getResultList();
    }
    public List<Tableau> getTableauDESC() {
        String query = "select tab from Tableau as tab ORDER BY tab.name DESC";
        return EntityManagerHelper.getEntityManager().
                createQuery(query, Tableau.class)
                .setFirstResult(0).setMaxResults(10)
                .getResultList();
    }

    public List<Tableau> getAllTableauxNatifs() {
        String query = "select * from Tableau";
        return EntityManagerHelper.getEntityManager().
                createNativeQuery(query, Tableau.class).getResultList();
    }

    public List<Tableau> getAllSectionOFTableauParam(String name) {
        String query = "select t from Tableau as t join t.sections as a where a.name=:name";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tableau.class)
                .setParameter("name", name).getResultList();
    }


}
