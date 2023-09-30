package ru.aston.popov_am.task9.OneTableForEveryoneClassWithUnions;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;

import java.util.List;

public class UnionTableTest {
    private static SessionFactory sessionFactory;
    private Session session;

    private Dog dog;
    private Cat cat;

    @BeforeAll
    public static void init() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Animal.class);
            configuration.addAnnotatedClass(Dog.class);
            configuration.addAnnotatedClass(Cat.class);
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
            dog = Dog.builder().nickname("Шарик").breed("Дворняга").build();
            cat = Cat.builder().nickname("Мурзик").breed("Сиамская").build();
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
        session.persist(dog);
        session.persist(cat);
    }

    @Test
    void findDog(){
        Dog dog1 = session.find(Dog.class,1);
        Assertions.assertEquals(dog1.getBreed(),"Дворняга");
    }
    @Test
    void findCat(){
        Cat cat1 = session.find(Cat.class,2);
        Assertions.assertEquals(cat1.getNickname(),"Мурзик");
    }
    @Test
    void findAllAnimal(){

        /*
        Данный select будет использовать union all для получения данных из таблиц dog и cat.
         */
     List<Animal> animals = session.createQuery("SELECT bd FROM Animal bd", Animal.class).getResultList();
     animals.forEach(System.out::println);
    }
}
