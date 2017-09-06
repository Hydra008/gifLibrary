package com.codeGodfather.giflib.dao;

import com.codeGodfather.giflib.model.Gif;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by godfather on 2017-09-05.
 */
public interface GifDao {
    List<Gif> findAll();
    Gif findById(Long id);
    void save(Gif gif);
    void delete(Gif gif);
    List<Gif> findFaves();
}
