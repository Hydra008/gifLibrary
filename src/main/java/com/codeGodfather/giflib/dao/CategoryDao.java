package com.codeGodfather.giflib.dao;

import com.codeGodfather.giflib.model.Category;

import java.util.List;

/**
 * Created by godfather on 2017-09-01.
 */
public interface CategoryDao {
    List<Category> findAll();
    Category findById(Long id);
    void save(Category category);
    void delete(Category category);
}
