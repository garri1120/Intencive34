package ru.aston.popov_am.task9.Communications.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OneToOneTest {
    private static SessionFactory sessionFactory;
    private Session session;

    private User user;
    private RegistrationAddress registrationAddress;

    @BeforeAll
    public static void init() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(RegistrationAddress.class);
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
            registrationAddress = RegistrationAddress.builder().city("Ростов").houseNumber("111").street("Текучева").apartmentNumber(12).build();
            user = User.builder().firstname("Ivan").lastname("Ivanov").registrationAddress(registrationAddress).build();

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
        session.persist(user);
    }

    @Test
    void findLazyRegistrationAddress(){
       User user1 = session.find(User.class,2);
       System.out.println("-------------------");
       System.out.println(user1);
    }

    @Test
    void deleteUserCascadeTypeALL(){
        User user1 = session.find(User.class,2);
        System.out.println("-------------------");
        session.remove(user1);
    }

    @Test
    void findAll(){
       List<User> users = session.createQuery("from User",User.class).list();
       System.out.println("-------------------");
       users.forEach(System.out::println);
    }

}
