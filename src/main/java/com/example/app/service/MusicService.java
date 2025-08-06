package com.example.app.service;

import java.util.List;

import com.example.app.domain.MusicInfo;

public interface MusicService {
	
	List<MusicInfo> searchAll();
	List<MusicInfo> searchBysongkey(String songkey);
	List<MusicInfo> searchBybpm(int from, int to);
	void save(MusicInfo musicinfo);


}
