package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.app.domain.MusicInfo;

@Mapper
public interface MusicMapper {

    // キーとBPMで絞り込み
    List<MusicInfo> selectMusic(@Param("songkey") String songkey, @Param("from") int from, @Param("to") int to);

    // 1件追加
    void addMusicInfo(MusicInfo musicinfo);
    
    void deleteMusicById(@Param("id") Integer id);
    
    List<MusicInfo> selectByTitle(@Param("title") String title);
}
