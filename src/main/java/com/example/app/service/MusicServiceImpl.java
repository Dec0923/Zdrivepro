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
		String songkey="";
		int from=0;
		int to =999;
		return musicMapper.selectMusic(songkey,from,to);
	}
	
	@Override
	public List<Musicinfo> searchBysongkey(String songkey){
		int from =0;
		int to=999;
		return musicMapper.selectMusic(songkey,from,to);
	}
	
	@Override
	public List<Musicinfo> searchBybpm(int from, int to){
		String songkey="";
		return musicMapper.selectMusic(songkey,from,to);
	}
	
	@Override
	public void save(Musicinfo musicinfo) {
		
	}

}
