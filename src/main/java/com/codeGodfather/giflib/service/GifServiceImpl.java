package com.codeGodfather.giflib.service;

import com.codeGodfather.giflib.dao.GifDao;
import com.codeGodfather.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by godfather on 2017-09-04.
 */
@Service
public class GifServiceImpl implements GifService {
    @Autowired
    private GifDao gifDao;

    @Override
    public List<Gif> findAll() {
         return gifDao.findAll();
    }

    @Override
    public Gif findById(Long id) {
        return gifDao.findById(id);
    }

    @Override
    public void save(Gif gif, MultipartFile file) {
        try {
            gif.setBytes(file.getBytes());
            gifDao.save(gif);
        } catch (IOException e) {
            System.out.println("Unable to get bytes array from file");
        }
    }

    @Override
    public void delete(Gif gif) {
    gifDao.delete(gif);
    }
    @Override
    public void toggleFavourite(Gif gif) {
    gif.setFavorite(!gif.isFavorite());
    gifDao.save(gif);
    }
    @Override
    public List<Gif> faves()
    {
        return gifDao.findFaves();
    }
}

