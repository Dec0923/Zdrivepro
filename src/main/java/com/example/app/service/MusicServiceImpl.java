package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.domain.Musicinfo;
import com.example.app.mapper.MusicMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MusicServiceImpl implements MusicService {
	
	private final MusicMapper musicMapper;
	
	@Override
	public List<Musicinfo> searchAll(){
		return musicMapper.selectMusic();
	}
	
	@Override
	public List<Musicinfo> searchBysongkey(String songkey){
		return null;
	}
	
	@Override
	public List<Musicinfo> searchBybpm(int from, int to){
		return null;
	}
	
	@Override
	public void save(Musicinfo musicinfo) {
		
	}

}
