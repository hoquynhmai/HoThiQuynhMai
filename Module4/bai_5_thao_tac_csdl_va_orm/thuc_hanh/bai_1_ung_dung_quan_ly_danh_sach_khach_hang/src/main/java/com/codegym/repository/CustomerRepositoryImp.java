package com.codegym.repository;

import com.codegym.entity.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomerRepositoryImp implements CustomerRepository {
    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> typedQuery = BaseRepository.entityManager.createQuery("select c from customer c", Customer.class);
        return typedQuery.getResultList();
    }

    @Override
    public Customer findById(int id) {
        TypedQuery<Customer> typedQuery = BaseRepository.entityManager.createQuery("select c from customer c where id = :idCustomer",Customer.class);
        typedQuery.setParameter("idCustomer",id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void save(Customer customer) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(customer);
        entityTransaction.commit();
    }

    @Override
    public void update(Customer customer) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(customer);
        entityTransaction.commit();
    }

    @Override
    public void remove(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(findById(id));
        entityTransaction.commit();
    }
}
