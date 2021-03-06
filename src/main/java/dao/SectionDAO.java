package dao;

import domain.Fiche;
import domain.Section;
import jpa.EntityManagerHelper;

import javax.persistence.EntityTransaction;
import java.util.List;

public class SectionDAO {

    public void saveSection(Section section) {
        EntityTransaction s = EntityManagerHelper.getEntityManager().getTransaction();

        s.begin();
        EntityManagerHelper.getEntityManager().persist(section);
        s.commit();
    }
    public List<Section> getAllSectionsDao() {
        String query = "select s from Section as s";
        return EntityManagerHelper.getEntityManager().createQuery(query, Section.class).getResultList();
    }

    public List<Section> getAllSection1() {
        String query = "select s from Section as s where s.name='section1'";
        return EntityManagerHelper.getEntityManager().createQuery(query, Section.class).getResultList();
    }

    public List<Section> getAllSectionsSansFicheDao() {
        String query = "select s from Section as s where s.fiches is EMPTY";
        return EntityManagerHelper.getEntityManager().createQuery(query, Section.class).getResultList();
    }

    public List<Section> getAllSectionsNameLong6() {
        String query = "select s from Section as s " +
                "where LENGTH(s.name) = 6";
        return EntityManagerHelper.getEntityManager().createQuery(query, Section.class).getResultList();
    }

    public List<Section> getFirstSection() {
        String query = "select s from Section as s ORDER BY s.name ASC";
        return EntityManagerHelper.getEntityManager().
                createQuery(query, Section.class)
                .setFirstResult(1).setMaxResults(1)
                .getResultList();
    }
    public List<Section> getLastSection() {
            String query = "select s from Section as s ORDER BY s.name DESC";
        return EntityManagerHelper.getEntityManager().
                createQuery(query, Section.class)
                .setFirstResult(1).setMaxResults(1)
                .getResultList();
    }

    public List<Section> getAllSectionsNative() {
        String query = "select * from Section ";
        return EntityManagerHelper.getEntityManager().
                createNativeQuery(query, Section.class).getResultList();
    }
    public List<Section> getAllSectionsWithTableauxLoaded() {
        String query = "SELECT s from Section as s "
                + "where s.name='section1' join fetch s.tableau.name";
        return EntityManagerHelper.getEntityManager().createQuery(query, Section.class).getResultList();
    }


}
