package com.redhat.dao.impl;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.redhat.dao.TestDAOService;
import com.redhat.model.TestModel;

public class TestDAO implements TestDAOService {

    private EntityManagerFactory entityManagerFactory;

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
	public void persistTestModel( TestModel tm ) throws SQLException {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(tm);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new SQLException("Something wrong with the DB");
        }finally{
            if( em!=null && em.getTransaction()!=null && em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            if( em!=null && em.isOpen() ){
                em.close();
            }
        }
    }
}

