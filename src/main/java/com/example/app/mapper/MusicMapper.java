package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Musicinfo;

@Mapper
public interface MusicMapper {
	List<Musicinfo> selectMusic();
	void addMusicinfo(Musicinfo musicinfo);

}