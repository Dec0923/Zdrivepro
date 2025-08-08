package com.example.app.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.domain.MusicInfo;
import com.example.app.mapper.MusicMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MusicServiceImpl implements MusicService {
    private final MusicMapper musicMapper;

    @Override
    public List<MusicInfo> searchAll() {
        // 空＋全範囲で全曲取得
        return musicMapper.selectMusic("", 0, 999);
    }

    @Override
    public List<MusicInfo> searchMusic(String songkey, int from, int to) {
        return musicMapper.selectMusic(songkey, from, to);
    }

    @Override
    public void save(MusicInfo musicinfo) {
        musicMapper.addMusicInfo(musicinfo);
    }
    
    @Override
    public void deleteById(Integer id) {
        musicMapper.deleteMusicById(id);
    }
}