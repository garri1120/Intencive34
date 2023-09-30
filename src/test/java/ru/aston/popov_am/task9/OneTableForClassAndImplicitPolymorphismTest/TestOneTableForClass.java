package ru.aston.popov_am.task9.OneTableForClassAndImplicitPolymorphismTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.aston.popov_am.task9.OneTableForClassAndImplicitPolymorphism.BankAccount;
import ru.aston.popov_am.task9.OneTableForClassAndImplicitPolymorphism.CreditCard;

public class TestOneTableForClass {
    private static SessionFactory sessionFactory;
    private Session session;

    private BankAccount bankAccount;
    private CreditCard creditCard;

    @BeforeAll
    public static void init() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(BankAccount.class);
            configuration.addAnnotatedClass(CreditCard.class);
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
            bankAccount = BankAccount.builder().owner("Petrov Ivan").bankName("CBER").account("12345").build();
            creditCard = CreditCard.builder().owner("Ivanov Roman").cardNumber("1234556787").expMonth("02").expYear("2015").build();
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
        session.persist(bankAccount);
        session.persist(creditCard);
    }


    @Test
    void getBankAccount(){
       BankAccount bankAccount1 = session.get(BankAccount.class,1);
       System.out.println("-------------------------");
       System.out.println(bankAccount1);
       System.out.println("-------------------------");
    }

    @Test
    void getCreditCard(){
        CreditCard creditCard1 = session.get(CreditCard.class,1);
        System.out.println("-------------------------");
        System.out.println(creditCard1);
        System.out.println("-------------------------");
    }
    @Test
    void findBankAccount(){
        BankAccount bankAccount1 = session.find(BankAccount.class,1);
        System.out.println("-------------------------");
        System.out.println(bankAccount1);
        System.out.println("-------------------------");
    }

}
