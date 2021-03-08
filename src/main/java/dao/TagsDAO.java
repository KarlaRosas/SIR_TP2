package dao;

import domain.Tars;
import jpa.EntityManagerHelper;
import sun.security.krb5.internal.ccache.Tag;
import javax.persistence.EntityTransaction;
import java.util.List;

/**Query Tags**/

public class TagsDAO {

    public void saveTag(Tars tag) {
        EntityTransaction ta = EntityManagerHelper.getEntityManager().getTransaction();

        ta.begin();
        EntityManagerHelper.getEntityManager().persist(tag);
        ta.commit();
    }
    public List<Tars> getAllTagsDao() {
        String query = "select ta from Tars as ta";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tars.class).getResultList();
    }


    public List<Tars> getAllTagsImportantDao() {
        String query = "select ta from Tars as ta where ta.name='Important'";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tars.class).getResultList();
    }

    public List<Tag> getAllTagsPriorityDao() {
        String query = "select ta from Tars as ta where ta.name='Priority'";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tag.class).getResultList();
    }


    public List<Tag> getImportantTagsWithFichesLoaded() {
        String query = "SELECT ta from Tars as ta "
                + "where ta.name='Important' join fetch ta.fiches.name";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tag.class).getResultList();
    }
    public List<Tag> getPriorityTagsWithFichesLoaded() {
        String query = "SELECT ta from Tars as ta "
                + "where ta.name='Priority' join fetch ta.fiches.name";
        return EntityManagerHelper.getEntityManager().createQuery(query, Tag.class).getResultList();
    }

}
