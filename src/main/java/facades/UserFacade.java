package facades;

import dto.AktiviteterDTO;
import entities.Aktiviteter;
import entities.CityInfo;
import entities.User;
import entities.Weather;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import security.errorhandling.AuthenticationException;
import utils.EMF_Creator;


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
    
    
     public List<AktiviteterDTO> getAktiviteter() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Aktiviteter> query = em.createQuery("SELECT a FROM Aktiviteter a", Aktiviteter.class);
        List<Aktiviteter> atr = query.getResultList();
        List<AktiviteterDTO> atrDTOList = new ArrayList<>();
        atr.forEach((Aktiviteter akt) -> atrDTOList.add(new AktiviteterDTO(akt)));
        return atrDTOList;
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

   
    
}
