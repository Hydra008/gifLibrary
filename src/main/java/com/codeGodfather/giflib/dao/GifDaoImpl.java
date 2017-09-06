package com.codeGodfather.giflib.dao;

import com.codeGodfather.giflib.model.Gif;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by godfather on 2017-09-05.
 */
@Repository
public class GifDaoImpl implements GifDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    @SuppressWarnings("unchecked")
    public List<Gif> findAll() {
        Session session = sessionFactory.openSession();
        List<Gif> gifs = session.createCriteria(Gif.class).list();
        session.close();
        return gifs;
    }

    @Override
    public Gif findById(Long id) {
        Session session = sessionFactory.openSession();
        Gif gif = session.get(Gif.class,id);
        session.close();
        return gif;
    }

    @Override
    public void save(Gif gif) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(gif);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void delete(Gif gif) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(gif);
        session.getTransaction().commit();
        session.close();

    }
    @Override
    @SuppressWarnings("unchecked")
    public List<Gif> findFaves()
    {
        Session session =sessionFactory.openSession();
        List<Gif> gifs = session.createCriteria(Gif.class).list();
        List<Gif> faveGifs=new ArrayList<Gif>();
        for(Gif gif :gifs)
            if(gif.isFavorite())
            {
                faveGifs.add(gif);
            }
        session.close();
        return faveGifs;
    }
    @Override
    @SuppressWarnings("unchecked")
    public List<Gif> search(String q)
    {
        Session session =sessionFactory.openSession();
        List<Gif> gifs = session.createCriteria(Gif.class).list();
        List<Gif> search=new ArrayList<Gif>();
        for(Gif gif :gifs)
            if(gif.getDescription().contains(q))
            {
                search.add(gif);
            }
        session.close();
        return search;

    }
}
