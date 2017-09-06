package com.codeGodfather.giflib.service;

import com.codeGodfather.giflib.model.Gif;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by godfather on 2017-09-04.
 */
public interface GifService {
    List<Gif> findAll();
    Gif findById(Long id);
    void save(Gif gif, MultipartFile file);
    void delete(Gif gif);
    void toggleFavourite(Gif gif);
    List<Gif> faves();

}
