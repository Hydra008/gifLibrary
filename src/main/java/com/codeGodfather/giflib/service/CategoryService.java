package com.codeGodfather.giflib.service;

import com.codeGodfather.giflib.model.Category;
import com.codeGodfather.giflib.model.Gif;

import java.util.List;

/**
 * Created by godfather on 2017-09-01.
 */
public interface CategoryService {
    List<Category> findAll();
    Category findById(Long id);
    void save(Category category);
    void delete(Category category);

}
