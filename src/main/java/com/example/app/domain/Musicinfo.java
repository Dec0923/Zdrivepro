package com.example.app.domain;

import lombok.Data;

@Data
public class Musicinfo {
	private Integer id;
	 @NotBlank
	 private String loginId;
	 private String loginPass; 
}
