package com.example.app.domain;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class MusicInfo {
	private Integer id;
	 @NotBlank
	 private String title;
	 private String artist; 
	 private String songkey;
	 private Integer bpm;
	 private String  memo;
}
