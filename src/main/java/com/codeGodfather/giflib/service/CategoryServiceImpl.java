package com.codeGodfather.giflib.service;

import com.codeGodfather.giflib.dao.CategoryDao;
import com.codeGodfather.giflib.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by godfather on 2017-09-01.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public void save(Category category) {
    categoryDao.save(category);
    }

    @Override
    public void delete(Category category) {

    }
}
