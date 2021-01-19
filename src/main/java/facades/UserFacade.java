package facades;

import entities.Aktiviteter;
import entities.CityInfo;
import entities.User;
import entities.Weather;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import security.errorhandling.AuthenticationException;
import utils.EMF_Creator;

/**
 * @author lam@cphbusiness.dk
 */
public class UserFacade {

    private static EntityManagerFactory emf;
    private static UserFacade instance;

    private UserFacade() {
    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static UserFacade getUserFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new UserFacade();
        }
        return instance;
    }

    public User getVeryfiedUser(String username, String password) throws AuthenticationException {
        EntityManager em = emf.createEntityManager();
        User user;
        try {
            user = em.find(User.class, username);
            if (user == null || !user.verifyPassword(password)) {
                throw new AuthenticationException("Invalid user name or password");
            }
        } finally {
            em.close();
        }
        return user;
    }

    public static void main(String[] args) {
        
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        
        Weather w1 = new Weather("Roskilde",2,"Skyet",100,"3m/s");
        
        CityInfo c1 = new CityInfo("Roskilde","Roskilde kommune",51262);
    
         Aktiviteter a1 = new Aktiviteter("løbetræning","18:40","20:03","5 km","ingen",c1);
        
        a1.setCity(c1);
        w1.setAktiviteter(a1);
        
        
         try {
            em.getTransaction().begin();
            em.persist(w1);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        
    }
    
}
