package dev.patika;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Market");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        //eklme
        transaction.begin();
        Customer customer = new Customer();

        customer.setCustomerName("Cüneyt");
        customer.setCustomerMail("c.ugurongun@gmail.com");
        customer.setCustomerGender(Customer.Gender.MALE);
        customer.setCustomerOnDate(LocalDate.now());

        entityManager.persist(customer);
        transaction.commit();

        //bulma
        Customer c1 = entityManager.find(Customer.class,1);

        System.out.println(c1.getCustomerName());

        //güncelleme
        transaction.begin();
        customer.setCustomerName("Cüneyt Uğur");
        entityManager.persist(customer);
        transaction.commit();

        //silme
        transaction.begin();

        entityManager.remove(customer);
        transaction.commit();
    }
}