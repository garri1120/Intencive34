package ru.aston.popov_am.task9.OneTableForHierarchy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


public class OneTableForHierarchyTest {
    private static SessionFactory sessionFactory;
    private Session session;

    private Cat cat;
    private Fish fish;

    @BeforeAll
    public static void init() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Pet.class);
            configuration.addAnnotatedClass(Cat.class);
            configuration.addAnnotatedClass(Fish.class);
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @BeforeEach
    public  void setUp(){
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            cat = Cat.builder().nickname("Мурзик").breed("Дворовая").color("Белая").build();
            fish = Fish.builder().nickname("Тритон").waterTemperature(25).build();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    @AfterEach
    public void stopSession(){
        session.getTransaction().commit();
        session.close();
    }
    @Test
    void save(){
        session.persist(cat);
        session.persist(fish);
    }
    @Test
    void findFish(){
       Fish fish1 = session.find(Fish.class,2);
       System.out.println(fish1);
    }
    @Test
    void findCat(){
       Cat cat1 = session.find(Cat.class,1);
       System.out.println(cat1);
    }
    @Test
    void findAllPets(){
        List<Pet> pets = session.createQuery("from Pet", Pet.class).getResultList();
        pets.forEach(System.out::println);

    }
}
