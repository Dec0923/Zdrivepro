package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.service.MusicService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/music")
public class MusicController {
	private final MusicService service;

	 @GetMapping
	 public String all(Model model) {
	 return "TOPgamen";
	 }

	 @GetMapping("/search")
	 public String search(
	 @RequestParam String songkey,
	 @RequestParam int from,
	 @RequestParam int to,
	 @RequestParam(required = false) String songkeyButton,
	 Model model) {
	 if(songkeyButton != null) {
	 if(songkey.isBlank()) {
	 return "Tourokuitiran";
	 }
	 model.addAttribute("searchedBy", songkey);
	 model.addAttribute("members",
	service.searchBysongkey(songkey));
	 } else {
	 model.addAttribute("searchedBy", from + "才～" + to + "才");
	 model.addAttribute("members", service.searchBybpm(from, to));
	 }
	 return "members";
	 }

	 
}
