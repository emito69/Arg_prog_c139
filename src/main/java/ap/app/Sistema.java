
package ap.app;

import ap.persistencia.EntityManagerUtil;

import javax.persistence.EntityManager;


public class sistema {

    public static void main(String[] args) {

        EntityManager manager = EntityManagerUtil.getEntityManager();
        System.out.println("EntityManager class ==> " + manager.getClass().getCanonicalName());
    }
}