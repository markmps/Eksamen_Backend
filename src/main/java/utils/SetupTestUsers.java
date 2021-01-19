package utils;


import entities.Aktiviteter;
import entities.CityInfo;
import entities.Role;
import entities.User;
import entities.Weather;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsers {

  public static void main(String[] args) {

    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    EntityManager em = emf.createEntityManager();
    
    // IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
    // CHANGE the three passwords below, before you uncomment and execute the code below
    // Also, either delete this file, when users are created or rename and add to .gitignore
    // Whatever you do DO NOT COMMIT and PUSH with the real passwords

    User user = new User("user","Mark Sørensen",26,"81kg", "test1");
    User admin = new User("admin", "test2");
    User both = new User("user_admin", "test3");
    
    Weather w1 = new Weather("Roskilde",2,"Skyet",100,"3m/s");
        
        CityInfo c1 = new CityInfo("Roskilde","Roskilde kommune",51262);
    
         Aktiviteter a1 = new Aktiviteter("løbetræning","18:40","20:03","5 km","ingen",c1);
        
        a1.setCity(c1);
        w1.setAktiviteter(a1);
    
        user.addAktiviteter(a1);
        
    if(admin.getUserPass().equals("test")||user.getUserPass().equals("test")||both.getUserPass().equals("test"))
      throw new UnsupportedOperationException("You have not changed the passwords");

    em.getTransaction().begin();
    Role userRole = new Role("user");
    Role adminRole = new Role("admin");
    user.addRole(userRole);
    admin.addRole(adminRole);
    both.addRole(userRole);
    both.addRole(adminRole);
    em.persist(w1);
    em.persist(userRole);
    em.persist(adminRole);
    em.persist(user);
    em.persist(admin);
    em.persist(both);
    em.getTransaction().commit();
    System.out.println("PW: " + user.getUserPass());
    System.out.println("Testing user with OK password: " + user.verifyPassword("test"));
    System.out.println("Testing user with wrong password: " + user.verifyPassword("test1"));
    System.out.println("Created TEST Users");
   
  }

}