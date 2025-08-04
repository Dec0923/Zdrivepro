package com.example.app.service;

import java.util.List;

import com.example.app.domain.Musicinfo;

public interface MusicService {
	
	List<Musicinfo> searchAll();
	List<Musicinfo> searchBysongkey(String songkey);
	List<Musicinfo> searchBybpm(int from, int to);
	void save(Musicinfo musicinfo);


}
