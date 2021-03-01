package jpa;
import domain.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class JpaTestFiche {

    private EntityManager manager;

    public JpaTestFiche(EntityManager manager) {
        this.manager = manager;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
		/*EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();*/
        EntityManager manager = EntityManagerHelper.getEntityManager();
        JpaTestFiche test = new JpaTestFiche(manager);


        EntityTransaction tx = manager.getTransaction();


        tx.begin();
        try {
            test.createFiches();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();

        test.listFiches();

        manager.close();
        System.out.println(".. done");
        EntityManagerHelper.closeEntityManagerFactory();
    }

    private void createFiches() {
        int numOfFiches = manager.createQuery("Select a From Fiche a", Fiche.class).getResultList().size();
        if (numOfFiches == 0) {
            Tableau tableau = new Tableau("tab1");
            Tableau tableau2 = new Tableau("tab2");
            Section section = new Section("section");
            //List<Fiche> fiches = new ArrayList<Fiche>();
            Fiche fiche = new Fiche("fiche1",section);
            Fiche fiche2 = new Fiche("fiche2",section);
            //fiches.add(fiche2);
            manager.persist(tableau);
            manager.persist(tableau2);
            manager.persist(fiche);
            manager.persist(fiche2);
            manager.persist(section);

            manager.persist(new Fiche("Jakab Gipsz",section));
            manager.persist(new Fiche("Captain Nemo",section));
            manager.persist(new Fiche("Bon Toronja",section));
            manager.persist(new Fiche("Bebecito bebeLean",section));
            manager.persist(new Utilisateur("user1",fiche));
            manager.persist(new Utilisateur("user2",fiche2));
            manager.persist(new Section("section1",tableau));
            manager.persist(new Section("section2",tableau2));
            manager.persist(new Tars("tars1", fiche));
            manager.persist(new Tars("tars2", fiche2));






        }
    }

    private void listFiches() {
        List<Fiche> resultList = manager.createQuery("Select a From Fiche a", Fiche.class).getResultList();
        System.out.println("num of fiches:" + resultList.size());
        for (Fiche next : resultList) {
            System.out.println("next fiche: " + next);
        }
    }
}


