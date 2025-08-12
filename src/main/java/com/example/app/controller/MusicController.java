package com.example.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.domain.MusicInfo;
import com.example.app.service.MusicService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/music")
public class MusicController {

    private final MusicService service;

    // トップ画面
    @GetMapping
    public String top() {
        return "Topgamen";
    }
    
    @PostMapping("/topsearch")
    public String topSearch(@RequestParam(required = false) String songkey,
                            @RequestParam(required = false, defaultValue = "0") int from,
                            @RequestParam(required = false, defaultValue = "999") int to,
                            Model model) {
        model.addAttribute("songs", service.searchMusic(songkey != null ? songkey : "", from, to));
        model.addAttribute("searchedBy", (songkey != null && !songkey.isBlank()) ? songkey : (from + "~" + to));
        return "Tourokuitiran";  // 検索結果を一覧で表示
    }

    // 楽曲一覧
    @GetMapping("/list")
    public String all(Model model) {
        model.addAttribute("songs", service.searchAll());
        return "Tourokuitiran";
    }

    // 楽曲検索
    @GetMapping("/search")
    public String search(
            @RequestParam(required = false) String title, // ★フォームのname="title"に対応
            @RequestParam(required = false) String songkey,
            @RequestParam(required = false, defaultValue = "0") int from,
            @RequestParam(required = false, defaultValue = "999") int to,
            Model model) {

        List<MusicInfo> result;

        if (title != null && !title.isBlank()) {
            // ★曲名で検索
            result = service.searchByTitle(title);
            model.addAttribute("searchedBy", "曲名: " + title);
        } else {
            // ★従来通りsongkey + BPM検索
            result = service.searchMusic(songkey != null ? songkey : "", from, to);
            model.addAttribute("searchedBy", (songkey != null && !songkey.isBlank()) ? songkey : (from + "~" + to));
        }

        model.addAttribute("songs", result);
        return "Tourokuitiran";
    }

    // 登録フォーム
    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("musicInfo", new MusicInfo());
        return "song_register";
    }

    // 登録処理
    @PostMapping("/register")
    public String register(@ModelAttribute MusicInfo musicInfo) {
        service.save(musicInfo);
        return "redirect:/music/list";
    }
    
    @PostMapping("/delete")
    public String delete(@RequestParam Integer id) {
        service.deleteById(id);
        return "redirect:/music/list";
    }
}