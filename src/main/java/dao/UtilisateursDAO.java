package dao;

import domain.Utilisateur;
import jpa.EntityManagerHelper;
import javax.persistence.EntityTransaction;
import java.util.List;


/**Query Utilisateur**/

public class UtilisateursDAO {

    public void saveUtilisateur(Utilisateur utilisateur) {
        EntityTransaction u = EntityManagerHelper.getEntityManager().getTransaction();

        u.begin();
        EntityManagerHelper.getEntityManager().persist(utilisateur);
        u.commit();
    }

    public List<Utilisateur> getAllUtilisateursDao() {
        String query = "select u from Utilisateur as u";
        return EntityManagerHelper.getEntityManager().createQuery(query, Utilisateur.class).getResultList();
    }

    public List<Utilisateur> getUtilisateur1() {
        String query = "select u from Utilisateur as u where u.name='Karla Rosas'";
        return EntityManagerHelper.getEntityManager().createQuery(query, Utilisateur.class).getResultList();
    }

    public List<Utilisateur> getAllUtilisateursSansFicheDao() {
        String query = "select u from Utilisateur as u where u.fiches is EMPTY";
        return EntityManagerHelper.getEntityManager().createQuery(query, Utilisateur.class).getResultList();
    }

    public List<Utilisateur> getAllUtilisateursNameLong13() {
        String query = "select u from Utilisateur as u " +
                "where LENGTH(u.name) = 13";
        return EntityManagerHelper.getEntityManager().createQuery(query, Utilisateur.class).getResultList();
    }

    public List<Utilisateur> get2UtilisateursASC() {
        String query = "select u from Utilisateur as u ORDER BY u.name ASC";
        return EntityManagerHelper.getEntityManager().
                createQuery(query, Utilisateur.class)
                .setFirstResult(1).setMaxResults(2)
                .getResultList();
    }
    public List<Utilisateur> get2FirstDESCUtilisateurs() {
        String query = "select u from Utilisateur as u ORDER BY u.name DESC";
        return EntityManagerHelper.getEntityManager().
                createQuery(query, Utilisateur.class)
                .setFirstResult(1).setMaxResults(2)
                .getResultList();
    }

    public List<Utilisateur> getAllUtilisateursNatifs() {
        String query = "select * from Utilisateur ";
        return EntityManagerHelper.getEntityManager().
                createNativeQuery(query, Utilisateur.class).getResultList();
    }
    public List<Utilisateur> getUtilisateurWithFichesLoaded() {
        String query = "SELECT u from Utilisateur as u "
                + "where s.name='Rabeea Kessal' join fetch u.fiche.name";
        return EntityManagerHelper.getEntityManager().createQuery(query, Utilisateur.class).getResultList();
    }


}
