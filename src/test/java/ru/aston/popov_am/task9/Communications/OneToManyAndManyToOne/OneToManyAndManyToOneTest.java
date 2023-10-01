package ru.aston.popov_am.task9.Communications.OneToManyAndManyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;


public class OneToManyAndManyToOneTest {
    private static SessionFactory sessionFactory;
    private Session session;

    private Person person;
    private Person person1;
    private Pet dog;
    private Pet cat;
    private Pet parrot;
    private Pet dog1;
    private Pet fish;
    @BeforeAll
    public static void init() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Person.class);
            configuration.addAnnotatedClass(Pet.class);
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
            person = Person.builder().firstname("Иван").build();
            person1 = Person.builder().firstname("Дима").build();

            dog = Pet.builder().nickname("Мухтар").speciesOfAnimal(SpeciesOfAnimal.DOG).person(person).build();
            parrot = Pet.builder().speciesOfAnimal(SpeciesOfAnimal.PARROT).nickname("Кеша").person(person).build();
            cat = Pet.builder().nickname("Мурка").speciesOfAnimal(SpeciesOfAnimal.CAT).person(person).build();

            dog1 = Pet.builder().nickname("Reks").speciesOfAnimal(SpeciesOfAnimal.DOG).person(person1).build();
            fish = Pet.builder().nickname("Гектор").speciesOfAnimal(SpeciesOfAnimal.FISH).person(person1).build();
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
        session.persist(person);
        session.persist(dog);
        session.persist(cat);
        session.persist(parrot);

        session.persist(person1);
        session.persist(dog1);
        session.persist(fish);
    }

    @Test
    void getAllPets() {
        List<Pet> pets = session.createQuery("from Pet", Pet.class).list();
        pets.forEach(System.out::println);
    }
    @Test
    void findPerson(){
        Person person1 = session.find(Person.class,1);
        System.out.println(person1);
    }
    @Test
    void getAllPetPerson(){
        Person person1 = session.find(Person.class,1);
        List<Pet> pets = person1.getPetSet();
        pets.forEach(System.out::println);
    }
    @Test
    void deletePersonCascadeAll(){
        Person person1 = session.get(Person.class,2);
        session.remove(person1);
    }
}
