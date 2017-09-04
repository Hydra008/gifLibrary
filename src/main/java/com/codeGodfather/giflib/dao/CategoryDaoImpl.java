package com.codeGodfather.giflib.dao;

import com.codeGodfather.giflib.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by godfather on 2017-09-01.
 */

@Repository
public class CategoryDaoImpl implements CategoryDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Category> findAll() {
        //open a session
        Session session = sessionFactory.openSession();
        //get all Categories
        List<Category> categories = session.createCriteria(Category.class).list();
        //close session
        session.close();
        return categories;
    }

    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public void save(Category category) {
        //open a session
        Session session = sessionFactory.openSession();
        //begin transaction
        session.beginTransaction();
        //save the category
        session.save(category);
        //commit the transaction
        session.getTransaction().commit();
        //close the session
        session.close();

    }

    @Override
    public void delete(Category category) {

    }
}
