package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.app.domain.Musicinfo;

@Mapper
public interface MusicMapper {
	List<Musicinfo> selectMusic(
			@Param("songkey") String songkey,
			@Param("from") int from,
			@Param("to") int to);
	void addMusicinfo(Musicinfo musicinfo);

}