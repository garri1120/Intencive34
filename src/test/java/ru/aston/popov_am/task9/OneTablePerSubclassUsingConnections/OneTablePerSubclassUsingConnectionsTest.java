package ru.aston.popov_am.task9.OneTablePerSubclassUsingConnections;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;


public class OneTablePerSubclassUsingConnectionsTest {
    private static SessionFactory sessionFactory;
    private Session session;

    private ProductDairy productDairy;
    private ProductFruit productFruit;

    @BeforeAll
    public static void init() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Product.class);
            configuration.addAnnotatedClass(ProductDairy.class);
            configuration.addAnnotatedClass(ProductFruit.class);
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
            productDairy = ProductDairy.builder().name("Веселый молочник").dairy(Dairy.MILK).price(100).fatContent(2.5).build();
            productFruit = ProductFruit.builder().name("Апельсин").fruits(Fruits.ORANGE).price(150).manufacturerCountry("Турция").build();

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
        session.persist(productDairy);
        session.persist(productFruit);
    }
    @Test
    void leftJoin(){
        List<Product> productList = session.createQuery("select bd from Product bd", Product.class).getResultList();
        productList.forEach(System.out::println);
    }
    @Test
    void innerJoin(){
        List<ProductFruit> productFruits = session.createQuery("select bd from ProductFruit bd",ProductFruit.class).getResultList();
        productFruits.forEach(System.out::println);
    }

}
