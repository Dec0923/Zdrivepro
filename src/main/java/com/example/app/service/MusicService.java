package com.example.app.service;

import java.util.List;

import com.example.app.domain.MusicInfo;

public interface MusicService {
    List<MusicInfo> searchAll();
    List<MusicInfo> searchMusic(String songkey, int from, int to);
    void save(MusicInfo musicinfo);
    
    void deleteById(Integer id);
    List<MusicInfo> searchByTitle(String title);
}
